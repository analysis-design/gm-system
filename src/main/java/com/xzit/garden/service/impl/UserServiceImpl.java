package com.xzit.garden.service.impl;

import com.xzit.garden.bean.dto.UserDto;
import com.xzit.garden.bean.entity.*;
import com.xzit.garden.bean.model.AuthModel;
import com.xzit.garden.bean.model.PageModel;
import com.xzit.garden.bean.model.RoleModel;
import com.xzit.garden.exception.ObjNotFoundException;
import com.xzit.garden.exception.ObjectAlreadyExistException;
import com.xzit.garden.exception.ObjectAlreadyInUse;
import com.xzit.garden.mapper.AuthorityMapper;
import com.xzit.garden.mapper.RoleMapper;
import com.xzit.garden.mapper.StaffMapper;
import com.xzit.garden.mapper.UserMapper;
import com.xzit.garden.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserServiceImpl implements UserDetailsService, UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private AuthorityMapper authorityMapper;

    @Autowired
    private StaffMapper staffMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userMapper.findByName(username);
        if (user == null) return null;

        // 假设返回的用户信息如下;
        List<Role> roleList = roleMapper.findByUserId(user.getId());
        for (Role role : roleList) {
            List<Authority> authorityList = authorityMapper.findByRoleId(role.getId());
            role.setAuthorityList(authorityList);
        }
        user.setRoleList(roleList);
        return user;
    }

    @Override
    public UserDto getUserDto() {
//        User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        User user = (User) loadUserByUsername(principal.getUsername());
        User user = (User) loadUserByUsername("admin");
        List<Authority> authorities = new ArrayList<>();
        user.getRoleList().forEach(role -> {
            for (Authority authority : role.getAuthorityList()) {
                if (authorities.contains(authority)) continue;
                authorities.add(authority);
            }
        });

        Staff staff = staffMapper.findById(user.getStaffId());
        return new UserDto(user.getId(), user.getUsername(), user.getRoleList(), authorities, staff);
    }

    @Override
    public List<UserDto> getUserList() {
        List<User> userList = userMapper.findAll();

        return getUserDtoList(userList);
    }

    private List<UserDto> getUserDtoList(List<User> userList) {
        List<UserDto> userDtoList = new ArrayList<>();

        for (User user : userList) {
            UserDto userDto = getUserDto(user);
            userDtoList.add(userDto);
        }
        return userDtoList;
    }

    private UserDto getUserDto(User user) {
        Staff staff = staffMapper.findById(user.getStaffId());
        List<Authority> authorityList = authorityMapper.findByUserId(user.getId());
        List<Role> roleList = roleMapper.findByUserId(user.getId());

        return new UserDto(user.getId(), user.getUsername(), roleList, authorityList, staff);
    }

    @Transactional
    @Override
    public void addAuthority(AuthModel authModel) {
        Long userId = authModel.getUserId();
        validateExistUser(userId);

        List<RoleModel> roleList = authModel.getRoleList();
        validateExistRole(roleList);

        List<UserRole> userRoleList = getUserRoleList(userId, roleList);
        userMapper.addRoleRelations(userRoleList);
    }

    private User validateExistUser(Long userId) {
        User user = userMapper.findById(userId);
        if (user == null)
            throw new RuntimeException("用户不存在");
        return user;
    }

    @Transactional
    @Override
    public void updAuthority(AuthModel authModel) {
        validateExistUser(authModel.getUserId());

        List<RoleModel> roleList = authModel.getRoleList();
        validateExistRole(roleList);

        List<UserRole> updUserRoleList = getUserRoleList(authModel.getUserId(), roleList);

        List<UserRole> userRoles = userMapper.findUserRoleListByUserId(authModel.getUserId());

        updUserRoleList.removeAll(userRoles);
        List<UserRole> addURList = new ArrayList<>(updUserRoleList);
        userRoles.removeAll(updUserRoleList);
        List<Long> delURList = new ArrayList<>();
        for (UserRole userRole : userRoles)
            delURList.add(userRole.getRoleId());

        userMapper.addRoleRelations(addURList);
        userMapper.deleteRoleRelations(authModel.getUserId(), delURList);
    }

    @Override
    public AuthModel getUserAuthByUserId(Long userId) {
        List<UserRole> userRoleList = userMapper.findUserRoleListByUserId(userId);
        AuthModel authModelList = new AuthModel();

        List<RoleModel> roleModelList = new ArrayList<>();

        for (UserRole userRole : userRoleList) {
            List<RoleAuth> roleAuthList = roleMapper.findRoleAuthListByRoleId(userRole.getRoleId());

            List<Long> authList = new ArrayList<>();
            for (RoleAuth roleModel : roleAuthList)
                authList.add(roleModel.getAuthId());

            RoleModel roleModel = new RoleModel();
            roleModel.setRoleId(userRole.getRoleId());
            roleModel.setAuthList(authList);

            roleModelList.add(roleModel);
        }

        authModelList.setRoleList(roleModelList);
        return authModelList;
    }

    @Override
    public List<UserDto> getPageUserList(PageModel<List<UserDto>> pageModel) {
        int page = pageModel.getPage() - 1;
        List<User> userList = userMapper.findAllPage(page * pageModel.getLimit(), pageModel.getLimit());
        int count = userMapper.countUser();
        pageModel.setCount(count);

        if (userList == null)
            userList = new ArrayList<>();

        return getUserDtoList(userList);
    }

    @Override
    public UserDto getUserByUserId(Long userId) {
        User user = userMapper.findById(userId);
        if (user == null)
            throw new ObjNotFoundException("用户" + userId + "不存在");

        return getUserDto(user);
    }

    @Transactional
    @Override
    public void addUser(UserDto userDto) {
        validateEditUser(userDto);

        User temp = new User();
        temp.setUsername(userDto.getUsername());
        temp.setPassword(userDto.getPassword());
        temp.setStaffId(userDto.getStaffId());
        userMapper.add(temp);
        List<UserRole> userRoleList = switchUserRoleList(temp.getId(), userDto.getRoleIdList());

        if (userRoleList.size() > 0)
            userMapper.addRoleRelations(userRoleList);
    }

    private void validateEditUser(UserDto userDto) {
        User user = userMapper.findByName(userDto.getUsername());
        if (user != null && userDto.getId() != null && !userDto.getId().equals(user.getId()))
            throw new ObjectAlreadyExistException("用户" + userDto.getUsername() + "已存在");

        List<Long> relatedRoleList = userDto.getRoleIdList();
        if (relatedRoleList != null && relatedRoleList.size() > 0)
            validateExistRoleList(relatedRoleList);

        if (userDto.getStaffId() != null)
            validateExistStaff(userDto.getStaffId());
    }

    private void validateExistStaff(Long staffId) {
        Staff staff = staffMapper.findById(staffId);
        if (staff == null)
            throw new ObjNotFoundException("员工编号" + staffId + "不存在");
    }

    private void validateExistRoleList(List<Long> relatedRoleList) {
        List<Role> roleList = roleMapper.findByIdList(relatedRoleList);
        List<Long> existRoleList = new ArrayList<>();
        roleList.forEach(role -> existRoleList.add(role.getId()));
        List<Long> roleIdList = new ArrayList<>(relatedRoleList);
        roleIdList.removeAll(existRoleList);
        if (roleIdList.size() > 0)
            throw new ObjNotFoundException("角色" + Arrays.toString(roleIdList.toArray()) + "不存在");
    }

    @Transactional
    @Override
    public User deleteById(Long userId) {
        User user = validateExistUser(userId);
        List<UserRole> userRoleList = userMapper.findUserRoleListByUserId(userId);
        if (userRoleList != null && userRoleList.size() > 0)
            throw new ObjectAlreadyInUse("用户" + user.getUsername() + "无法删除");

        userMapper.deleteById(userId);
        return user;
    }

    @Transactional
    @Override
    public List<User> deleteAllById(List<Long> userList) {
        List<User> list = new ArrayList<>();
        for (Long userId : userList) {
            list.add(validateExistUser(userId));
        }
        List<UserRole> userRoleList = userMapper.findUserRoleListByUserIdList(userList);
        if (userRoleList != null && userRoleList.size() > 0)
            throw new ObjectAlreadyInUse("无法批量删除用户，存在角色关联");

        userMapper.deleteByIdList(userList);
        return list;
    }

    @Transactional
    @Override
    public void updateById(UserDto userDto) {
        Long userId = userDto.getId();
        User user = validateExistUser(userId);

        validateEditUser(userDto);
        List<Long> relatedRoleList = userDto.getRoleIdList();
        List<UserRole> userRoleList = userMapper.findUserRoleListByUserId(userId);
        List<Long> originUserRoleList = new ArrayList<>();
        userRoleList.forEach(userRole -> originUserRoleList.add(userRole.getRoleId()));

        List<Long> updUserRoleList = new ArrayList<>(relatedRoleList);
        relatedRoleList.removeAll(originUserRoleList);
        originUserRoleList.removeAll(updUserRoleList);
        List<Long> delUserRoleList = new ArrayList<>(originUserRoleList);


        List<UserRole> addUserRoleList = switchUserRoleList(userId, relatedRoleList);
        if (addUserRoleList.size() > 0)
            userMapper.addRoleRelations(addUserRoleList);

        if (delUserRoleList.size() > 0)
            userMapper.deleteRoleRelations(userId, delUserRoleList);

        if (user.getPassword() != null && !user.getPassword().equals(""))
            user.setPassword(userDto.getPassword());

        user.setUsername(userDto.getUsername());
        user.setStaffId(userDto.getStaffId());
        userMapper.update(user);
    }

    private List<UserRole> switchUserRoleList(Long userId, List<Long> relatedRoleList) {
        List<UserRole> addUserRoleList = new ArrayList<>();
        if (relatedRoleList == null) return addUserRoleList;

        for (Long roleId : relatedRoleList) {
            UserRole temp = new UserRole();
            temp.setUserId(userId);
            temp.setRoleId(roleId);
            addUserRoleList.add(temp);
        }
        return addUserRoleList;
    }

    private List<UserRole> getUserRoleList(Long userId, List<RoleModel> roleList) {
        List<UserRole> userRoleList = new ArrayList<>();
        for (RoleModel roleModel : roleList) {
            UserRole userRole = new UserRole();
            userRole.setRoleId(roleModel.getRoleId());
            userRole.setUserId(userId);
            userRoleList.add(userRole);
        }

        return userRoleList;
    }

    private void validateExistRole(List<RoleModel> roleList) {
        for (RoleModel roleModel : roleList) {
            Role role = roleMapper.findById(roleModel.getRoleId());
            if (role == null)
                throw new RuntimeException("角色" + roleModel.getRoleId() + "不存在");
        }
    }

}

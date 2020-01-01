package com.xzit.garden.service.impl;

import com.xzit.garden.bean.dto.UserDto;
import com.xzit.garden.bean.entity.*;
import com.xzit.garden.bean.model.AuthModel;
import com.xzit.garden.bean.model.RoleModel;
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
        user.getRoleList().forEach(role -> authorities.addAll(role.getAuthorityList()));

        Staff staff = staffMapper.findById(user.getStaffId());
        return new UserDto(user.getId(), user.getUsername(), user.getRoleList(), authorities, staff);
    }

    @Override
    public List<UserDto> getUserList() {
        List<User> userList = userMapper.findAll();
        List<UserDto> userDtoList = new ArrayList<>();

        for (User user : userList) {
            Staff staff = staffMapper.findById(user.getStaffId());
            UserDto userDto = new UserDto(
                    user.getId(), user.getUsername(), new ArrayList<>(), new ArrayList<>(), staff);

            userDtoList.add(userDto);
        }

        return userDtoList;
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

    private void validateExistUser(Long userId) {
        User user = userMapper.findById(userId);
        if (user == null)
            throw new RuntimeException("用户不存在");
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

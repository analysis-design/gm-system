package com.xzit.garden.service.impl;

import com.xzit.garden.bean.entity.Authority;
import com.xzit.garden.bean.entity.Role;
import com.xzit.garden.bean.entity.RoleAuth;
import com.xzit.garden.bean.entity.UserRole;
import com.xzit.garden.bean.model.RoleModel;
import com.xzit.garden.exception.ObjectAlreadyInUseException;
import com.xzit.garden.mapper.AuthorityMapper;
import com.xzit.garden.mapper.RoleMapper;
import com.xzit.garden.mapper.UserMapper;
import com.xzit.garden.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private AuthorityMapper authorityMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<Role> getAllRole() {
        List<Role> roleList = roleMapper.findAll();
        if (roleList == null)
            roleList = new ArrayList<>();
        return roleList;
    }

    @Transactional
    @Override
    public void roleAllocAdd(RoleModel roleModel) {
        validateExistRole(roleModel);

        List<RoleAuth> roleAuthList = getRoleAuth(roleModel.getRoleId(), roleModel.getAuthList());
        roleMapper.addAuthRelations(roleAuthList);
    }

    private void validateExistRole(RoleModel roleModel) {
        Role role = roleMapper.findById(roleModel.getRoleId());
        if (role == null)
            throw new RuntimeException("角色" + roleModel.getRoleId() + "不存在");

        if (roleModel.getAuthList() != null && roleModel.getAuthList().size() > 0)
            validateExistAuthority(roleModel.getAuthList());
    }

    @Transactional
    @Override
    public void roleAllocUpd(RoleModel roleModel) {
        validateExistRole(roleModel);
        List<RoleAuth> updRoleAuthList = getRoleAuth(roleModel.getRoleId(), roleModel.getAuthList());
        List<RoleAuth> roleAuthList = new ArrayList<>(roleMapper.findRoleAuthListByRoleId(roleModel.getRoleId()));

        List<RoleAuth> updRoleAuthListCopy = new ArrayList<>(updRoleAuthList);
        updRoleAuthList.removeAll(roleAuthList);
        List<RoleAuth> addRAList = new ArrayList<>(updRoleAuthList);
        roleAuthList.removeAll(updRoleAuthListCopy);
        List<Long> delRAList = new ArrayList<>();
        for (RoleAuth roleAuth : roleAuthList)
            delRAList.add(roleAuth.getAuthId());


        if (addRAList.size() > 0)
            roleMapper.addAuthRelations(addRAList);
        if (delRAList.size() > 0)
            roleMapper.delAuthRelations(roleModel.getRoleId(), delRAList);
    }

    @Override
    public RoleModel roleAllocList(Long roleId) {
        List<RoleAuth> roleAuthList = roleMapper.findRoleAuthListByRoleId(roleId);
        List<Long> authList = new ArrayList<>();
        for (RoleAuth roleAuth : roleAuthList)
            authList.add(roleAuth.getAuthId());

        RoleModel roleModel = new RoleModel();
        roleModel.setAuthList(authList);
        return roleModel;
    }

    @Transactional
    @Override
    public void roleAdd(RoleModel roleModel) {
        Role role = roleMapper.findByName(roleModel.getRoleName());
        if (role != null)
            throw new RuntimeException("角色" + roleModel.getRoleName() + "已存在");

        Role temp = new Role();
        temp.setName(roleModel.getRoleName());
        temp.setDescription(roleModel.getDescription());
        roleMapper.addRole(temp);

        if (roleModel.getAuthList() == null || roleModel.getAuthList().size() == 0) return;

        roleModel.setRoleId(temp.getId());
        List<RoleAuth> roleAuthList = getRoleAuth(temp.getId(), roleModel.getAuthList());
        roleMapper.addAuthRelations(roleAuthList);
    }

    @Override
    public void roleUpd(RoleModel roleModel) {
        validateExistRole(roleModel);

        Role temp = new Role();
        temp.setId(roleModel.getRoleId());
        temp.setName(roleModel.getRoleName());
        temp.setDescription(roleModel.getDescription());
        roleMapper.updateById(temp);

        if (roleModel.getAuthList() == null || roleModel.getAuthList().size() == 0) return;

        roleModel.setRoleId(temp.getId());
        List<RoleAuth> roleAuthList = getRoleAuth(temp.getId(), roleModel.getAuthList());
        roleMapper.addAuthRelations(roleAuthList);
    }

    @Transactional
    @Override
    public Role roleDelete(Long roleId) {
        Role role = roleMapper.findById(roleId);
        if (role == null)
            throw new RuntimeException("角色" + roleId + "不存在");

        List<RoleAuth> roleAuthList = roleMapper.findRoleAuthListByRoleId(roleId);
        if (roleAuthList != null && roleAuthList.size() > 0)
            throw new ObjectAlreadyInUseException("角色和权限有关联，请解除其关系");

        List<UserRole> userRoleList = roleMapper.findUserRole(roleId);
        if (userRoleList != null && userRoleList.size() > 0)
            throw new ObjectAlreadyInUseException("角色已分配给用户，请解除其关系");

        roleMapper.deleteById(roleId);
        return role;
    }

    @Override
    public Role getRoleById(Long roleId) {
        Role role = roleMapper.findById(roleId);
        if (role == null)
            throw new RuntimeException("角色" + roleId + "不存在");

        List<Authority> authorityList = authorityMapper.findByRoleId(roleId);
        role.setAuthorityList(authorityList);
        return role;
    }

    private List<RoleAuth> getRoleAuth(Long roleId, List<Long> authList) {
        List<RoleAuth> roleAuthList = new ArrayList<>();
        for (Long authId : authList) {
            RoleAuth roleAuth = new RoleAuth();
            roleAuth.setRoleId(roleId);
            roleAuth.setAuthId(authId);
            roleAuthList.add(roleAuth);
        }
        return roleAuthList;
    }

    private void validateExistAuthority(List<Long> authList) {
        for (Long authId : authList) {
            Authority authority = authorityMapper.findById(authId);
            if (authority == null)
                throw new RuntimeException("权限" + authId + "不存在");
        }
    }
}

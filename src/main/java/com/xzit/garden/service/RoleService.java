package com.xzit.garden.service;

import com.xzit.garden.bean.entity.Role;
import com.xzit.garden.bean.model.RoleModel;

import java.util.List;

public interface RoleService {

    List<Role> getAllRole();

    void roleAllocAdd(RoleModel role);

    void roleAllocUpd(RoleModel role);

    RoleModel roleAllocList(Long roleId);

    void roleAdd(RoleModel role);

    void roleUpd(RoleModel role);

    Role roleDelete(Long roleId);

    Role getRoleById(Long roleId);
}

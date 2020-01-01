package com.xzit.garden.bean.model;

import java.io.Serializable;
import java.util.List;

public class RoleModel implements Serializable {
    private Long roleId;
    private String roleName;
    private String description;
    private List<Long> authList;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Long> getAuthList() {
        return authList;
    }

    public void setAuthList(List<Long> authList) {
        this.authList = authList;
    }
}

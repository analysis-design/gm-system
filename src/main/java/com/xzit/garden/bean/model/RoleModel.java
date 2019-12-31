package com.xzit.garden.bean.model;

import java.io.Serializable;
import java.util.List;

public class RoleModel implements Serializable {
    private Long roleId;
    private List<Long> authList;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public List<Long> getAuthList() {
        return authList;
    }

    public void setAuthList(List<Long> authList) {
        this.authList = authList;
    }
}

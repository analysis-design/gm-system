package com.xzit.garden.bean.model;

import java.io.Serializable;
import java.util.List;

public class AuthModel implements Serializable {
    private Long userId;
    private List<RoleModel> roleList;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<RoleModel> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<RoleModel> roleList) {
        this.roleList = roleList;
    }
}

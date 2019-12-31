package com.xzit.garden.bean.entity;

public class RoleAuth {
    private Long id;
    private Long roleId;
    private Long authId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getAuthId() {
        return authId;
    }

    public void setAuthId(Long authority) {
        this.authId = authority;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof RoleAuth)) return false;

        RoleAuth roleAuth = (RoleAuth) obj;
        return this.roleId.equals(roleAuth.getRoleId()) && this.authId.equals(roleAuth.getAuthId());
    }
}

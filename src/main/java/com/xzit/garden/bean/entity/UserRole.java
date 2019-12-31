package com.xzit.garden.bean.entity;

public class UserRole {
    private Long id;
    private Long userId;
    private Long roleId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof UserRole)) return false;
        UserRole userRole = new UserRole();

        return this.getUserId().equals(userRole.getUserId()) && this.getRoleId().equals(userRole.getRoleId());
    }
}

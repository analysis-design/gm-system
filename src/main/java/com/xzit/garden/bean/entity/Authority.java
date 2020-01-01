package com.xzit.garden.bean.entity;

import java.io.Serializable;

/**
 * 权限
 */
public class Authority implements Serializable {
    /**
     * 主键
     */
    private Long id;
    /**
     * 权限名称
     */
    private String authName;
    /**
     * 资源名称
     */
    private String resName;
    /**
     * 资源类型：0：菜单，1：按钮
     */
    private Integer resType;
    /**
     * 资源url
     */
    private String url;
    /**
     * 资源图标
     */
    private String icon;
    /**
     * 菜单的上一级菜单的id或者按钮属于的菜单的id
     */
    private Long parentId;
    /**
     * 描述
     */
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthName() {
        return authName;
    }

    public void setAuthName(String authName) {
        this.authName = authName;
    }

    public String getResName() {
        return resName;
    }

    public void setResName(String resName) {
        this.resName = resName;
    }

    public Integer getResType() {
        return resType;
    }

    public void setResType(Integer resType) {
        this.resType = resType;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof Authority)) return false;
        Authority temp = (Authority) obj;
        if (this.getAuthName().equals(temp.getAuthName()) && this.getUrl().equals(temp.getUrl()))
            return true;
        return super.equals(obj);
    }
}

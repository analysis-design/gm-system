package com.xzit.garden.bean.entity;

import java.io.Serializable;

/**
 * 权限
 */
public class Authority implements Serializable {
    /**
     * 主键
     */
    private Integer id;
    /**
     * 权限名称
     */
    private String authName;
    /**
     * 资源名称
     */
    private String resName;
    /**
     * 资源url
     */
    private String url;
    /**
     * 资源图标
     */
    private String icon;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
}

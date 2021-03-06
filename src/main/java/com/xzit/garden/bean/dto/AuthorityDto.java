package com.xzit.garden.bean.dto;

import com.xzit.garden.bean.entity.Authority;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AuthorityDto extends Authority implements Serializable {
    // 表示权限的下一级菜单
    private List<AuthorityDto> children;
    // 表示权限的上一级菜单
    private AuthorityDto parent;
    // 表示管理页面下面的权限
    private List<AuthorityDto> content;

    public AuthorityDto() {
        this.setAuthName("顶级菜单");
        this.children = new ArrayList<>();
        this.content = new ArrayList<>();
    }

    public AuthorityDto(Authority authority) {
        this.setAuthName("顶级菜单");
        this.children = new ArrayList<>();
        this.content = new ArrayList<>();

        this.setId(authority.getId());
        this.setAuthName(authority.getAuthName());
        this.setResName(authority.getResName());
        this.setResType(authority.getResType());
        this.setUrl(authority.getUrl());
        this.setIcon(authority.getIcon());
        this.setDescription(authority.getDescription());
        this.setParentId(authority.getParentId());
    }

    public void addContents(List<Authority> authorities) {
        for (Authority authority : authorities)
            addContent(authority);
    }

    public void addContent(Authority authority) {
        this.content.add(new AuthorityDto(authority));
    }

    public void addChildren(List<Authority> authorities) {
        for (Authority authority : authorities)
            addChild(authority);
    }

    public void addChild(Authority authority) {
        this.children.add(new AuthorityDto(authority));
    }

    public List<AuthorityDto> getChildren() {
        return children;
    }

    public AuthorityDto getParent() {
        return parent;
    }

    public void setParent(AuthorityDto parent) {
        this.parent = parent;
    }

    public List<AuthorityDto> getContents() {
        return content;
    }
}

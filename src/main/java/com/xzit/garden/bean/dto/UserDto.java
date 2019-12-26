package com.xzit.garden.bean.dto;

import com.xzit.garden.bean.entity.Authority;
import com.xzit.garden.bean.entity.Role;

import java.io.Serializable;
import java.util.List;

/**
 * 用户传输对象
 */
public class UserDto implements Serializable {

    /**
     * 主键
     */
    private Long id;

    /**
     * 用户名称
     */
    private String username;

    /**
     * 用户联系方式
     */
    private String mobile;

    // ************关联数据部分************
    // 用户所属角色
    private List<Role> roleList;
    private List<Authority> authorityList;


    public UserDto() {
    }

    public UserDto(Long id, String username, String mobile, List<Role> roleList, List<Authority> authorityList) {
        this.id = id;
        this.username = username;
        this.mobile = mobile;
        this.roleList = roleList;
        this.authorityList = authorityList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    public List<Authority> getAuthorityList() {
        return authorityList;
    }

    public void setAuthorityList(List<Authority> authorityList) {
        this.authorityList = authorityList;
    }
}

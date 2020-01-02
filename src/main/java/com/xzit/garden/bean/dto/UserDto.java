package com.xzit.garden.bean.dto;

import com.xzit.garden.bean.entity.Authority;
import com.xzit.garden.bean.entity.Role;
import com.xzit.garden.bean.entity.Staff;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
    private String roleDesc;
    private String authDesc;
    private Long staffId;
    private String password;
    private List<Long> roleIdList;

    // ************关联数据部分************
    // 用户所属角色
    private List<Role> roleList;
    private AuthorityDto root;

    private Staff staff;


    public UserDto() {
    }

    public UserDto(Long id, String username, List<Role> roleList, List<Authority> authorityList, Staff staff) {
        this.id = id;
        this.username = username;
        this.roleList = roleList;
        this.staff = staff;
        this.root = loadAuthority(authorityList);
        this.roleDesc = "";
        this.authDesc = "";
        this.staffId = staff.getId();
        this.roleIdList = new ArrayList<>();

        for (Role role : roleList) {
            this.roleDesc += role.getName() + ", \n";
            roleIdList.add(role.getId());
        }

        for (Authority authority : authorityList)
            this.authDesc += authority.getAuthName() + ", \n";
    }

    public static AuthorityDto loadAuthority(List<Authority> authorityList) {
        AuthorityDto root = new AuthorityDto();
        List<Authority> level1 = authorityList.stream()
                .filter(authority -> authority.getParentId() == null).collect(Collectors.toList());

        root.addChildren(level1);

        List<AuthorityDto> children = root.getChildren();

        while (children != null && children.size() > 0) {
            children = getChildren(authorityList, children);
        }
        return root;
    }

    private static List<AuthorityDto> getChildren(List<Authority> authorityList, List<AuthorityDto> children) {
        List<AuthorityDto> level2 = new ArrayList<>();
        for (AuthorityDto authorityDto : children) {
            List<Authority> list = authorityList
                    .stream()
                    .filter(authority -> authority.getResType() == 0 &&
                            authorityDto.getId().equals(authority.getParentId())).collect(Collectors.toList());

            authorityDto.addChildren(list);
            level2.addAll(authorityDto.getChildren());

            list = authorityList
                    .stream()
                    .filter(authority -> authority.getResType() != 0 &&
                            authorityDto.getId().equals(authority.getParentId())).collect(Collectors.toList());
            authorityDto.addContents(list);
        }
        return level2;
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

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    public String getAuthDesc() {
        return authDesc;
    }

    public void setAuthDesc(String authDesc) {
        this.authDesc = authDesc;
    }

    public Long getStaffId() {
        return staffId;
    }

    public void setStaffId(Long staffId) {
        this.staffId = staffId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Long> getRoleIdList() {
        return roleIdList;
    }

    public void setRoleIdList(List<Long> roleIdList) {
        this.roleIdList = roleIdList;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    public AuthorityDto getRoot() {
        return root;
    }

    public void setRoot(AuthorityDto root) {
        this.root = root;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }
}

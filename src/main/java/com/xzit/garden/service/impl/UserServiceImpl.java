package com.xzit.garden.service.impl;

import com.xzit.garden.bean.dto.UserDto;
import com.xzit.garden.bean.entity.Authority;
import com.xzit.garden.bean.entity.Role;
import com.xzit.garden.bean.entity.Staff;
import com.xzit.garden.bean.entity.User;
import com.xzit.garden.mapper.AuthorityMapper;
import com.xzit.garden.mapper.RoleMapper;
import com.xzit.garden.mapper.StaffMapper;
import com.xzit.garden.mapper.UserMapper;
import com.xzit.garden.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserDetailsService, UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private AuthorityMapper authorityMapper;

    @Autowired
    private StaffMapper staffMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userMapper.findByName(username);
        if (user == null) return null;

        // 假设返回的用户信息如下;
        List<Role> roleList = roleMapper.findByUserId(user.getId());
        for (Role role : roleList) {
            List<Authority> authorityList = authorityMapper.findByRoleId(role.getId());
            role.setAuthorityList(authorityList);
        }
        user.setRoleList(roleList);
        return user;
    }

    @Override
    public UserDto getUserDto() {
        User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = (User) loadUserByUsername(principal.getUsername());
        List<Authority> authorities = new ArrayList<>();
        user.getRoleList().forEach(role -> authorities.addAll(role.getAuthorityList()));

        Staff staff = staffMapper.findById(principal.getStaffId());
        return new UserDto(principal.getId(), principal.getUsername(), principal.getRoleList(), authorities, staff);
    }

    @Override
    public List<UserDto> getUserList() {
        List<User> userList = userMapper.findAll();
        List<UserDto> userDtoList = new ArrayList<>();

        for (User user: userList) {
            Staff staff = staffMapper.findById(user.getStaffId());
            UserDto userDto = new UserDto(
                    user.getId(), user.getUsername(), new ArrayList<>(), new ArrayList<>(), staff);

            userDtoList.add(userDto);
        }

        return userDtoList;
    }
}

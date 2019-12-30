package com.xzit.garden.service.impl;

import com.xzit.garden.bean.dto.UserDto;
import com.xzit.garden.bean.entity.Authority;
import com.xzit.garden.bean.entity.Role;
import com.xzit.garden.bean.entity.User;
import com.xzit.garden.mapper.AuthorityMapper;
import com.xzit.garden.mapper.RoleMapper;
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
        List<Authority> authorities = new ArrayList<>();
        principal.getRoleList().forEach(role -> authorities.addAll(role.getAuthorityList()));

        return new UserDto(principal.getId(), principal.getUsername(), principal.getRoleList(), authorities);
    }
}

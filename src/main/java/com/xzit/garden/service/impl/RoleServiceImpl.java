package com.xzit.garden.service.impl;

import com.xzit.garden.bean.entity.Role;
import com.xzit.garden.mapper.RoleMapper;
import com.xzit.garden.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Role> getAllRole() {
        return roleMapper.findAll();
    }
}

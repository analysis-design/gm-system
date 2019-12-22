package com.xzit.garden.service.impl;

import com.xzit.garden.bean.entity.Users;
import com.xzit.garden.mapper.UsersMapper;
import com.xzit.garden.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl implements UsersService {
    @Autowired
    UsersMapper usersMapper;
    @Override
    public Users findByUserId(String id) {
        return usersMapper.findByid(id);
    }
}

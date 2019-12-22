package com.xzit.garden.service;

import com.xzit.garden.bean.entity.Users;

public interface UsersService {
    Users findByUserId(String id);
}

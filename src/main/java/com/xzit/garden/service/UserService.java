package com.xzit.garden.service;

import com.xzit.garden.bean.dto.UserDto;

/**
 * 操作用户的业务逻辑
 */
public interface UserService {

    /**
     * 获取已认证用户的传输对象
     *
     * @return 用户传输对象
     */
    UserDto getUserDto();
}

package com.xzit.garden.service;

import com.xzit.garden.bean.dto.UserDto;
import com.xzit.garden.bean.model.AuthModel;

import java.util.List;

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

    /**
     * @return 获取所有的用户
     */
    List<UserDto> getUserList();

    /**
     * 添加权限关系
     *
     * @param authModel 权限模型
     */
    void addAuthority(AuthModel authModel);

    /**
     * 修改权限关系
     *
     * @param authModel 权限模型
     */
    void updAuthority(AuthModel authModel);

    /**
     * 根据用户id查询用户权限关系
     *
     * @param userId 用户id
     * @return 用户角色权限对应关系
     */
    AuthModel getUserAuthByUserId(Long userId);
}

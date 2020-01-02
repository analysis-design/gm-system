package com.xzit.garden.service;

import com.xzit.garden.bean.dto.UserDto;
import com.xzit.garden.bean.entity.User;
import com.xzit.garden.bean.model.AuthModel;
import com.xzit.garden.bean.model.PageModel;

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

    /**
     * 获取分页的用户列表
     *
     * @param pageModel 分页模型对象
     * @return 用户列表信息
     */
    List<UserDto> getPageUserList(PageModel<List<UserDto>> pageModel);

    /**
     * 根据用户id查询用户
     *
     * @param userId 用户id
     * @return 查询到的用户对象
     */
    UserDto getUserByUserId(Long userId);

    /**
     * 添加用户对象
     *
     * @param userDto 添加的用户对象
     */
    void addUser(UserDto userDto);

    /**
     * 根据用户id删除用户
     *
     * @param userId 用户id
     * @return 删除的用户信息
     */
    User deleteById(Long userId);

    /**
     * 批量删除用户信息
     *
     * @param userList 删除的用户id信息
     * @return 删除的用户列表信息
     */
    List<User> deleteAllById(List<Long> userList);

    /**
     * 根据用户id修改用户信息
     *
     * @param userDto 修改的用户信息
     */
    void updateById(UserDto userDto);
}

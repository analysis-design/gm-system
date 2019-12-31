package com.xzit.garden.mapper;

import com.xzit.garden.bean.entity.User;
import com.xzit.garden.bean.entity.UserRole;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
    /**
     * 根据用户id查询用户信息
     *
     * @param id 用户id
     * @return 查询的用户信息
     */
    @Select("select * from user where id=#{id}")
    User findById(@Param("id") Long id);

    /**
     * 根据用户名查询用户信息
     *
     * @param username 用户名
     * @return 查询的用户信息
     */
    @Select("select * from user where username=#{username}")
    User findByName(@Param("username") String username);

    @Select("select * from user")
    List<User> findAll();

    /**
     * 插入用户角色关系
     *
     * @param userRoleList 用户角色对应关系
     */
    @Insert("")
    int addRoleRelations(List<UserRole> userRoleList);

    /**
     * 根据用户id查询用户角色关系
     *
     * @param userId 用户id
     * @return 用户角色对应关系
     */
    @Select("select * from user_role where userId=#{userId}")
    List<UserRole> findUserRoleListByUserId(Long userId);

    /**
     * 删除用户角色关系
     * @param delURList 删除的用户角色关系列表
     * @return 删除的数目
     */
    @Delete("delete from user_role where userId")
    int deleteRoleRelations(List<UserRole> delURList);
}

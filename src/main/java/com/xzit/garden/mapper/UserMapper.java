package com.xzit.garden.mapper;

import com.xzit.garden.bean.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    /**
     * 根据用户id查询用户信息
     *
     * @param id 用户id
     * @return 查询的用户信息
     */
    @Select("select * from user where id=#{id}")
    User findById(@Param("id") String id);

    /**
     * 根据用户名查询用户信息
     *
     * @param username 用户名
     * @return 查询的用户信息
     */
    @Select("select * from user where username=#{username}")
    User findByName(@Param("username") String username);
}

package com.xzit.garden.mapper;

import com.xzit.garden.bean.entity.Authority;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 用户权限
 */
@Mapper
public interface AuthorityMapper {

    /**
     * 根据用户名查询用户所拥有的权限
     *
     * @param username 用户名
     * @return 用户拥有的权限列表
     */
    @Select("select * from authority where id in " +
            "(select authId from role_authority where roleId in " +
            "(select roleId from user_role where userId = " +
            "(select id from user where username=#{username})))")
    List<Authority> findByUserName(@Param("username") String username);

    /**
     * 根据用户id查询用户所拥有的权限
     *
     * @param userId 用户id
     * @return 用户拥有的权限列表
     */
    @Select("select * from authority where id in " +
            "(select authId from role_authority where roleId in " +
            "(select roleId from user_role where userId = #{userId}))")
    List<Authority> findByUserId(@Param("userId") Long userId);

    /**
     * 根据角色Id查询权限
     *
     * @param roleId 角色Id
     * @return 角色对应的权限
     */
    @Select("select * from authority where id in " +
            "(select authId from role_authority where roleId=#{roleId})")
    List<Authority> findByRoleId(@Param("roleId") Long roleId);
}

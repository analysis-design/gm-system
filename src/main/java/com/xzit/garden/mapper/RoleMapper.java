package com.xzit.garden.mapper;

import com.xzit.garden.bean.entity.Role;
import com.xzit.garden.bean.entity.RoleAuth;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface RoleMapper {

    /**
     * 根据用户名称查询用户角色列表
     *
     * @param username 用户名
     * @return 角色列表
     */
    @Select("select * from role where id in " +
            "(select roleId from user_role where userId=" +
            "(select * from user where username=#{username}))")
    List<Role> findByUsername(@Param("username") String username);

    /**
     * 根据用户id查询用户角色列表
     *
     * @param userId 用户id
     * @return 角色列表
     */
    @Select("select * from role where id in " +
            "(select roleId from user_role where userId=#{userId})")
    List<Role> findByUserId(@Param("userId") Long userId);

    @Select("select * from role")
    List<Role> findAll();

    @Select("select * from role where id=#{roleId}")
    Role findById(Long roleId);

    /**
     * 插入角色和权限关系
     *
     * @param roleAuthList 角色和权限关系列表
     */
    @Insert("")
    void addAuthRelations(List<RoleAuth> roleAuthList);

    /**
     * 根据角色id查询角色权限关系
     *
     * @param roleId 角色id
     * @return 角色权限对应关系
     */
    @Select("select * from role_authority where roleId=#{roleId}")
    List<RoleAuth> findRoleAuthListByRoleId(Long roleId);

    /**
     * 删除角色权限关系
     *
     * @param authList 删除的角色权限关系列表
     */
    @Delete("")
    void delAuthRelations(Long roleId, List<Long> authList);

    @Select("select * from role where name=#{roleName}")
    Role findByName(String roleName);

    @Insert("")
    void addRole(Role role);

    @Update("")
    void updateById(Role role);

    @Delete("delete from role where id=#{roleId}")
    void deleteById(Long roleId);
}

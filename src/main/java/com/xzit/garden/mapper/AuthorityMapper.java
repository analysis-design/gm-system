package com.xzit.garden.mapper;

import com.xzit.garden.bean.entity.Authority;
import org.apache.ibatis.annotations.*;

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

    @Select("select * from authority")
    List<Authority> findAll();

    @Select("select * from authority where id=#{id}")
    Authority findById(Long id);

    @Insert("insert into authority (authName, resName, resType, url, icon, parentId, description) " +
            "values (#{authName}, #{resName}, #{resType}, #{url}, #{icon}, #{parentId}, #{description})")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    void add(Authority authority);

    @Delete("delete from authority where id=#{id}")
    void deleteById(Long id);

    @Update("update authority set " +
            "authName = #{authName}, resName = #{resName}, resType = #{resType}, " +
            "url = #{url}, icon = #{icon}, parentId = #{parentId}, description = #{description} " +
            "where id = #{id}")
    void update(Authority authority);

    @Select("select * from authority limit #{index}, #{limit}")
    List<Authority> findPage(@Param("index") Integer index, @Param("limit") Integer limit);

    @Select("select count(*) from authority")
    int countList();

    @Delete("<script>" +
            "delete from authority where id in  " +
            "<foreach collection=\"idList\"  item=\"item\" open=\"(\" separator=\",\" close=\")\">" +
            "   #{item} " +
            "</foreach>" +
            "</script>")
    void deleteByIdList(@Param("idList") List<Long> authList);
}

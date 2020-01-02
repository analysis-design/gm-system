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
    @Insert("<script>" +
            "insert into user_role (userId, roleId) " +
            "values " +
            "<foreach collection=\"list\" item=\"item\" index=\"index\" separator=\",\">" +
            "   (#{item.userId}, #{item.roleId})" +
            "</foreach>" +
            "</script>")
    int addRoleRelations(@Param("list") List<UserRole> userRoleList);

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
     *
     * @param delURList 删除的用户角色关系列表
     * @return 删除的数目
     */
    @Delete("<script>" +
            "delete from user_role where userId=#{userId} and roleId in " +
            "<foreach collection=\"idList\"  item=\"item\" open=\"(\" separator=\",\" close=\")\">" +
            "   #{item} " +
            "</foreach>" +
            "</script>")
    int deleteRoleRelations(@Param("userId") Long userId, @Param("idList") List<Long> delURList);

    @Select("select * from user limit #{page}, #{limit}")
    List<User> findAllPage(@Param("page") Integer page, @Param("limit") Integer limit);

    @Select("select count(*) from user")
    int countUser();

    @Insert("insert into user (username, password, staffId) values (#{username}, #{password}, #{staffId})")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    void add(User user);

    @Delete("delete from user where id=#{userId}")
    void deleteById(Long userId);

    @Delete("<script>" +
            "delete from user where id in " +
            "<foreach collection=\"idList\"  item=\"item\" open=\"(\" separator=\",\" close=\")\">" +
            "   #{item} " +
            "</foreach>" +
            "</script>")
    void deleteByIdList(@Param("idList") List<Long> userList);

    @Update("update user set username = #{username}, password = #{password}, staffId = #{staffId} where id = #{id}")
    void update(User user);

    @Select("<script>" +
            "select * from user_role where userId in " +
            "<foreach collection=\"idList\"  item=\"item\" open=\"(\" separator=\",\" close=\")\">" +
            "   #{item} " +
            "</foreach>" +
            "</script>")
    List<UserRole> findUserRoleListByUserIdList(@Param("idList") List<Long> userList);
}

package com.xzit.garden.mapperAndSqlprovider2;

import com.xzit.garden.bean.entity.*;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

public interface GroupMemberMapper {
    @Delete({
        "delete from group_member",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into group_member (id, groupId, ",
        "memberId, postId, ",
        "state)",
        "values (#{id,jdbcType=INTEGER}, #{groupid,jdbcType=INTEGER}, ",
        "#{memberid,jdbcType=INTEGER}, #{postid,jdbcType=INTEGER}, ",
        "#{state,jdbcType=INTEGER})"
    })
    int insert(GroupMember record);

    @InsertProvider(type=GroupMemberSqlProvider.class, method="insertSelective")
    int insertSelective(GroupMember record);

    @Select({
        "select",
        "id, groupId, memberId, postId, state",
        "from group_member",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType= JdbcType.INTEGER, id=true),
        @Result(column="groupId", property="groupid", jdbcType= JdbcType.INTEGER),
        @Result(column="memberId", property="memberid", jdbcType= JdbcType.INTEGER),
        @Result(column="postId", property="postid", jdbcType= JdbcType.INTEGER),
        @Result(column="state", property="state", jdbcType= JdbcType.INTEGER)
    })
    GroupMember selectByPrimaryKey(Integer id);

    @UpdateProvider(type=GroupMemberSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(GroupMember record);

    @Update({
        "update group_member",
        "set groupId = #{groupid,jdbcType=INTEGER},",
          "memberId = #{memberid,jdbcType=INTEGER},",
          "postId = #{postid,jdbcType=INTEGER},",
          "state = #{state,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(GroupMember record);
}
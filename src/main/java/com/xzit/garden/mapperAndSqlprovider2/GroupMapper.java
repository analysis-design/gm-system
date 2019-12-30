package com.xzit.garden.mapperAndSqlprovider2;

import com.xzit.garden.bean.entity.*;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

public interface GroupMapper {
    @Delete({
        "delete from group",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into group (id, name, ",
        "state, createTime, ",
        "leaderId, type, ",
        "description)",
        "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
        "#{state,jdbcType=INTEGER}, #{createtime,jdbcType=TIMESTAMP}, ",
        "#{leaderid,jdbcType=INTEGER}, #{type,jdbcType=INTEGER}, ",
        "#{description,jdbcType=VARCHAR})"
    })
    int insert(Group record);

    @InsertProvider(type=GroupSqlProvider.class, method="insertSelective")
    int insertSelective(Group record);

    @Select({
        "select",
        "id, name, state, createTime, leaderId, type, description",
        "from group",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType= JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType= JdbcType.VARCHAR),
        @Result(column="state", property="state", jdbcType= JdbcType.INTEGER),
        @Result(column="createTime", property="createtime", jdbcType= JdbcType.TIMESTAMP),
        @Result(column="leaderId", property="leaderid", jdbcType= JdbcType.INTEGER),
        @Result(column="type", property="type", jdbcType= JdbcType.INTEGER),
        @Result(column="description", property="description", jdbcType= JdbcType.VARCHAR)
    })
    Group selectByPrimaryKey(Integer id);

    @UpdateProvider(type=GroupSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Group record);

    @Update({
        "update group",
        "set name = #{name,jdbcType=VARCHAR},",
          "state = #{state,jdbcType=INTEGER},",
          "createTime = #{createtime,jdbcType=TIMESTAMP},",
          "leaderId = #{leaderid,jdbcType=INTEGER},",
          "type = #{type,jdbcType=INTEGER},",
          "description = #{description,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Group record);
}
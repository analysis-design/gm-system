package com.xzit.garden.mapperAndSqlprovider2;

import com.xzit.garden.bean.entity.*;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

public interface ProjectMapper {
    @Delete({
        "delete from project",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into project (id, name, ",
        "workSite, state, ",
        "contractFile, difficultyLevel, ",
        "startTime, expectedEndTime, ",
        "actualEndTime, description, ",
        "saleId, clientId)",
        "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
        "#{worksite,jdbcType=VARCHAR}, #{state,jdbcType=INTEGER}, ",
        "#{contractfile,jdbcType=VARCHAR}, #{difficultylevel,jdbcType=INTEGER}, ",
        "#{starttime,jdbcType=TIMESTAMP}, #{expectedendtime,jdbcType=TIMESTAMP}, ",
        "#{actualendtime,jdbcType=TIMESTAMP}, #{description,jdbcType=VARCHAR}, ",
        "#{saleid,jdbcType=INTEGER}, #{clientid,jdbcType=INTEGER})"
    })
    int insert(Project record);

    @InsertProvider(type=ProjectSqlProvider.class, method="insertSelective")
    int insertSelective(Project record);

    @Select({
        "select",
        "id, name, workSite, state, contractFile, difficultyLevel, startTime, expectedEndTime, ",
        "actualEndTime, description, saleId, clientId",
        "from project",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType= JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType= JdbcType.VARCHAR),
        @Result(column="workSite", property="worksite", jdbcType= JdbcType.VARCHAR),
        @Result(column="state", property="state", jdbcType= JdbcType.INTEGER),
        @Result(column="contractFile", property="contractfile", jdbcType= JdbcType.VARCHAR),
        @Result(column="difficultyLevel", property="difficultylevel", jdbcType= JdbcType.INTEGER),
        @Result(column="startTime", property="starttime", jdbcType= JdbcType.TIMESTAMP),
        @Result(column="expectedEndTime", property="expectedendtime", jdbcType= JdbcType.TIMESTAMP),
        @Result(column="actualEndTime", property="actualendtime", jdbcType= JdbcType.TIMESTAMP),
        @Result(column="description", property="description", jdbcType= JdbcType.VARCHAR),
        @Result(column="saleId", property="saleid", jdbcType= JdbcType.INTEGER),
        @Result(column="clientId", property="clientid", jdbcType= JdbcType.INTEGER)
    })
    Project selectByPrimaryKey(Integer id);

    @UpdateProvider(type=ProjectSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Project record);

    @Update({
        "update project",
        "set name = #{name,jdbcType=VARCHAR},",
          "workSite = #{worksite,jdbcType=VARCHAR},",
          "state = #{state,jdbcType=INTEGER},",
          "contractFile = #{contractfile,jdbcType=VARCHAR},",
          "difficultyLevel = #{difficultylevel,jdbcType=INTEGER},",
          "startTime = #{starttime,jdbcType=TIMESTAMP},",
          "expectedEndTime = #{expectedendtime,jdbcType=TIMESTAMP},",
          "actualEndTime = #{actualendtime,jdbcType=TIMESTAMP},",
          "description = #{description,jdbcType=VARCHAR},",
          "saleId = #{saleid,jdbcType=INTEGER},",
          "clientId = #{clientid,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Project record);
}
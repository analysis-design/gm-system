package com.xzit.garden.mapperAndSqlprovider2;

import com.xzit.garden.bean.entity.*;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

public interface ImplPlanMapper {
    @Delete({
        "delete from impl_plan",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into impl_plan (id, projectId, ",
        "name, stepName, ",
        "difficultyLevel, startTime, ",
        "expectedEndTime, actualEndTime, ",
        "state, description)",
        "values (#{id,jdbcType=INTEGER}, #{projectid,jdbcType=INTEGER}, ",
        "#{name,jdbcType=VARCHAR}, #{stepname,jdbcType=VARCHAR}, ",
        "#{difficultylevel,jdbcType=INTEGER}, #{starttime,jdbcType=TIMESTAMP}, ",
        "#{expectedendtime,jdbcType=TIMESTAMP}, #{actualendtime,jdbcType=TIMESTAMP}, ",
        "#{state,jdbcType=INTEGER}, #{description,jdbcType=VARCHAR})"
    })
    int insert(ImplPlan record);

    @InsertProvider(type=ImplPlanSqlProvider.class, method="insertSelective")
    int insertSelective(ImplPlan record);

    @Select({
        "select",
        "id, projectId, name, stepName, difficultyLevel, startTime, expectedEndTime, ",
        "actualEndTime, state, description",
        "from impl_plan",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType= JdbcType.INTEGER, id=true),
        @Result(column="projectId", property="projectid", jdbcType= JdbcType.INTEGER),
        @Result(column="name", property="name", jdbcType= JdbcType.VARCHAR),
        @Result(column="stepName", property="stepname", jdbcType= JdbcType.VARCHAR),
        @Result(column="difficultyLevel", property="difficultylevel", jdbcType= JdbcType.INTEGER),
        @Result(column="startTime", property="starttime", jdbcType= JdbcType.TIMESTAMP),
        @Result(column="expectedEndTime", property="expectedendtime", jdbcType= JdbcType.TIMESTAMP),
        @Result(column="actualEndTime", property="actualendtime", jdbcType= JdbcType.TIMESTAMP),
        @Result(column="state", property="state", jdbcType= JdbcType.INTEGER),
        @Result(column="description", property="description", jdbcType= JdbcType.VARCHAR)
    })
    ImplPlan selectByPrimaryKey(Integer id);

    @UpdateProvider(type=ImplPlanSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ImplPlan record);

    @Update({
        "update impl_plan",
        "set projectId = #{projectid,jdbcType=INTEGER},",
          "name = #{name,jdbcType=VARCHAR},",
          "stepName = #{stepname,jdbcType=VARCHAR},",
          "difficultyLevel = #{difficultylevel,jdbcType=INTEGER},",
          "startTime = #{starttime,jdbcType=TIMESTAMP},",
          "expectedEndTime = #{expectedendtime,jdbcType=TIMESTAMP},",
          "actualEndTime = #{actualendtime,jdbcType=TIMESTAMP},",
          "state = #{state,jdbcType=INTEGER},",
          "description = #{description,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(ImplPlan record);
}
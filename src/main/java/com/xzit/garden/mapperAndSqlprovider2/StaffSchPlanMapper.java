package com.xzit.garden.mapperAndSqlprovider2;

import com.xzit.garden.bean.entity.*;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

public interface StaffSchPlanMapper {
    @Delete({
        "delete from staff_sch_plan",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into staff_sch_plan (id, implPlanId, ",
        "projectId, startTime, ",
        "expectedEndTime, actualEndTime, ",
        "description)",
        "values (#{id,jdbcType=INTEGER}, #{implplanid,jdbcType=INTEGER}, ",
        "#{projectid,jdbcType=INTEGER}, #{starttime,jdbcType=TIMESTAMP}, ",
        "#{expectedendtime,jdbcType=TIMESTAMP}, #{actualendtime,jdbcType=TIMESTAMP}, ",
        "#{description,jdbcType=VARCHAR})"
    })
    int insert(StaffSchPlan record);

    @InsertProvider(type=StaffSchPlanSqlProvider.class, method="insertSelective")
    int insertSelective(StaffSchPlan record);

    @Select({
        "select",
        "id, implPlanId, projectId, startTime, expectedEndTime, actualEndTime, description",
        "from staff_sch_plan",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType= JdbcType.INTEGER, id=true),
        @Result(column="implPlanId", property="implplanid", jdbcType= JdbcType.INTEGER),
        @Result(column="projectId", property="projectid", jdbcType= JdbcType.INTEGER),
        @Result(column="startTime", property="starttime", jdbcType= JdbcType.TIMESTAMP),
        @Result(column="expectedEndTime", property="expectedendtime", jdbcType= JdbcType.TIMESTAMP),
        @Result(column="actualEndTime", property="actualendtime", jdbcType= JdbcType.TIMESTAMP),
        @Result(column="description", property="description", jdbcType= JdbcType.VARCHAR)
    })
    StaffSchPlan selectByPrimaryKey(Integer id);

    @UpdateProvider(type=StaffSchPlanSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(StaffSchPlan record);

    @Update({
        "update staff_sch_plan",
        "set implPlanId = #{implplanid,jdbcType=INTEGER},",
          "projectId = #{projectid,jdbcType=INTEGER},",
          "startTime = #{starttime,jdbcType=TIMESTAMP},",
          "expectedEndTime = #{expectedendtime,jdbcType=TIMESTAMP},",
          "actualEndTime = #{actualendtime,jdbcType=TIMESTAMP},",
          "description = #{description,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(StaffSchPlan record);
}
package com.xzit.garden.mapper;

import com.xzit.garden.bean.dto.MaintenancePlanDto;
import com.xzit.garden.bean.entity.MaintenancePlan;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
public interface MaintenancePlanMapper {
    @Delete({
        "delete from maintenance_plan",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into maintenance_plan (id, projectId, ",
        "startTime, expectedEndTime, ",
        "actualEndTime, groupId, ",
        "purpose, planState, ",
        "description)",
        "values (#{id,jdbcType=INTEGER}, #{projectid,jdbcType=INTEGER}, ",
        "#{starttime,jdbcType=TIMESTAMP}, #{expectedendtime,jdbcType=TIMESTAMP}, ",
        "#{actualendtime,jdbcType=TIMESTAMP}, #{groupid,jdbcType=INTEGER}, ",
        "#{purpose,jdbcType=VARCHAR}, #{planstate,jdbcType=INTEGER}, ",
        "#{description,jdbcType=VARCHAR})"
    })
    int insert(MaintenancePlan record);

    @InsertProvider(type= MaintenancePlanSqlProvider.class, method="insertSelective")
    int insertSelective(MaintenancePlan record);

    @Select({
        "select",
        "id, projectId, startTime, expectedEndTime, actualEndTime, groupId, purpose, ",
        "planState, description",
        "from maintenance_plan",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType= JdbcType.INTEGER, id=true),
        @Result(column="projectId", property="projectid", jdbcType= JdbcType.INTEGER),
        @Result(column="startTime", property="starttime", jdbcType= JdbcType.TIMESTAMP),
        @Result(column="expectedEndTime", property="expectedendtime", jdbcType= JdbcType.TIMESTAMP),
        @Result(column="actualEndTime", property="actualendtime", jdbcType= JdbcType.TIMESTAMP),
        @Result(column="groupId", property="groupid", jdbcType= JdbcType.INTEGER),
        @Result(column="purpose", property="purpose", jdbcType= JdbcType.VARCHAR),
        @Result(column="planState", property="planstate", jdbcType= JdbcType.INTEGER),
        @Result(column="description", property="description", jdbcType= JdbcType.VARCHAR)
    })
    MaintenancePlan selectByPrimaryKey(Long id);

    @UpdateProvider(type= MaintenancePlanSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(MaintenancePlan record);

    @Update({
        "update maintenance_plan",
        "set projectId = #{projectid,jdbcType=INTEGER},",
          "startTime = #{starttime,jdbcType=TIMESTAMP},",
          "expectedEndTime = #{expectedendtime,jdbcType=TIMESTAMP},",
          "actualEndTime = #{actualendtime,jdbcType=TIMESTAMP},",
          "groupId = #{groupid,jdbcType=INTEGER},",
          "purpose = #{purpose,jdbcType=VARCHAR},",
          "planState = #{planstate,jdbcType=INTEGER},",
          "description = #{description,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(MaintenancePlan record);
    @Select("select * from maintenance_plan")
    List<MaintenancePlan> findAll();

    @Select("select a.* ,b.name from   maintenance_plan as a join project as b on a.projectId=b.id limit #{index}, #{limit}")
    List<MaintenancePlanDto> findPage(@Param("index") Integer index, @Param("limit") Integer limit);

    @Select("select count(*) from maintenance_plan")
    int countList();
}
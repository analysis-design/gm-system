package com.xzit.garden.mapper;

import com.xzit.garden.bean.entity.StaffSchPlan;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StaffSchPlanMapper {

    @Select("select * from staff_sch_plan order by startTime desc limit #{page}, #{limit}")
    List<StaffSchPlan> findPage(@Param("page") int page, @Param("limit") Integer limit);

    @Select("select count(*) from attendance")
    int countStaffSchPlan();

    @Select("select * from staff_sch_plan where id=#{sspId}")
    StaffSchPlan findById(Long sspId);

    @Insert("insert into staff_sch_plan (implPlanId, groupId, startTime, expectedEndTime, actualEndTime, description)" +
            " values (#{implPlanId}, #{groupId}, #{startTime}, #{expectedEndTime}, #{actualEndTime}, #{description})")
    void add(StaffSchPlan staffSchPlan);

    @Update("update staff_sch_plan set implPlanId = #{implPlanId}, groupId = #{groupId}, " +
            "startTime = #{startTime}, expectedEndTime = #{expectedEndTime}, " +
            "actualEndTime = #{actualEndTime}, description = #{description} WHERE id = #{id}")
    void updateById(StaffSchPlan staffSchPlan);
}

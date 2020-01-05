package com.xzit.garden.mapper;

import com.xzit.garden.bean.entity.StaffSchPlan;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StaffSchPlanMapper {

    @Select("select * from staff_sch_plan order by startTime desc limit #{page}, #{limit}")
    List<StaffSchPlan> findPage(@Param("page") int page, @Param("limit") Integer limit);

    @Select("select count(*) from attendance")
    int countStaffSchPlan();
}

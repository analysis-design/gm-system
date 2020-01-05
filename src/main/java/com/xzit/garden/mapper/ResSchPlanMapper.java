package com.xzit.garden.mapper;

import com.xzit.garden.bean.entity.ResSchPlan;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ResSchPlanMapper {

    @Select("select * from res_sch_plan order by allocatedTime desc limit #{page}, #{limit}")
    List<ResSchPlan> findPage(@Param("page") int page, @Param("limit") Integer limit);

    @Select("select count(*) from res_sch_plan")
    int countResSchPlan();
}

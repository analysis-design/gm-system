package com.xzit.garden.mapper;

import com.xzit.garden.bean.entity.ImplPlan;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ImplPlanMapper {

    @Select("select * from impl_plan where id=#{implPlanId}")
    ImplPlan findById(Long implPlanId);
}

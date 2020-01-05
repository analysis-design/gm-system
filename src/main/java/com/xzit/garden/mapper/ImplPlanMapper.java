package com.xzit.garden.mapper;

import com.xzit.garden.bean.entity.ImplPlan;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ImplPlanMapper {

    @Select("select * from impl_plan where id=#{implPlanId}")
    ImplPlan findById(Long implPlanId);

    @Select("select * from impl_plan")
    List<ImplPlan> findAll();

    @Select("select * from impl_plan where state=0")
    List<ImplPlan> findNotImplAll();
}

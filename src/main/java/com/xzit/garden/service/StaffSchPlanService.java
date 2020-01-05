package com.xzit.garden.service;

import com.xzit.garden.bean.dto.StaffSchPlanDto;
import com.xzit.garden.bean.entity.StaffSchPlan;
import com.xzit.garden.bean.model.PageModel;

import java.util.List;

public interface StaffSchPlanService {
    List<StaffSchPlanDto> findAllPage(PageModel<List<StaffSchPlanDto>> pageModel);

    StaffSchPlanDto getById(Long sspId);

    void addStaffSchPlan(StaffSchPlan staffSchPlan);

    void updateById(StaffSchPlan staffSchPlan);

    StaffSchPlan deleteById(Long sspId);

    List<StaffSchPlan> deleteAllById(List<Long> staffSchPlanIdList);
}

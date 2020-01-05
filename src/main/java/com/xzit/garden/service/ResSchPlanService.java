package com.xzit.garden.service;

import com.xzit.garden.bean.dto.ResSchPlanDto;
import com.xzit.garden.bean.entity.ResSchPlan;
import com.xzit.garden.bean.model.PageModel;

import java.util.List;

public interface ResSchPlanService {
    List<ResSchPlanDto> findAllPage(PageModel<List<ResSchPlanDto>> pageModel);

    ResSchPlan getById(Long rspId);

    void addResSchPlan(ResSchPlan resSchPlan);

    void updateById(ResSchPlan resSchPlan);

    ResSchPlan deleteById(Long rspId);

    List<ResSchPlan> deleteAllById(List<Long> resSchPlanIdList);
}

package com.xzit.garden.service;

import com.xzit.garden.bean.dto.ResSchPlanDto;
import com.xzit.garden.bean.model.PageModel;

import java.util.List;

public interface ResSchPlanService {
    List<ResSchPlanDto> findAllPage(PageModel<List<ResSchPlanDto>> pageModel);
}

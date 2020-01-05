package com.xzit.garden.service.impl;

import com.xzit.garden.bean.dto.ResSchPlanDto;
import com.xzit.garden.bean.entity.ResSchPlan;
import com.xzit.garden.bean.model.PageModel;
import com.xzit.garden.mapper.ImplPlanMapper;
import com.xzit.garden.mapper.ResSchPlanMapper;
import com.xzit.garden.mapper.ResourceMapper;
import com.xzit.garden.service.ResSchPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ResSchPlanServiceImpl implements ResSchPlanService {

    @Autowired
    private ResSchPlanMapper resSchPlanMapper;

    @Autowired
    private ResourceMapper resourceMapper;

    @Autowired
    private ImplPlanMapper implPlanMapper;

    @Override
    public List<ResSchPlanDto> findAllPage(PageModel<List<ResSchPlanDto>> pageModel) {
        int page = pageModel.getPage() - 1;
        List<ResSchPlan> resSchPlanList = resSchPlanMapper.
                findPage(page * pageModel.getLimit(), pageModel.getLimit());
        int count = resSchPlanMapper.countResSchPlan();
        pageModel.setCount(count);

        List<ResSchPlanDto> resSchPlanDtoList = new ArrayList<>();
        for (ResSchPlan resSchPlan : resSchPlanList) {
            ResSchPlanDto resSchPlanDto = new ResSchPlanDto(resSchPlan);
            resSchPlanDto.setResName(resourceMapper.findById(resSchPlan.getResId()).getName());
            resSchPlanDto.setImplPlanName(implPlanMapper.findById(resSchPlan.getImplPlanId()).getName());
            resSchPlanDtoList.add(resSchPlanDto);
        }

        return resSchPlanDtoList;
    }
}

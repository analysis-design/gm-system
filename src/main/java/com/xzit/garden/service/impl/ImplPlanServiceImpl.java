package com.xzit.garden.service.impl;

import com.xzit.garden.bean.entity.ImplPlan;
import com.xzit.garden.mapper.ImplPlanMapper;
import com.xzit.garden.service.ImplPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ImplPlanServiceImpl implements ImplPlanService {

    @Autowired
    private ImplPlanMapper implPlanMapper;

    @Override
    public List<ImplPlan> findAll() {
        List<ImplPlan> implPlanList = implPlanMapper.findAll();
        if (implPlanList == null) implPlanList = new ArrayList<>();
        return implPlanList;
    }

    @Override
    public List<ImplPlan> findNotImplAll() {
        List<ImplPlan> implPlanList = implPlanMapper.findNotImplAll();
        if (implPlanList == null) implPlanList = new ArrayList<>();

        return implPlanList;
    }
}

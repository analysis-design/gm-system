package com.xzit.garden.service.impl;

import com.xzit.garden.bean.dto.ResSchPlanDto;
import com.xzit.garden.bean.entity.ImplPlan;
import com.xzit.garden.bean.entity.ResSchPlan;
import com.xzit.garden.bean.entity.Resource;
import com.xzit.garden.bean.model.PageModel;
import com.xzit.garden.exception.ObjectAlreadyInUseException;
import com.xzit.garden.exception.ObjectNotFoundException;
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

    @Override
    public ResSchPlan getById(Long rspId) {
        ResSchPlan resSchPlan = resSchPlanMapper.findById(rspId);

        if (resSchPlan == null)
            throw new ObjectNotFoundException("物资调度计划编号" + rspId + "不存在");

        return resSchPlan;
    }

    @Override
    public void addResSchPlan(ResSchPlan resSchPlan) {
        validateExistImplPlan(resSchPlan.getImplPlanId());
        validateExistResource(resSchPlan.getResId(), resSchPlan.getResNum());


        resSchPlan.setPlanState(0);
        resSchPlanMapper.add(resSchPlan);
    }

    private void validateExistResource(Long resId, Integer resNum) {
        Resource resource = resourceMapper.findById(resId);
        if (resource == null)
            throw new ObjectNotFoundException("物资编号" + resId + "不存在");

        int num = resource.getNum() - resNum;
        if (num < 0)
            throw new RuntimeException("物资数量不足，剩余" + resource.getNum() + resource.getUnit());
    }

    private void validateExistImplPlan(Long implPlanId) {
        ImplPlan implPlan = implPlanMapper.findById(implPlanId);
        if (implPlan == null)
            throw new ObjectNotFoundException("实施计划编号" + implPlanId + "不存在");
    }

    @Override
    public void updateById(ResSchPlan resSchPlan) {
        ResSchPlan temp = getById(resSchPlan.getId());

        if (temp.getPlanState() == 1)
            throw new ObjectAlreadyInUseException("物资调度计划为已分配状态，不可以进行修改操作");

        validateExistImplPlan(resSchPlan.getImplPlanId());
        validateExistResource(resSchPlan.getResId(), resSchPlan.getResNum());

        resSchPlanMapper.updateById(resSchPlan);
    }
}

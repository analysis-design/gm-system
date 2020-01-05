package com.xzit.garden.service.impl;

import com.xzit.garden.bean.dto.StaffSchPlanDto;
import com.xzit.garden.bean.entity.StaffSchPlan;
import com.xzit.garden.bean.model.PageModel;
import com.xzit.garden.mapper.GroupMapper;
import com.xzit.garden.mapper.ImplPlanMapper;
import com.xzit.garden.mapper.StaffSchPlanMapper;
import com.xzit.garden.service.StaffSchPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StaffSchPlanServiceImpl implements StaffSchPlanService {

    @Autowired
    private StaffSchPlanMapper staffSchPlanMapper;

    @Autowired
    private GroupMapper groupMapper;

    @Autowired
    private ImplPlanMapper implPlanMapper;

    @Override
    public List<StaffSchPlanDto> findAllPage(PageModel<List<StaffSchPlanDto>> pageModel) {
        int page = pageModel.getPage() - 1;
        List<StaffSchPlan> staffSchPlanList = staffSchPlanMapper.
                findPage(page * pageModel.getLimit(), pageModel.getLimit());
        int count = staffSchPlanMapper.countStaffSchPlan();
        pageModel.setCount(count);

        List<StaffSchPlanDto> staffSchPlanDtoList = new ArrayList<>();
        for (StaffSchPlan staffSchPlan : staffSchPlanList) {
            StaffSchPlanDto staffSchPlanDto = new StaffSchPlanDto(staffSchPlan);
            staffSchPlanDto.setGroupName(groupMapper.findById(staffSchPlan.getGroupId()).getName());
            staffSchPlanDto.setImplPlanName(implPlanMapper.findById(staffSchPlan.getImplPlanId()).getName());
            staffSchPlanDtoList.add(staffSchPlanDto);
        }

        return staffSchPlanDtoList;
    }
}

package com.xzit.garden.service.impl;

import com.xzit.garden.bean.dto.StaffSchPlanDto;
import com.xzit.garden.bean.entity.Group;
import com.xzit.garden.bean.entity.ImplPlan;
import com.xzit.garden.bean.entity.StaffSchPlan;
import com.xzit.garden.bean.model.PageModel;
import com.xzit.garden.exception.ObjectNotFoundException;
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

    @Override
    public StaffSchPlanDto getById(Long sspId) {
        StaffSchPlan staffSchPlan = staffSchPlanMapper.findById(sspId);
        if (staffSchPlan == null)
            throw new ObjectNotFoundException("人员调度计划编号" + sspId + "不存在");

        return new StaffSchPlanDto(staffSchPlan);
    }

    @Override
    public void addStaffSchPlan(StaffSchPlan staffSchPlan) {
        validateExistImplPlan(staffSchPlan.getImplPlanId());
        validateExistGroup(staffSchPlan.getGroupId());

        staffSchPlanMapper.add(staffSchPlan);
    }

    private void validateExistGroup(Long groupId) {
        Group group = groupMapper.findById(groupId);
        if (group == null)
            throw new ObjectNotFoundException("工程组编号" + groupId + "不存在");
    }

    private void validateExistImplPlan(Long implPlanId) {
        ImplPlan implPlan = implPlanMapper.findById(implPlanId);
        if (implPlan == null)
            throw new ObjectNotFoundException("实施计划编号" + implPlanId + "不存在");
    }

    @Override
    public void updateById(StaffSchPlan staffSchPlan) {
        getById(staffSchPlan.getId());

        validateExistImplPlan(staffSchPlan.getImplPlanId());
        validateExistGroup(staffSchPlan.getGroupId());

        staffSchPlanMapper.updateById(staffSchPlan);
    }
}

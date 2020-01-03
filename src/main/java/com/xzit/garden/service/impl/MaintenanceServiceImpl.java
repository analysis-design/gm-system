package com.xzit.garden.service.impl;

import com.xzit.garden.bean.dto.MaintenancePlanDto;
import com.xzit.garden.bean.entity.Group;
import com.xzit.garden.bean.entity.MaintenancePlan;
import com.xzit.garden.bean.entity.Project;
import com.xzit.garden.bean.model.PageModel;
import com.xzit.garden.mapper.MaintenancePlanMapper;
import com.xzit.garden.service.MaintenancePlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/*
* 包含了养护计划和养护
* */
import java.util.ArrayList;
import java.util.List;
@Service
public class MaintenanceServiceImpl implements MaintenancePlanService {
    @Autowired
    MaintenancePlanMapper maintenancePlanMapper;
    @Override
    public MaintenancePlan findById(Long id) {
        return maintenancePlanMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<MaintenancePlan> findAll() {
        return maintenancePlanMapper.findAll();
    }

    @Override
    public int updateMaintenancePlan(MaintenancePlan maintenancePlan) {
        return maintenancePlanMapper.updateByPrimaryKeySelective(maintenancePlan);
    }

    @Override
    public int deleteMaintenancePlan(Long id) {
        return maintenancePlanMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertMaintenancePlan(MaintenancePlan maintenancePlan) {
        return maintenancePlanMapper.insertSelective(maintenancePlan);
    }

    @Override
    public List<MaintenancePlanDto> getAllMaintenanceList(PageModel<List<MaintenancePlanDto>> page) {
        Integer limit = page.getLimit();
        List<MaintenancePlanDto> maintenancePlanDtoList = maintenancePlanMapper.findPage((page.getPage() - 1) * limit, limit);
        if (maintenancePlanDtoList == null)
            maintenancePlanDtoList = new ArrayList<>();
        int count = maintenancePlanMapper.countList();
        page.setCount(count);
        return maintenancePlanDtoList;
    }

    @Override
    public List<Project> findAllProject() {
        return maintenancePlanMapper.findAllProject();
    }

    @Override
    public List<Group> findAllGroup() {
        return maintenancePlanMapper.findAllGroup();
    }
}

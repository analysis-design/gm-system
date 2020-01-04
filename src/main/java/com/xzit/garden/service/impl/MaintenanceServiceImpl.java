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
import org.springframework.transaction.annotation.Transactional;
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
    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    public int updateMaintenancePlan(MaintenancePlan maintenancePlan) {
        Group group=new Group();
        group.setId(maintenancePlan.getGroupid());
        if(maintenancePlan.getPlanstate()==0)
            group.setState(2);
        else if(maintenancePlan.getPlanstate()==1)
            group.setState(1);
        else group.setState(3);
        int a1=maintenancePlanMapper.updateByPrimaryKeySelective(maintenancePlan);
        int a2=maintenancePlanMapper.updateGroupByPrimaryKeySelective(group);
        int flag=a1*a2;
        return flag;
    }

    @Override
    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    public int deleteMaintenancePlan(Long id)
    {
        Group group=new Group();
        MaintenancePlan maintenancePlan=maintenancePlanMapper.selectByPrimaryKey(id);
        group.setId(maintenancePlan.getGroupid());
        group.setState(3);
        int a1=maintenancePlanMapper.deleteByPrimaryKey(id);
        int a2=maintenancePlanMapper.updateGroupByPrimaryKeySelective(group);
        int flag=a1*a2;
        return flag;
    }


    @Override
    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    public int insertMaintenancePlan(MaintenancePlan maintenancePlan) {
        Group group=new Group();
        group.setId(maintenancePlan.getGroupid());
        if(maintenancePlan.getPlanstate()==0)
        group.setState(2);
        else if(maintenancePlan.getPlanstate()==1)
            group.setState(1);
        else group.setState(3);
       int a1= maintenancePlanMapper.insertSelective(maintenancePlan);
       int a2=maintenancePlanMapper.updateGroupByPrimaryKeySelective(group);
       int flag=a1*a2;
        return flag;
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

    @Override
    public MaintenancePlanDto findDtoById(Long id) {
        return maintenancePlanMapper.findDtoById(id);
    }

    @Override
    public List<MaintenancePlanDto>  searchByIdOrName(PageModel<List<MaintenancePlanDto>> page,String text) {
        Integer limit = page.getLimit();
        List<MaintenancePlanDto> maintenancePlanDtoList = maintenancePlanMapper.searchByIdOrName((page.getPage() - 1) * limit, limit,text);
        if (maintenancePlanDtoList == null)
            maintenancePlanDtoList = new ArrayList<>();
        int count = maintenancePlanMapper.countList();
        page.setCount(count);
        return maintenancePlanDtoList;
    }
}

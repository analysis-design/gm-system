package com.xzit.garden.service;

import com.xzit.garden.bean.dto.MaintenancePlanDto;
import com.xzit.garden.bean.entity.Group;
import com.xzit.garden.bean.entity.MaintenancePlan;
import com.xzit.garden.bean.entity.Project;
import com.xzit.garden.bean.model.PageModel;

import java.util.List;

public interface MaintenancePlanService {
     MaintenancePlan  findById(Long id);
     List<MaintenancePlan> findAll();
     int updateMaintenancePlan(MaintenancePlan maintenancePlan);
     int deleteMaintenancePlan(Long id);
     int insertMaintenancePlan(MaintenancePlan maintenancePlan);
     List<MaintenancePlanDto> getAllMaintenanceList(PageModel<List<MaintenancePlanDto>> page);
     List<Project> findAllProject();
     List<Group> findAllGroup();
     MaintenancePlanDto findDtoById( Long id);
     List<MaintenancePlanDto> searchByIdOrName(PageModel<List<MaintenancePlanDto>> page,String text);
}


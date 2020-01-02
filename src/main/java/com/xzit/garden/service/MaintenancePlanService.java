package com.xzit.garden.service;

import com.xzit.garden.bean.entity.MaintenancePlan;

import java.util.List;

public interface MaintenancePlanService {
     MaintenancePlan  findById(Long id);
     List<MaintenancePlan> findAll();
     int updateMaintenancePlan(MaintenancePlan maintenancePlan);
     int deleteMaintenancePlan(Long id);
     int insertMaintenancePlan(MaintenancePlan maintenancePlan);

}


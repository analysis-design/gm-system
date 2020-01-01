package com.xzit.garden.service;

import com.xzit.garden.bean.entity.MaintenanceRes;

import java.util.List;

public interface MaintenanceResService {
    MaintenanceRes findbyid(Long id);
    List<MaintenanceRes> findall();
    int update(MaintenanceRes maintenanceRes);
    int insert(MaintenanceRes maintenanceRes);
    int delete(Long id);
}

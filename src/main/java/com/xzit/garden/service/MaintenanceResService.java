package com.xzit.garden.service;

import com.xzit.garden.bean.dto.MaintenanceResApplyDto;
import com.xzit.garden.bean.dto.MaintenanceResDto;
import com.xzit.garden.bean.entity.MaintenanceRes;
import com.xzit.garden.bean.entity.MaintenanceplanResApply;
import com.xzit.garden.bean.entity.ResApply;
import com.xzit.garden.bean.entity.Resource;

import java.util.List;

public interface MaintenanceResService {
    MaintenanceRes findbyid(Long id);
    List<MaintenanceRes> findall();
    int update(MaintenanceRes maintenanceRes);
    int insert(MaintenanceRes maintenanceRes);
    int delete(Long id);
    List<MaintenanceResDto> findAllresourceDtoByid(Long id);
    List<MaintenanceResApplyDto> findAllMaintenanceApplyDto(Long id);
    int deleteMaintenanceApplyByPrimaryKey(Long id);
    int updateMaintenanceResApplyByPrimaryKeySelective(MaintenanceplanResApply  record);
    int insertMaintenanceResApplySelective(MaintenanceplanResApply  record);
    MaintenanceplanResApply selectmaintenanceplanRes_applyByPrimaryKey(Long id);
    List<Resource> findAllResource();
}

package com.xzit.garden.service.impl;

import com.xzit.garden.bean.dto.MaintenanceResApplyDto;
import com.xzit.garden.bean.dto.MaintenanceResDto;
import com.xzit.garden.bean.entity.MaintenanceRes;
import com.xzit.garden.bean.entity.MaintenanceplanResApply;
import com.xzit.garden.bean.entity.ResApply;
import com.xzit.garden.bean.entity.Resource;
import com.xzit.garden.mapper.MaintenanceResMapper;
import com.xzit.garden.service.MaintenanceResService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MaintenanceResServiceImpl implements MaintenanceResService {
   @Autowired
   MaintenanceResMapper maintenanceResMapper;


    @Override
    public MaintenanceRes findbyid(Long id) {
        return maintenanceResMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<MaintenanceRes> findall() {
        return null;
    }

    @Override
    public int update(MaintenanceRes maintenanceRes) {
        return maintenanceResMapper.updateByPrimaryKeySelective(maintenanceRes);
    }

    @Override
    public int insert(MaintenanceRes maintenanceRes) {
        return maintenanceResMapper.insert(maintenanceRes);
    }

    @Override
    public int delete(Long id) {
        return maintenanceResMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<MaintenanceResDto> findAllresourceDtoByid(Long id) {
        return maintenanceResMapper.findAllresourceDtoByid(id);
    }

    @Override
    public List<MaintenanceResApplyDto> findAllMaintenanceApplyDto(Long id) {
        return maintenanceResMapper.findAllMaintenanceApplyDto(id);
    }

    @Override
    public int deleteMaintenanceApplyByPrimaryKey(Long id) {
        return maintenanceResMapper.deleteMaintenanceApplyByPrimaryKey(id);
    }

    @Override
    public int updateMaintenanceResApplyByPrimaryKeySelective(MaintenanceplanResApply record) {
        return maintenanceResMapper.updateMaintenanceResApplyByPrimaryKeySelective(record);
    }

    @Override
    public int insertMaintenanceResApplySelective(MaintenanceplanResApply record) {
        return maintenanceResMapper.insertMaintenanceResApplySelective(record);
    }

    @Override
    public MaintenanceplanResApply selectmaintenanceplanRes_applyByPrimaryKey(Long id) {
        return maintenanceResMapper.selectmaintenanceplanRes_applyByPrimaryKey(id);
    }

    @Override
    public List<Resource> findAllResource() {
        return maintenanceResMapper.findAllResource();
    }
}

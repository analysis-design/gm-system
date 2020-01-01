package com.xzit.garden.service.impl;

import com.xzit.garden.bean.entity.MaintenanceRes;
import com.xzit.garden.mapper.MaintenanceResMapper;
import com.xzit.garden.service.MaintenanceResService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MaintenanceResServiceImpl implements MaintenanceResService {
   @Autowired
   MaintenanceResMapper maintenanceResMapper;


    @Override
    public MaintenanceRes findbyid(Long id) {
        return maintenanceResMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<MaintenanceRes> findall() {
        return maintenanceResMapper.findAll();
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


}

package com.xzit.garden.service.impl;

import com.xzit.garden.bean.entity.HireStaff;
import com.xzit.garden.mapper.HireStaffMapper;
import com.xzit.garden.service.HireStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HireStaffServiceImpl implements HireStaffService {

    @Autowired
    private HireStaffMapper hireStaffMapper;

    @Override
    public List<HireStaff> findExistAll() {
        List<HireStaff> hireStaffList = hireStaffMapper.findExistAll();
        if (hireStaffList == null) hireStaffList = new ArrayList<>();

        return hireStaffList;
    }
}

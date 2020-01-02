package com.xzit.garden.service.impl;

import com.xzit.garden.bean.entity.Staff;
import com.xzit.garden.mapper.StaffMapper;
import com.xzit.garden.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StaffServiceImpl implements StaffService {

    @Autowired
    private StaffMapper staffMapper;

    @Override
    public List<Staff> getAllStaff() {
        List<Staff> staffList = staffMapper.findAll();
        if (staffList == null)
            staffList = new ArrayList<>();

        return staffList;
    }
}

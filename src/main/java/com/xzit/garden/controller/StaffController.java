package com.xzit.garden.controller;

import com.xzit.garden.bean.entity.HireStaff;
import com.xzit.garden.bean.entity.Staff;
import com.xzit.garden.service.HireStaffService;
import com.xzit.garden.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/staff")
public class StaffController {
    @Autowired
    private StaffService staffService;

    @Autowired
    private HireStaffService hireStaffService;

    @GetMapping("/list")
    @ResponseBody
    public Map<String, Object> indexList() {
        List<Staff> staffList = staffService.getAllStaff();

        Map<String, Object> rs = new HashMap<>();
        rs.put("code", 0);
        rs.put("msg", "查询完成");
        rs.put("data", staffList);
        return rs;
    }

    @GetMapping("/hire/list")
    @ResponseBody
    public Map<String, Object> indexHireList() {
        List<HireStaff> hireStaffList = hireStaffService.findExistAll();

        Map<String, Object> rs = new HashMap<>();
        rs.put("code", 0);
        rs.put("msg", "查询完成");
        rs.put("data", hireStaffList);
        return rs;
    }
}

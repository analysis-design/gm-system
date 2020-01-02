package com.xzit.garden.controller;

import com.xzit.garden.bean.entity.MaintenancePlan;
import com.xzit.garden.service.MaintenancePlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/*
* 这个controler 包含了养护计划和养护
* */
@Controller
@RequestMapping("/maintenance")
public class MaintenanceController {
    @Autowired
    MaintenancePlanService maintenancePlanService;
    @RequestMapping("findPlane")
    public String findAllMaintenancePlan(Model model){
        List<MaintenancePlan> list=maintenancePlanService.findAll();
        model.addAttribute("maintenancePlanList",list);
       return "MaintenancePlan";
    }
}

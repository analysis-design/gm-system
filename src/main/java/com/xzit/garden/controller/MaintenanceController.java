package com.xzit.garden.controller;

import com.xzit.garden.bean.dto.MaintenancePlanDto;
import com.xzit.garden.bean.dto.UserDto;
import com.xzit.garden.bean.entity.MaintenancePlan;
import com.xzit.garden.bean.model.PageModel;
import com.xzit.garden.service.MaintenancePlanService;
import com.xzit.garden.service.ProjectService;
import com.xzit.garden.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
* 这个controler 包含了养护计划和养护
* */
@Controller
@RequestMapping("/maintenance")
public class MaintenanceController {
    @Autowired
    MaintenancePlanService maintenancePlanService;
    @Autowired
    ProjectService projectService;
    @Autowired
    UserService userService;
    @RequestMapping("/index")
    public String returnpage(Model model)
    {
        return "MaintenancePlan";
    }
    @RequestMapping("/list")
    @ResponseBody
    public Map<String, Object> maintenanceList(PageModel<List<MaintenancePlanDto>> page) {
        List<MaintenancePlanDto> maintenancePlanDtoList = maintenancePlanService.getAllMaintenanceList(page);
        Map<String, Object> data = new HashMap<>();
        data.put("code", 0);
        data.put("msg", "查询完成");
        data.put("count", page.getCount());
        data.put("data", maintenancePlanDtoList);
        return data;
    }

    @GetMapping("/add/index")
    public String addIndex(Model model) {
        UserDto user = userService.getUserDto();
        PageModel<List<MaintenancePlanDto>> pageModel = new PageModel<>();
        pageModel.setPage(1);
        pageModel.setLimit(65536);
        List<MaintenancePlanDto> maintenancePlanDtoList = maintenancePlanService.getAllMaintenanceList(pageModel);
        model.addAttribute("user", user);
        model.addAttribute("msg", "添加计划");
        model.addAttribute("authList", maintenancePlanDtoList);
        return "maintenancePlan_edit";
    }

    @PostMapping("/add")
    @ResponseBody
    public Map<String, Object> authAdd(@RequestBody MaintenancePlan maintenancePlan) {
        maintenancePlanService.insertMaintenancePlan(maintenancePlan);
        Map<String, Object> rs = new HashMap<>();
        rs.put("code", 0);
        rs.put("msg", "添加成功");
        rs.put("data", maintenancePlan);
        return rs;
    }
}

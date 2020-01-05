package com.xzit.garden.controller;

import com.xzit.garden.bean.dto.MaintenancePlanDto;
import com.xzit.garden.bean.dto.UserDto;
import com.xzit.garden.bean.entity.Group;
import com.xzit.garden.bean.entity.MaintenancePlan;
import com.xzit.garden.bean.entity.Project;
import com.xzit.garden.bean.model.PageModel;
import com.xzit.garden.service.MaintenancePlanService;
import com.xzit.garden.service.ProjectService;
import com.xzit.garden.service.UserService;
import com.xzit.garden.util.DateChangeUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Date;

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
    @RequestMapping("/search/list")
    @ResponseBody
    public Map<String, Object> maintenanceSearchList(PageModel<List<MaintenancePlanDto>> page,String search) {
        List<MaintenancePlanDto> maintenancePlanDtoList = maintenancePlanService.searchByIdOrName(page,search);
        Map<String, Object> data = new HashMap<>();
        data.put("code", 0);
        data.put("msg", "查询完成");
        data.put("count", page.getCount());
        data.put("data", maintenancePlanDtoList);
        return data;
    }
    @GetMapping("/add/index")
    public String addIndex(Model model, Long id) {
        MaintenancePlan maintenancePlan=new MaintenancePlan();
        int type=0;
        if(id!=null)
            maintenancePlan=maintenancePlanService.findById(id);
        model.addAttribute("maintenancePlan",maintenancePlan);
        List<Project> list=maintenancePlanService.findAllProject();
        List<Group> list1=maintenancePlanService.findAllGroup();
        MaintenancePlanDto maintenancePlanDto=new MaintenancePlanDto();
        if(id!=null){
            maintenancePlanDto=maintenancePlanService.findDtoById(id);
            DateChangeUtil dateChangeUtil=new DateChangeUtil();
            model.addAttribute("starttime",dateChangeUtil.changeDate(maintenancePlan.getStarttime()));
            model.addAttribute("expectedendtime",dateChangeUtil.changeDate(maintenancePlan.getExpectedendtime()));
            model.addAttribute("actualendtime",dateChangeUtil.changeDate(maintenancePlan.getActualendtime()));
            type=1;
        }
        System.out.println(type);

        model.addAttribute("maintenanceDto",maintenancePlanDto);
        model.addAttribute("project",list);
        model.addAttribute("group",list1);
        model.addAttribute("type",type);
        return "maintenancePlan_edit";
    }

    @PostMapping("/add")
    @ResponseBody
    public Map<String, Object> authAdd(@RequestBody MaintenancePlan maintenancePlan) {
        int result=maintenancePlanService.insertMaintenancePlan(maintenancePlan);
        Map<String, Object> rs = new HashMap<>();
        rs.put("code", 0);
        if(result==0)
            rs.put("msg","添加失败");
        else
            rs.put("msg", "添加成功");
        rs.put("data", maintenancePlan);
        System.out.println("插入成功");
        return rs;
    }
    @RequestMapping("/update")
    @ResponseBody
    public  Map<String, Object> update(@RequestBody MaintenancePlan maintenancePlan,Long meantenceid)
    {
        maintenancePlan.setId(meantenceid);
        System.out.println(maintenancePlan.getId());

        int result=maintenancePlanService.updateMaintenancePlan(maintenancePlan);
        Map<String, Object> rs = new HashMap<>();
        rs.put("code", 0);
        if(result==0)
            rs.put("msg","更新失败");
        else
            rs.put("msg", "更新成功");
        System.out.println("更新");
        rs.put("data", maintenancePlan);
        return rs;
    }
    @RequestMapping("/del")
    @ResponseBody
    public Map<String, Object> userDelete(Model model,Long id) {
        int flag=maintenancePlanService.deleteMaintenancePlan(id);
        Map<String, Object> rs = new HashMap<>();
        rs.put("code", 0);
        if(flag!=0)
        rs.put("msg", "删除成功");
        else
            rs.put("msg","删除失败");
        return rs;
    }

}
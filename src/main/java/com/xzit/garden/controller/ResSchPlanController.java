package com.xzit.garden.controller;

import com.xzit.garden.bean.dto.ResSchPlanDto;
import com.xzit.garden.bean.entity.ImplPlan;
import com.xzit.garden.bean.entity.ResSchPlan;
import com.xzit.garden.bean.entity.Resource;
import com.xzit.garden.bean.model.PageModel;
import com.xzit.garden.service.ImplPlanService;
import com.xzit.garden.service.ResSchPlanService;
import com.xzit.garden.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/rsp")
public class ResSchPlanController {

    @Autowired
    private ResSchPlanService resSchPlanService;

    @Autowired
    private ImplPlanService implPlanService;

    @Autowired
    private ResourceService resourceService;

    @GetMapping("/index")
    public String index() {
        return "res_sch_plan";
    }

    @GetMapping("/add/index")
    public String addIndex(Model model) {
        List<ImplPlan> implPlanList = implPlanService.findAll();
        List<Resource> resourceList = resourceService.findAll();

        model.addAttribute("msg", "添加物资调度计划信息");
        model.addAttribute("flag", 0);
        model.addAttribute("implPlanList", implPlanList);
        model.addAttribute("resourceList", resourceList);
        model.addAttribute("url", "/rsp/add");
        return "res_sch_plan_edit";
    }

    @GetMapping("/upd/index")
    public String updIndex(@RequestParam("rspId") Long rspId, Model model) {
        List<ImplPlan> implPlanList = implPlanService.findAll();
        List<Resource> resourceList = resourceService.findAll();
        ResSchPlan resSchPlan = resSchPlanService.getById(rspId);

        model.addAttribute("msg", "编辑物资调度计划信息");
        model.addAttribute("flag", 1);
        model.addAttribute("resSchPlan", resSchPlan);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date allocatedTime = resSchPlan.getAllocatedTime();
        String newTime = "";
        if (allocatedTime != null)
            newTime = simpleDateFormat.format(allocatedTime);

        model.addAttribute("allocatedTime", newTime);
        model.addAttribute("implPlanList", implPlanList);
        model.addAttribute("resourceList", resourceList);
        model.addAttribute("url", "/rsp/upd");
        return "res_sch_plan_edit";
    }

    @PostMapping("/add")
    @ResponseBody
    public Map<String, Object> groupAdd(@RequestBody ResSchPlan resSchPlan) {
        resSchPlanService.addResSchPlan(resSchPlan);

        Map<String, Object> rs = new HashMap<>();
        rs.put("code", 0);
        rs.put("msg", "添加成功");
        rs.put("data", resSchPlan);
        return rs;
    }

    @PostMapping("/upd")
    @ResponseBody
    public Map<String, Object> userUpdate(@RequestBody ResSchPlan resSchPlan) {
        resSchPlanService.updateById(resSchPlan);

        Map<String, Object> rs = new HashMap<>();
        rs.put("msg", "修改成功");
        rs.put("data", resSchPlan);
        rs.put("code", 0);
        return rs;
    }

    @RequestMapping("/del")
    @ResponseBody
    public Map<String, Object> userDelete(@RequestParam("rspId") Long rspId) {
        ResSchPlan resSchPlan = resSchPlanService.deleteById(rspId);
        Map<String, Object> rs = new HashMap<>();
        rs.put("code", 0);
        rs.put("msg", "删除成功");
        rs.put("data", resSchPlan);
        return rs;
    }

    @PostMapping("/del/list")
    @ResponseBody
    public Map<String, Object> userDeleteAll(@RequestBody List<Long> resSchPlanIdList) {
        List<ResSchPlan> resSchPlanList = resSchPlanService.deleteAllById(resSchPlanIdList);
        Map<String, Object> rs = new HashMap<>();
        rs.put("code", 0);
        rs.put("msg", "删除成功");
        rs.put("data", resSchPlanList);
        return rs;
    }

    @GetMapping("/list")
    @ResponseBody
    public Map<String, Object> indexList(PageModel<List<ResSchPlanDto>> pageModel) {
        List<ResSchPlanDto> resourceList = resSchPlanService.findAllPage(pageModel);

        Map<String, Object> rs = new HashMap<>();
        rs.put("code", 0);
        rs.put("count", pageModel.getCount());
        rs.put("msg", "查询完成");
        rs.put("data", resourceList);
        return rs;
    }
}

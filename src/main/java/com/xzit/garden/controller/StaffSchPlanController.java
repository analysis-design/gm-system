package com.xzit.garden.controller;

import com.xzit.garden.bean.dto.StaffSchPlanDto;
import com.xzit.garden.bean.entity.Group;
import com.xzit.garden.bean.entity.ImplPlan;
import com.xzit.garden.bean.entity.StaffSchPlan;
import com.xzit.garden.bean.model.PageModel;
import com.xzit.garden.service.GroupService;
import com.xzit.garden.service.ImplPlanService;
import com.xzit.garden.service.StaffSchPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/ssp")
public class StaffSchPlanController {

    @Autowired
    private StaffSchPlanService staffSchPlanService;

    @Autowired
    private ImplPlanService implPlanService;

    @Autowired
    private GroupService groupService;

    @GetMapping("/index")
    public String index() {
        return "staff_sch_plan";
    }

    @GetMapping("/add/index")
    public String addIndex(Model model) {
        List<ImplPlan> implPlanList = implPlanService.findNotImplAll();
        List<Group>  groupList = groupService.getNotImplAll();

        model.addAttribute("msg", "添加人员调度计划");
        model.addAttribute("flag", 0);
        model.addAttribute("implPlanList", implPlanList);
        model.addAttribute("groupList", groupList);
        model.addAttribute("url", "/ssp/add");
        return "staff_sch_plan_edit";
    }

    @GetMapping("/upd/index")
    public String updIndex(@RequestParam("sspId") Long sspId, Model model) {
        List<ImplPlan> implPlanList = implPlanService.findNotImplAll();
        List<Group>  groupList = groupService.getNotImplAll();
        StaffSchPlanDto staffSchPlanDto = staffSchPlanService.getById(sspId);

        model.addAttribute("msg", "编辑人员调度计划");
        model.addAttribute("flag", 1);
        model.addAttribute("staffSchPlan", staffSchPlanDto);
        model.addAttribute("startTime", staffSchPlanDto.getNewTime());
        model.addAttribute("expectedTime", staffSchPlanDto.getOldExpectedTime());
        model.addAttribute("endTime", staffSchPlanDto.getOldTime());
        model.addAttribute("implPlanList", implPlanList);
        model.addAttribute("groupList", groupList);
        model.addAttribute("url", "/ssp/upd");
        return "staff_sch_plan_edit";
    }

    @PostMapping("/add")
    @ResponseBody
    public Map<String, Object> groupAdd(@RequestBody StaffSchPlan staffSchPlan) {
        staffSchPlanService.addStaffSchPlan(staffSchPlan);

        Map<String, Object> rs = new HashMap<>();
        rs.put("code", 0);
        rs.put("msg", "添加成功");
        rs.put("data", staffSchPlan);
        return rs;
    }

    @PostMapping("/upd")
    @ResponseBody
    public Map<String, Object> userUpdate(@RequestBody StaffSchPlan staffSchPlan) {
        Map<String, Object> rs = new HashMap<>();
        staffSchPlanService.updateById(staffSchPlan);

        rs.put("code", 0);
        rs.put("msg", "修改成功");
        rs.put("data", staffSchPlan);
        return rs;
    }

    @GetMapping("/list")
    @ResponseBody
    public Map<String, Object> indexList(PageModel<List<StaffSchPlanDto>> pageModel) {
        List<StaffSchPlanDto> staffSchPlanDtoList = staffSchPlanService.findAllPage(pageModel);
        Map<String, Object> rs = new HashMap<>();
        rs.put("count", pageModel.getCount());
        rs.put("code", 0);
        rs.put("msg", "查询完成");
        rs.put("data", staffSchPlanDtoList);
        return rs;
    }
}

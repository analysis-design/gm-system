package com.xzit.garden.controller;

import com.xzit.garden.bean.dto.StaffSchPlanDto;
import com.xzit.garden.bean.model.PageModel;
import com.xzit.garden.service.StaffSchPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/ssp")
public class StaffSchPlanController {

    @Autowired
    private StaffSchPlanService staffSchPlanService;

    @GetMapping("/index")
    public String index() {
        return "staff_sch_plan";
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

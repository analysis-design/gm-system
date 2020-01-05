package com.xzit.garden.controller;

import com.xzit.garden.bean.dto.ResSchPlanDto;
import com.xzit.garden.bean.model.PageModel;
import com.xzit.garden.service.ResSchPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/rsp")
public class ResSchPlanController {

    @Autowired
    private ResSchPlanService resSchPlanService;

    @GetMapping("/index")
    public String index() {
        return "res_sch_plan";
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

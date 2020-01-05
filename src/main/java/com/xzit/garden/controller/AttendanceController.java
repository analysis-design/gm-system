package com.xzit.garden.controller;

import com.xzit.garden.bean.dto.AttendanceDto;
import com.xzit.garden.bean.model.PageModel;
import com.xzit.garden.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @GetMapping("/index")
    public String index() {
        return "attendance";
    }

    @GetMapping("/list")
    @ResponseBody
    public Map<String, Object> indexList(PageModel<List<AttendanceDto>> pageModel) {
        List<AttendanceDto> attendanceList =  attendanceService.findAllPage(pageModel);
        Map<String, Object> rs = new HashMap<>();
        rs.put("code", 0);
        rs.put("count", pageModel.getCount());
        rs.put("data", attendanceList);
        rs.put("msg", "查询完成");
        return rs;
    }
}

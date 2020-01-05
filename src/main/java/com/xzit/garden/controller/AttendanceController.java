package com.xzit.garden.controller;

import com.xzit.garden.bean.dto.AttendanceDto;
import com.xzit.garden.bean.entity.Attendance;
import com.xzit.garden.bean.entity.HireStaff;
import com.xzit.garden.bean.entity.Staff;
import com.xzit.garden.bean.model.PageModel;
import com.xzit.garden.service.AttendanceService;
import com.xzit.garden.service.HireStaffService;
import com.xzit.garden.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @Autowired
    private StaffService staffService;

    @Autowired
    private HireStaffService hireStaffService;

    @GetMapping("/index")
    public String index() {
        return "attendance";
    }

    @GetMapping("/add/index")
    public String addIndex(Model model) {
        List<Staff> staffList = staffService.getAllStaff();

        model.addAttribute("msg", "添加考勤信息");
        model.addAttribute("flag", 0);
        model.addAttribute("staffList", staffList);
        model.addAttribute("url", "/attendance/add");
        return "attendance_edit";
    }

    @GetMapping("/upd/index")
    public String updIndex(@RequestParam("attendanceId") Long attendanceId, Model model) {
        List<Staff> staffList = staffService.getAllStaff();
        List<HireStaff> hireStaffList = hireStaffService.findExistAll();
        AttendanceDto attendance = attendanceService.getById(attendanceId);

        model.addAttribute("msg", "编辑考勤信息");
        model.addAttribute("flag", 1);
        model.addAttribute("attendance", attendance);
        model.addAttribute("startTime", attendance.getNewTime());
        model.addAttribute("endTime", attendance.getOldTime());
        if (attendance.getStaffType() == 0)
            model.addAttribute("staffList", staffList);
        else if (attendance.getStaffType() == 1)
            model.addAttribute("staffList", hireStaffList);

        model.addAttribute("url", "/attendance/upd");
        return "attendance_edit";
    }

    @PostMapping("/add")
    @ResponseBody
    public Map<String, Object> groupAdd(@RequestBody Attendance attendance) {
        attendanceService.addAttendance(attendance);

        Map<String, Object> rs = new HashMap<>();
        rs.put("code", 0);
        rs.put("msg", "添加成功");
        rs.put("data", attendance);
        return rs;
    }

    @PostMapping("/upd")
    @ResponseBody
    public Map<String, Object> userUpdate(@RequestBody Attendance attendance) {
        attendanceService.updateById(attendance);

        Map<String, Object> rs = new HashMap<>();
        rs.put("data", attendance);
        rs.put("msg", "修改成功");
        rs.put("code", 0);
        return rs;
    }

    @RequestMapping("/del")
    @ResponseBody
    public Map<String, Object> userDelete(@RequestParam("attendanceId") Long attendanceId) {
        Attendance attendance = attendanceService.deleteById(attendanceId);
        Map<String, Object> rs = new HashMap<>();
        rs.put("code", 0);
        rs.put("msg", "删除成功");
        rs.put("data", attendance);
        return rs;
    }

    @PostMapping("/del/list")
    @ResponseBody
    public Map<String, Object> userDeleteAll(@RequestBody List<Long> attendanceIdList) {
        List<Attendance> attendanceList = attendanceService.deleteAllById(attendanceIdList);
        Map<String, Object> rs = new HashMap<>();
        rs.put("code", 0);
        rs.put("msg", "删除成功");
        rs.put("data", attendanceList);
        return rs;
    }

    @GetMapping("/list")
    @ResponseBody
    public Map<String, Object> indexList(PageModel<List<AttendanceDto>> pageModel) {
        List<AttendanceDto> attendanceList = attendanceService.findAllPage(pageModel);
        Map<String, Object> rs = new HashMap<>();
        rs.put("code", 0);
        rs.put("count", pageModel.getCount());
        rs.put("data", attendanceList);
        rs.put("msg", "查询完成");
        return rs;
    }
}

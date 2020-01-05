package com.xzit.garden.service.impl;

import com.xzit.garden.bean.dto.AttendanceDto;
import com.xzit.garden.bean.entity.Attendance;
import com.xzit.garden.bean.model.PageModel;
import com.xzit.garden.mapper.AttendanceMapper;
import com.xzit.garden.mapper.HireStaffMapper;
import com.xzit.garden.mapper.StaffMapper;
import com.xzit.garden.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AttendanceServiceImpl implements AttendanceService {

    @Autowired
    private AttendanceMapper attendanceMapper;

    @Autowired
    private StaffMapper staffMapper;

    @Autowired
    private HireStaffMapper hireStaffMapper;

    @Override
    public List<AttendanceDto> findAllPage(PageModel<List<AttendanceDto>> pageModel) {
        int page = pageModel.getPage() - 1;
        List<Attendance> attendanceList = attendanceMapper.findPage(page * pageModel.getLimit(), pageModel.getLimit());
        int count = attendanceMapper.countAttendance();
        pageModel.setCount(count);
        if (attendanceList == null)
            attendanceList = new ArrayList<>();

        List<AttendanceDto> attendanceDtoList = new ArrayList<>();
        for (Attendance attendance : attendanceList) {
            AttendanceDto attendanceDto = new AttendanceDto(attendance);
            if (attendance.getStaffType() == 0)
                attendanceDto.setStaffName(staffMapper.findById(attendance.getStaffId()).getName());
            else
                attendanceDto.setStaffName(hireStaffMapper.findById(attendance.getStaffId()).getName());
            attendanceDtoList.add(attendanceDto);
        }
        return attendanceDtoList;
    }
}

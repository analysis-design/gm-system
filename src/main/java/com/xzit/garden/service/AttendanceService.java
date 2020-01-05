package com.xzit.garden.service;

import com.xzit.garden.bean.dto.AttendanceDto;
import com.xzit.garden.bean.entity.Attendance;
import com.xzit.garden.bean.model.PageModel;

import java.util.List;

public interface AttendanceService {
    List<AttendanceDto> findAllPage(PageModel<List<AttendanceDto>> pageModel);

    AttendanceDto getById(Long attendanceId);

    void addAttendance(Attendance attendance);

    void updateById(Attendance attendance);

    Attendance deleteById(Long attendanceId);

    List<Attendance> deleteAllById(List<Long> attendanceIdList);
}

package com.xzit.garden.service.impl;

import com.xzit.garden.bean.dto.AttendanceDto;
import com.xzit.garden.bean.entity.Attendance;
import com.xzit.garden.bean.entity.Staff;
import com.xzit.garden.bean.model.PageModel;
import com.xzit.garden.exception.ObjectNotFoundException;
import com.xzit.garden.mapper.AttendanceMapper;
import com.xzit.garden.mapper.HireStaffMapper;
import com.xzit.garden.mapper.StaffMapper;
import com.xzit.garden.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Override
    public AttendanceDto getById(Long attendanceId) {
        Attendance attendance = attendanceMapper.findById(attendanceId);
        if (attendance == null)
            throw new ObjectNotFoundException("考勤信息编号" + attendanceId + "不存在");
        return new AttendanceDto(attendance);
    }

    @Transactional
    @Override
    public void addAttendance(Attendance attendance) {
        Long staffId = attendance.getStaffId();
        if (attendance.getStaffType() == 0)
            validateExistStaff(staffId);
        else validateExistHireStaff(staffId);

        attendanceMapper.add(attendance);
    }

    private void validateExistHireStaff(Long staffId) {
        Staff staff = staffMapper.findByHireStaffId(staffId);
        if (staff == null)
            throw new ObjectNotFoundException("雇佣员工编号" + staffId + "不存在");
    }

    private void validateExistStaff(Long staffId) {
        Staff staff = staffMapper.findById(staffId);
        if (staff == null)
            throw new ObjectNotFoundException("公司员工编号" + staffId + "不存在");
    }

    @Transactional
    @Override
    public void updateById(Attendance attendance) {
        getById(attendance.getId());

        Long staffId = attendance.getStaffId();
        if (attendance.getStaffType() == 0)
            validateExistStaff(staffId);
        else validateExistHireStaff(staffId);

        attendanceMapper.updateById(attendance);
    }

    @Transactional
    @Override
    public Attendance deleteById(Long attendanceId) {
        AttendanceDto attendanceDto = getById(attendanceId);
        attendanceMapper.deleteById(attendanceId);
        return attendanceDto;
    }

    @Transactional
    @Override
    public List<Attendance> deleteAllById(List<Long> attendanceIdList) {
        List<Attendance> attendanceList = new ArrayList<>();

        if (attendanceIdList == null || attendanceIdList.size() == 0) return attendanceList;

        for (Long id : attendanceIdList) {
            AttendanceDto attendanceDto = getById(id);
            attendanceList.add(attendanceDto);
        }

        attendanceMapper.deleteByIdList(attendanceIdList);
        return attendanceList;
    }
}

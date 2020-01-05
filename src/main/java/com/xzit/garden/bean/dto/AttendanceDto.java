package com.xzit.garden.bean.dto;

import com.xzit.garden.bean.entity.Attendance;

import java.text.SimpleDateFormat;

public class AttendanceDto extends Attendance {

    private String staffName;
    private String newTime;
    private String oldTime;

    public AttendanceDto() {
    }

    public AttendanceDto(Attendance attendance) {
        this.setId(attendance.getId());
        this.setStartTime(attendance.getStartTime());
        this.setEndTime(attendance.getEndTime());
        this.setStaffId(attendance.getStaffId());
        this.setStaffType(attendance.getStaffType());
        this.setAttendanceState(attendance.getAttendanceState());
        this.setDescription(attendance.getDescription());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.newTime = simpleDateFormat.format(attendance.getStartTime());
        this.oldTime = simpleDateFormat.format(attendance.getEndTime());
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getNewTime() {
        return newTime;
    }

    public void setNewTime(String newTime) {
        this.newTime = newTime;
    }

    public String getOldTime() {
        return oldTime;
    }

    public void setOldTime(String oldTime) {
        this.oldTime = oldTime;
    }
}

package com.xzit.garden.bean.dto;

import com.xzit.garden.bean.entity.Attendance;

import java.text.SimpleDateFormat;
import java.util.Date;

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
        Date startTime = attendance.getStartTime();
        if (startTime != null)
            this.newTime = simpleDateFormat.format(startTime);

        Date endTime = attendance.getEndTime();
        if (endTime != null)
            this.oldTime = simpleDateFormat.format(endTime);
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

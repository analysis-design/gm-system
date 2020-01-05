package com.xzit.garden.bean.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Attendance {
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date startTime;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date endTime;

    private Long staffId;

    private Integer staffType;

    private Integer attendanceState;

    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Long getStaffId() {
        return staffId;
    }

    public void setStaffId(Long staffId) {
        this.staffId = staffId;
    }

    public Integer getStaffType() {
        return staffType;
    }

    public void setStaffType(Integer staffType) {
        this.staffType = staffType;
    }

    public Integer getAttendanceState() {
        return attendanceState;
    }

    public void setAttendanceState(Integer attendanceState) {
        this.attendanceState = attendanceState;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}
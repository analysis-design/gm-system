package com.xzit.garden.bean.entity;

import java.util.Date;

public class Attendance {
    private Integer id;

    private Date starttime;

    private Date endtime;

    private Integer staffid;

    private Integer stafftype;

    private Integer attendancestate;

    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public Integer getStaffid() {
        return staffid;
    }

    public void setStaffid(Integer staffid) {
        this.staffid = staffid;
    }

    public Integer getStafftype() {
        return stafftype;
    }

    public void setStafftype(Integer stafftype) {
        this.stafftype = stafftype;
    }

    public Integer getAttendancestate() {
        return attendancestate;
    }

    public void setAttendancestate(Integer attendancestate) {
        this.attendancestate = attendancestate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}
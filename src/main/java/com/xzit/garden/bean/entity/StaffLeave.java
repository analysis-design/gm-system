package com.xzit.garden.bean.entity;

import java.util.Date;

public class StaffLeave {
    private Long id;

    private Date starttime;

    private Date endtime;

    private Long staffid;

    private Integer stafftype;

    private String reason;

    private Integer leavetype;

    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Long getStaffid() {
        return staffid;
    }

    public void setStaffid(Long staffid) {
        this.staffid = staffid;
    }

    public Integer getStafftype() {
        return stafftype;
    }

    public void setStafftype(Integer stafftype) {
        this.stafftype = stafftype;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }

    public Integer getLeavetype() {
        return leavetype;
    }

    public void setLeavetype(Integer leavetype) {
        this.leavetype = leavetype;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}
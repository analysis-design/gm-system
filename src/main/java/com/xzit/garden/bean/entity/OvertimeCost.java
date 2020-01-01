package com.xzit.garden.bean.entity;

import java.util.Date;

public class OvertimeCost {
    private Long id;

    private Long staffid;

    private Date starttime;

    private Date endtime;

    private Integer auditstate;

    private Integer overtimetotal;

    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStaffid() {
        return staffid;
    }

    public void setStaffid(Long staffid) {
        this.staffid = staffid;
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

    public Integer getAuditstate() {
        return auditstate;
    }

    public void setAuditstate(Integer auditstate) {
        this.auditstate = auditstate;
    }

    public Integer getOvertimetotal() {
        return overtimetotal;
    }

    public void setOvertimetotal(Integer overtimetotal) {
        this.overtimetotal = overtimetotal;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}
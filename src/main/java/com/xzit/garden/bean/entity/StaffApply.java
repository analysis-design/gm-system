package com.xzit.garden.bean.entity;

import java.util.Date;

public class StaffApply {
    private Integer id;

    private Date applytime;

    private Integer auditstate;

    private Integer groupid;

    private Integer implplanid;

    private Integer applierid;

    private String purpose;

    private Integer staffType;

    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getApplytime() {
        return applytime;
    }

    public void setApplytime(Date applytime) {
        this.applytime = applytime;
    }

    public Integer getAuditstate() {
        return auditstate;
    }

    public void setAuditstate(Integer auditstate) {
        this.auditstate = auditstate;
    }

    public Integer getGroupid() {
        return groupid;
    }

    public void setGroupid(Integer groupid) {
        this.groupid = groupid;
    }

    public Integer getImplplanid() {
        return implplanid;
    }

    public void setImplplanid(Integer implplanid) {
        this.implplanid = implplanid;
    }

    public Integer getApplierid() {
        return applierid;
    }

    public void setApplierid(Integer applierid) {
        this.applierid = applierid;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose == null ? null : purpose.trim();
    }

    public Integer getStaffType() {
        return staffType;
    }

    public void setStaffType(Integer staffType) {
        this.staffType = staffType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}
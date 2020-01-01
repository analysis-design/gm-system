package com.xzit.garden.bean.entity;

import java.util.Date;

public class StaffApply {
    private Long id;

    private Date applytime;

    private Integer auditstate;

    private Long groupid;

    private Long implplanid;

    private Long applierid;

    private String purpose;

    private Integer staffType;

    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Long getGroupid() {
        return groupid;
    }

    public void setGroupid(Long groupid) {
        this.groupid = groupid;
    }

    public Long getImplplanid() {
        return implplanid;
    }

    public void setImplplanid(Long implplanid) {
        this.implplanid = implplanid;
    }

    public Long getApplierid() {
        return applierid;
    }

    public void setApplierid(Long applierid) {
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
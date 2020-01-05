package com.xzit.garden.bean.entity;

import java.util.Date;

public class MaintenanceplanResApply {
    private Long id;

    private Date applytime;

    private Integer auditstate;

    private Long applierid;

    private Long resid;

    private Integer resnum;

    private String purpose;

    private Long implplanid;

    private Date resallocatedtime;

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

    public Long getApplierid() {
        return applierid;
    }

    public void setApplierid(Long applierid) {
        this.applierid = applierid;
    }

    public Long getResid() {
        return resid;
    }

    public void setResid(Long resid) {
        this.resid = resid;
    }

    public Integer getResnum() {
        return resnum;
    }

    public void setResnum(Integer resnum) {
        this.resnum = resnum;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose == null ? null : purpose.trim();
    }

    public Long getImplplanid() {
        return implplanid;
    }

    public void setImplplanid(Long implplanid) {
        this.implplanid = implplanid;
    }

    public Date getResallocatedtime() {
        return resallocatedtime;
    }

    public void setResallocatedtime(Date resallocatedtime) {
        this.resallocatedtime = resallocatedtime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}

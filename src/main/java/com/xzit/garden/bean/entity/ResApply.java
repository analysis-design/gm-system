package com.xzit.garden.bean.entity;

import java.util.Date;

public class ResApply {
    private Integer id;

    private Date applytime;

    private Integer auditstate;

    private Integer applierid;

    private Integer resid;

    private Integer resnum;

    private String purpose;

    private Integer implplanid;

    private Date resallocatedtime;

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

    public Integer getApplierid() {
        return applierid;
    }

    public void setApplierid(Integer applierid) {
        this.applierid = applierid;
    }

    public Integer getResid() {
        return resid;
    }

    public void setResid(Integer resid) {
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

    public Integer getImplplanid() {
        return implplanid;
    }

    public void setImplplanid(Integer implplanid) {
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
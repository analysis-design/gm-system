package com.xzit.garden.bean.entity;

import java.util.Date;

public class ResSchPlan {
    private Integer id;

    private Integer implplanid;

    private Integer resid;

    private Integer resnum;

    private Integer planstate;

    private Date allocatedtime;

    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getImplplanid() {
        return implplanid;
    }

    public void setImplplanid(Integer implplanid) {
        this.implplanid = implplanid;
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

    public Integer getPlanstate() {
        return planstate;
    }

    public void setPlanstate(Integer planstate) {
        this.planstate = planstate;
    }

    public Date getAllocatedtime() {
        return allocatedtime;
    }

    public void setAllocatedtime(Date allocatedtime) {
        this.allocatedtime = allocatedtime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}
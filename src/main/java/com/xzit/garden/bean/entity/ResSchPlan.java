package com.xzit.garden.bean.entity;

import java.util.Date;

public class ResSchPlan {
    private Long id;

    private Long implplanid;

    private Long resid;

    private Integer resnum;

    private Integer planstate;

    private Date allocatedtime;

    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getImplplanid() {
        return implplanid;
    }

    public void setImplplanid(Long implplanid) {
        this.implplanid = implplanid;
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
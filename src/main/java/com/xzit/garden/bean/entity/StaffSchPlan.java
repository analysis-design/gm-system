package com.xzit.garden.bean.entity;

import java.util.Date;

public class StaffSchPlan {
    private Long id;

    private Long implplanid;

    private Long projectid;

    private Date starttime;

    private Date expectedendtime;

    private Date actualendtime;

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

    public Long getProjectid() {
        return projectid;
    }

    public void setProjectid(Long projectid) {
        this.projectid = projectid;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getExpectedendtime() {
        return expectedendtime;
    }

    public void setExpectedendtime(Date expectedendtime) {
        this.expectedendtime = expectedendtime;
    }

    public Date getActualendtime() {
        return actualendtime;
    }

    public void setActualendtime(Date actualendtime) {
        this.actualendtime = actualendtime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}
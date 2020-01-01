package com.xzit.garden.bean.entity;

import java.util.Date;

public class MaintenancePlan {
    private Long id;

    private Long projectid;

    private Date starttime;

    private Date expectedendtime;

    private Date actualendtime;

    private Integer groupid;

    private String purpose;

    private Integer planstate;

    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Integer getGroupid() {
        return groupid;
    }

    public void setGroupid(Integer groupid) {
        this.groupid = groupid;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose == null ? null : purpose.trim();
    }

    public Integer getPlanstate() {
        return planstate;
    }

    public void setPlanstate(Integer planstate) {
        this.planstate = planstate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}
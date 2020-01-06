package com.xzit.garden.bean.entity;

import java.util.Date;

public class Budget {
    private Long id;

    private Long projectId;

    private Integer resTotal;

    private Integer staffTotal;

    private Integer period;

    private Integer surchargeTotal;

    private Integer hireStaffTotal;

    private Integer hireMechanicTotal;

    private Date startTime;

    private Date endTime;

    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Integer getResTotal() {
        return resTotal;
    }

    public void setResTotal(Integer resTotal) {
        this.resTotal = resTotal;
    }

    public Integer getStaffTotal() {
        return staffTotal;
    }

    public void setStaffTotal(Integer staffTotal) {
        this.staffTotal = staffTotal;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    public Integer getSurchargeTotal() {
        return surchargeTotal;
    }

    public void setSurchargeTotal(Integer surchargeTotal) {
        this.surchargeTotal = surchargeTotal;
    }

    public Integer getHireStaffTotal() {
        return hireStaffTotal;
    }

    public void setHireStaffTotal(Integer hireStaffTotal) {
        this.hireStaffTotal = hireStaffTotal;
    }

    public Integer getHireMechanicTotal() {
        return hireMechanicTotal;
    }

    public void setHireMechanicTotal(Integer hireMechanicTotal) {
        this.hireMechanicTotal = hireMechanicTotal;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}
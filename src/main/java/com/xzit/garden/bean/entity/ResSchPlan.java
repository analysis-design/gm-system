package com.xzit.garden.bean.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class ResSchPlan {
    private Long id;

    private Long implPlanId;

    private Long resId;

    private Integer resNum;

    private Integer planState;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date allocatedTime;

    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getImplPlanId() {
        return implPlanId;
    }

    public void setImplPlanId(Long implPlanId) {
        this.implPlanId = implPlanId;
    }

    public Long getResId() {
        return resId;
    }

    public void setResId(Long resId) {
        this.resId = resId;
    }

    public Integer getResNum() {
        return resNum;
    }

    public void setResNum(Integer resNum) {
        this.resNum = resNum;
    }

    public Integer getPlanState() {
        return planState;
    }

    public void setPlanState(Integer planState) {
        this.planState = planState;
    }

    public Date getAllocatedTime() {
        return allocatedTime;
    }

    public void setAllocatedTime(Date allocatedTime) {
        this.allocatedTime = allocatedTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}
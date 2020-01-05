package com.xzit.garden.bean.dto;

import com.xzit.garden.bean.entity.ResSchPlan;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ResSchPlanDto extends ResSchPlan {
    private String implPlanName;
    private String resName;
    private String newTime;

    public ResSchPlanDto() {
    }

    public ResSchPlanDto(ResSchPlan resSchPlan) {
        this.setId(resSchPlan.getId());
        this.setImplPlanId(resSchPlan.getImplPlanId());
        this.setResId(resSchPlan.getResId());
        this.setResNum(resSchPlan.getResNum());
        this.setPlanState(resSchPlan.getPlanState());
        this.setAllocatedTime(resSchPlan.getAllocatedTime());
        this.setDescription(resSchPlan.getDescription());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date allocatedTime = resSchPlan.getAllocatedTime();
        if (allocatedTime != null)
            this.newTime = simpleDateFormat.format(allocatedTime);
    }

    public String getImplPlanName() {
        return implPlanName;
    }

    public void setImplPlanName(String implPlanName) {
        this.implPlanName = implPlanName;
    }

    public String getResName() {
        return resName;
    }

    public void setResName(String resName) {
        this.resName = resName;
    }

    public String getNewTime() {
        return newTime;
    }

    public void setNewTime(String newTime) {
        this.newTime = newTime;
    }
}

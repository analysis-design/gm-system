package com.xzit.garden.bean.dto;

import com.xzit.garden.bean.entity.StaffSchPlan;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StaffSchPlanDto extends StaffSchPlan {

    private String implPlanName;
    private String groupName;
    private String newTime;
    private String oldExpectedTime;
    private String oldTime;

    public StaffSchPlanDto() {
    }

    public StaffSchPlanDto(StaffSchPlan staffSchPlan) {
        this.setId(staffSchPlan.getId());
        this.setImplPlanId(staffSchPlan.getImplPlanId());
        this.setGroupId(staffSchPlan.getGroupId());
        this.setStartTime(staffSchPlan.getStartTime());
        this.setExpectedEndTime(staffSchPlan.getExpectedEndTime());
        this.setActualEndTime(staffSchPlan.getActualEndTime());
        this.setDescription(staffSchPlan.getDescription());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date startTime = staffSchPlan.getStartTime();
        if (startTime != null)
            this.newTime = simpleDateFormat.format(startTime);
        Date expectedEndTime = staffSchPlan.getExpectedEndTime();
        if (expectedEndTime != null)
            this.oldExpectedTime = simpleDateFormat.format(expectedEndTime);
        Date actualEndTime = staffSchPlan.getActualEndTime();
        if (actualEndTime != null)
            this.oldTime = simpleDateFormat.format(actualEndTime);
    }

    public String getImplPlanName() {
        return implPlanName;
    }

    public void setImplPlanName(String implPlanName) {
        this.implPlanName = implPlanName;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getNewTime() {
        return newTime;
    }

    public void setNewTime(String newTime) {
        this.newTime = newTime;
    }

    public String getOldExpectedTime() {
        return oldExpectedTime;
    }

    public void setOldExpectedTime(String oldExpectedTime) {
        this.oldExpectedTime = oldExpectedTime;
    }

    public String getOldTime() {
        return oldTime;
    }

    public void setOldTime(String oldTime) {
        this.oldTime = oldTime;
    }
}

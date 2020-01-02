package com.xzit.garden.bean.dto;

import com.xzit.garden.bean.entity.Group;
import com.xzit.garden.bean.entity.Staff;

import java.text.SimpleDateFormat;

public class GroupDto extends Group {

    private Staff leader;

    private String newTime;
    private String oldTime;

    private String showState;
    private String showType;

    private String leaderName;

    public GroupDto() {
    }

    public GroupDto(Group group) {
        this.setId(group.getId());
        this.setName(group.getName());
        this.setState(group.getState());
        this.setCreateTime(group.getCreateTime());
        this.setType(group.getType());
        this.setLeaderId(group.getLeaderId());
        this.setDescription(group.getDescription());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        this.newTime = format.format(group.getCreateTime());
        if (group.getDismissTime() != null)
            this.oldTime = format.format(group.getDismissTime());

        this.showState = (this.getState() == 1 ? "施工" : this.getState() == 2 ? "已加入实施计划" :
                this.getState() == 3 ? "解除" : "空闲");
        this.showType = (this.getType() == 0 ? "实施工程组" : "养护工程组");
    }

    public Staff getLeader() {
        return leader;
    }

    public void setLeader(Staff leader) {
        this.leaderName = leader.getName();
        this.leader = leader;
    }

    public String getNewTime() {
        return newTime;
    }

    public void setNewTime(String newTime) {
        this.newTime = newTime;
    }

    public String getOldTime() {
        return oldTime;
    }

    public void setOldTime(String oldTime) {
        this.oldTime = oldTime;
    }

    public String getShowState() {
        return showState;
    }

    public void setShowState(String showState) {
        this.showState = showState;
    }

    public String getShowType() {
        return showType;
    }

    public void setShowType(String showType) {
        this.showType = showType;
    }

    public String getLeaderName() {
        return leaderName;
    }

    public void setLeaderName(String leaderName) {
        this.leaderName = leaderName;
    }
}

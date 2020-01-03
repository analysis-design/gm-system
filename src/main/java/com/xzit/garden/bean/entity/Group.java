package com.xzit.garden.bean.entity;

import java.util.Date;

public class Group {
    private Long id;

    private String name;

    /**
     * 0：空闲、1：施工、2：已加入实施计划
     */
    private Integer state;

    private Date createTime;

    private Date dismissTime;

    private Long leaderId;

    /**
     * 0：实施工程组，1：养护工程组
     */
    private Integer type;

    private String description;

    private boolean dismissFlag;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getDismissTime() {
        return dismissTime;
    }

    public void setDismissTime(Date dismissTime) {
        this.dismissTime = dismissTime;
    }

    public Long getLeaderId() {
        return leaderId;
    }

    public void setLeaderId(Long leaderId) {
        this.leaderId = leaderId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public boolean isDismissFlag() {
        return dismissFlag;
    }

    public void setDismissFlag(boolean dismissFlag) {
        this.dismissFlag = dismissFlag;
    }
}
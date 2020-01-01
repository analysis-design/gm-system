package com.xzit.garden.bean.entity;

public class MaintenanceRes {
    private Long id;

    private Long maintenanceplanid;

    private Long resid;

    private Integer resnum;

    private String purpose;

    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMaintenanceplanid() {
        return maintenanceplanid;
    }

    public void setMaintenanceplanid(Long maintenanceplanid) {
        this.maintenanceplanid = maintenanceplanid;
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

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose == null ? null : purpose.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}
package com.xzit.garden.bean.entity;

public class MaintenanceRes {
    private Integer id;

    private Integer maintenanceplanid;

    private Integer resid;

    private Integer resnum;

    private String purpose;

    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMaintenanceplanid() {
        return maintenanceplanid;
    }

    public void setMaintenanceplanid(Integer maintenanceplanid) {
        this.maintenanceplanid = maintenanceplanid;
    }

    public Integer getResid() {
        return resid;
    }

    public void setResid(Integer resid) {
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
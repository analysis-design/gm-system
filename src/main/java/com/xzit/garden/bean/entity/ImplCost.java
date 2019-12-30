package com.xzit.garden.bean.entity;

public class ImplCost {
    private Integer id;

    private Integer staffid;

    private Integer implplanid;

    private Integer projectid;

    private Integer implday;

    private Integer stafftype;

    private Integer implstafftotal;

    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStaffid() {
        return staffid;
    }

    public void setStaffid(Integer staffid) {
        this.staffid = staffid;
    }

    public Integer getImplplanid() {
        return implplanid;
    }

    public void setImplplanid(Integer implplanid) {
        this.implplanid = implplanid;
    }

    public Integer getProjectid() {
        return projectid;
    }

    public void setProjectid(Integer projectid) {
        this.projectid = projectid;
    }

    public Integer getImplday() {
        return implday;
    }

    public void setImplday(Integer implday) {
        this.implday = implday;
    }

    public Integer getStafftype() {
        return stafftype;
    }

    public void setStafftype(Integer stafftype) {
        this.stafftype = stafftype;
    }

    public Integer getImplstafftotal() {
        return implstafftotal;
    }

    public void setImplstafftotal(Integer implstafftotal) {
        this.implstafftotal = implstafftotal;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}
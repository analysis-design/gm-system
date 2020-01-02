package com.xzit.garden.bean.entity;

public class ImplCost {
    private Long id;

    private Long staffid;

    private Long implplanid;

    private Long projectid;

    private Integer implday;

    private Integer stafftype;

    private Integer implstafftotal;

    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStaffid() {
        return staffid;
    }

    public void setStaffid(Long staffid) {
        this.staffid = staffid;
    }

    public Long getImplplanid() {
        return implplanid;
    }

    public void setImplplanid(Long implplanid) {
        this.implplanid = implplanid;
    }

    public Long getProjectid() {
        return projectid;
    }

    public void setProjectid(Long projectid) {
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
package com.xzit.garden.bean.entity;

public class ProjectRes {
    private Long id;

    private Long projectid;

    private Long resid;

    private Integer resnum;

    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProjectid() {
        return projectid;
    }

    public void setProjectid(Long projectid) {
        this.projectid = projectid;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}
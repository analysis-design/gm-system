package com.xzit.garden.bean.entity;

public class ProjectDep {
    private Long id;

    private Long projectid;

    private Long depid;

    private Integer depstaffnum;

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

    public Long getDepid() {
        return depid;
    }

    public void setDepid(Long depid) {
        this.depid = depid;
    }

    public Integer getDepstaffnum() {
        return depstaffnum;
    }

    public void setDepstaffnum(Integer depstaffnum) {
        this.depstaffnum = depstaffnum;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}
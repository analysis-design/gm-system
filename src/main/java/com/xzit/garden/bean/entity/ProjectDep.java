package com.xzit.garden.bean.entity;

public class ProjectDep {
    private Integer id;

    private Integer projectid;

    private Integer depid;

    private Integer depstaffnum;

    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProjectid() {
        return projectid;
    }

    public void setProjectid(Integer projectid) {
        this.projectid = projectid;
    }

    public Integer getDepid() {
        return depid;
    }

    public void setDepid(Integer depid) {
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
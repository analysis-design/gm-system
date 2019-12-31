package com.xzit.garden.bean.entity;

public class ProjectDep {
    private Integer id;

    private Integer projectId;

    private Integer depId;

    private Integer depStaffNum;

    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public Integer getDepId() {
        return depId;
    }

    public void setDepId(Integer depId) {
        this.depId = depId;
    }

    public Integer getDepStaffNum() {
        return depStaffNum;
    }

    public void setDepStaffNum(Integer depStaffNum) {
        this.depStaffNum = depStaffNum;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}
package com.xzit.garden.bean.dto;

import com.xzit.garden.bean.entity.Project;

import java.text.SimpleDateFormat;

public class ProjectDto extends Project {
    Project project;
    String pState;
    String pDifficultyLevel;
    String pStartTime;
    String pExpectedEndTime;
    String pActualEndTime;
    String saleName;
    String clientName;

    public ProjectDto(){}

    public ProjectDto(Project project){
        this.setId(project.getId());
        this.setName(project.getName());
        this.setWorkSite(project.getWorkSite());
        this.setContractFile(project.getContractFile());
        this.setDescription(project.getDescription());
        this.setState(project.getState());
        this.setDifficultyLevel(project.getDifficultyLevel());
        this.setStartTime(project.getStartTime());
        this.setExpectedEndTime(project.getExpectedEndTime());
        this.setActualEndTime(project.getActualEndTime());
        this.setSaleId(project.getSaleId());
        this.setClientId(project.getClientId());
        //日期格式
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        this.pStartTime = format.format(project.getStartTime());
        this.pExpectedEndTime = format.format(project.getExpectedEndTime());
        if (project.getActualEndTime()!=null)
            this.pActualEndTime = format.format(project.getActualEndTime());
        this.pState = (project.getState()==0?"未签合同":project.getState()==1?"已签合同":
                project.getState()==2?"正在实施":project.getState()==3?"工程完成": "已结算完");
        this.pDifficultyLevel = (project.getDifficultyLevel()==0?"简单":project.getDifficultyLevel()==1?"中等":"困难");
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public String getpState() {
        return pState;
    }

    public void setpState(String pState) {
        this.pState = pState;
    }

    public String getpDifficultyLevel() {
        return pDifficultyLevel;
    }

    public void setpDifficultyLevel(String pDifficultyLevel) {
        this.pDifficultyLevel = pDifficultyLevel;
    }

    public String getpStartTime() {
        return pStartTime;
    }

    public void setpStartTime(String pStartTime) {
        this.pStartTime = pStartTime;
    }

    public String getpExpectedEndTime() {
        return pExpectedEndTime;
    }

    public void setpExpectedEndTime(String pExpectedEndTime) {
        this.pExpectedEndTime = pExpectedEndTime;
    }

    public String getpActualEndTime() {
        return pActualEndTime;
    }

    public void setpActualEndTime(String pActualEndTime) {
        this.pActualEndTime = pActualEndTime;
    }

    public String getSaleName() {
        return saleName;
    }

    public void setSaleName(String saleName) {
        this.saleName = saleName;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }
}

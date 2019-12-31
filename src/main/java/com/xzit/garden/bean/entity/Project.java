package com.xzit.garden.bean.entity;

import java.util.Date;

public class Project {
    private Long id;

    private String name;

    private String worksite;

    private Integer state;

    private String contractfile;

    private Integer difficultylevel;

    private Date starttime;

    private Date expectedendtime;

    private Date actualendtime;

    private String description;

    private Long saleid;

    private Long clientid;

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

    public String getWorksite() {
        return worksite;
    }

    public void setWorksite(String worksite) {
        this.worksite = worksite == null ? null : worksite.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getContractfile() {
        return contractfile;
    }

    public void setContractfile(String contractfile) {
        this.contractfile = contractfile == null ? null : contractfile.trim();
    }

    public Integer getDifficultylevel() {
        return difficultylevel;
    }

    public void setDifficultylevel(Integer difficultylevel) {
        this.difficultylevel = difficultylevel;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getExpectedendtime() {
        return expectedendtime;
    }

    public void setExpectedendtime(Date expectedendtime) {
        this.expectedendtime = expectedendtime;
    }

    public Date getActualendtime() {
        return actualendtime;
    }

    public void setActualendtime(Date actualendtime) {
        this.actualendtime = actualendtime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Long getSaleid() {
        return saleid;
    }

    public void setSaleid(Long saleid) {
        this.saleid = saleid;
    }

    public Long getClientid() {
        return clientid;
    }

    public void setClientid(Long clientid) {
        this.clientid = clientid;
    }
}
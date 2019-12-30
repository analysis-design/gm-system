package com.xzit.garden.bean.entity;

import java.util.Date;

public class Budget {
    private Integer id;

    private Integer projectid;

    private Integer restotal;

    private Integer stafftotal;

    private Integer period;

    private Integer surchargetotal;

    private Integer hirestafftotal;

    private Integer hiremechanictotal;

    private Date starttime;

    private Date endtime;

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

    public Integer getRestotal() {
        return restotal;
    }

    public void setRestotal(Integer restotal) {
        this.restotal = restotal;
    }

    public Integer getStafftotal() {
        return stafftotal;
    }

    public void setStafftotal(Integer stafftotal) {
        this.stafftotal = stafftotal;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    public Integer getSurchargetotal() {
        return surchargetotal;
    }

    public void setSurchargetotal(Integer surchargetotal) {
        this.surchargetotal = surchargetotal;
    }

    public Integer getHirestafftotal() {
        return hirestafftotal;
    }

    public void setHirestafftotal(Integer hirestafftotal) {
        this.hirestafftotal = hirestafftotal;
    }

    public Integer getHiremechanictotal() {
        return hiremechanictotal;
    }

    public void setHiremechanictotal(Integer hiremechanictotal) {
        this.hiremechanictotal = hiremechanictotal;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}
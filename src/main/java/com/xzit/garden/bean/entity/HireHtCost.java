package com.xzit.garden.bean.entity;

import java.util.Date;

public class HireHtCost {
    private Integer id;

    private Integer heavytoolid;

    private Date starttime;

    private Date endtime;

    private Integer settlementtotal;

    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getHeavytoolid() {
        return heavytoolid;
    }

    public void setHeavytoolid(Integer heavytoolid) {
        this.heavytoolid = heavytoolid;
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

    public Integer getSettlementtotal() {
        return settlementtotal;
    }

    public void setSettlementtotal(Integer settlementtotal) {
        this.settlementtotal = settlementtotal;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}
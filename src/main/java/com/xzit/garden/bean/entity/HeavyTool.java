package com.xzit.garden.bean.entity;

public class HeavyTool {
    private Integer id;

    private String name;

    private Integer supplierid;

    private Integer hireprice;

    private Integer settlementtype;

    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getSupplierid() {
        return supplierid;
    }

    public void setSupplierid(Integer supplierid) {
        this.supplierid = supplierid;
    }

    public Integer getHireprice() {
        return hireprice;
    }

    public void setHireprice(Integer hireprice) {
        this.hireprice = hireprice;
    }

    public Integer getSettlementtype() {
        return settlementtype;
    }

    public void setSettlementtype(Integer settlementtype) {
        this.settlementtype = settlementtype;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}
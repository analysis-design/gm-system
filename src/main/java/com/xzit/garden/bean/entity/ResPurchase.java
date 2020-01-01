package com.xzit.garden.bean.entity;

import java.util.Date;

public class ResPurchase {
    private Long id;

    private Date purtime;

    private Integer purnum;

    private Integer unitprice;

    private Double discount;

    private Long resid;

    private Long supplierid;

    private Long buyerid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getPurtime() {
        return purtime;
    }

    public void setPurtime(Date purtime) {
        this.purtime = purtime;
    }

    public Integer getPurnum() {
        return purnum;
    }

    public void setPurnum(Integer purnum) {
        this.purnum = purnum;
    }

    public Integer getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(Integer unitprice) {
        this.unitprice = unitprice;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Long getResid() {
        return resid;
    }

    public void setResid(Long resid) {
        this.resid = resid;
    }

    public Long getSupplierid() {
        return supplierid;
    }

    public void setSupplierid(Long supplierid) {
        this.supplierid = supplierid;
    }

    public Long getBuyerid() {
        return buyerid;
    }

    public void setBuyerid(Long buyerid) {
        this.buyerid = buyerid;
    }
}
package com.xzit.garden.bean.entity;

import java.util.Date;

public class Order {
    private Integer id;

    private String name;

    private Integer budgetid;

    private Integer budgettotal;

    private Double discount;

    private Integer prepaid;

    private Integer paystate;

    private Integer paymentmethod;

    private Integer paymenttotal;

    private Date createtime;

    private Date endtime;

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

    public Integer getBudgetid() {
        return budgetid;
    }

    public void setBudgetid(Integer budgetid) {
        this.budgetid = budgetid;
    }

    public Integer getBudgettotal() {
        return budgettotal;
    }

    public void setBudgettotal(Integer budgettotal) {
        this.budgettotal = budgettotal;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Integer getPrepaid() {
        return prepaid;
    }

    public void setPrepaid(Integer prepaid) {
        this.prepaid = prepaid;
    }

    public Integer getPaystate() {
        return paystate;
    }

    public void setPaystate(Integer paystate) {
        this.paystate = paystate;
    }

    public Integer getPaymentmethod() {
        return paymentmethod;
    }

    public void setPaymentmethod(Integer paymentmethod) {
        this.paymentmethod = paymentmethod;
    }

    public Integer getPaymenttotal() {
        return paymenttotal;
    }

    public void setPaymenttotal(Integer paymenttotal) {
        this.paymenttotal = paymenttotal;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }
}
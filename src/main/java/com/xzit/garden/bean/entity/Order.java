package com.xzit.garden.bean.entity;

import java.util.Date;

public class Order {
    private Long id;

    private String name;

    private Long budgetid;

    private Integer budgettotal;

    private Double discount;

    private Long prepaid;

    private Integer paystate;

    private Integer paymentmethod;

    private Integer paymenttotal;

    private Date createtime;

    private Date endtime;

    private Long projectid;

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

    public Long getBudgetid() {
        return budgetid;
    }

    public void setBudgetid(Long budgetid) {
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

    public Long getPrepaid() {
        return prepaid;
    }

    public void setPrepaid(Long prepaid) {
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

    public Long getProjectid() {
        return projectid;
    }

    public void setProjectid(Long projectid) {
        this.projectid = projectid;
    }
}
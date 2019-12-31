package com.xzit.garden.bean.entity;

import java.util.Date;

public class Order {
    private Long id;

    private String name;

    private Long budgetId;

    private Integer budgetTotal;

    private Double discount;

    private Integer prepaid;

    private Integer payState;

    private Integer paymentMethod;

    private Integer paymentTotal;

    private Date createTime;

    private Date endTime;

    private Long projectId;

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

    public Long getBudgetId() {
        return budgetId;
    }

    public void setBudgetId(Long budgetId) {
        this.budgetId = budgetId;
    }

    public Integer getBudgetTotal() {
        return budgetTotal;
    }

    public void setBudgetTotal(Integer budgetTotal) {
        this.budgetTotal = budgetTotal;
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

    public Integer getPayState() {
        return payState;
    }

    public void setPayState(Integer payState) {
        this.payState = payState;
    }

    public Integer getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(Integer paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Integer getPaymentTotal() {
        return paymentTotal;
    }

    public void setPaymentTotal(Integer paymentTotal) {
        this.paymentTotal = paymentTotal;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }
}
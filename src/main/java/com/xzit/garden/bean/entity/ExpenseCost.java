package com.xzit.garden.bean.entity;

import java.util.Date;

public class ExpenseCost {
    private Long id;

    private Long staffid;

    private Date time;

    private Integer expensetotal;

    private Integer expensetype;

    private Integer total;

    private Integer expensestate;

    private String surchargepurpose;

    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStaffid() {
        return staffid;
    }

    public void setStaffid(Long staffid) {
        this.staffid = staffid;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getExpensetotal() {
        return expensetotal;
    }

    public void setExpensetotal(Integer expensetotal) {
        this.expensetotal = expensetotal;
    }

    public Integer getExpensetype() {
        return expensetype;
    }

    public void setExpensetype(Integer expensetype) {
        this.expensetype = expensetype;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getExpensestate() {
        return expensestate;
    }

    public void setExpensestate(Integer expensestate) {
        this.expensestate = expensestate;
    }

    public String getSurchargepurpose() {
        return surchargepurpose;
    }

    public void setSurchargepurpose(String surchargepurpose) {
        this.surchargepurpose = surchargepurpose == null ? null : surchargepurpose.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}
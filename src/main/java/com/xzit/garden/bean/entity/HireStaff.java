package com.xzit.garden.bean.entity;

import java.util.Date;

public class HireStaff {
    private Long id;

    private String name;

    private Integer gender;

    private Date birthday;

    private String phone;

    private String address;

    private Date hireStartTime;

    private Date hireEndTime;

    private Integer settlementType;

    private Integer salary;

    private String comment;

    private Integer hireState;

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

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Date getHireStartTime() {
        return hireStartTime;
    }

    public void setHireStartTime(Date hireStartTime) {
        this.hireStartTime = hireStartTime;
    }

    public Date getHireEndTime() {
        return hireEndTime;
    }

    public void setHireEndTime(Date hireEndTime) {
        this.hireEndTime = hireEndTime;
    }

    public Integer getSettlementType() {
        return settlementType;
    }

    public void setSettlementType(Integer settlementType) {
        this.settlementType = settlementType;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

    public Integer getHireState() {
        return hireState;
    }

    public void setHireState(Integer hireState) {
        this.hireState = hireState;
    }
}
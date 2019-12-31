package com.xzit.garden.bean.entity;

import java.util.Date;

public class HireStaff {
    private Long id;

    private String name;

    private Integer gender;

    private Date birthday;

    private String phone;

    private String address;

    private Date hirestarttime;

    private Date hireendtime;

    private Integer settlementtype;

    private Integer salary;

    private String comment;

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

    public Date getHirestarttime() {
        return hirestarttime;
    }

    public void setHirestarttime(Date hirestarttime) {
        this.hirestarttime = hirestarttime;
    }

    public Date getHireendtime() {
        return hireendtime;
    }

    public void setHireendtime(Date hireendtime) {
        this.hireendtime = hireendtime;
    }

    public Integer getSettlementtype() {
        return settlementtype;
    }

    public void setSettlementtype(Integer settlementtype) {
        this.settlementtype = settlementtype;
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
}
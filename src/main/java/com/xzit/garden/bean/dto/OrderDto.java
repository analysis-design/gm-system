package com.xzit.garden.bean.dto;

import com.xzit.garden.bean.entity.Order;

import java.text.SimpleDateFormat;

public class OrderDto extends Order {
    String dtoBudgetTotal;
    String dtoDiscount;
    String dtoPrepaid;
    String dtoPayState;
    String dtoPaymentMethod;
    String dtoPaymentTotal;
    String dtoCreatTime;
    String dtoEndTime;
    String projectName;

    public OrderDto() {
    }

    public OrderDto(Order order) {
        this.setId(order.getId());
        this.setName(order.getName());
        this.setBudgetId(order.getBudgetId());
        this.setBudgetTotal(order.getBudgetTotal());
        this.setDiscount(order.getDiscount());
        this.setPrepaid(order.getPrepaid());
        this.setPayState(order.getPayState());
        this.setPaymentMethod(order.getPaymentMethod());
        this.setPaymentTotal(order.getPaymentTotal());
        this.setCreateTime(order.getCreateTime());
        this.setEndTime(order.getEndTime());
        this.setProjectId(order.getProjectId());
        if (order.getBudgetTotal() != null)
            this.dtoBudgetTotal = (order.getBudgetTotal() + " ￥");
        this.dtoDiscount = (String.format("%.1f", order.getDiscount()) + " 折");
        if (order.getPrepaid() != null)
            this.dtoPrepaid = (order.getPrepaid() + " ￥");
        this.dtoPayState = (order.getPayState() == 0 ? "未付定金" : order.getPayState() == 1 ? "已付定金" : "已付尾款");
        this.dtoPaymentMethod = (order.getPaymentMethod() == 0 ? "未支付" : order.getPaymentMethod() == 1 ? "现金" :
                order.getPaymentMethod() == 2 ? "银行转账" : order.getPaymentMethod() == 3 ? "汇款" : order.getPaymentMethod() == 4 ? "支票" : "本票");
        if (order.getPaymentTotal() != null)
            this.dtoPaymentTotal = (order.getPaymentTotal() + " ￥");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.dtoCreatTime = format.format(order.getCreateTime());
        if (order.getEndTime() != null)
            this.dtoEndTime = format.format(order.getEndTime());
    }

    public String getDtoBudgetTotal() {
        return dtoBudgetTotal;
    }

    public void setDtoBudgetTotal(String dtoBudgetTotal) {
        this.dtoBudgetTotal = dtoBudgetTotal;
    }

    public String getDtoDiscount() {
        return dtoDiscount;
    }

    public void setDtoDiscount(String dtoDiscount) {
        this.dtoDiscount = dtoDiscount;
    }

    public String getDtoPrepaid() {
        return dtoPrepaid;
    }

    public void setDtoPrepaid(String dtoPrepaid) {
        this.dtoPrepaid = dtoPrepaid;
    }

    public String getDtoPayState() {
        return dtoPayState;
    }

    public void setDtoPayState(String dtoPayState) {
        this.dtoPayState = dtoPayState;
    }

    public String getDtoPaymentMethod() {
        return dtoPaymentMethod;
    }

    public void setDtoPaymentMethod(String dtoPaymentMethod) {
        this.dtoPaymentMethod = dtoPaymentMethod;
    }

    public String getDtoPaymentTotal() {
        return dtoPaymentTotal;
    }

    public void setDtoPaymentTotal(String dtoPaymentTotal) {
        this.dtoPaymentTotal = dtoPaymentTotal;
    }

    public String getDtoCreatTime() {
        return dtoCreatTime;
    }

    public void setDtoCreatTime(String dtoCreatTime) {
        this.dtoCreatTime = dtoCreatTime;
    }

    public String getDtoEndTime() {
        return dtoEndTime;
    }

    public void setDtoEndTime(String dtoEndTime) {
        this.dtoEndTime = dtoEndTime;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
}

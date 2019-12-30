package com.xzit.garden.mapperAndSqlprovider2;

import com.xzit.garden.bean.entity.*;

import static org.apache.ibatis.jdbc.SqlBuilder.*;

public class ExpenseCostSqlProvider {

    public String insertSelective(ExpenseCost record) {
        BEGIN();
        INSERT_INTO("expense_cost");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getStaffid() != null) {
            VALUES("staffId", "#{staffid,jdbcType=INTEGER}");
        }
        
        if (record.getTime() != null) {
            VALUES("time", "#{time,jdbcType=TIMESTAMP}");
        }
        
        if (record.getExpensetotal() != null) {
            VALUES("expenseTotal", "#{expensetotal,jdbcType=INTEGER}");
        }
        
        if (record.getExpensetype() != null) {
            VALUES("expenseType", "#{expensetype,jdbcType=INTEGER}");
        }
        
        if (record.getTotal() != null) {
            VALUES("total", "#{total,jdbcType=INTEGER}");
        }
        
        if (record.getExpensestate() != null) {
            VALUES("expenseState", "#{expensestate,jdbcType=INTEGER}");
        }
        
        if (record.getSurchargepurpose() != null) {
            VALUES("surchargePurpose", "#{surchargepurpose,jdbcType=VARCHAR}");
        }
        
        if (record.getDescription() != null) {
            VALUES("description", "#{description,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(ExpenseCost record) {
        BEGIN();
        UPDATE("expense_cost");
        
        if (record.getStaffid() != null) {
            SET("staffId = #{staffid,jdbcType=INTEGER}");
        }
        
        if (record.getTime() != null) {
            SET("time = #{time,jdbcType=TIMESTAMP}");
        }
        
        if (record.getExpensetotal() != null) {
            SET("expenseTotal = #{expensetotal,jdbcType=INTEGER}");
        }
        
        if (record.getExpensetype() != null) {
            SET("expenseType = #{expensetype,jdbcType=INTEGER}");
        }
        
        if (record.getTotal() != null) {
            SET("total = #{total,jdbcType=INTEGER}");
        }
        
        if (record.getExpensestate() != null) {
            SET("expenseState = #{expensestate,jdbcType=INTEGER}");
        }
        
        if (record.getSurchargepurpose() != null) {
            SET("surchargePurpose = #{surchargepurpose,jdbcType=VARCHAR}");
        }
        
        if (record.getDescription() != null) {
            SET("description = #{description,jdbcType=VARCHAR}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }
}
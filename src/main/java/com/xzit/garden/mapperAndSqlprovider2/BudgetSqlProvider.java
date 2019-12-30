package com.xzit.garden.mapperAndSqlprovider2;

import com.xzit.garden.bean.entity.*;

import static org.apache.ibatis.jdbc.SqlBuilder.*;

public class BudgetSqlProvider {

    public String insertSelective(Budget record) {
        BEGIN();
        INSERT_INTO("budget");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getProjectid() != null) {
            VALUES("projectId", "#{projectid,jdbcType=INTEGER}");
        }
        
        if (record.getRestotal() != null) {
            VALUES("resTotal", "#{restotal,jdbcType=INTEGER}");
        }
        
        if (record.getStafftotal() != null) {
            VALUES("staffTotal", "#{stafftotal,jdbcType=INTEGER}");
        }
        
        if (record.getPeriod() != null) {
            VALUES("period", "#{period,jdbcType=INTEGER}");
        }
        
        if (record.getSurchargetotal() != null) {
            VALUES("surchargeTotal", "#{surchargetotal,jdbcType=INTEGER}");
        }
        
        if (record.getHirestafftotal() != null) {
            VALUES("hireStaffTotal", "#{hirestafftotal,jdbcType=INTEGER}");
        }
        
        if (record.getHiremechanictotal() != null) {
            VALUES("hireMechanicTotal", "#{hiremechanictotal,jdbcType=INTEGER}");
        }
        
        if (record.getStarttime() != null) {
            VALUES("startTime", "#{starttime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getEndtime() != null) {
            VALUES("endTime", "#{endtime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getDescription() != null) {
            VALUES("description", "#{description,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(Budget record) {
        BEGIN();
        UPDATE("budget");
        
        if (record.getProjectid() != null) {
            SET("projectId = #{projectid,jdbcType=INTEGER}");
        }
        
        if (record.getRestotal() != null) {
            SET("resTotal = #{restotal,jdbcType=INTEGER}");
        }
        
        if (record.getStafftotal() != null) {
            SET("staffTotal = #{stafftotal,jdbcType=INTEGER}");
        }
        
        if (record.getPeriod() != null) {
            SET("period = #{period,jdbcType=INTEGER}");
        }
        
        if (record.getSurchargetotal() != null) {
            SET("surchargeTotal = #{surchargetotal,jdbcType=INTEGER}");
        }
        
        if (record.getHirestafftotal() != null) {
            SET("hireStaffTotal = #{hirestafftotal,jdbcType=INTEGER}");
        }
        
        if (record.getHiremechanictotal() != null) {
            SET("hireMechanicTotal = #{hiremechanictotal,jdbcType=INTEGER}");
        }
        
        if (record.getStarttime() != null) {
            SET("startTime = #{starttime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getEndtime() != null) {
            SET("endTime = #{endtime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getDescription() != null) {
            SET("description = #{description,jdbcType=VARCHAR}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }
}
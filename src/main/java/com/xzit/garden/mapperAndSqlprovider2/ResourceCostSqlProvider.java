package com.xzit.garden.mapperAndSqlprovider2;

import com.xzit.garden.bean.entity.*;

import static org.apache.ibatis.jdbc.SqlBuilder.*;

public class ResourceCostSqlProvider {

    public String insertSelective(ResourceCost record) {
        BEGIN();
        INSERT_INTO("resource_cost");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getPlanid() != null) {
            VALUES("planId", "#{planid,jdbcType=INTEGER}");
        }
        
        if (record.getResid() != null) {
            VALUES("resId", "#{resid,jdbcType=INTEGER}");
        }
        
        if (record.getResnum() != null) {
            VALUES("resNum", "#{resnum,jdbcType=INTEGER}");
        }
        
        if (record.getRestotal() != null) {
            VALUES("resTotal", "#{restotal,jdbcType=INTEGER}");
        }
        
        if (record.getDescription() != null) {
            VALUES("description", "#{description,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(ResourceCost record) {
        BEGIN();
        UPDATE("resource_cost");
        
        if (record.getPlanid() != null) {
            SET("planId = #{planid,jdbcType=INTEGER}");
        }
        
        if (record.getResid() != null) {
            SET("resId = #{resid,jdbcType=INTEGER}");
        }
        
        if (record.getResnum() != null) {
            SET("resNum = #{resnum,jdbcType=INTEGER}");
        }
        
        if (record.getRestotal() != null) {
            SET("resTotal = #{restotal,jdbcType=INTEGER}");
        }
        
        if (record.getDescription() != null) {
            SET("description = #{description,jdbcType=VARCHAR}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }
}
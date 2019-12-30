package com.xzit.garden.mapperAndSqlprovider2;

import com.xzit.garden.bean.entity.*;

import static org.apache.ibatis.jdbc.SqlBuilder.*;

public class HeavyToolSqlProvider {

    public String insertSelective(HeavyTool record) {
        BEGIN();
        INSERT_INTO("heavy_tool");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getName() != null) {
            VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getSupplierid() != null) {
            VALUES("supplierId", "#{supplierid,jdbcType=INTEGER}");
        }
        
        if (record.getHireprice() != null) {
            VALUES("hirePrice", "#{hireprice,jdbcType=INTEGER}");
        }
        
        if (record.getSettlementtype() != null) {
            VALUES("settlementType", "#{settlementtype,jdbcType=INTEGER}");
        }
        
        if (record.getDescription() != null) {
            VALUES("description", "#{description,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(HeavyTool record) {
        BEGIN();
        UPDATE("heavy_tool");
        
        if (record.getName() != null) {
            SET("name = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getSupplierid() != null) {
            SET("supplierId = #{supplierid,jdbcType=INTEGER}");
        }
        
        if (record.getHireprice() != null) {
            SET("hirePrice = #{hireprice,jdbcType=INTEGER}");
        }
        
        if (record.getSettlementtype() != null) {
            SET("settlementType = #{settlementtype,jdbcType=INTEGER}");
        }
        
        if (record.getDescription() != null) {
            SET("description = #{description,jdbcType=VARCHAR}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }
}
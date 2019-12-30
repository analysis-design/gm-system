package com.xzit.garden.mapperAndSqlprovider2;

import com.xzit.garden.bean.entity.*;

import static org.apache.ibatis.jdbc.SqlBuilder.*;

public class ResApplySqlProvider {

    public String insertSelective(ResApply record) {
        BEGIN();
        INSERT_INTO("res_apply");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getApplytime() != null) {
            VALUES("applyTime", "#{applytime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getAuditstate() != null) {
            VALUES("auditState", "#{auditstate,jdbcType=INTEGER}");
        }
        
        if (record.getApplierid() != null) {
            VALUES("applierId", "#{applierid,jdbcType=INTEGER}");
        }
        
        if (record.getResid() != null) {
            VALUES("resId", "#{resid,jdbcType=INTEGER}");
        }
        
        if (record.getResnum() != null) {
            VALUES("resNum", "#{resnum,jdbcType=INTEGER}");
        }
        
        if (record.getPurpose() != null) {
            VALUES("purpose", "#{purpose,jdbcType=VARCHAR}");
        }
        
        if (record.getImplplanid() != null) {
            VALUES("implPlanId", "#{implplanid,jdbcType=INTEGER}");
        }
        
        if (record.getResallocatedtime() != null) {
            VALUES("resAllocatedTime", "#{resallocatedtime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getDescription() != null) {
            VALUES("description", "#{description,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(ResApply record) {
        BEGIN();
        UPDATE("res_apply");
        
        if (record.getApplytime() != null) {
            SET("applyTime = #{applytime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getAuditstate() != null) {
            SET("auditState = #{auditstate,jdbcType=INTEGER}");
        }
        
        if (record.getApplierid() != null) {
            SET("applierId = #{applierid,jdbcType=INTEGER}");
        }
        
        if (record.getResid() != null) {
            SET("resId = #{resid,jdbcType=INTEGER}");
        }
        
        if (record.getResnum() != null) {
            SET("resNum = #{resnum,jdbcType=INTEGER}");
        }
        
        if (record.getPurpose() != null) {
            SET("purpose = #{purpose,jdbcType=VARCHAR}");
        }
        
        if (record.getImplplanid() != null) {
            SET("implPlanId = #{implplanid,jdbcType=INTEGER}");
        }
        
        if (record.getResallocatedtime() != null) {
            SET("resAllocatedTime = #{resallocatedtime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getDescription() != null) {
            SET("description = #{description,jdbcType=VARCHAR}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }
}
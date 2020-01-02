package com.xzit.garden.mapperAndSqlprovider2;

import com.xzit.garden.bean.entity.*;

import static org.apache.ibatis.jdbc.SqlBuilder.*;

public class StaffApplySqlProvider {

    public String insertSelective(StaffApply record) {
        BEGIN();
        INSERT_INTO("staff_apply");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getApplytime() != null) {
            VALUES("applyTime", "#{applytime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getAuditstate() != null) {
            VALUES("auditState", "#{auditstate,jdbcType=INTEGER}");
        }
        
        if (record.getGroupid() != null) {
            VALUES("groupId", "#{groupid,jdbcType=INTEGER}");
        }
        
        if (record.getImplplanid() != null) {
            VALUES("implPlanId", "#{implplanid,jdbcType=INTEGER}");
        }
        
        if (record.getApplierid() != null) {
            VALUES("applierId", "#{applierid,jdbcType=INTEGER}");
        }
        
        if (record.getPurpose() != null) {
            VALUES("purpose", "#{purpose,jdbcType=VARCHAR}");
        }
        
        if (record.getStaffType() != null) {
            VALUES("staff_type", "#{staffType,jdbcType=INTEGER}");
        }
        
        if (record.getDescription() != null) {
            VALUES("description", "#{description,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(StaffApply record) {
        BEGIN();
        UPDATE("staff_apply");
        
        if (record.getApplytime() != null) {
            SET("applyTime = #{applytime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getAuditstate() != null) {
            SET("auditState = #{auditstate,jdbcType=INTEGER}");
        }
        
        if (record.getGroupid() != null) {
            SET("groupId = #{groupid,jdbcType=INTEGER}");
        }
        
        if (record.getImplplanid() != null) {
            SET("implPlanId = #{implplanid,jdbcType=INTEGER}");
        }
        
        if (record.getApplierid() != null) {
            SET("applierId = #{applierid,jdbcType=INTEGER}");
        }
        
        if (record.getPurpose() != null) {
            SET("purpose = #{purpose,jdbcType=VARCHAR}");
        }
        
        if (record.getStaffType() != null) {
            SET("staff_type = #{staffType,jdbcType=INTEGER}");
        }
        
        if (record.getDescription() != null) {
            SET("description = #{description,jdbcType=VARCHAR}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }
}
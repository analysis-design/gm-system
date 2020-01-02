package com.xzit.garden.mapper;

import com.xzit.garden.bean.entity.MaintenanceRes;

import static org.apache.ibatis.jdbc.SqlBuilder.*;

public class MaintenanceResSqlProvider {

    public String insertSelective(MaintenanceRes record) {
        BEGIN();
        INSERT_INTO("maintenance_res");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getMaintenanceplanid() != null) {
            VALUES("maintenancePlanId", "#{maintenanceplanid,jdbcType=INTEGER}");
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
        
        if (record.getDescription() != null) {
            VALUES("description", "#{description,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(MaintenanceRes record) {
        BEGIN();
        UPDATE("maintenance_res");
        
        if (record.getMaintenanceplanid() != null) {
            SET("maintenancePlanId = #{maintenanceplanid,jdbcType=INTEGER}");
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
        
        if (record.getDescription() != null) {
            SET("description = #{description,jdbcType=VARCHAR}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }
}
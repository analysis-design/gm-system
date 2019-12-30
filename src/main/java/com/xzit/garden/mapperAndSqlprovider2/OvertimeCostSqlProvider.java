package com.xzit.garden.mapperAndSqlprovider2;

import com.xzit.garden.bean.entity.*;

import static org.apache.ibatis.jdbc.SqlBuilder.*;

public class OvertimeCostSqlProvider {

    public String insertSelective(OvertimeCost record) {
        BEGIN();
        INSERT_INTO("overtime_cost");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getStaffid() != null) {
            VALUES("staffId", "#{staffid,jdbcType=INTEGER}");
        }
        
        if (record.getStarttime() != null) {
            VALUES("startTime", "#{starttime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getEndtime() != null) {
            VALUES("endTime", "#{endtime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getAuditstate() != null) {
            VALUES("auditState", "#{auditstate,jdbcType=INTEGER}");
        }
        
        if (record.getOvertimetotal() != null) {
            VALUES("overtimeTotal", "#{overtimetotal,jdbcType=INTEGER}");
        }
        
        if (record.getDescription() != null) {
            VALUES("description", "#{description,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(OvertimeCost record) {
        BEGIN();
        UPDATE("overtime_cost");
        
        if (record.getStaffid() != null) {
            SET("staffId = #{staffid,jdbcType=INTEGER}");
        }
        
        if (record.getStarttime() != null) {
            SET("startTime = #{starttime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getEndtime() != null) {
            SET("endTime = #{endtime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getAuditstate() != null) {
            SET("auditState = #{auditstate,jdbcType=INTEGER}");
        }
        
        if (record.getOvertimetotal() != null) {
            SET("overtimeTotal = #{overtimetotal,jdbcType=INTEGER}");
        }
        
        if (record.getDescription() != null) {
            SET("description = #{description,jdbcType=VARCHAR}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }
}
package com.xzit.garden.mapperAndSqlprovider2;

import com.xzit.garden.bean.entity.*;

import static org.apache.ibatis.jdbc.SqlBuilder.*;

public class StaffLeaveSqlProvider {

    public String insertSelective(StaffLeave record) {
        BEGIN();
        INSERT_INTO("staff_leave");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getStarttime() != null) {
            VALUES("startTime", "#{starttime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getEndtime() != null) {
            VALUES("endTime", "#{endtime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStaffid() != null) {
            VALUES("staffId", "#{staffid,jdbcType=INTEGER}");
        }
        
        if (record.getStafftype() != null) {
            VALUES("staffType", "#{stafftype,jdbcType=INTEGER}");
        }
        
        if (record.getReason() != null) {
            VALUES("reason", "#{reason,jdbcType=VARCHAR}");
        }
        
        if (record.getLeavetype() != null) {
            VALUES("leaveType", "#{leavetype,jdbcType=INTEGER}");
        }
        
        if (record.getDescription() != null) {
            VALUES("description", "#{description,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(StaffLeave record) {
        BEGIN();
        UPDATE("staff_leave");
        
        if (record.getStarttime() != null) {
            SET("startTime = #{starttime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getEndtime() != null) {
            SET("endTime = #{endtime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStaffid() != null) {
            SET("staffId = #{staffid,jdbcType=INTEGER}");
        }
        
        if (record.getStafftype() != null) {
            SET("staffType = #{stafftype,jdbcType=INTEGER}");
        }
        
        if (record.getReason() != null) {
            SET("reason = #{reason,jdbcType=VARCHAR}");
        }
        
        if (record.getLeavetype() != null) {
            SET("leaveType = #{leavetype,jdbcType=INTEGER}");
        }
        
        if (record.getDescription() != null) {
            SET("description = #{description,jdbcType=VARCHAR}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }
}
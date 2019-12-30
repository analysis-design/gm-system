package com.xzit.garden.mapperAndSqlprovider2;

import com.xzit.garden.bean.entity.*;

import static org.apache.ibatis.jdbc.SqlBuilder.*;

public class StaffSqlProvider {

    public String insertSelective(Staff record) {
        BEGIN();
        INSERT_INTO("staff");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getName() != null) {
            VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getGender() != null) {
            VALUES("gender", "#{gender,jdbcType=INTEGER}");
        }
        
        if (record.getBirthday() != null) {
            VALUES("birthday", "#{birthday,jdbcType=TIMESTAMP}");
        }
        
        if (record.getPhone() != null) {
            VALUES("phone", "#{phone,jdbcType=VARCHAR}");
        }
        
        if (record.getAddress() != null) {
            VALUES("address", "#{address,jdbcType=VARCHAR}");
        }
        
        if (record.getEntrytime() != null) {
            VALUES("entryTime", "#{entrytime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getState() != null) {
            VALUES("state", "#{state,jdbcType=INTEGER}");
        }
        
        if (record.getSettlementtype() != null) {
            VALUES("settlementType", "#{settlementtype,jdbcType=INTEGER}");
        }
        
        if (record.getSalary() != null) {
            VALUES("salary", "#{salary,jdbcType=INTEGER}");
        }
        
        if (record.getPosition() != null) {
            VALUES("position", "#{position,jdbcType=VARCHAR}");
        }
        
        if (record.getStafftype() != null) {
            VALUES("staffType", "#{stafftype,jdbcType=INTEGER}");
        }
        
        if (record.getDescription() != null) {
            VALUES("description", "#{description,jdbcType=VARCHAR}");
        }
        
        if (record.getDepid() != null) {
            VALUES("depId", "#{depid,jdbcType=INTEGER}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(Staff record) {
        BEGIN();
        UPDATE("staff");
        
        if (record.getName() != null) {
            SET("name = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getGender() != null) {
            SET("gender = #{gender,jdbcType=INTEGER}");
        }
        
        if (record.getBirthday() != null) {
            SET("birthday = #{birthday,jdbcType=TIMESTAMP}");
        }
        
        if (record.getPhone() != null) {
            SET("phone = #{phone,jdbcType=VARCHAR}");
        }
        
        if (record.getAddress() != null) {
            SET("address = #{address,jdbcType=VARCHAR}");
        }
        
        if (record.getEntrytime() != null) {
            SET("entryTime = #{entrytime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getState() != null) {
            SET("state = #{state,jdbcType=INTEGER}");
        }
        
        if (record.getSettlementtype() != null) {
            SET("settlementType = #{settlementtype,jdbcType=INTEGER}");
        }
        
        if (record.getSalary() != null) {
            SET("salary = #{salary,jdbcType=INTEGER}");
        }
        
        if (record.getPosition() != null) {
            SET("position = #{position,jdbcType=VARCHAR}");
        }
        
        if (record.getStafftype() != null) {
            SET("staffType = #{stafftype,jdbcType=INTEGER}");
        }
        
        if (record.getDescription() != null) {
            SET("description = #{description,jdbcType=VARCHAR}");
        }
        
        if (record.getDepid() != null) {
            SET("depId = #{depid,jdbcType=INTEGER}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }
}
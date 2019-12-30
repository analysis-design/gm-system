package com.xzit.garden.mapperAndSqlprovider2;

import com.xzit.garden.bean.entity.*;

import static org.apache.ibatis.jdbc.SqlBuilder.*;

public class HireStaffSqlProvider {

    public String insertSelective(HireStaff record) {
        BEGIN();
        INSERT_INTO("hire_staff");
        
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
        
        if (record.getHirestarttime() != null) {
            VALUES("hireStartTime", "#{hirestarttime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getHireendtime() != null) {
            VALUES("hireEndTime", "#{hireendtime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getSettlementtype() != null) {
            VALUES("settlementType", "#{settlementtype,jdbcType=INTEGER}");
        }
        
        if (record.getSalary() != null) {
            VALUES("salary", "#{salary,jdbcType=INTEGER}");
        }
        
        if (record.getComment() != null) {
            VALUES("comment", "#{comment,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(HireStaff record) {
        BEGIN();
        UPDATE("hire_staff");
        
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
        
        if (record.getHirestarttime() != null) {
            SET("hireStartTime = #{hirestarttime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getHireendtime() != null) {
            SET("hireEndTime = #{hireendtime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getSettlementtype() != null) {
            SET("settlementType = #{settlementtype,jdbcType=INTEGER}");
        }
        
        if (record.getSalary() != null) {
            SET("salary = #{salary,jdbcType=INTEGER}");
        }
        
        if (record.getComment() != null) {
            SET("comment = #{comment,jdbcType=VARCHAR}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }
}
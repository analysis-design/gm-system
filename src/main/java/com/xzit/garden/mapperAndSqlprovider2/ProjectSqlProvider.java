package com.xzit.garden.mapperAndSqlprovider2;

import com.xzit.garden.bean.entity.*;

import static org.apache.ibatis.jdbc.SqlBuilder.*;

public class ProjectSqlProvider {

    public String insertSelective(Project record) {
        BEGIN();
        INSERT_INTO("project");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getName() != null) {
            VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getWorksite() != null) {
            VALUES("workSite", "#{worksite,jdbcType=VARCHAR}");
        }
        
        if (record.getState() != null) {
            VALUES("state", "#{state,jdbcType=INTEGER}");
        }
        
        if (record.getContractfile() != null) {
            VALUES("contractFile", "#{contractfile,jdbcType=VARCHAR}");
        }
        
        if (record.getDifficultylevel() != null) {
            VALUES("difficultyLevel", "#{difficultylevel,jdbcType=INTEGER}");
        }
        
        if (record.getStarttime() != null) {
            VALUES("startTime", "#{starttime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getExpectedendtime() != null) {
            VALUES("expectedEndTime", "#{expectedendtime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getActualendtime() != null) {
            VALUES("actualEndTime", "#{actualendtime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getDescription() != null) {
            VALUES("description", "#{description,jdbcType=VARCHAR}");
        }
        
        if (record.getSaleid() != null) {
            VALUES("saleId", "#{saleid,jdbcType=INTEGER}");
        }
        
        if (record.getClientid() != null) {
            VALUES("clientId", "#{clientid,jdbcType=INTEGER}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(Project record) {
        BEGIN();
        UPDATE("project");
        
        if (record.getName() != null) {
            SET("name = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getWorksite() != null) {
            SET("workSite = #{worksite,jdbcType=VARCHAR}");
        }
        
        if (record.getState() != null) {
            SET("state = #{state,jdbcType=INTEGER}");
        }
        
        if (record.getContractfile() != null) {
            SET("contractFile = #{contractfile,jdbcType=VARCHAR}");
        }
        
        if (record.getDifficultylevel() != null) {
            SET("difficultyLevel = #{difficultylevel,jdbcType=INTEGER}");
        }
        
        if (record.getStarttime() != null) {
            SET("startTime = #{starttime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getExpectedendtime() != null) {
            SET("expectedEndTime = #{expectedendtime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getActualendtime() != null) {
            SET("actualEndTime = #{actualendtime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getDescription() != null) {
            SET("description = #{description,jdbcType=VARCHAR}");
        }
        
        if (record.getSaleid() != null) {
            SET("saleId = #{saleid,jdbcType=INTEGER}");
        }
        
        if (record.getClientid() != null) {
            SET("clientId = #{clientid,jdbcType=INTEGER}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }
}
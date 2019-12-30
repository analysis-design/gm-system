package com.xzit.garden.mapperAndSqlprovider2;

import com.xzit.garden.bean.entity.*;

import static org.apache.ibatis.jdbc.SqlBuilder.*;

public class ProjectDepSqlProvider {

    public String insertSelective(ProjectDep record) {
        BEGIN();
        INSERT_INTO("project_dep");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getProjectid() != null) {
            VALUES("projectId", "#{projectid,jdbcType=INTEGER}");
        }
        
        if (record.getDepid() != null) {
            VALUES("depId", "#{depid,jdbcType=INTEGER}");
        }
        
        if (record.getDepstaffnum() != null) {
            VALUES("depStaffNum", "#{depstaffnum,jdbcType=INTEGER}");
        }
        
        if (record.getDescription() != null) {
            VALUES("description", "#{description,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(ProjectDep record) {
        BEGIN();
        UPDATE("project_dep");
        
        if (record.getProjectid() != null) {
            SET("projectId = #{projectid,jdbcType=INTEGER}");
        }
        
        if (record.getDepid() != null) {
            SET("depId = #{depid,jdbcType=INTEGER}");
        }
        
        if (record.getDepstaffnum() != null) {
            SET("depStaffNum = #{depstaffnum,jdbcType=INTEGER}");
        }
        
        if (record.getDescription() != null) {
            SET("description = #{description,jdbcType=VARCHAR}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }
}
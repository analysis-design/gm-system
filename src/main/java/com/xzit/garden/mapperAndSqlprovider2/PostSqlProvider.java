package com.xzit.garden.mapperAndSqlprovider2;

import com.xzit.garden.bean.entity.*;

import static org.apache.ibatis.jdbc.SqlBuilder.*;

public class PostSqlProvider {

    public String insertSelective(Post record) {
        BEGIN();
        INSERT_INTO("post");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getName() != null) {
            VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getDescription() != null) {
            VALUES("description", "#{description,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(Post record) {
        BEGIN();
        UPDATE("post");
        
        if (record.getName() != null) {
            SET("name = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getDescription() != null) {
            SET("description = #{description,jdbcType=VARCHAR}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }
}
package com.xzit.garden.mapperAndSqlprovider2;

import com.xzit.garden.bean.entity.*;

import static org.apache.ibatis.jdbc.SqlBuilder.*;

public class PersistentLoginsSqlProvider {

    public String insertSelective(PersistentLogins record) {
        BEGIN();
        INSERT_INTO("persistent_logins");
        
        if (record.getSeries() != null) {
            VALUES("series", "#{series,jdbcType=VARCHAR}");
        }
        
        if (record.getUsername() != null) {
            VALUES("username", "#{username,jdbcType=VARCHAR}");
        }
        
        if (record.getToken() != null) {
            VALUES("token", "#{token,jdbcType=VARCHAR}");
        }
        
        if (record.getLastUsed() != null) {
            VALUES("last_used", "#{lastUsed,jdbcType=TIMESTAMP}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(PersistentLogins record) {
        BEGIN();
        UPDATE("persistent_logins");
        
        if (record.getUsername() != null) {
            SET("username = #{username,jdbcType=VARCHAR}");
        }
        
        if (record.getToken() != null) {
            SET("token = #{token,jdbcType=VARCHAR}");
        }
        
        if (record.getLastUsed() != null) {
            SET("last_used = #{lastUsed,jdbcType=TIMESTAMP}");
        }
        
        WHERE("series = #{series,jdbcType=VARCHAR}");
        
        return SQL();
    }
}
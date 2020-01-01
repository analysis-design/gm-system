package com.xzit.garden.mapperAndSqlprovider2;

import com.xzit.garden.bean.entity.*;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

public interface PersistentLoginsMapper {
    @Delete({
        "delete from persistent_logins",
        "where series = #{series,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String series);

    @Insert({
        "insert into persistent_logins (series, username, ",
        "token, last_used)",
        "values (#{series,jdbcType=VARCHAR}, #{username,jdbcType=VARCHAR}, ",
        "#{token,jdbcType=VARCHAR}, #{lastUsed,jdbcType=TIMESTAMP})"
    })
    int insert(PersistentLogins record);

    @InsertProvider(type=PersistentLoginsSqlProvider.class, method="insertSelective")
    int insertSelective(PersistentLogins record);

    @Select({
        "select",
        "series, username, token, last_used",
        "from persistent_logins",
        "where series = #{series,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="series", property="series", jdbcType= JdbcType.VARCHAR, id=true),
        @Result(column="username", property="username", jdbcType= JdbcType.VARCHAR),
        @Result(column="token", property="token", jdbcType= JdbcType.VARCHAR),
        @Result(column="last_used", property="lastUsed", jdbcType= JdbcType.TIMESTAMP)
    })
    PersistentLogins selectByPrimaryKey(String series);

    @UpdateProvider(type=PersistentLoginsSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(PersistentLogins record);

    @Update({
        "update persistent_logins",
        "set username = #{username,jdbcType=VARCHAR},",
          "token = #{token,jdbcType=VARCHAR},",
          "last_used = #{lastUsed,jdbcType=TIMESTAMP}",
        "where series = #{series,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(PersistentLogins record);
}
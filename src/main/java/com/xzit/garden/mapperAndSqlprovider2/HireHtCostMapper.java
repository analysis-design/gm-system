package com.xzit.garden.mapperAndSqlprovider2;

import com.xzit.garden.bean.entity.*;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

public interface HireHtCostMapper {
    @Delete({
        "delete from hire_ht_cost",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into hire_ht_cost (id, heavyToolId, ",
        "startTime, endTime, ",
        "settlementTotal, description)",
        "values (#{id,jdbcType=INTEGER}, #{heavytoolid,jdbcType=INTEGER}, ",
        "#{starttime,jdbcType=TIMESTAMP}, #{endtime,jdbcType=TIMESTAMP}, ",
        "#{settlementtotal,jdbcType=INTEGER}, #{description,jdbcType=VARCHAR})"
    })
    int insert(HireHtCost record);

    @InsertProvider(type=HireHtCostSqlProvider.class, method="insertSelective")
    int insertSelective(HireHtCost record);

    @Select({
        "select",
        "id, heavyToolId, startTime, endTime, settlementTotal, description",
        "from hire_ht_cost",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType= JdbcType.INTEGER, id=true),
        @Result(column="heavyToolId", property="heavytoolid", jdbcType= JdbcType.INTEGER),
        @Result(column="startTime", property="starttime", jdbcType= JdbcType.TIMESTAMP),
        @Result(column="endTime", property="endtime", jdbcType= JdbcType.TIMESTAMP),
        @Result(column="settlementTotal", property="settlementtotal", jdbcType= JdbcType.INTEGER),
        @Result(column="description", property="description", jdbcType= JdbcType.VARCHAR)
    })
    HireHtCost selectByPrimaryKey(Integer id);

    @UpdateProvider(type=HireHtCostSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(HireHtCost record);

    @Update({
        "update hire_ht_cost",
        "set heavyToolId = #{heavytoolid,jdbcType=INTEGER},",
          "startTime = #{starttime,jdbcType=TIMESTAMP},",
          "endTime = #{endtime,jdbcType=TIMESTAMP},",
          "settlementTotal = #{settlementtotal,jdbcType=INTEGER},",
          "description = #{description,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(HireHtCost record);
}
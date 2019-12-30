package com.xzit.garden.mapperAndSqlprovider2;

import com.xzit.garden.bean.entity.*;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

public interface BudgetMapper {
    @Delete({
        "delete from budget",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into budget (id, projectId, ",
        "resTotal, staffTotal, ",
        "period, surchargeTotal, ",
        "hireStaffTotal, hireMechanicTotal, ",
        "startTime, endTime, ",
        "description)",
        "values (#{id,jdbcType=INTEGER}, #{projectid,jdbcType=INTEGER}, ",
        "#{restotal,jdbcType=INTEGER}, #{stafftotal,jdbcType=INTEGER}, ",
        "#{period,jdbcType=INTEGER}, #{surchargetotal,jdbcType=INTEGER}, ",
        "#{hirestafftotal,jdbcType=INTEGER}, #{hiremechanictotal,jdbcType=INTEGER}, ",
        "#{starttime,jdbcType=TIMESTAMP}, #{endtime,jdbcType=TIMESTAMP}, ",
        "#{description,jdbcType=VARCHAR})"
    })
    int insert(Budget record);

    @InsertProvider(type=BudgetSqlProvider.class, method="insertSelective")
    int insertSelective(Budget record);

    @Select({
        "select",
        "id, projectId, resTotal, staffTotal, period, surchargeTotal, hireStaffTotal, ",
        "hireMechanicTotal, startTime, endTime, description",
        "from budget",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType= JdbcType.INTEGER, id=true),
        @Result(column="projectId", property="projectid", jdbcType= JdbcType.INTEGER),
        @Result(column="resTotal", property="restotal", jdbcType= JdbcType.INTEGER),
        @Result(column="staffTotal", property="stafftotal", jdbcType= JdbcType.INTEGER),
        @Result(column="period", property="period", jdbcType= JdbcType.INTEGER),
        @Result(column="surchargeTotal", property="surchargetotal", jdbcType= JdbcType.INTEGER),
        @Result(column="hireStaffTotal", property="hirestafftotal", jdbcType= JdbcType.INTEGER),
        @Result(column="hireMechanicTotal", property="hiremechanictotal", jdbcType= JdbcType.INTEGER),
        @Result(column="startTime", property="starttime", jdbcType= JdbcType.TIMESTAMP),
        @Result(column="endTime", property="endtime", jdbcType= JdbcType.TIMESTAMP),
        @Result(column="description", property="description", jdbcType= JdbcType.VARCHAR)
    })
    Budget selectByPrimaryKey(Integer id);

    @UpdateProvider(type=BudgetSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Budget record);

    @Update({
        "update budget",
        "set projectId = #{projectid,jdbcType=INTEGER},",
          "resTotal = #{restotal,jdbcType=INTEGER},",
          "staffTotal = #{stafftotal,jdbcType=INTEGER},",
          "period = #{period,jdbcType=INTEGER},",
          "surchargeTotal = #{surchargetotal,jdbcType=INTEGER},",
          "hireStaffTotal = #{hirestafftotal,jdbcType=INTEGER},",
          "hireMechanicTotal = #{hiremechanictotal,jdbcType=INTEGER},",
          "startTime = #{starttime,jdbcType=TIMESTAMP},",
          "endTime = #{endtime,jdbcType=TIMESTAMP},",
          "description = #{description,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Budget record);
}
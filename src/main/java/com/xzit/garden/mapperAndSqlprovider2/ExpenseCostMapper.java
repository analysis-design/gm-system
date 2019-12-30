package com.xzit.garden.mapperAndSqlprovider2;

import com.xzit.garden.bean.entity.*;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

public interface ExpenseCostMapper {
    @Delete({
        "delete from expense_cost",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into expense_cost (id, staffId, ",
        "time, expenseTotal, ",
        "expenseType, total, ",
        "expenseState, surchargePurpose, ",
        "description)",
        "values (#{id,jdbcType=INTEGER}, #{staffid,jdbcType=INTEGER}, ",
        "#{time,jdbcType=TIMESTAMP}, #{expensetotal,jdbcType=INTEGER}, ",
        "#{expensetype,jdbcType=INTEGER}, #{total,jdbcType=INTEGER}, ",
        "#{expensestate,jdbcType=INTEGER}, #{surchargepurpose,jdbcType=VARCHAR}, ",
        "#{description,jdbcType=VARCHAR})"
    })
    int insert(ExpenseCost record);

    @InsertProvider(type=ExpenseCostSqlProvider.class, method="insertSelective")
    int insertSelective(ExpenseCost record);

    @Select({
        "select",
        "id, staffId, time, expenseTotal, expenseType, total, expenseState, surchargePurpose, ",
        "description",
        "from expense_cost",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType= JdbcType.INTEGER, id=true),
        @Result(column="staffId", property="staffid", jdbcType= JdbcType.INTEGER),
        @Result(column="time", property="time", jdbcType= JdbcType.TIMESTAMP),
        @Result(column="expenseTotal", property="expensetotal", jdbcType= JdbcType.INTEGER),
        @Result(column="expenseType", property="expensetype", jdbcType= JdbcType.INTEGER),
        @Result(column="total", property="total", jdbcType= JdbcType.INTEGER),
        @Result(column="expenseState", property="expensestate", jdbcType= JdbcType.INTEGER),
        @Result(column="surchargePurpose", property="surchargepurpose", jdbcType= JdbcType.VARCHAR),
        @Result(column="description", property="description", jdbcType= JdbcType.VARCHAR)
    })
    ExpenseCost selectByPrimaryKey(Integer id);

    @UpdateProvider(type=ExpenseCostSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ExpenseCost record);

    @Update({
        "update expense_cost",
        "set staffId = #{staffid,jdbcType=INTEGER},",
          "time = #{time,jdbcType=TIMESTAMP},",
          "expenseTotal = #{expensetotal,jdbcType=INTEGER},",
          "expenseType = #{expensetype,jdbcType=INTEGER},",
          "total = #{total,jdbcType=INTEGER},",
          "expenseState = #{expensestate,jdbcType=INTEGER},",
          "surchargePurpose = #{surchargepurpose,jdbcType=VARCHAR},",
          "description = #{description,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(ExpenseCost record);
}
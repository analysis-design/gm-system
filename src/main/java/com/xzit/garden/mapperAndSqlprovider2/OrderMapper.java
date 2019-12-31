package com.xzit.garden.mapperAndSqlprovider2;

import com.xzit.garden.bean.entity.*;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

public interface OrderMapper {
    @Delete({
        "delete from order",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into order (id, name, ",
        "budgetId, budgetTotal, ",
        "discount, prepaid, ",
        "payState, paymentMethod, ",
        "paymentTotal, createTime, ",
        "endTime, projectId)",
        "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
        "#{budgetid,jdbcType=INTEGER}, #{budgettotal,jdbcType=INTEGER}, ",
        "#{discount,jdbcType=DOUBLE}, #{prepaid,jdbcType=INTEGER}, ",
        "#{paystate,jdbcType=INTEGER}, #{paymentmethod,jdbcType=INTEGER}, ",
        "#{paymenttotal,jdbcType=INTEGER}, #{createtime,jdbcType=TIMESTAMP}, ",
        "#{endtime,jdbcType=TIMESTAMP}, #{projectid,jdbcType=INTEGER})"
    })
    int insert(Order record);

    @InsertProvider(type=OrderSqlProvider.class, method="insertSelective")
    int insertSelective(Order record);

    @Select({
        "select",
        "id, name, budgetId, budgetTotal, discount, prepaid, payState, paymentMethod, ",
        "paymentTotal, createTime, endTime, projectId",
        "from order",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType= JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType= JdbcType.VARCHAR),
        @Result(column="budgetId", property="budgetid", jdbcType= JdbcType.INTEGER),
        @Result(column="budgetTotal", property="budgettotal", jdbcType= JdbcType.INTEGER),
        @Result(column="discount", property="discount", jdbcType= JdbcType.DOUBLE),
        @Result(column="prepaid", property="prepaid", jdbcType= JdbcType.INTEGER),
        @Result(column="payState", property="paystate", jdbcType= JdbcType.INTEGER),
        @Result(column="paymentMethod", property="paymentmethod", jdbcType= JdbcType.INTEGER),
        @Result(column="paymentTotal", property="paymenttotal", jdbcType= JdbcType.INTEGER),
        @Result(column="createTime", property="createtime", jdbcType= JdbcType.TIMESTAMP),
        @Result(column="endTime", property="endtime", jdbcType= JdbcType.TIMESTAMP),
        @Result(column="projectId", property="projectid", jdbcType= JdbcType.INTEGER)
    })
    Order selectByPrimaryKey(Integer id);

    @UpdateProvider(type=OrderSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Order record);

    @Update({
        "update order",
        "set name = #{name,jdbcType=VARCHAR},",
          "budgetId = #{budgetid,jdbcType=INTEGER},",
          "budgetTotal = #{budgettotal,jdbcType=INTEGER},",
          "discount = #{discount,jdbcType=DOUBLE},",
          "prepaid = #{prepaid,jdbcType=INTEGER},",
          "payState = #{paystate,jdbcType=INTEGER},",
          "paymentMethod = #{paymentmethod,jdbcType=INTEGER},",
          "paymentTotal = #{paymenttotal,jdbcType=INTEGER},",
          "createTime = #{createtime,jdbcType=TIMESTAMP},",
          "endTime = #{endtime,jdbcType=TIMESTAMP},",
          "projectId = #{projectid,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Order record);
}
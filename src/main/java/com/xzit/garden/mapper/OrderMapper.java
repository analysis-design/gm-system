package com.xzit.garden.mapper;

import com.xzit.garden.bean.entity.Order;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface OrderMapper {

    @Insert("insert into `order` (name,budgetId,budgetTotal,discount,prepaid,payState," +
            "paymentMethod,paymentTotal,createTime,endTime,projectId) values (#{name}," +
            "#{budgetId},#{budgetTotal},#{discount},#{prepaid},#{payState},#{paymentMethod},#{paymentTotal},#{createTime},#{endTime},#{projectId})")
    Integer insert(Order order);

    @Delete("delete from `order` where id=#{id}")
    Integer delete(@Param("id")Long id);

    @Update("update `order` set name=#{name},budgetId=#{budgetId},budgetTotal=#{budgetTotal},discount=#{discount}," +
            "prepaid=#{prepaid},payState=#{payState},paymentMethod=#{paymentMethod},paymentTotal=#{paymentTotal}," +
            "createTime=#{createTime},endTime=#{endTime},projectId=#{projectId} where id=#{id}")
    Integer update(Order order);

    @Select("select * from `order` where id=#{id}")
    Order findById(@Param("id")Long id);

    @Select("select * from `order`")
    List<Order> findAll();

    @Select("select * from `order` where projectId in (select id from project where name like '%${projectName}%')")
    List<Order> findByProjectName(@Param("projectName")String name);

    @Select("select * from `order` where projectId=#{projectId}")
    Order findByProjectId(@Param("projectId") Long id);
}

package com.xzit.garden.mapper;

import com.xzit.garden.bean.entity.Budget;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BudgetMapper {

    @Select("select * from budget where id=#{id}")
    Budget findById(@Param("id") Long id);

    @Select("select * from budget")
    List<Budget> findAll();

    @Select("select * from budget where projectId=#{id}")
    Budget findByProjectId(@Param("id") Long id);
}

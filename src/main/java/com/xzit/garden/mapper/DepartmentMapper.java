package com.xzit.garden.mapper;

import com.xzit.garden.bean.entity.Department;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DepartmentMapper {

    @Select("select * from department where id=#{id}")
    Department findById(@Param("id") Long id);

    @Select("select * from department")
    List<Department> findAll();
}

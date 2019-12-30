package com.xzit.garden.mapper;

import com.xzit.garden.bean.entity.Staff;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface StaffMapper {
    @Select("select * from staff where id=#{id}")
    Staff findById(Long id);
}

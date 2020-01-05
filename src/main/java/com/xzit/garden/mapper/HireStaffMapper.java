package com.xzit.garden.mapper;

import com.xzit.garden.bean.entity.HireStaff;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface HireStaffMapper {

    @Select("select * from hire_staff where id=#{staffId}")
    HireStaff findById(Long staffId);
}

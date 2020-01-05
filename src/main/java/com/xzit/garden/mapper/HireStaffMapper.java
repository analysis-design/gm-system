package com.xzit.garden.mapper;

import com.xzit.garden.bean.entity.HireStaff;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface HireStaffMapper {

    @Select("select * from hire_staff where id=#{staffId}")
    HireStaff findById(Long staffId);

    @Select("select * from hire_staff where hire_state = 0")
    List<HireStaff> findExistAll();

}

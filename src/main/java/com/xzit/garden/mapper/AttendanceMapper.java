package com.xzit.garden.mapper;

import com.xzit.garden.bean.entity.Attendance;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AttendanceMapper {

    @Select("select * from attendance order by startTime desc limit #{page}, #{limit}")
    List<Attendance> findPage(@Param("page") int page, @Param("limit") Integer limit);

    @Select("select count(*) from attendance")
    int countAttendance();
}

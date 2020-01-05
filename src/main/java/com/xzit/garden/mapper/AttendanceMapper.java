package com.xzit.garden.mapper;

import com.xzit.garden.bean.entity.Attendance;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AttendanceMapper {

    @Select("select * from attendance order by startTime desc limit #{page}, #{limit}")
    List<Attendance> findPage(@Param("page") int page, @Param("limit") Integer limit);

    @Select("select count(*) from attendance")
    int countAttendance();

    @Select("select * from attendance where id=#{attendanceId}")
    Attendance findById(Long attendanceId);

    @Insert("insert into attendance (startTime, endTime, staffId, staffType, attendanceState, description) " +
            "values (#{startTime}, #{endTime}, #{staffId}, #{staffType}, #{attendanceState}, #{description})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    void add(Attendance attendance);

    @Update("update attendance set startTime = #{startTime}, endTime = #{endTime}, " +
            "staffId = #{staffId}, staffType = #{staffType}, attendanceState = #{attendanceState}, " +
            "description = #{description} where id = #{id}")
    void updateById(Attendance attendance);
}

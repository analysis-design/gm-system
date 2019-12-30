package com.xzit.garden.mapperAndSqlprovider2;

import com.xzit.garden.bean.entity.*;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

public interface StaffLeaveMapper {
    @Delete({
        "delete from staff_leave",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into staff_leave (id, startTime, ",
        "endTime, staffId, ",
        "staffType, reason, ",
        "leaveType, description)",
        "values (#{id,jdbcType=INTEGER}, #{starttime,jdbcType=TIMESTAMP}, ",
        "#{endtime,jdbcType=TIMESTAMP}, #{staffid,jdbcType=INTEGER}, ",
        "#{stafftype,jdbcType=INTEGER}, #{reason,jdbcType=VARCHAR}, ",
        "#{leavetype,jdbcType=INTEGER}, #{description,jdbcType=VARCHAR})"
    })
    int insert(StaffLeave record);

    @InsertProvider(type=StaffLeaveSqlProvider.class, method="insertSelective")
    int insertSelective(StaffLeave record);

    @Select({
        "select",
        "id, startTime, endTime, staffId, staffType, reason, leaveType, description",
        "from staff_leave",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType= JdbcType.INTEGER, id=true),
        @Result(column="startTime", property="starttime", jdbcType= JdbcType.TIMESTAMP),
        @Result(column="endTime", property="endtime", jdbcType= JdbcType.TIMESTAMP),
        @Result(column="staffId", property="staffid", jdbcType= JdbcType.INTEGER),
        @Result(column="staffType", property="stafftype", jdbcType= JdbcType.INTEGER),
        @Result(column="reason", property="reason", jdbcType= JdbcType.VARCHAR),
        @Result(column="leaveType", property="leavetype", jdbcType= JdbcType.INTEGER),
        @Result(column="description", property="description", jdbcType= JdbcType.VARCHAR)
    })
    StaffLeave selectByPrimaryKey(Integer id);

    @UpdateProvider(type=StaffLeaveSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(StaffLeave record);

    @Update({
        "update staff_leave",
        "set startTime = #{starttime,jdbcType=TIMESTAMP},",
          "endTime = #{endtime,jdbcType=TIMESTAMP},",
          "staffId = #{staffid,jdbcType=INTEGER},",
          "staffType = #{stafftype,jdbcType=INTEGER},",
          "reason = #{reason,jdbcType=VARCHAR},",
          "leaveType = #{leavetype,jdbcType=INTEGER},",
          "description = #{description,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(StaffLeave record);
}
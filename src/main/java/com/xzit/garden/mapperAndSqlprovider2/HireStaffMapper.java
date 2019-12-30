package com.xzit.garden.mapperAndSqlprovider2;

import com.xzit.garden.bean.entity.*;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

public interface HireStaffMapper {
    @Delete({
        "delete from hire_staff",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into hire_staff (id, name, ",
        "gender, birthday, ",
        "phone, address, ",
        "hireStartTime, hireEndTime, ",
        "settlementType, salary, ",
        "comment)",
        "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
        "#{gender,jdbcType=INTEGER}, #{birthday,jdbcType=TIMESTAMP}, ",
        "#{phone,jdbcType=VARCHAR}, #{address,jdbcType=VARCHAR}, ",
        "#{hirestarttime,jdbcType=TIMESTAMP}, #{hireendtime,jdbcType=TIMESTAMP}, ",
        "#{settlementtype,jdbcType=INTEGER}, #{salary,jdbcType=INTEGER}, ",
        "#{comment,jdbcType=VARCHAR})"
    })
    int insert(HireStaff record);

    @InsertProvider(type=HireStaffSqlProvider.class, method="insertSelective")
    int insertSelective(HireStaff record);

    @Select({
        "select",
        "id, name, gender, birthday, phone, address, hireStartTime, hireEndTime, settlementType, ",
        "salary, comment",
        "from hire_staff",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType= JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType= JdbcType.VARCHAR),
        @Result(column="gender", property="gender", jdbcType= JdbcType.INTEGER),
        @Result(column="birthday", property="birthday", jdbcType= JdbcType.TIMESTAMP),
        @Result(column="phone", property="phone", jdbcType= JdbcType.VARCHAR),
        @Result(column="address", property="address", jdbcType= JdbcType.VARCHAR),
        @Result(column="hireStartTime", property="hirestarttime", jdbcType= JdbcType.TIMESTAMP),
        @Result(column="hireEndTime", property="hireendtime", jdbcType= JdbcType.TIMESTAMP),
        @Result(column="settlementType", property="settlementtype", jdbcType= JdbcType.INTEGER),
        @Result(column="salary", property="salary", jdbcType= JdbcType.INTEGER),
        @Result(column="comment", property="comment", jdbcType= JdbcType.VARCHAR)
    })
    HireStaff selectByPrimaryKey(Integer id);

    @UpdateProvider(type=HireStaffSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(HireStaff record);

    @Update({
        "update hire_staff",
        "set name = #{name,jdbcType=VARCHAR},",
          "gender = #{gender,jdbcType=INTEGER},",
          "birthday = #{birthday,jdbcType=TIMESTAMP},",
          "phone = #{phone,jdbcType=VARCHAR},",
          "address = #{address,jdbcType=VARCHAR},",
          "hireStartTime = #{hirestarttime,jdbcType=TIMESTAMP},",
          "hireEndTime = #{hireendtime,jdbcType=TIMESTAMP},",
          "settlementType = #{settlementtype,jdbcType=INTEGER},",
          "salary = #{salary,jdbcType=INTEGER},",
          "comment = #{comment,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(HireStaff record);
}
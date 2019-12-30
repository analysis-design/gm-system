package com.xzit.garden.mapperAndSqlprovider2;

import com.xzit.garden.bean.entity.*;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

public interface StaffMapper {
    @Delete({
        "delete from staff",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into staff (id, name, ",
        "gender, birthday, ",
        "phone, address, ",
        "entryTime, state, ",
        "settlementType, salary, ",
        "position, staffType, ",
        "description, depId)",
        "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
        "#{gender,jdbcType=INTEGER}, #{birthday,jdbcType=TIMESTAMP}, ",
        "#{phone,jdbcType=VARCHAR}, #{address,jdbcType=VARCHAR}, ",
        "#{entrytime,jdbcType=TIMESTAMP}, #{state,jdbcType=INTEGER}, ",
        "#{settlementtype,jdbcType=INTEGER}, #{salary,jdbcType=INTEGER}, ",
        "#{position,jdbcType=VARCHAR}, #{stafftype,jdbcType=INTEGER}, ",
        "#{description,jdbcType=VARCHAR}, #{depid,jdbcType=INTEGER})"
    })
    int insert(Staff record);

    @InsertProvider(type=StaffSqlProvider.class, method="insertSelective")
    int insertSelective(Staff record);

    @Select({
        "select",
        "id, name, gender, birthday, phone, address, entryTime, state, settlementType, ",
        "salary, position, staffType, description, depId",
        "from staff",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType= JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType= JdbcType.VARCHAR),
        @Result(column="gender", property="gender", jdbcType= JdbcType.INTEGER),
        @Result(column="birthday", property="birthday", jdbcType= JdbcType.TIMESTAMP),
        @Result(column="phone", property="phone", jdbcType= JdbcType.VARCHAR),
        @Result(column="address", property="address", jdbcType= JdbcType.VARCHAR),
        @Result(column="entryTime", property="entrytime", jdbcType= JdbcType.TIMESTAMP),
        @Result(column="state", property="state", jdbcType= JdbcType.INTEGER),
        @Result(column="settlementType", property="settlementtype", jdbcType= JdbcType.INTEGER),
        @Result(column="salary", property="salary", jdbcType= JdbcType.INTEGER),
        @Result(column="position", property="position", jdbcType= JdbcType.VARCHAR),
        @Result(column="staffType", property="stafftype", jdbcType= JdbcType.INTEGER),
        @Result(column="description", property="description", jdbcType= JdbcType.VARCHAR),
        @Result(column="depId", property="depid", jdbcType= JdbcType.INTEGER)
    })
    Staff selectByPrimaryKey(Integer id);

    @UpdateProvider(type=StaffSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Staff record);

    @Update({
        "update staff",
        "set name = #{name,jdbcType=VARCHAR},",
          "gender = #{gender,jdbcType=INTEGER},",
          "birthday = #{birthday,jdbcType=TIMESTAMP},",
          "phone = #{phone,jdbcType=VARCHAR},",
          "address = #{address,jdbcType=VARCHAR},",
          "entryTime = #{entrytime,jdbcType=TIMESTAMP},",
          "state = #{state,jdbcType=INTEGER},",
          "settlementType = #{settlementtype,jdbcType=INTEGER},",
          "salary = #{salary,jdbcType=INTEGER},",
          "position = #{position,jdbcType=VARCHAR},",
          "staffType = #{stafftype,jdbcType=INTEGER},",
          "description = #{description,jdbcType=VARCHAR},",
          "depId = #{depid,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Staff record);
}
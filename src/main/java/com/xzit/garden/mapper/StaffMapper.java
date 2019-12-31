package com.xzit.garden.mapper;

import com.xzit.garden.bean.entity.Staff;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StaffMapper {

    @Insert("insert into staff(name,gender,birthday,phone,address,entryTime,state," +
            "settlementType,salary,position,staffType,description,depId) " +
            "values(#{name},#{gender},#{birthday},#{phone},#{address},#{entryTime},#{state}," +
            "#{settlementType},#{salary},#{position},#{staffType},#{description},#{depId})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    Integer insert(Staff staff);

    @Delete("delete from staff where id=#{id}")
    Integer delete(@Param("id") Long id);

    @Update("update staff set name=#{name},gender=#{gender},birthday=#{birthday},phone=#{phone},address=#{address}," +
            "entryTime=#{entryTime},state=#{state},settlementType=#{settlementType},salary=#{salary},position=#{position}," +
            "staffType=#{staffType},description=#{description},depId=#{depId} where id=#{id}")
    Integer update(Staff staff);

    @Select("select * from staff where id=#{id}")
    Staff findById(Long id);

    @Select("select * from staff")
    List<Staff> findAll();
}

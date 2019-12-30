package com.xzit.garden.mapperAndSqlprovider2;

import com.xzit.garden.bean.entity.*;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

public interface SupplierMapper {
    @Delete({
        "delete from supplier",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into supplier (id, name, ",
        "leader, phone, address, ",
        "description)",
        "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
        "#{leader,jdbcType=VARCHAR}, #{phone,jdbcType=VARCHAR}, #{address,jdbcType=VARCHAR}, ",
        "#{description,jdbcType=VARCHAR})"
    })
    int insert(Supplier record);

    @InsertProvider(type=SupplierSqlProvider.class, method="insertSelective")
    int insertSelective(Supplier record);

    @Select({
        "select",
        "id, name, leader, phone, address, description",
        "from supplier",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType= JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType= JdbcType.VARCHAR),
        @Result(column="leader", property="leader", jdbcType= JdbcType.VARCHAR),
        @Result(column="phone", property="phone", jdbcType= JdbcType.VARCHAR),
        @Result(column="address", property="address", jdbcType= JdbcType.VARCHAR),
        @Result(column="description", property="description", jdbcType= JdbcType.VARCHAR)
    })
    Supplier selectByPrimaryKey(Integer id);

    @UpdateProvider(type=SupplierSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Supplier record);

    @Update({
        "update supplier",
        "set name = #{name,jdbcType=VARCHAR},",
          "leader = #{leader,jdbcType=VARCHAR},",
          "phone = #{phone,jdbcType=VARCHAR},",
          "address = #{address,jdbcType=VARCHAR},",
          "description = #{description,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Supplier record);
}
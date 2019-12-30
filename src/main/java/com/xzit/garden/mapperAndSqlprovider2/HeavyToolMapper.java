package com.xzit.garden.mapperAndSqlprovider2;

import com.xzit.garden.bean.entity.*;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

public interface HeavyToolMapper {
    @Delete({
        "delete from heavy_tool",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into heavy_tool (id, name, ",
        "supplierId, hirePrice, ",
        "settlementType, description)",
        "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
        "#{supplierid,jdbcType=INTEGER}, #{hireprice,jdbcType=INTEGER}, ",
        "#{settlementtype,jdbcType=INTEGER}, #{description,jdbcType=VARCHAR})"
    })
    int insert(HeavyTool record);

    @InsertProvider(type=HeavyToolSqlProvider.class, method="insertSelective")
    int insertSelective(HeavyTool record);

    @Select({
        "select",
        "id, name, supplierId, hirePrice, settlementType, description",
        "from heavy_tool",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType= JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType= JdbcType.VARCHAR),
        @Result(column="supplierId", property="supplierid", jdbcType= JdbcType.INTEGER),
        @Result(column="hirePrice", property="hireprice", jdbcType= JdbcType.INTEGER),
        @Result(column="settlementType", property="settlementtype", jdbcType= JdbcType.INTEGER),
        @Result(column="description", property="description", jdbcType= JdbcType.VARCHAR)
    })
    HeavyTool selectByPrimaryKey(Integer id);

    @UpdateProvider(type=HeavyToolSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(HeavyTool record);

    @Update({
        "update heavy_tool",
        "set name = #{name,jdbcType=VARCHAR},",
          "supplierId = #{supplierid,jdbcType=INTEGER},",
          "hirePrice = #{hireprice,jdbcType=INTEGER},",
          "settlementType = #{settlementtype,jdbcType=INTEGER},",
          "description = #{description,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(HeavyTool record);
}
package com.xzit.garden.mapperAndSqlprovider2;

import com.xzit.garden.bean.entity.*;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

public interface ResourceCostMapper {
    @Delete({
        "delete from resource_cost",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into resource_cost (id, planId, ",
        "resId, resNum, resTotal, ",
        "description)",
        "values (#{id,jdbcType=INTEGER}, #{planid,jdbcType=INTEGER}, ",
        "#{resid,jdbcType=INTEGER}, #{resnum,jdbcType=INTEGER}, #{restotal,jdbcType=INTEGER}, ",
        "#{description,jdbcType=VARCHAR})"
    })
    int insert(ResourceCost record);

    @InsertProvider(type=ResourceCostSqlProvider.class, method="insertSelective")
    int insertSelective(ResourceCost record);

    @Select({
        "select",
        "id, planId, resId, resNum, resTotal, description",
        "from resource_cost",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType= JdbcType.INTEGER, id=true),
        @Result(column="planId", property="planid", jdbcType= JdbcType.INTEGER),
        @Result(column="resId", property="resid", jdbcType= JdbcType.INTEGER),
        @Result(column="resNum", property="resnum", jdbcType= JdbcType.INTEGER),
        @Result(column="resTotal", property="restotal", jdbcType= JdbcType.INTEGER),
        @Result(column="description", property="description", jdbcType= JdbcType.VARCHAR)
    })
    ResourceCost selectByPrimaryKey(Integer id);

    @UpdateProvider(type=ResourceCostSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ResourceCost record);

    @Update({
        "update resource_cost",
        "set planId = #{planid,jdbcType=INTEGER},",
          "resId = #{resid,jdbcType=INTEGER},",
          "resNum = #{resnum,jdbcType=INTEGER},",
          "resTotal = #{restotal,jdbcType=INTEGER},",
          "description = #{description,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(ResourceCost record);
}
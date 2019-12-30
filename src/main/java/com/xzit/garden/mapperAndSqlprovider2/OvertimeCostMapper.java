package com.xzit.garden.mapperAndSqlprovider2;

import com.xzit.garden.bean.entity.*;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

public interface OvertimeCostMapper {
    @Delete({
        "delete from overtime_cost",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into overtime_cost (id, staffId, ",
        "startTime, endTime, ",
        "auditState, overtimeTotal, ",
        "description)",
        "values (#{id,jdbcType=INTEGER}, #{staffid,jdbcType=INTEGER}, ",
        "#{starttime,jdbcType=TIMESTAMP}, #{endtime,jdbcType=TIMESTAMP}, ",
        "#{auditstate,jdbcType=INTEGER}, #{overtimetotal,jdbcType=INTEGER}, ",
        "#{description,jdbcType=VARCHAR})"
    })
    int insert(OvertimeCost record);

    @InsertProvider(type=OvertimeCostSqlProvider.class, method="insertSelective")
    int insertSelective(OvertimeCost record);

    @Select({
        "select",
        "id, staffId, startTime, endTime, auditState, overtimeTotal, description",
        "from overtime_cost",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType= JdbcType.INTEGER, id=true),
        @Result(column="staffId", property="staffid", jdbcType= JdbcType.INTEGER),
        @Result(column="startTime", property="starttime", jdbcType= JdbcType.TIMESTAMP),
        @Result(column="endTime", property="endtime", jdbcType= JdbcType.TIMESTAMP),
        @Result(column="auditState", property="auditstate", jdbcType= JdbcType.INTEGER),
        @Result(column="overtimeTotal", property="overtimetotal", jdbcType= JdbcType.INTEGER),
        @Result(column="description", property="description", jdbcType= JdbcType.VARCHAR)
    })
    OvertimeCost selectByPrimaryKey(Integer id);

    @UpdateProvider(type=OvertimeCostSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(OvertimeCost record);

    @Update({
        "update overtime_cost",
        "set staffId = #{staffid,jdbcType=INTEGER},",
          "startTime = #{starttime,jdbcType=TIMESTAMP},",
          "endTime = #{endtime,jdbcType=TIMESTAMP},",
          "auditState = #{auditstate,jdbcType=INTEGER},",
          "overtimeTotal = #{overtimetotal,jdbcType=INTEGER},",
          "description = #{description,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(OvertimeCost record);
}
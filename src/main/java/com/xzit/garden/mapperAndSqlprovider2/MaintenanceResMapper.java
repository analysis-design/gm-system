package com.xzit.garden.mapperAndSqlprovider2;

import com.xzit.garden.bean.entity.*;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

public interface MaintenanceResMapper {
    @Delete({
        "delete from maintenance_res",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into maintenance_res (id, maintenancePlanId, ",
        "resId, resNum, purpose, ",
        "description)",
        "values (#{id,jdbcType=INTEGER}, #{maintenanceplanid,jdbcType=INTEGER}, ",
        "#{resid,jdbcType=INTEGER}, #{resnum,jdbcType=INTEGER}, #{purpose,jdbcType=VARCHAR}, ",
        "#{description,jdbcType=VARCHAR})"
    })
    int insert(MaintenanceRes record);

    @InsertProvider(type=MaintenanceResSqlProvider.class, method="insertSelective")
    int insertSelective(MaintenanceRes record);

    @Select({
        "select",
        "id, maintenancePlanId, resId, resNum, purpose, description",
        "from maintenance_res",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType= JdbcType.INTEGER, id=true),
        @Result(column="maintenancePlanId", property="maintenanceplanid", jdbcType= JdbcType.INTEGER),
        @Result(column="resId", property="resid", jdbcType= JdbcType.INTEGER),
        @Result(column="resNum", property="resnum", jdbcType= JdbcType.INTEGER),
        @Result(column="purpose", property="purpose", jdbcType= JdbcType.VARCHAR),
        @Result(column="description", property="description", jdbcType= JdbcType.VARCHAR)
    })
    MaintenanceRes selectByPrimaryKey(Integer id);

    @UpdateProvider(type=MaintenanceResSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(MaintenanceRes record);

    @Update({
        "update maintenance_res",
        "set maintenancePlanId = #{maintenanceplanid,jdbcType=INTEGER},",
          "resId = #{resid,jdbcType=INTEGER},",
          "resNum = #{resnum,jdbcType=INTEGER},",
          "purpose = #{purpose,jdbcType=VARCHAR},",
          "description = #{description,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(MaintenanceRes record);
}
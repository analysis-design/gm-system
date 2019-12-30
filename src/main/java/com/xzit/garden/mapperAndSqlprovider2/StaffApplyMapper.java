package com.xzit.garden.mapperAndSqlprovider2;

import entity.StaffApply;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

public interface StaffApplyMapper {
    @Delete({
        "delete from staff_apply",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into staff_apply (id, applyTime, ",
        "auditState, groupId, ",
        "implPlanId, applierId, ",
        "purpose, staff_type, ",
        "description)",
        "values (#{id,jdbcType=INTEGER}, #{applytime,jdbcType=TIMESTAMP}, ",
        "#{auditstate,jdbcType=INTEGER}, #{groupid,jdbcType=INTEGER}, ",
        "#{implplanid,jdbcType=INTEGER}, #{applierid,jdbcType=INTEGER}, ",
        "#{purpose,jdbcType=VARCHAR}, #{staffType,jdbcType=INTEGER}, ",
        "#{description,jdbcType=VARCHAR})"
    })
    int insert(StaffApply record);

    @InsertProvider(type=StaffApplySqlProvider.class, method="insertSelective")
    int insertSelective(StaffApply record);

    @Select({
        "select",
        "id, applyTime, auditState, groupId, implPlanId, applierId, purpose, staff_type, ",
        "description",
        "from staff_apply",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType= JdbcType.INTEGER, id=true),
        @Result(column="applyTime", property="applytime", jdbcType= JdbcType.TIMESTAMP),
        @Result(column="auditState", property="auditstate", jdbcType= JdbcType.INTEGER),
        @Result(column="groupId", property="groupid", jdbcType= JdbcType.INTEGER),
        @Result(column="implPlanId", property="implplanid", jdbcType= JdbcType.INTEGER),
        @Result(column="applierId", property="applierid", jdbcType= JdbcType.INTEGER),
        @Result(column="purpose", property="purpose", jdbcType= JdbcType.VARCHAR),
        @Result(column="staff_type", property="staffType", jdbcType= JdbcType.INTEGER),
        @Result(column="description", property="description", jdbcType= JdbcType.VARCHAR)
    })
    StaffApply selectByPrimaryKey(Integer id);

    @UpdateProvider(type=StaffApplySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(StaffApply record);

    @Update({
        "update staff_apply",
        "set applyTime = #{applytime,jdbcType=TIMESTAMP},",
          "auditState = #{auditstate,jdbcType=INTEGER},",
          "groupId = #{groupid,jdbcType=INTEGER},",
          "implPlanId = #{implplanid,jdbcType=INTEGER},",
          "applierId = #{applierid,jdbcType=INTEGER},",
          "purpose = #{purpose,jdbcType=VARCHAR},",
          "staff_type = #{staffType,jdbcType=INTEGER},",
          "description = #{description,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(StaffApply record);
}
package com.xzit.garden.mapper;

import com.xzit.garden.bean.dto.MaintenanceResApplyDto;
import com.xzit.garden.bean.dto.MaintenanceResDto;
import com.xzit.garden.bean.entity.MaintenanceRes;
import com.xzit.garden.bean.entity.MaintenanceplanResApply;
import com.xzit.garden.bean.entity.ResApply;
import com.xzit.garden.bean.entity.Resource;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

@Mapper
public interface MaintenanceResMapper {
    @Delete({
            "delete from maintenance_res",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
            "insert into maintenance_res (id, maintenancePlanId, ",
            "resId, resNum, purpose, ",
            "description)",
            "values (#{id,jdbcType=INTEGER}, #{maintenanceplanid,jdbcType=INTEGER}, ",
            "#{resid,jdbcType=INTEGER}, #{resnum,jdbcType=INTEGER}, #{purpose,jdbcType=VARCHAR}, ",
            "#{description,jdbcType=VARCHAR})"
    })
    int insert(MaintenanceRes record);

    @InsertProvider(type = MaintenanceResSqlProvider.class, method = "insertSelective")
    int insertSelective(MaintenanceRes record);

    @Select({
            "select",
            "id, maintenancePlanId, resId, resNum, purpose, description",
            "from maintenance_res",
            "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "maintenancePlanId", property = "maintenanceplanid", jdbcType = JdbcType.INTEGER),
            @Result(column = "resId", property = "resid", jdbcType = JdbcType.INTEGER),
            @Result(column = "resNum", property = "resnum", jdbcType = JdbcType.INTEGER),
            @Result(column = "purpose", property = "purpose", jdbcType = JdbcType.VARCHAR),
            @Result(column = "description", property = "description", jdbcType = JdbcType.VARCHAR)
    })
    MaintenanceRes selectByPrimaryKey(Long id);

    @UpdateProvider(type = MaintenanceResSqlProvider.class, method = "updateByPrimaryKeySelective")
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
    @Select("select * from resource")
    List<Resource> findAllResource();
    @Select("SELECT b.* , a.name as resourcename , a.description as  resourcedescription from resource as a join maintenance_res as b on a.id=b.resId" +
            " where maintenancePlanid=#{id}")
    List<MaintenanceResDto> findAllresourceDtoByid(Long id);
    @Select("SELECT a.*  , b.name as resourcename , b.description as  resourcedescription" +
            " from maintenanceplanRes_apply as a join resource as b on a.resId=b.id where implPlanId=#{id}")
    List<MaintenanceResApplyDto> findAllMaintenanceApplyDto(Long id);
    @Delete({
            "delete from maintenanceplanRes_apply",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteMaintenanceApplyByPrimaryKey(Long id);
    @UpdateProvider(type=MaintenanceResSqlProvider.class, method="updateMaintenanceResApplyByPrimaryKeySelective")
    int updateMaintenanceResApplyByPrimaryKeySelective(MaintenanceplanResApply  record);
    @InsertProvider(type=MaintenanceResSqlProvider.class, method="insertMaintenanceResApplySelective")
    int insertMaintenanceResApplySelective(MaintenanceplanResApply  record);
    @Select({
            "select",
            "id, applyTime, auditState, applierId, resId, resNum, purpose, implPlanId, resAllocatedTime, ",
            "description",
            "from maintenanceplanRes_apply",
            "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="applyTime", property="applytime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="auditState", property="auditstate", jdbcType=JdbcType.INTEGER),
            @Result(column="applierId", property="applierid", jdbcType=JdbcType.INTEGER),
            @Result(column="resId", property="resid", jdbcType=JdbcType.INTEGER),
            @Result(column="resNum", property="resnum", jdbcType=JdbcType.INTEGER),
            @Result(column="purpose", property="purpose", jdbcType=JdbcType.VARCHAR),
            @Result(column="implPlanId", property="implplanid", jdbcType=JdbcType.INTEGER),
            @Result(column="resAllocatedTime", property="resallocatedtime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR)
    })
    MaintenanceplanResApply selectmaintenanceplanRes_applyByPrimaryKey(Long id);




}

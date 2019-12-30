package com.xzit.garden.mapperAndSqlprovider2;

import com.xzit.garden.bean.entity.*;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

public interface ProjectDepMapper {
    @Delete({
        "delete from project_dep",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into project_dep (id, projectId, ",
        "depId, depStaffNum, ",
        "description)",
        "values (#{id,jdbcType=INTEGER}, #{projectid,jdbcType=INTEGER}, ",
        "#{depid,jdbcType=INTEGER}, #{depstaffnum,jdbcType=INTEGER}, ",
        "#{description,jdbcType=VARCHAR})"
    })
    int insert(ProjectDep record);

    @InsertProvider(type=ProjectDepSqlProvider.class, method="insertSelective")
    int insertSelective(ProjectDep record);

    @Select({
        "select",
        "id, projectId, depId, depStaffNum, description",
        "from project_dep",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType= JdbcType.INTEGER, id=true),
        @Result(column="projectId", property="projectid", jdbcType= JdbcType.INTEGER),
        @Result(column="depId", property="depid", jdbcType= JdbcType.INTEGER),
        @Result(column="depStaffNum", property="depstaffnum", jdbcType= JdbcType.INTEGER),
        @Result(column="description", property="description", jdbcType= JdbcType.VARCHAR)
    })
    ProjectDep selectByPrimaryKey(Integer id);

    @UpdateProvider(type=ProjectDepSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ProjectDep record);

    @Update({
        "update project_dep",
        "set projectId = #{projectid,jdbcType=INTEGER},",
          "depId = #{depid,jdbcType=INTEGER},",
          "depStaffNum = #{depstaffnum,jdbcType=INTEGER},",
          "description = #{description,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(ProjectDep record);
}
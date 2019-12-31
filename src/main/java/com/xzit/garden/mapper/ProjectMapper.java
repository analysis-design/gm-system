package com.xzit.garden.mapper;

import com.xzit.garden.bean.entity.Project;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProjectMapper {

    @Select("select * from project")
    List<Project> findAll();

    @Select("select * from project where id=#{id}")
    Project findById(@Param("id") Integer id);

    @Insert("insert into project (name,workSite,state,contractFile,difficultyLevel,startTime,expectedEndTime,actualEndTime,description,saleId,clientId)" +
            "values (#{name},#{workSite},#{state},#{contractFile},#{difficultyLevel},#{startTime},#{expectedEndTime},#{actualEndTime},#{description},#{saleId},#{clientId})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    Integer insert(Project project);

    @Delete("delete from project where id=#{id}")
    Integer delete(@Param("id") Integer id);

    @Update("update project set name=#{name},workSite=#{workSite},state=#{state},contractFile=#{contractFile}," +
            "difficultyLevel=#{difficultyLevel},startTime=#{startTime},expectedEndTime=#{expectedEndTime}" +
            "actualEndTime=#{actualEndTime},description=#{description},saleId=#{saleId},clientId=#{clientId} where id=#{id}")
    Integer update(Project project);
}

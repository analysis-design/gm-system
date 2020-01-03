package com.xzit.garden.mapper;

import com.xzit.garden.bean.entity.Project;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProjectMapper {

    @Select("select * from project where isDelete=0")
    List<Project> findAll();

    @Select("select count(*) from project")
    Integer findCount();

    @Select("select * from project where id=#{id} and isDelete=0")
    Project findById(@Param("id") Long id);

    @Select("select * from project where name like'%${name}%' and isDelete=0")
    List<Project> findByName(@Param("name")String name);

    @Select("select * from project where state=#{state} and isDelete=0")
    List<Project> findByState(@Param("state")Integer state);

    @Select("select * from project where difficultyLevel=#{difficultyLevel} and isDelete=0")
    List<Project> findByDifficulty(@Param("difficultyLevel")Integer difficultyLevel);

    @Insert("insert into project (name,workSite,state,contractFile,difficultyLevel,startTime,expectedEndTime,actualEndTime,description,saleId,clientId)" +
            "values (#{name},#{workSite},#{state},#{contractFile},#{difficultyLevel},#{startTime},#{expectedEndTime},#{actualEndTime},#{description},#{saleId},#{clientId})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    Integer insert(Project project);

    @Delete("delete from project where id=#{id}")
    Integer delete(@Param("id") Long id);

    @Update("update project set isDelete=1 where id=#{id}")
    Integer isDelete(@Param("id")Long id);

    @Update("update project set name=#{name},workSite=#{workSite},state=#{state},contractFile=#{contractFile}," +
            "difficultyLevel=#{difficultyLevel},startTime=#{startTime},expectedEndTime=#{expectedEndTime}," +
            "actualEndTime=#{actualEndTime},description=#{description},saleId=#{saleId},clientId=#{clientId} where id=#{id}")
    Integer update(Project project);
}

package com.xzit.garden.mapper;

import com.xzit.garden.bean.entity.HelloEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface HelloMapper {

    @Select("select * from hello where id=#{id}")
    HelloEntity findById(@Param("id") Long id);

    @Select("select * from hello")
    List<HelloEntity> findAll();

    @Insert("insert into hello(message, A) values(#{message}, #{A})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int add(HelloEntity entity);

    @Update("update hello set message=#{message} where id=#{id}")
    void update(HelloEntity entity);

    @Delete("delete from hello where id=#{id}")
    int deleteById(@Param("id") Long id);
}

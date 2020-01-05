package com.xzit.garden.mapper;

import com.xzit.garden.bean.entity.Resource;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ResourceMapper {

    @Select("select * from resource limit #{page}, #{limit}")
    List<Resource> findPage(@Param("page") int page, @Param("limit") Integer limit);

    @Select("select count(*) from resource")
    int countResource();

    @Select("select * from resource where id=#{resId}")
    Resource findById(Long resId);
}

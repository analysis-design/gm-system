package com.xzit.garden.mapper;

import com.xzit.garden.bean.entity.HelloEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface HelloMapper {

    @Select("select * from hello where id=#{id}")
    HelloEntity findById(@Param("id") Long id);
}

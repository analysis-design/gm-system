package com.xzit.garden.mapper;

import com.xzit.garden.bean.entity.Resource;
import org.apache.ibatis.annotations.Insert;
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

    @Select("select * from resource where name=#{resourceName}")
    Resource findByName(String resourceName);

    @Insert("insert into resource (name, num, image, type, color, unit, size, " +
            "purpose, purchasePrice, salePrice, supplierId, description) " +
            "values (#{name}, #{num}, #{image}, #{type}, #{color}, #{unit}, #{size}, " +
            "#{purpose}, #{purchasePrice}, #{salePrice}, #{supplierId}, #{description})")
    void add(Resource resource);

    @Insert("update resource set name = #{name}, num = #{num}, image = #{image}, type = #{type}, color = #{color}, " +
            "unit = #{unit}, size = #{size}, purpose = #{purpose}, purchasePrice = #{purchasePrice}, " +
            "salePrice = #{salePrice}, supplierId = #{supplierId}, " +
            "description = #{description} where id = #{id}")
    void updateById(Resource resource);

    @Select("select * from resource")
    List<Resource> findAll();
}

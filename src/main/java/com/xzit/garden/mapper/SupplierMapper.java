package com.xzit.garden.mapper;

import com.xzit.garden.bean.entity.Supplier;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SupplierMapper {
    @Select("select * from supplier")
    List<Supplier> findAll();
}

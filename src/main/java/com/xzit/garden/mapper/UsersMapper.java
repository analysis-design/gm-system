package com.xzit.garden.mapper;

import com.xzit.garden.bean.entity.Users;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UsersMapper {
    @Select("select * from users where id=#{id}")
    Users findByid(String id);
}

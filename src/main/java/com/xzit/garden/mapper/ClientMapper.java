package com.xzit.garden.mapper;

import com.xzit.garden.bean.entity.Client;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ClientMapper {

    @Insert("insert into client(name,company,address,phone,creditRating,comment,description) " +
            "values(#{name},#{company},#{address},#{phone},#{creditRating},#{comment},#{description})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    Integer insert(Client client);

    @Delete("delete from client where id=#{id}")
    Integer delete(@Param("id") Long id);

    @Update("update client set name=#{name},company=#{company},address=#{address},phone=#{phone}," +
            "creditRating=#{creditRating},comment=#{comment},description=#{description} where id=#{id}")
    Integer update(Client client);

    @Select("select * from client")
    List<Client> findAll();

    @Select("select * from client where id=#{id}")
    Client findById(@Param("id") Long id);
}

package com.xzit.garden.mapperAndSqlprovider2;

import com.xzit.garden.bean.entity.*;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

public interface ResourceMapper {
    @Delete({
        "delete from resource",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into resource (id, name, ",
        "num, image, type, ",
        "color, unit, size, ",
        "purpose, purchasePrice, ",
        "salePrice, supplierId, ",
        "description)",
        "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
        "#{num,jdbcType=INTEGER}, #{image,jdbcType=VARCHAR}, #{type,jdbcType=INTEGER}, ",
        "#{color,jdbcType=VARCHAR}, #{unit,jdbcType=VARCHAR}, #{size,jdbcType=INTEGER}, ",
        "#{purpose,jdbcType=VARCHAR}, #{purchaseprice,jdbcType=INTEGER}, ",
        "#{saleprice,jdbcType=INTEGER}, #{supplierid,jdbcType=INTEGER}, ",
        "#{description,jdbcType=VARCHAR})"
    })
    int insert(Resource record);

    @InsertProvider(type=ResourceSqlProvider.class, method="insertSelective")
    int insertSelective(Resource record);

    @Select({
        "select",
        "id, name, num, image, type, color, unit, size, purpose, purchasePrice, salePrice, ",
        "supplierId, description",
        "from resource",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType= JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType= JdbcType.VARCHAR),
        @Result(column="num", property="num", jdbcType= JdbcType.INTEGER),
        @Result(column="image", property="image", jdbcType= JdbcType.VARCHAR),
        @Result(column="type", property="type", jdbcType= JdbcType.INTEGER),
        @Result(column="color", property="color", jdbcType= JdbcType.VARCHAR),
        @Result(column="unit", property="unit", jdbcType= JdbcType.VARCHAR),
        @Result(column="size", property="size", jdbcType= JdbcType.INTEGER),
        @Result(column="purpose", property="purpose", jdbcType= JdbcType.VARCHAR),
        @Result(column="purchasePrice", property="purchaseprice", jdbcType= JdbcType.INTEGER),
        @Result(column="salePrice", property="saleprice", jdbcType= JdbcType.INTEGER),
        @Result(column="supplierId", property="supplierid", jdbcType= JdbcType.INTEGER),
        @Result(column="description", property="description", jdbcType= JdbcType.VARCHAR)
    })
    Resource selectByPrimaryKey(Integer id);

    @UpdateProvider(type=ResourceSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Resource record);

    @Update({
        "update resource",
        "set name = #{name,jdbcType=VARCHAR},",
          "num = #{num,jdbcType=INTEGER},",
          "image = #{image,jdbcType=VARCHAR},",
          "type = #{type,jdbcType=INTEGER},",
          "color = #{color,jdbcType=VARCHAR},",
          "unit = #{unit,jdbcType=VARCHAR},",
          "size = #{size,jdbcType=INTEGER},",
          "purpose = #{purpose,jdbcType=VARCHAR},",
          "purchasePrice = #{purchaseprice,jdbcType=INTEGER},",
          "salePrice = #{saleprice,jdbcType=INTEGER},",
          "supplierId = #{supplierid,jdbcType=INTEGER},",
          "description = #{description,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Resource record);
}
package com.xzit.garden.mapperAndSqlprovider2;

import com.xzit.garden.bean.entity.*;

import static org.apache.ibatis.jdbc.SqlBuilder.*;

public class ResourceSqlProvider {

    public String insertSelective(Resource record) {
        BEGIN();
        INSERT_INTO("resource");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getName() != null) {
            VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getNum() != null) {
            VALUES("num", "#{num,jdbcType=INTEGER}");
        }
        
        if (record.getImage() != null) {
            VALUES("image", "#{image,jdbcType=VARCHAR}");
        }
        
        if (record.getType() != null) {
            VALUES("type", "#{type,jdbcType=INTEGER}");
        }
        
        if (record.getColor() != null) {
            VALUES("color", "#{color,jdbcType=VARCHAR}");
        }
        
        if (record.getUnit() != null) {
            VALUES("unit", "#{unit,jdbcType=VARCHAR}");
        }
        
        if (record.getSize() != null) {
            VALUES("size", "#{size,jdbcType=INTEGER}");
        }
        
        if (record.getPurpose() != null) {
            VALUES("purpose", "#{purpose,jdbcType=VARCHAR}");
        }
        
        if (record.getPurchaseprice() != null) {
            VALUES("purchasePrice", "#{purchaseprice,jdbcType=INTEGER}");
        }
        
        if (record.getSaleprice() != null) {
            VALUES("salePrice", "#{saleprice,jdbcType=INTEGER}");
        }
        
        if (record.getSupplierid() != null) {
            VALUES("supplierId", "#{supplierid,jdbcType=INTEGER}");
        }
        
        if (record.getDescription() != null) {
            VALUES("description", "#{description,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(Resource record) {
        BEGIN();
        UPDATE("resource");
        
        if (record.getName() != null) {
            SET("name = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getNum() != null) {
            SET("num = #{num,jdbcType=INTEGER}");
        }
        
        if (record.getImage() != null) {
            SET("image = #{image,jdbcType=VARCHAR}");
        }
        
        if (record.getType() != null) {
            SET("type = #{type,jdbcType=INTEGER}");
        }
        
        if (record.getColor() != null) {
            SET("color = #{color,jdbcType=VARCHAR}");
        }
        
        if (record.getUnit() != null) {
            SET("unit = #{unit,jdbcType=VARCHAR}");
        }
        
        if (record.getSize() != null) {
            SET("size = #{size,jdbcType=INTEGER}");
        }
        
        if (record.getPurpose() != null) {
            SET("purpose = #{purpose,jdbcType=VARCHAR}");
        }
        
        if (record.getPurchaseprice() != null) {
            SET("purchasePrice = #{purchaseprice,jdbcType=INTEGER}");
        }
        
        if (record.getSaleprice() != null) {
            SET("salePrice = #{saleprice,jdbcType=INTEGER}");
        }
        
        if (record.getSupplierid() != null) {
            SET("supplierId = #{supplierid,jdbcType=INTEGER}");
        }
        
        if (record.getDescription() != null) {
            SET("description = #{description,jdbcType=VARCHAR}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }
}
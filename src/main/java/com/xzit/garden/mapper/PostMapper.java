package com.xzit.garden.mapper;

import com.xzit.garden.bean.entity.Post;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PostMapper {

    @Select("select * from post where id=#{postId}")
    Post findById(Long postId);

    @Select("select * from post")
    List<Post> findAll();

}

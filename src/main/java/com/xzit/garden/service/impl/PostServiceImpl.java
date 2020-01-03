package com.xzit.garden.service.impl;

import com.xzit.garden.bean.entity.Post;
import com.xzit.garden.mapper.PostMapper;
import com.xzit.garden.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostMapper postMapper;

    @Override
    public List<Post> findAll() {
        List<Post> postList = postMapper.findAll();
        if (postList == null) postList = new ArrayList<>();
        return postList;
    }
}

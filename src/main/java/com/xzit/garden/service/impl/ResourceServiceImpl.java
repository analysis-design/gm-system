package com.xzit.garden.service.impl;

import com.xzit.garden.bean.entity.Resource;
import com.xzit.garden.bean.model.PageModel;
import com.xzit.garden.mapper.ResourceMapper;
import com.xzit.garden.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    private ResourceMapper resourceMapper;

    @Override
    public List<Resource> findAllPage(PageModel<List<Resource>> pageModel) {
        int page = pageModel.getPage() - 1;
        List<Resource> resourceList = resourceMapper.
                findPage(page * pageModel.getLimit(), pageModel.getLimit());
        int count = resourceMapper.countResource();
        pageModel.setCount(count);

        if (resourceList == null) resourceList = new ArrayList<>();
        return resourceList;
    }
}

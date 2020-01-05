package com.xzit.garden.service;

import com.xzit.garden.bean.entity.Resource;
import com.xzit.garden.bean.model.PageModel;

import java.util.List;

public interface ResourceService {
    List<Resource> findAllPage(PageModel<List<Resource>> pageModel);
}

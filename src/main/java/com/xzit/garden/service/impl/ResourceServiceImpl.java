package com.xzit.garden.service.impl;

import com.xzit.garden.bean.entity.Resource;
import com.xzit.garden.bean.model.PageModel;
import com.xzit.garden.exception.ObjectAlreadyExistException;
import com.xzit.garden.exception.ObjectNotFoundException;
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

    @Override
    public Resource getById(Long resId) {
        Resource resource = resourceMapper.findById(resId);
        if (resource == null)
            throw new ObjectNotFoundException("物资编号" + resId + "不存在");
        return resource;
    }

    @Override
    public void addResource(Resource resource) {
        Integer supplierId = resource.getSupplierId();
        validateExistSupplier(supplierId);

        Resource temp = resourceMapper.findByName(resource.getName());
        if (temp != null)
            throw new ObjectAlreadyExistException("物资名称" + resource.getName() + "已存在");

        resourceMapper.add(resource);
    }

    private void validateExistSupplier(Integer supplierId) {
        if (supplierId == null)
            throw new ObjectNotFoundException("供应商编号不存在");
    }

    @Override
    public void updateById(Resource resource) {
        getById(resource.getId());

        Resource temp2 = resourceMapper.findByName(resource.getName());
        if (temp2 != null && !temp2.getName().equals(resource.getName()))
            throw new ObjectAlreadyExistException("物资名称" + resource.getName() + "已存在");

        validateExistSupplier(resource.getSupplierId());
        resourceMapper.updateById(resource);
    }
}

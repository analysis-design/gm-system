package com.xzit.garden.service.impl;

import com.xzit.garden.bean.entity.Supplier;
import com.xzit.garden.mapper.SupplierMapper;
import com.xzit.garden.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierMapper supplierMapper;

    @Override
    public List<Supplier> findAll() {
        List<Supplier> supplierList = supplierMapper.findAll();
        if (supplierList == null)  supplierList = new ArrayList<>();
        return supplierList;
    }
}

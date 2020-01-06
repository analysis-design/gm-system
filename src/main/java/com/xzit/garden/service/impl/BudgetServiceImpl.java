package com.xzit.garden.service.impl;

import com.xzit.garden.bean.entity.Budget;
import com.xzit.garden.mapper.BudgetMapper;
import com.xzit.garden.service.BudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Xsk on 2020/1/2.
 */
@Service
public class BudgetServiceImpl implements BudgetService {
    @Autowired
    BudgetMapper budgetMapper;
    @Override
    public Budget findById(Long id) {
        return budgetMapper.findById(id);
    }

    @Override
    public List<Budget> findAll() {
        return budgetMapper.findAll();
    }

    @Override
    public Budget findByProjectId(Long id) {
        Budget byProjectId = budgetMapper.findByProjectId(id);
        if (byProjectId==null)
            throw new RuntimeException("该工程暂无预算");
        return byProjectId;
    }
}

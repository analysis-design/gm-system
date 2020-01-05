package com.xzit.garden.service;

import com.xzit.garden.bean.entity.Budget;

import java.util.List;

/**
 * Created by Xsk on 2020/1/2.
 */
public interface BudgetService {

    Budget findById(Long id);

    List<Budget> findAll();

    Budget findByProjectId(Long id);
}

package com.xzit.garden.service.impl;

import com.xzit.garden.bean.dto.OrderDto;
import com.xzit.garden.bean.entity.Order;
import com.xzit.garden.bean.entity.Project;
import com.xzit.garden.mapper.OrderMapper;
import com.xzit.garden.mapper.ProjectMapper;
import com.xzit.garden.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Xsk on 2020/1/2.
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderMapper orderMapper;

    @Autowired
    ProjectMapper projectMapper;

    /**
     * 增加订单先判断是否存在与订单相关的工程
     *
     * @param order
     * @return
     */
    @Override
    public Integer addOrder(Order order) {
        Project project = projectMapper.findById(order.getProjectId());
        if (project == null)
            throw new RuntimeException("与订单相关的工程不存在");
        if (order.getBudgetTotal()==0||order.getBudgetId()==0)
            throw new RuntimeException("预算不存在，不能添加！");
        if (order.getPrepaid()>order.getBudgetTotal()||order.getPrepaid()>order.getPaymentTotal())
            throw new RuntimeException("定金不能大于总额！");
        return orderMapper.insert(order);
    }

    /**
     * 删除订单逻辑
     * 已付定金的订单不能删除
     * 工程未结束的订单不能删除
     *
     * @param id
     * @return
     */
    @Override
    public Integer deleteOrder(Long id) {
        if (orderMapper.findById(id).getPayState() == 1)
            throw new RuntimeException("已付定金，不能删除");
        if (projectMapper.findById(orderMapper.findById(id).getProjectId()).getActualEndTime() == null)
            throw new RuntimeException("工程未结束，不能删除");
        return orderMapper.delete(id);
    }

    /**
     * 修改订单也要判断与订单的相关工程是否存在
     * 订单结束时间要大于等于工程结束时间
     *
     * @param order
     * @return
     */
    @Override
    public Integer updateOrder(Order order) {
        Project project = projectMapper.findById(order.getProjectId());
        if (project == null)
            throw new RuntimeException("与订单相关的工程不存在");
        if (order.getEndTime() != null && projectMapper.findById(order.getProjectId()).getActualEndTime() == null)
            throw new RuntimeException("工程未结束，订单无法完成");
        if (order.getBudgetTotal()==0||order.getBudgetId()==0)
            throw new RuntimeException("预算不存在，不能修改！");
        if (order.getPrepaid()>order.getBudgetTotal()||order.getPrepaid()>order.getPaymentTotal())
            throw new RuntimeException("定金不能大于总额！");
        return orderMapper.update(order);
    }

    @Override
    public List<Order> findAllOrder() {
        return orderMapper.findAll();
    }

    @Override
    public Order findById(Long id) {
        return orderMapper.findById(id);
    }

    @Override
    public List<Order> findByProjectName(String name) {
        System.out.println(name);
        if (name == null || name == "" || name.equals(""))
            return findAllOrder();
        return orderMapper.findByProjectName(name);
    }

    /**
     * OrderList转为OrderDtoList
     *
     * @param orderList
     * @return
     */
    @Override
    public List<OrderDto> getOrderDtoList(List<Order> orderList) {
        List<OrderDto> orderDtoList = new ArrayList<>();
        for (Order order : orderList) {
            OrderDto orderDto = new OrderDto(order);
            Project project = projectMapper.findById(order.getProjectId());
            if (project != null)
                orderDto.setProjectName(project.getName());
            orderDtoList.add(orderDto);
        }
        return orderDtoList;
    }

    /**
     * Order转换为OrderDto
     *
     * @param order
     * @return
     */
    @Override
    public OrderDto getOrderDto(Order order) {
        OrderDto orderDto = new OrderDto(order);
        Project project = projectMapper.findById(order.getProjectId());
        if (project != null)
            orderDto.setProjectName(project.getName());
        return orderDto;
    }
}

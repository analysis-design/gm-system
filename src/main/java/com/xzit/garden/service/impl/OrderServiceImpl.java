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
        else
            return orderMapper.insert(order);
    }

    @Override
    public Integer deleteOrder(Long id) {
        return orderMapper.delete(id);
    }

    /**
     * 修改订单也要判断与订单的相关工程是否存在
     * @param order
     * @return
     */
    @Override
    public Integer updateOrder(Order order) {
        Project project = projectMapper.findById(order.getProjectId());
        if (project == null)
            throw new RuntimeException("与订单相关的工程不存在");
        else
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
        if (name==null||name==""||name.equals(""))
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

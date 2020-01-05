package com.xzit.garden.service;

import com.sun.org.apache.xpath.internal.operations.Or;
import com.xzit.garden.bean.dto.OrderDto;
import com.xzit.garden.bean.entity.Order;

import java.util.List;

/**
 * Created by Xsk on 2020/1/2.
 */
public interface OrderService {

    Integer addOrder(Order order);

    Integer deleteOrder(Long id);

    Integer updateOrder(Order order);

    List<Order> findAllOrder();

    Order findById(Long id);

    List<Order> findByProjectName(String name);

    List<OrderDto> getOrderDtoList(List<Order> orderList);

    OrderDto getOrderDto(Order order);
}

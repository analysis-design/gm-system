package com.xzit.garden.controller;

import com.xzit.garden.bean.dto.LayuiDataDto;
import com.xzit.garden.bean.dto.OrderDto;
import com.xzit.garden.bean.dto.ProjectDto;
import com.xzit.garden.bean.entity.Client;
import com.xzit.garden.bean.entity.Order;
import com.xzit.garden.bean.entity.Project;
import com.xzit.garden.bean.entity.Staff;
import com.xzit.garden.service.OrderService;
import com.xzit.garden.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderService;
    @Autowired
    ProjectService projectService;

    @RequestMapping("/index")
    public String order(){
        return "order";
    }

    @RequestMapping("")
    @ResponseBody
    public LayuiDataDto<OrderDto> orderList(OrderDto order,
                                            @RequestParam(required = false,defaultValue = "1",value = "page")Integer page,
                                            @RequestParam(required = false,defaultValue = "10",value = "limit")Integer limit){
        List<OrderDto> orderDtos = new ArrayList<>();
        List<Order> orders = orderService.findByProjectName(order.getProjectName());
        //分页
        for (int i = page * limit - limit; i < page * limit && i < orders.size(); i++) {
            OrderDto orderDto = orderService.getOrderDto(orders.get(i));
            orderDtos.add(orderDto);
        }

        LayuiDataDto<OrderDto> layuiDataDto = new LayuiDataDto<>();
        layuiDataDto.setCode(0);
        layuiDataDto.setCount(orders.size());
        layuiDataDto.setData(orderDtos);
        layuiDataDto.setMsg("订单列表查询结果");
        return layuiDataDto;
    }

    @RequestMapping("/edit")
    public String editOrder(Model model, @RequestParam(required = false,defaultValue = "0",value = "id")Long id,
                            @RequestParam(required = false,defaultValue = "0",value = "isDisabled")Integer isDisabled){
        if (id==0){//添加
            List<Project> projectList = projectService.findAllProject();
            model.addAttribute("projectList",projectList);
            model.addAttribute("url","/order/add");
            return "order_edit";
        }
        if (isDisabled==1){//查看
            Order order = orderService.findById(id);
            OrderDto orderDto = orderService.getOrderDto(order);
            model.addAttribute("order",orderDto);
            model.addAttribute("disabled",1);
            return "order_edit";
        }
        //编辑
        Order order = orderService.findById(id);
        OrderDto orderDto = orderService.getOrderDto(order);
        List<Project> projectList = projectService.findAllProject();
        model.addAttribute("projectList",projectList);
        model.addAttribute("order",orderDto);
        model.addAttribute("url","/order/update");
        return "order_edit";
    }

    @RequestMapping(path = "/add",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Map<String,String> addInsOrder(@RequestBody Order order){
        order.setCreateTime(new Date());
        orderService.addOrder(order);
        Map<String,String> map = new HashMap<>();
        map.put("msg","增加成功");
        return map;
    }

    @RequestMapping(path = "/update",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Map<String,String> addUpdOrder(@RequestBody Order order){
        System.out.println(order.getId());
        System.out.println(order.getDiscount());
        orderService.updateOrder(order);
        Map<String,String> map = new HashMap<>();
        map.put("msg","修改成功");
        return map;
    }

    @RequestMapping(path = "/del", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> delOrder(@RequestParam(required = false, defaultValue = "") Long id) {
        Integer delete = orderService.deleteOrder(id);
        Map<String,Object> map = new HashMap<>();
        map.put("code",0);
        map.put("msg","删除成功");
        return map;
    }

    @RequestMapping(path = "/end",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Map<String,String> endOrder(@RequestBody Order order){
        System.out.println(order.getId());
        System.out.println(order.getDiscount());
        order.setEndTime(new Date());
        orderService.updateOrder(order);
        Map<String,String> map = new HashMap<>();
        map.put("msg","修改成功");
        return map;
    }
}

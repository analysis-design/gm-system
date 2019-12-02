package com.xzit.garden.controller;

import com.xzit.garden.bean.dto.HelloDto;
import com.xzit.garden.bean.entity.HelloEntity;
import com.xzit.garden.bean.model.HelloModel;
import com.xzit.garden.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private HelloService helloService;

    @RequestMapping("/get")
    public String getById(@RequestParam("id") Long id, Model model) {
        HelloDto dto = helloService.getHelloById(id);

        model.addAttribute("msg", dto.getMsg());
        return "forward:/hello/list";
    }

    @RequestMapping("/list")
    public String list(Model model) {
        List<HelloEntity> entityList = helloService.getAll();

        model.addAttribute("list", entityList);
        return "hello";
    }

    @RequestMapping("/add")
    public String add(HelloEntity entity, Model model) {
        helloService.add(entity);
        model.addAttribute("msg", "添加成功");
        return "forward:/hello/list";
    }

    @RequestMapping("/upd")
    public String update(HelloEntity entity, Model model) {
        helloService.update(entity);
        model.addAttribute("msg", "更新成功");
        return "forward:/hello/list";
    }

    @RequestMapping("/del")
    public String delete(@RequestParam("id") Long id, Model model) {
        helloService.delete(id);
        model.addAttribute("msg", "删除成功");
        return "forward:/hello/list";
    }
}

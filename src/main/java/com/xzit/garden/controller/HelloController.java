package com.xzit.garden.controller;

import com.xzit.garden.bean.dto.HelloDto;
import com.xzit.garden.bean.model.HelloModel;
import com.xzit.garden.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class HelloController {

    @Autowired
    private HelloService helloService;

    @RequestMapping("/hello")
    public String hello(@Valid @RequestBody HelloModel helloModel, Model model) {
        model.addAttribute("msg", "你好！访问成功");

        HelloDto dto = helloService.getDto();
        model.addAttribute("hello", dto);
        return "hello";
    }
}

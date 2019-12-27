package com.xzit.garden.controller;

import com.xzit.garden.bean.dto.UserDto;
import com.xzit.garden.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    /**
     * @return 登录页面
     */
    @GetMapping("/auth/form")
    public String loginPage() {
        return "login";
    }

    /**
     * 首页
     * @param model 传入数据的域对象
     * @return 首页
     */
    @GetMapping("/index")
    public String index(Model model) {
        UserDto user = userService.getUserDto();
        model.addAttribute("user", user);
        return "engineer";
    }
}

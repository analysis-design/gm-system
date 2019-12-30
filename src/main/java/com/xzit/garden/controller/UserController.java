package com.xzit.garden.controller;

import com.xzit.garden.bean.dto.UserDto;
import com.xzit.garden.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/detail")
    public String details(Model model) {
        UserDto user = userService.getUserDto();
        model.addAttribute("user", user);
        return "details";
    }
}
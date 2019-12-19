package com.xzit.garden.controller;

import com.xzit.garden.bean.entity.Users;
import com.xzit.garden.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
    @Autowired
    UsersService usersService;

    @RequestMapping("/login")
    public String login(Model model){
        return "login";
    }

    @RequestMapping("/main")
    public String main(String id,String password,Model model){
        Users users = usersService.findByUserId(id);
        if (users == null){
            model.addAttribute("message","用户名或密码错误，登录失败！");
            return "login";
        }
        if(!password.equals(users.getPassword())){
            model.addAttribute("message","用户名或密码错误，登录失败！");
            return "login";
        }
        switch (users.getRole()){
            case 1:
                model.addAttribute("id",users.getId());
                model.addAttribute("name",users.getName());
                return "administrator";
            case 2:
                model.addAttribute("id",users.getId());
                model.addAttribute("name",users.getName());
                return "sale";
            case 3:
                model.addAttribute("id",users.getId());
                model.addAttribute("name",users.getName());
                return "maintain";
            case 4:
                model.addAttribute("id",users.getId());
                model.addAttribute("name",users.getName());
                return "engineer";
            case 5:
                model.addAttribute("id",users.getId());
                model.addAttribute("name",users.getName());
                return "purchaser";
            default:return "login";
        }
    }
    @RequestMapping("/personalInfo")
    public String personalInfo(String id,Model model){
        Users users = usersService.findByUserId(id);
        model.addAttribute("info",users);
        return "personalInfo";
    }


}

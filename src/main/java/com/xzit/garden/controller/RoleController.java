package com.xzit.garden.controller;

import com.xzit.garden.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    /**
     * 访问角色页面
     *
     * @param model
     * @return
     */
    @RequestMapping("/index")
    public String index(Model model) {

        return "role";
    }
}

package com.xzit.garden.controller;

import com.xzit.garden.bean.dto.AuthorityDto;
import com.xzit.garden.bean.dto.UserDto;
import com.xzit.garden.bean.entity.Authority;
import com.xzit.garden.bean.entity.Role;
import com.xzit.garden.service.AuthorityService;
import com.xzit.garden.service.RoleService;
import com.xzit.garden.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthorityService authorityService;

    @Autowired
    private RoleService roleService;

    /**
     * @return 登录页面
     */
    @GetMapping("/auth/form")
    public String loginPage() {
        return "login";
    }

    /**
     * 首页
     *
     * @param model 传入数据的域对象
     * @return 首页
     */
    @GetMapping("/index")
    public String index(Model model) {
        UserDto user = userService.getUserDto();
        model.addAttribute("user", user);
        return "engineer";
    }

    /**
     * 首先获取员工、显示员工列表
     *
     * @return 访问权限验证的首页
     */
    @GetMapping("/auth/index")
    public String authIndex(Model model) {
        List<UserDto> users = userService.getUserList();
        AuthorityDto root = authorityService.getAllAuthority();
        List<Role> roleList = roleService.getAllRole();

        model.addAttribute("userList", users);
        model.addAttribute("roleList", roleList);
        model.addAttribute("authorityTree", root);
        return "authority";
    }

    @PostMapping("/auth/add")
    @ResponseBody
    public Map<String, Object> authAdd(@RequestBody Authority authority) {
        authorityService.add(authority);
        Map<String, Object> rs = new HashMap<>();
        rs.put("code", 0);
        rs.put("msg", "添加成功");
        rs.put("data", authority);
        return rs;
    }

    @RequestMapping("/auth/del")
    @ResponseBody
    public Map<String, Object> authDelete(@RequestParam("id") Long authId) {
        Authority authority = authorityService.deleteById(authId);
        Map<String, Object> rs = new HashMap<>();
        rs.put("code", 0);
        rs.put("msg", "删除成功");
        rs.put("data", authority);
        return rs;
    }

    @PostMapping("/auth/upd")
    @ResponseBody
    public Map<String, Object> authUpdate(@RequestBody Authority authority) {
        authorityService.updateById(authority);
        Map<String, Object> rs = new HashMap<>();
        rs.put("code", 0);
        rs.put("msg", "修改成功成功");
        rs.put("data", authority);
        return rs;
    }
}

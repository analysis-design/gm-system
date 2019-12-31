package com.xzit.garden.controller;

import com.xzit.garden.bean.dto.UserDto;
import com.xzit.garden.bean.model.AuthModel;
import com.xzit.garden.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

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

    @PostMapping("/role/add")
    @ResponseBody
    public Map<String, Object> authAllocate(@RequestBody AuthModel authModel) {
        userService.addAuthority(authModel);
        Map<String, Object> rs = new HashMap<>();

        rs.put("code", 0);
        rs.put("msg", "添加成功");
        rs.put("data", authModel);
        return rs;
    }

    @PostMapping("/role/upd")
    @ResponseBody
    public Map<String, Object> authAllocationUpdate(@RequestBody AuthModel authModel) {
        userService.updAuthority(authModel);
        Map<String, Object> rs = new HashMap<>();

        rs.put("code", 0);
        rs.put("msg", "修改完成");
        rs.put("data", authModel);
        return rs;
    }

    @GetMapping("/role/list")
    @ResponseBody
    public Map<String, Object> authAllocationList(@RequestParam("userId") Long userId) {
        AuthModel authModelList = userService.getUserAuthByUserId(userId);
        Map<String, Object> rs = new HashMap<>();

        rs.put("code", 0);
        rs.put("msg", "查询完成");
        rs.put("data", authModelList);
        return rs;
    }
}
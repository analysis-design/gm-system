package com.xzit.garden.controller;

import com.xzit.garden.bean.entity.Role;
import com.xzit.garden.bean.model.RoleModel;
import com.xzit.garden.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    /**
     * 访问角色页面
     *
     * @return 角色页面
     */
    @RequestMapping("/add/index")
    public String index() {
        return "role_add";
    }

    @PostMapping("/add")
    @ResponseBody
    public Map<String, Object> roleAdd(@RequestBody RoleModel role) {
        roleService.roleAdd(role);
        Map<String, Object> rs = new HashMap<>();

        rs.put("code", 0);
        rs.put("msg", "添加成功");
        rs.put("data", role);
        return rs;
    }

    @PostMapping("/update")
    @ResponseBody
    public Map<String, Object> roleUpd(@RequestBody RoleModel role) {
        roleService.roleUpd(role);
        Map<String, Object> rs = new HashMap<>();

        rs.put("code", 0);
        rs.put("msg", "修改成功");
        rs.put("data", role);
        return rs;
    }

    @RequestMapping("/del")
    @ResponseBody
    public Map<String, Object> roleUpd(@RequestParam Long roleId) {
        Role role = roleService.roleDelete(roleId);
        Map<String, Object> rs = new HashMap<>();

        rs.put("code", 0);
        rs.put("msg", "删除成功");
        rs.put("data", role);
        return rs;
    }

    @GetMapping("/details")
    @ResponseBody
    public Map<String, Object> roleDetails(@RequestParam Long roleId) {
        Role role = roleService.getRoleById(roleId);
        Map<String, Object> rs = new HashMap<>();

        rs.put("code", 0);
        rs.put("msg", "查询完成");
        rs.put("data", role);
        return rs;
    }

    @PostMapping("/alloc/add")
    @ResponseBody
    public Map<String, Object> roleAllocAdd(@RequestBody RoleModel role) {
        roleService.roleAllocAdd(role);
        Map<String, Object> rs = new HashMap<>();

        rs.put("code", 0);
        rs.put("msg", "添加成功");
        rs.put("data", role);
        return rs;
    }

    @PostMapping("/alloc/upd")
    @ResponseBody
    public Map<String, Object> roleAllocUpd(@RequestBody RoleModel role) {
        roleService.roleAllocUpd(role);
        Map<String, Object> rs = new HashMap<>();

        rs.put("code", 0);
        rs.put("msg", "权限分配成功");
        rs.put("data", role);
        return rs;
    }

    @GetMapping("/list")
    @ResponseBody
    public Map<String, Object> roleList() {
        List<Role> roleList = roleService.getAllRole();
        Map<String, Object> rs = new HashMap<>();

        rs.put("code", 0);
        rs.put("msg", "查询完成");
        rs.put("count", roleList.size());
        rs.put("data", roleList);
        return rs;
    }

    @GetMapping("/alloc/list")
    @ResponseBody
    public Map<String, Object> roleAllocList(@RequestParam Long roleId) {
        RoleModel roleList = roleService.roleAllocList(roleId);
        Map<String, Object> rs = new HashMap<>();

        rs.put("code", 0);
        rs.put("msg", "查询完成");
        rs.put("data", roleList);
        return rs;
    }
}

package com.xzit.garden.controller;

import com.alibaba.fastjson.JSON;
import com.xzit.garden.bean.dto.AuthorityDto;
import com.xzit.garden.bean.dto.UserDto;
import com.xzit.garden.bean.entity.Authority;
import com.xzit.garden.bean.entity.Role;
import com.xzit.garden.bean.model.PageModel;
import com.xzit.garden.service.AuthorityService;
import com.xzit.garden.service.RoleService;
import com.xzit.garden.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
        return "index";
    }

    /**
     * 首先获取员工、显示员工列表
     *
     * @return 访问权限验证的首页
     */
    @GetMapping("/auth/index")
    public String authIndex(Model model) {
        List<UserDto> users = userService.getUserList();
        AuthorityDto root = authorityService.getAllAuthorityTree();
        List<Role> roleList = roleService.getAllRole();

        model.addAttribute("userList", users);
        model.addAttribute("roleList", roleList);
        model.addAttribute("authorityTree", root);
        return "authority";
    }

    /**
     * 添加权限首页
     *
     * @param model 传入数据的域对象
     * @return 首页
     */
    @GetMapping("/auth/add/index")
    public String addIndex(Model model) {
        UserDto user = userService.getUserDto();
        PageModel<List<Authority>> pageModel = new PageModel<>();
        pageModel.setPage(1);
        pageModel.setLimit(65536);

        List<Authority> authorityList = authorityService.getAllAuthorityList(pageModel);

        model.addAttribute("user", user);
        model.addAttribute("msg", "添加权限");
        model.addAttribute("authList", authorityList);
        model.addAttribute("url", "/auth/add");
        return "authority_edit";
    }

    /**
     * 更新权限首页
     *
     * @param model 传入数据的域对象
     * @return 首页
     */
    @GetMapping("/auth/upd/index")
    public String updIndex(@RequestParam("authId") Long authId, Model model) {
        PageModel<List<Authority>> pageModel = new PageModel<>();
        pageModel.setPage(1);
        pageModel.setLimit(65536);

        UserDto user = userService.getUserDto();
        List<Authority> authorityList = authorityService.getAllAuthorityList(pageModel);
        Authority authority = authorityService.getById(authId);

        if (authority.getParentId() != null)
            authorityList.remove(authority);
        model.addAttribute("user", user);
        model.addAttribute("msg", "编辑权限");
        model.addAttribute("updAuthority", authority);
        model.addAttribute("authList", authorityList);
        model.addAttribute("url", "/auth/upd");
        return "authority_edit";
    }

    @GetMapping("/auth/tree/index")
    public String treeIndex(Model model) {

        model.addAttribute("data", JSON.toJSON(authTree()));
        return "authority_tree";
    }

    @GetMapping("/auth/tree")
    @ResponseBody
    public Map<String, Object> authTree() {
        AuthorityDto root = authorityService.getAllAuthorityTree();
        List<Role> roleList = roleService.getAllRole();

        Map<String, Object> rs = new HashMap<>();
        rs.put("code", 0);
        rs.put("msg", "查询完成");
        rs.put("data", root);
        rs.put("role", roleList);
        return rs;
    }

    @GetMapping("/auth/list")
    @ResponseBody
    public Map<String, Object> authList(PageModel<List<Authority>> page) {
        List<Authority> authorityList = authorityService.getAllAuthorityList(page);
        Map<String, Object> data = new HashMap<>();
        data.put("code", 0);
        data.put("msg", "查询完成");
        data.put("count", page.getCount());
        data.put("data", authorityList);
        return data;
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
    public Map<String, Object> authDelete(@RequestParam("authId") Long authId) {
        Authority authority = authorityService.deleteById(authId);
        Map<String, Object> rs = new HashMap<>();
        rs.put("code", 0);
        rs.put("msg", "删除成功");
        rs.put("data", authority);
        return rs;
    }

    @PostMapping("/auth/del/list")
    @ResponseBody
    public Map<String, Object> authDeleteAll(@RequestBody List<Long> authList) {
        List<Authority> authorityList = authorityService.deleteAllById(authList);
        Map<String, Object> rs = new HashMap<>();
        rs.put("code", 0);
        rs.put("msg", "删除成功");
        rs.put("data", authorityList);
        return rs;
    }

    @PostMapping("/auth/upd")
    @ResponseBody
    public Map<String, Object> authUpdate(@RequestBody Authority authority) {
        authorityService.updateById(authority);
        Map<String, Object> rs = new HashMap<>();
        rs.put("code", 0);
        rs.put("msg", "修改成功");
        rs.put("data", authority);
        return rs;
    }
}

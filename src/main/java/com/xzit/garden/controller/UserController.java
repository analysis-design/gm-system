package com.xzit.garden.controller;

import com.xzit.garden.bean.dto.UserDto;
import com.xzit.garden.bean.entity.Role;
import com.xzit.garden.bean.entity.Staff;
import com.xzit.garden.bean.entity.User;
import com.xzit.garden.bean.model.AuthModel;
import com.xzit.garden.bean.model.PageModel;
import com.xzit.garden.service.RoleService;
import com.xzit.garden.service.StaffService;
import com.xzit.garden.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private StaffService staffService;

    @Autowired
    private RoleService roleService;

    /**
     * @return 用户管理的首页
     */
    @GetMapping("/index")
    public String index() {
        return "user";
    }
    /**
     * 添加用户首页
     *
     * @param model 传入数据的域对象
     * @return 首页
     */
    @GetMapping("/add/index")
    public String addIndex(Model model) {
        List<Staff> staffList = staffService.getAllStaff();
        List<Role> roleList = roleService.getAllRole();

        model.addAttribute("roleList", roleList);
        model.addAttribute("staffList", staffList);
        model.addAttribute("msg", "添加用户");
        model.addAttribute("flag", 0);
        model.addAttribute("url", "/user/add");
        return "user_edit";
    }

    /**
     * 更新用户首页
     *
     * @param model 传入数据的域对象
     * @return 首页
     */
    @GetMapping("/upd/index")
    public String updIndex(@RequestParam("userId") Long userId, Model model) {
        UserDto user = userService.getUserByUserId(userId);
        List<Staff> staffList = staffService.getAllStaff();
        List<Role> roleList = roleService.getAllRole();

        model.addAttribute("roleList", roleList);
        model.addAttribute("staffList", staffList);
        model.addAttribute("user", user);
        model.addAttribute("userRoleList", user.getRoleIdList());
        model.addAttribute("msg", "编辑用户");
        model.addAttribute("flag", 1);
        model.addAttribute("url", "/user/upd");
        return "user_edit";
    }

    /**
     * 添加用户信息
     *
     * @param userDto 添加的用户信息
     * @return 添加的结果
     */
    @PostMapping("/add")
    @ResponseBody
    public Map<String, Object> userAdd(@RequestBody UserDto userDto) {
        userService.addUser(userDto);
        Map<String, Object> rs = new HashMap<>();
        rs.put("code", 0);
        rs.put("msg", "添加成功");
        rs.put("data", userDto);
        return rs;
    }

    @RequestMapping("/del")
    @ResponseBody
    public Map<String, Object> userDelete(@RequestParam("userId") Long userId) {
        User userDto = userService.deleteById(userId);
        Map<String, Object> rs = new HashMap<>();
        rs.put("code", 0);
        rs.put("msg", "删除成功");
        rs.put("data", userDto);
        return rs;
    }

    @PostMapping("/del/list")
    @ResponseBody
    public Map<String, Object> userDeleteAll(@RequestBody List<Long> userList) {
        List<User> userDtoList = userService.deleteAllById(userList);
        Map<String, Object> rs = new HashMap<>();
        rs.put("code", 0);
        rs.put("msg", "删除成功");
        rs.put("data", userDtoList);
        return rs;
    }

    @PostMapping("/upd")
    @ResponseBody
    public Map<String, Object> userUpdate(@RequestBody UserDto userDto) {
        userService.updateById(userDto);
        Map<String, Object> rs = new HashMap<>();
        rs.put("code", 0);
        rs.put("data", userDto);
        rs.put("msg", "修改成功");
        return rs;
    }

    /**
     * 获取用户列表
     *
     * @param pageModel 分页模型对象
     * @return 查询的用户列表数据
     */
    @GetMapping("/list")
    @ResponseBody
    public Map<String, Object> list(PageModel<List<UserDto>> pageModel) {
        List<UserDto> users = userService.getPageUserList(pageModel);

        Map<String, Object> rs = new HashMap<>();
        pageModel.setData(users);
        rs.put("code", 0);
        rs.put("msg", "查询成功");
        rs.put("data", users);
        rs.put("count", pageModel.getCount());
        return rs;
    }

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
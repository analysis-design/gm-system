package com.xzit.garden.controller;

import com.xzit.garden.bean.dto.GroupDto;
import com.xzit.garden.bean.dto.GroupMemberDto;
import com.xzit.garden.bean.entity.Group;
import com.xzit.garden.bean.entity.GroupMember;
import com.xzit.garden.bean.entity.Post;
import com.xzit.garden.bean.entity.Staff;
import com.xzit.garden.bean.model.PageModel;
import com.xzit.garden.service.GroupService;
import com.xzit.garden.service.PostService;
import com.xzit.garden.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/group")
public class GroupController {

    @Autowired
    private GroupService groupService;

    @Autowired
    private StaffService staffService;

    @Autowired
    private PostService postService;

    /**
     * @return 用户管理的首页
     */
    @GetMapping("/index")
    public String index() {
        return "group";
    }

    /**
     * 获取用户列表
     *
     * @param pageModel 分页模型对象
     * @return 查询的用户列表数据
     */
    @GetMapping("/list")
    @ResponseBody
    public Map<String, Object> list(PageModel<List<GroupDto>> pageModel) {
        List<GroupDto> groupList = groupService.getPageUserList(pageModel);

        Map<String, Object> rs = new HashMap<>();
        pageModel.setData(groupList);
        rs.put("code", 0);
        rs.put("msg", "查询成功");
        rs.put("count", pageModel.getCount());
        rs.put("data", groupList);
        return rs;
    }

    @GetMapping("/add/index")
    public String addIndex(Model model) {
        List<Staff> staffList = staffService.getAllStaff();

        model.addAttribute("staffList", staffList);
        model.addAttribute("msg", "添加工程组");
        model.addAttribute("flag", 0);
        model.addAttribute("url", "/group/add");
        return "group_edit";
    }

    @GetMapping("/upd/index")
    public String updIndex(@RequestParam("groupId") Long groupId, Model model) {
        List<Staff> staffList = staffService.getAllStaff();
        Group group = groupService.getById(groupId);


        model.addAttribute("staffList", staffList);
        model.addAttribute("msg", "编辑工程组");
        model.addAttribute("flag", 1);
        model.addAttribute("group", group);
        model.addAttribute("url", "/group/upd");
        return "group_edit";
    }

    @GetMapping("/alloc/index")
    public String allocationIndex(@RequestParam("groupId") Long groupId, Model model) {

        model.addAttribute("groupId", groupId);
        return "group_allocation";
    }

    /**
     * 获取用户列表
     *
     * @param pageModel 分页模型对象
     * @return 查询的用户列表数据
     */
    @GetMapping("/member/list")
    @ResponseBody
    public Map<String, Object> allocationList(PageModel<List<GroupMemberDto>> pageModel,
                                              @RequestParam("groupId") Long groupId) {
        List<GroupMemberDto> groupMemberList = groupService.getGroupMemberList(pageModel, groupId);

        Map<String, Object> rs = new HashMap<>();
        rs.put("data", groupMemberList);
        pageModel.setData(groupMemberList);
        rs.put("code", 0);
        rs.put("msg", "查询成功");
        rs.put("count", pageModel.getCount());
        return rs;
    }

    /**
     * 添加工程组成员首页
     */
    @GetMapping("/member/add/index")
    public String memberAddIndex(@RequestParam("groupId") Long groupId, Model model) {
        List<Staff> staffList = staffService.getAllStaff();
        List<Post> postList = postService.findAll();

        model.addAttribute("groupId", groupId);
        model.addAttribute("staffList", staffList);
        model.addAttribute("msg", "添加工程组成员");
        model.addAttribute("flag", 0);
        model.addAttribute("postList", postList);
        model.addAttribute("url", "/group/member/add");
        return "member_edit";
    }
    /**
     * 编辑工程组成员首页
     */
    @GetMapping("/member/upd/index")
    public String memberUpdIndex(@RequestParam("groupId") Long groupMemberId, Model model) {
        GroupMember groupMember = groupService.getGroupMemberById(groupMemberId);
        List<Staff> staffList = staffService.getAllStaff();
        List<Post> postList = postService.findAll();


        model.addAttribute("staffList", staffList);
        model.addAttribute("msg", "编辑工程组成员");
        model.addAttribute("flag", 1);
        model.addAttribute("postList", postList);
        model.addAttribute("groupMember", groupMember);
        model.addAttribute("url", "/group/member/upd");
        return "member_edit";
    }

    /**
     * 添加工程组信息
     *
     * @param groupMember 添加的工程组信息
     * @return 添加的结果
     */
    @PostMapping("/member/add")
    @ResponseBody
    public Map<String, Object> groupMemberAdd(@RequestBody GroupMember groupMember) {
        groupService.addGroupMember(groupMember);
        Map<String, Object> rs = new HashMap<>();
        rs.put("code", 0);
        rs.put("msg", "添加成功");
        rs.put("data", groupMember);
        return rs;
    }

    @RequestMapping("/member/del")
    @ResponseBody
    public Map<String, Object> groupMemberDelete(@RequestParam("groupMemberId") Long groupMemberId) {
        GroupMember groupMember = groupService.deleteGroupMemberById(groupMemberId);
        Map<String, Object> rs = new HashMap<>();
        rs.put("code", 0);
        rs.put("msg", "删除成功");
        rs.put("data", groupMember);
        return rs;
    }

    @PostMapping("/member/upd")
    @ResponseBody
    public Map<String, Object> groupMemberUpdate(@RequestBody GroupMember groupMember) {
        groupService.updateGroupMemberById(groupMember);

        Map<String, Object> rs = new HashMap<>();
        rs.put("msg", "修改成功");
        rs.put("code", 0);
        rs.put("data", groupMember);
        return rs;
    }

    /**
     * 添加工程组信息
     *
     * @param group 添加的工程组信息
     * @return 添加的结果
     */
    @PostMapping("/add")
    @ResponseBody
    public Map<String, Object> groupAdd(@RequestBody Group group) {
        groupService.addGroup(group);
        Map<String, Object> rs = new HashMap<>();
        rs.put("code", 0);
        rs.put("msg", "添加成功");
        rs.put("data", group);
        return rs;
    }

    @RequestMapping("/del")
    @ResponseBody
    public Map<String, Object> userDelete(@RequestParam("groupId") Long groupId) {
        Group group = groupService.deleteById(groupId);
        Map<String, Object> rs = new HashMap<>();
        rs.put("code", 0);
        rs.put("msg", "删除成功");
        rs.put("data", group);
        return rs;
    }

    @PostMapping("/del/list")
    @ResponseBody
    public Map<String, Object> userDeleteAll(@RequestBody List<Long> groupIdList) {
        List<Group> groupList = groupService.deleteAllById(groupIdList);
        Map<String, Object> rs = new HashMap<>();
        rs.put("code", 0);
        rs.put("msg", "删除成功");
        rs.put("data", groupList);
        return rs;
    }

    @PostMapping("/upd")
    @ResponseBody
    public Map<String, Object> userUpdate(@RequestBody Group group) {
        groupService.updateById(group);

        Map<String, Object> rs = new HashMap<>();
        rs.put("msg", "修改成功");
        rs.put("code", 0);
        rs.put("data", group);
        return rs;
    }
}

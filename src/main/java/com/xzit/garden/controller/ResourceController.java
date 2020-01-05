package com.xzit.garden.controller;

import com.xzit.garden.bean.entity.Resource;
import com.xzit.garden.bean.entity.Supplier;
import com.xzit.garden.bean.model.PageModel;
import com.xzit.garden.service.ResourceService;
import com.xzit.garden.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/res")
public class ResourceController {

    @Autowired
    private ResourceService resourceService;

    @Autowired
    private SupplierService supplierService;

    @GetMapping("/index")
    public String index() {
        return "resource";
    }


    @GetMapping("/add/index")
    public String addIndex(Model model) {
        List<Supplier> supplierList = supplierService.findAll();

        model.addAttribute("msg", "添加物资信息");
        model.addAttribute("flag", 0);
        model.addAttribute("supplierList", supplierList);
        model.addAttribute("url", "/res/add");
        return "resource_edit";
    }

    @GetMapping("/upd/index")
    public String updIndex(@RequestParam("resId") Long resId, Model model) {
        List<Supplier> supplierList = supplierService.findAll();
        Resource resource = resourceService.getById(resId);

        model.addAttribute("msg", "编辑物资信息");
        model.addAttribute("flag", 1);
        model.addAttribute("resource", resource);
        model.addAttribute("supplierList", supplierList);
        model.addAttribute("url", "/res/upd");
        return "resource_edit";
    }

    @PostMapping("/add")
    @ResponseBody
    public Map<String, Object> groupAdd(@RequestBody Resource resource) {
        resourceService.addResource(resource);

        Map<String, Object> rs = new HashMap<>();
        rs.put("code", 0);
        rs.put("msg", "添加成功");
        rs.put("data", resource);
        return rs;
    }

    @PostMapping("/upd")
    @ResponseBody
    public Map<String, Object> userUpdate(@RequestBody Resource resource) {
        resourceService.updateById(resource);

        Map<String, Object> rs = new HashMap<>();
        rs.put("msg", "修改成功");
        rs.put("code", 0);
        rs.put("data", resource);
        return rs;
    }

    @GetMapping("/list")
    @ResponseBody
    public Map<String, Object> indexList(PageModel<List<Resource>> pageModel) {
        List<Resource> resourceList = resourceService.findAllPage(pageModel);

        Map<String, Object> rs = new HashMap<>();
        rs.put("code", 0);
        rs.put("msg", "查询完成");
        rs.put("data", resourceList);
        rs.put("count", pageModel.getCount());
        return rs;
    }


}

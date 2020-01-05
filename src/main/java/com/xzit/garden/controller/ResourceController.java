package com.xzit.garden.controller;

import com.xzit.garden.bean.entity.Resource;
import com.xzit.garden.bean.model.PageModel;
import com.xzit.garden.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/res")
public class ResourceController {

    @Autowired
    private ResourceService resourceService;

    @GetMapping("/index")
    public String index() {
        return "resource";
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

package com.xzit.garden.controller;

import com.alibaba.fastjson.JSON;
import com.xzit.garden.bean.dto.MaintenanceResApplyDto;
import com.xzit.garden.bean.dto.MaintenanceResDto;
import com.xzit.garden.bean.entity.MaintenanceRes;
import com.xzit.garden.bean.entity.MaintenanceplanResApply;
import com.xzit.garden.bean.entity.ResApply;
import com.xzit.garden.bean.entity.Resource;
import com.xzit.garden.service.MaintenancePlanService;
import com.xzit.garden.service.MaintenanceResService;
import com.xzit.garden.util.DateChangeUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/maintenanceRes")
public class MaintenanceResController {
    @Autowired
    MaintenanceResService maintenanceResService;
    @RequestMapping ("/index")
    public String maintenanceResList(Model model,Long id)
    {
        model.addAttribute("id",id);
        return "maintenanceRes";
    }
    @RequestMapping("/list")
    @ResponseBody
    public Map<String, Object> findMaintenanceReslist(Long id)
    {
        List<MaintenanceResDto> list=maintenanceResService.findAllresourceDtoByid(id);
        Map<String, Object> data = new HashMap<>();
        data.put("code", 0);
        data.put("msg", "查询完成");
        data.put("count",list.size() );
        data.put("data", list);
        return data;
    }
    @RequestMapping ("/resApply/index")
    public String maintenanceResApply(Model model,Long id)
    {
        model.addAttribute("id",id);
        return "maintenanceResApply";
    }
    @RequestMapping("/resApply/list")
    @ResponseBody
    public Map<String, Object> findMaintenanceResApplylist(Long id)
    {
        List<MaintenanceResApplyDto> list=maintenanceResService.findAllMaintenanceApplyDto(id);
        Map<String, Object> data = new HashMap<>();
        data.put("code", 0);
        data.put("msg", "查询完成");
        data.put("count",list.size() );
        data.put("data", list);
        return data;
    }
    @RequestMapping("/resApply/add")
    @ResponseBody
    public Map<String, Object> ResApplyAdd(@RequestBody MaintenanceplanResApply resApply,Long planid) {
            resApply.setApplierid((long) 111112);
            resApply.setImplplanid(planid);
            Date date=new Date();
            resApply.setApplytime(date);
        System.out.println(JSON.toJSON(resApply));
        int result=maintenanceResService.insertMaintenanceResApplySelective(resApply);
        Map<String, Object> rs = new HashMap<>();
        rs.put("code", 0);
        if(result==0)
            rs.put("msg","添加失败");
        else
            rs.put("msg", "添加成功");
        rs.put("data", resApply);
        System.out.println("插入成功");
        return rs;
    }
    @RequestMapping("/resApply/update")
    @ResponseBody
    public  Map<String, Object> update(@RequestBody MaintenanceplanResApply  resApply,Long id,Long planid)
    {
        resApply.setApplierid((long) 111112);
        resApply.setId(id);
        resApply.setImplplanid(planid);
        int result=maintenanceResService.updateMaintenanceResApplyByPrimaryKeySelective(resApply);
        Map<String, Object> rs = new HashMap<>();
        rs.put("code", 0);
        if(result==0)
            rs.put("msg","更新失败");
        else
            rs.put("msg", "更新成功");
        System.out.println("更新");
        rs.put("data", resApply);
        return rs;
    }
    @RequestMapping("/resApply/del")
    @ResponseBody
    public Map<String, Object> resApplyDelete(Model model,Long id) {
        MaintenanceplanResApply maintenanceplanResApply=maintenanceResService.selectmaintenanceplanRes_applyByPrimaryKey(id);
       int flag=0;
        if(maintenanceplanResApply.getAuditstate()==0);
       flag=maintenanceResService.deleteMaintenanceApplyByPrimaryKey(id);
        Map<String, Object> rs = new HashMap<>();
        rs.put("code", 0);
        if(flag!=0)
            rs.put("msg", "删除成功");
        else
            rs.put("msg","删除失败");
        return rs;
    }
    @RequestMapping("/resApply/add/index")
    public String addIndex(Model model, @Param("id") Long id,@Param("planid") Long planid) {
        System.out.println(id+" "+planid);
        MaintenanceplanResApply maintenanceplanResApply=new MaintenanceplanResApply();
        maintenanceplanResApply.setImplplanid(planid);
        int type=0;
        if(id!=null)
        {
            maintenanceplanResApply=maintenanceResService.selectmaintenanceplanRes_applyByPrimaryKey(id);
            model.addAttribute("maintenanceplanResApply"
                    ,maintenanceplanResApply);
            type=1;
        }

        List<Resource> list=maintenanceResService.findAllResource();
        System.out.println(type);

        model.addAttribute("maintenanceplanResApply",maintenanceplanResApply);
        model.addAttribute("resource",list);
        model.addAttribute("type",type);
        model.addAttribute("planid",planid);
        return "MaintenanceResApplyEdit";
    }
}

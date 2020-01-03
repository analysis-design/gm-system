package com.xzit.garden.controller;

import com.xzit.garden.bean.dto.LayuiDataDto;
import com.xzit.garden.bean.entity.Project;
import com.xzit.garden.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("/project")
public class ProjectController {
    @Autowired
    ProjectService projectService;

    @RequestMapping("/index")
    public String projectTab() {
        return "projectTable";
    }

    @RequestMapping("")
    @ResponseBody
    public LayuiDataDto<Project> projectList(@RequestParam(required = false, defaultValue = "") String name,@RequestParam(required = false,value = "page", defaultValue = "1") int page,@RequestParam(required = false,value = "limit", defaultValue = "10") int limit) throws Exception {
        LayuiDataDto<Project> projectData = new LayuiDataDto<Project>();
        List<Project> projects = projectService.findByName(name,page,limit);
        projectData.setCode(0);
        projectData.setCount(projectService.findCount());
        projectData.setData(projects);
        projectData.setMsg("工程信息查询结果");
        return projectData;
    }

    @RequestMapping(path = "/del", method = RequestMethod.GET)
    @ResponseBody
    public String delProject(@RequestParam(required = false, defaultValue = "") Long id) {
        Integer delete = projectService.deleteProject(id);
        System.out.println("id = " + delete);
        if (delete < 0) {
            return "deleteError";
        }
        return "删除成功!";
    }

    @GetMapping("/add")
    public String addProject(@RequestParam(required = false,defaultValue = "",value = "id") Long id ,@RequestParam(required = false,defaultValue = "0",value = "isDisabled") Long isDisabled , Model model){
        if (id==0){
            model.addAttribute("url","/project/add/insert");
            return "project_edit";
        }
        if (isDisabled==1){
            Project project = projectService.findByIdProject(id);
            model.addAttribute("project",project);
            model.addAttribute("disabled",1);
            return "project_edit";
        }
        Project project = projectService.findByIdProject(id);
        model.addAttribute("project",project);
        model.addAttribute("url","/project/add/update");
        System.out.println(id);
        return "project_edit";
    }

    @RequestMapping(path = "/add/insert",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public LayuiDataDto<Project> addInsProject(@RequestBody Project project){
        System.out.println(project.getId());
        projectService.insertProject(project);
        LayuiDataDto<Project> projectLayuiDataDto = new LayuiDataDto<Project>();
        projectLayuiDataDto.setCode(0);
        projectLayuiDataDto.setCount(projectService.findAllProject().size());
        projectLayuiDataDto.setMsg("增加成功");
        projectLayuiDataDto.setData(projectService.findAllProject());
        return projectLayuiDataDto;
    }

    @RequestMapping(path = "/add/update",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public LayuiDataDto<Project> addUpdProject(@RequestBody Project project){
        System.out.println(project.getId());
        projectService.updateProject(project);
        LayuiDataDto<Project> projectLayuiDataDto = new LayuiDataDto<Project>();
        projectLayuiDataDto.setCode(0);
        projectLayuiDataDto.setCount(projectService.findAllProject().size());
        projectLayuiDataDto.setMsg("修改成功");
        projectLayuiDataDto.setData(projectService.findAllProject());
        return projectLayuiDataDto;
    }



//    @RequestMapping(path = "/delete", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
//    @ResponseBody
//    public String deleteProject(@RequestBody Project project) {
//        System.out.println("id = " + project.getId());
//        return "delete";
//    }
}

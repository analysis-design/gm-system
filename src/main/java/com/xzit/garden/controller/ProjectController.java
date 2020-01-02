package com.xzit.garden.controller;

import com.xzit.garden.bean.dto.LayuiDataDto;
import com.xzit.garden.bean.entity.Project;
import com.xzit.garden.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public LayuiDataDto<Project> projectList(@RequestParam(required = false, defaultValue = "") String name) throws Exception {
        LayuiDataDto<Project> projectData = new LayuiDataDto<Project>();
        List<Project> projects = projectService.findByName(name);
        projectData.setCode(0);
        projectData.setCount(projects.size());
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
    public String addProject(@RequestParam(required = false,defaultValue = "",value = "id") Long id , Model model){
        if (id==0){
            Project project = new Project();
            model.addAttribute("project",project);
            return "project_edit";
        }
        Project project = projectService.findByIdProject(id);
        model.addAttribute("project",project);
        System.out.println(id);
        return "project_edit";
    }




//    @RequestMapping(path = "/delete", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
//    @ResponseBody
//    public String deleteProject(@RequestBody Project project) {
//        System.out.println("id = " + project.getId());
//        return "delete";
//    }
}

package com.xzit.garden.controller;

import com.xzit.garden.bean.dto.LayuiDataDto;
import com.xzit.garden.bean.dto.ProjectDto;
import com.xzit.garden.bean.entity.Client;
import com.xzit.garden.bean.entity.Project;
import com.xzit.garden.bean.entity.Staff;
import com.xzit.garden.service.ClientService;
import com.xzit.garden.service.ProjectService;
import com.xzit.garden.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.*;

@Controller
@RequestMapping("/project")
public class ProjectController {
    @Autowired
    ProjectService projectService;
    @Autowired
    StaffService staffService;
    @Autowired
    ClientService clientService;

    @RequestMapping("/index")
    public String projectTab() {
        return "projectTable";
    }

    @RequestMapping("")
    @ResponseBody
    public LayuiDataDto<ProjectDto> projectList(ProjectDto projectDto,@RequestParam(required = false,value = "page", defaultValue = "1") int page,@RequestParam(required = false,value = "limit", defaultValue = "10") int limit) throws Exception {
        LayuiDataDto<ProjectDto> projectData = new LayuiDataDto<ProjectDto>();//layui数据格式
        List<ProjectDto> projectDtos = new ArrayList<>();
        projectDtos = projectService.findByProjectDto(projectDto);
        //分页
        List<ProjectDto> projectDtoList = new ArrayList<>();
        for (int i = page * limit - limit; i < page * limit && i < projectDtos.size(); i++) {
            projectDtoList.add(projectDtos.get(i));
        }

        System.out.println(projectDtos.size());
        projectData.setCode(0);
        projectData.setCount(projectService.findCount());
        projectData.setData(projectDtoList);
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
        if (id==0){//添加
            List<Staff> staffList = staffService.getAllStaff();
            model.addAttribute("staffList",staffList);
            List<Client> clientList = clientService.findAll();
            model.addAttribute("clientList",clientList);
            model.addAttribute("url","/project/add/insert");
            return "project_edit";
        }
        if (isDisabled==1){//查看
            Project project = projectService.findByIdProject(id);
            ProjectDto projectDto = projectService.getProjectDto(project);

            List<Staff> staffList = staffService.getAllStaff();
            model.addAttribute("staffList",staffList);
            List<Client> clientList = clientService.findAll();
            model.addAttribute("clientList",clientList);

            model.addAttribute("project",projectDto);
            model.addAttribute("disabled",1);
            return "project_edit";
        }
        //编辑
        Project project = projectService.findByIdProject(id);
        ProjectDto projectDto = projectService.getProjectDto(project);

        List<Staff> staffList = staffService.getAllStaff();
        model.addAttribute("staffList",staffList);
        List<Client> clientList = clientService.findAll();
        model.addAttribute("clientList",clientList);

        model.addAttribute("project",projectDto);
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

    @RequestMapping("/addClient")
    public String addClient(@RequestParam(required = false,value = "clientId",defaultValue = "0")Long clientId, Model model){
        if (clientId == 0){
            model.addAttribute("url","/project/add/client");
            model.addAttribute("disabled",1);
            return "client_add";
        }
        Client client = clientService.findById(clientId);
        model.addAttribute("client",client);
        model.addAttribute("url","/project/upd/client");
        return "client_add";
    }

    @RequestMapping(path = "/add/client",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Map<String,String> addClientDetail(@RequestBody Client client){
        System.out.println(client.getName());
        Integer succcess = clientService.addClient(client);
        Map<String,String> map = new HashMap<>();
        if (succcess==1){
            map.put("msg","添加成功");
            return map;
        }
        map.put("msg","添加失败");
        return map;
    }
    @RequestMapping(path = "/upd/client",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Map<String,String> updClientDetail(@RequestBody Client client){
        System.out.println(client.getName());
        Integer succcess = clientService.updClient(client);
        Map<String,String> map = new HashMap<>();
        if (succcess==1){
            map.put("msg","修改成功");
            return map;
        }
        map.put("msg","修改失败");
        return map;
    }

    @RequestMapping(path = "/del/client",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Map<String,String> delClient(@RequestBody Client client){
        System.out.println(client.getName());
        Integer succcess = clientService.deleteClient(client.getId());
        Map<String,String> map = new HashMap<>();
        if (succcess==0){
            map.put("msg","此客户有工程，不能删除！");
            map.put("del","1");
            return map;
        }
        else if (succcess==1){
            map.put("msg","删除成功");
            return map;
        }
        map.put("msg","删除失败");
        return map;
    }
}

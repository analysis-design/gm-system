package com.xzit.garden.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProjectController {

    @RequestMapping("/project")
    public String projectTab(){
        return "projectTable";
    }
}

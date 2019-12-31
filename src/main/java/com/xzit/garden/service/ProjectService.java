package com.xzit.garden.service;

import com.xzit.garden.bean.entity.Project;

import java.util.List;

public interface ProjectService {

    List<Project> findAllProject();

    Project findByIdProject(Integer id);

    Integer insertProject(Project project);

    Integer deleteProject(Integer id);

    Integer updateProject(Project project);
}

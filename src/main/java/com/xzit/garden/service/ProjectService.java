package com.xzit.garden.service;

import com.xzit.garden.bean.entity.Project;

import java.util.List;

public interface ProjectService {

    List<Project> findAllProject();

    Project findByIdProject(Long id);

    List<Project> findByName(String name,Integer page,Integer limit);

    Integer findCount();

    Integer insertProject(Project project);

    Integer deleteProject(Long id);

    Integer updateProject(Project project);
}

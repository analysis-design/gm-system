package com.xzit.garden.service;

import com.xzit.garden.bean.dto.ProjectDto;
import com.xzit.garden.bean.entity.Project;

import java.util.List;

public interface ProjectService {

    List<Project> findAllProject();

    Project findByIdProject(Long id);

    List<ProjectDto> findByName(String name);

    List<ProjectDto> getProjectDtoList(List<Project> projectList);

    ProjectDto getProjectDto(Project project);

    List<ProjectDto> findByProjectDto(ProjectDto projectDto);

    Integer findCount();

    Integer insertProject(Project project);

    Integer deleteProject(Long id);

    Integer updateProject(Project project);
}

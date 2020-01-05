package com.xzit.garden.service.impl;

import com.xzit.garden.bean.dto.ProjectDto;
import com.xzit.garden.bean.entity.Client;
import com.xzit.garden.bean.entity.Project;
import com.xzit.garden.bean.entity.Staff;
import com.xzit.garden.exception.ObjNotFoundException;
import com.xzit.garden.mapper.ClientMapper;
import com.xzit.garden.mapper.ProjectMapper;
import com.xzit.garden.mapper.StaffMapper;
import com.xzit.garden.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    ProjectMapper projectMapper;
    @Autowired
    private StaffMapper staffMapper;
    @Autowired
    private ClientMapper clientMapper;

    @Override
    public List<Project> findAllProject() {
        if (projectMapper.findAll() == null)
            throw new ObjNotFoundException("暂无工程！");
        return projectMapper.findAll();
    }

    @Override
    public Project findByIdProject(Long id) {
        if (projectMapper.findById(id) == null)
            throw new ObjNotFoundException("此工程不存在！");
        return projectMapper.findById(id);
    }

    /**
     * 根据工程名模糊查询工程
     * 如果名称为空则返回findAll
     *
     * @return
     */
    @Override
    public List<ProjectDto> findByName(String name) {
        if (name == "" || name == null || name.equals("")) {
            List<Project> projects = findAllProject();
            return getProjectDtoList(projects);
        }
        return getProjectDtoList(projectMapper.findByName(name));
    }

    /**
     * 把project列表转换成projectDto列表
     *
     * @return
     */
    public List<ProjectDto> getProjectDtoList(List<Project> projectList) {
        List<ProjectDto> projectDtoList = new ArrayList<>();
        for (Project project : projectList) {
            Project project1 = projectMapper.findById(project.getId());
            ProjectDto dto = new ProjectDto(project);
            dto.setProject(project1);

            Staff staff = staffMapper.findById(project.getSaleId());
            if (staff != null)
                dto.setSaleName(staff.getName());

            Client client = clientMapper.findById(project.getClientId());
            if (client != null)
                dto.setClientName(client.getName());
            projectDtoList.add(dto);
        }
        return projectDtoList;
    }

    //project转换为projectDto
    @Override
    public ProjectDto getProjectDto(Project project) {
        ProjectDto projectDto = new ProjectDto(project);
        Staff staff = staffMapper.findById(project.getSaleId());
        if (staff != null)
            projectDto.setSaleName(staff.getName());
        Client client = clientMapper.findById(project.getClientId());
        if (client != null)
            projectDto.setClientName(client.getName());
        return projectDto;
    }


    /**
     * 根据工程名或负责人姓名来进行模糊查询
     * 1.如果工程名和负责人姓名都不为空执行根据工程名和负责人名进行查询
     * 2.如果工程名不为空执行根据工程名来进行查询
     * 3.如果负责人姓名不为空执行根据负责人姓名进行查询
     *
     * @param projectDto
     * @return
     */
    @Override
    public List<ProjectDto> findByProjectDto(ProjectDto projectDto) {
        if (projectDto.getName() != "" && projectDto.getName() != null && projectDto.getSaleName() != null && projectDto.getSaleName() != "") {
            List<Project> projects = projectMapper.findByNameStaff(projectDto.getName(), projectDto.getSaleName());
            return getProjectDtoList(projects);
        } else if (projectDto.getName() != null && projectDto.getName() != "") {
            List<Project> projects = projectMapper.findByName(projectDto.getName());
            return getProjectDtoList(projects);
        } else if (projectDto.getSaleName() != null && projectDto.getSaleName() != "") {
            List<Project> projects = projectMapper.findByStaffName(projectDto.getSaleName());
            return getProjectDtoList(projects);
        }
        return findByName(projectDto.getName());
    }

    @Override
    public Integer findCount() {
        return projectMapper.findCount();
    }

    /*
    增加工程业务逻辑
    1.判断销售人员编号是否存在
    2.判断客户编号是否存在
    3.
     */
    @Override
    public Integer insertProject(Project project) {
        Long saleId = project.getSaleId();
        Staff staff = staffMapper.findById(saleId);

        if (staff == null)
            throw new RuntimeException("销售员不存在");

        Long clientId = project.getClientId();
        Client client = clientMapper.findById(clientId);

        if (client == null)
            throw new RuntimeException("客户不存在");

        return projectMapper.insert(project);
    }

    /*
    删除业务逻辑
    1.判断工程资源表是否在用此工程编号
    2.判断工程部门表是否在用此工程编号
    3.判断成本预算表是否在用此工程编号
    4.判断订单表是否在用此工程编号
    5.如果合同签了，就不能删除
    6.如果开始了
     */
    @Override
    public Integer deleteProject(Long id) {
        return projectMapper.isDelete(id);
    }

    /*
   修改工程业务逻辑
   1.判断销售人员编号是否存在
   2.判断客户编号是否存在
   3.
    */
    @Override
    public Integer updateProject(Project project) {
        Long saleid = project.getSaleId();
        Staff staff = staffMapper.findById(saleid);
        if (staff == null)
            throw new RuntimeException("销售员不存在");

        Long clientId = project.getClientId();
        Client client = clientMapper.findById(clientId);

        if (client == null)
            throw new RuntimeException("客户不存在");

        return projectMapper.update(project);
    }
}

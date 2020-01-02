package com.xzit.garden.service.impl;

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
        if (projectMapper.findAll()==null)
            throw new ObjNotFoundException("暂无工程！");
        return projectMapper.findAll();
    }

    @Override
    public Project findByIdProject(Long id) {
        if (projectMapper.findById(id)==null)
            throw new ObjNotFoundException("此工程不存在！");
        return projectMapper.findById(id);
    }

    /**
     * 根据工程名模糊查询工程
     * 如果名称为空则返回findAll
     * @return
     */
    @Override
    public List<Project> findByName(String name) {
        if (name==""||name==null||name.equals(""))
            findAllProject();
        return projectMapper.findByName(name);
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

        if (client==null)
            throw new RuntimeException("客户不存在");

        return projectMapper.insert(project);
    }

    /*
    删除业务逻辑
    1.判断工程资源表是否在用此工程编号
    2.判断工程部门表是否在用此工程编号
    3.判断成本预算表是否在用此工程编号
    4.判断订单表是否在用此工程编号
    5.
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

        if (client==null)
            throw new RuntimeException("客户不存在");

        return projectMapper.update(project);
    }
}

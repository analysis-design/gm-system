package com.xzit.garden.service.impl;

import com.xzit.garden.bean.entity.Client;
import com.xzit.garden.bean.entity.Project;
import com.xzit.garden.mapper.ClientMapper;
import com.xzit.garden.mapper.ProjectMapper;
import com.xzit.garden.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Xsk on 2020/1/2.
 */
@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    ClientMapper clientMapper;
    @Autowired
    ProjectMapper projectMapper;

    @Override
    public List<Client> findAll() {
        return clientMapper.findAll();
    }

    @Override
    public Integer addClient(Client client) {
        return clientMapper.insert(client);
    }

    @Override
    public Client findById(Long id) {
        System.out.println(id);
        System.out.println(clientMapper.findById(id).getName());
        return clientMapper.findById(id);
    }

    @Override
    public Integer updClient(Client client) {
        return clientMapper.update(client);
    }

    @Override
    public Integer deleteClient(Long id) {
        Project project = projectMapper.findByClientId(id);
        if (project == null)
            return clientMapper.delete(id);
        return 0;
    }
}

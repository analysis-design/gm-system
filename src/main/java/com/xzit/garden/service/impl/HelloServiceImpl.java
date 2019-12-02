package com.xzit.garden.service.impl;

import com.xzit.garden.bean.dto.HelloDto;
import com.xzit.garden.bean.entity.HelloEntity;
import com.xzit.garden.mapper.HelloMapper;
import com.xzit.garden.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HelloServiceImpl implements HelloService {

    @Autowired
    private HelloMapper helloMapper;

    @Override
    public HelloDto getHelloById(Long id) {

        HelloEntity helloEntity = helloMapper.findById(id);

        HelloDto helloDto = new HelloDto();
        if (helloEntity != null)
            helloDto.setMsg(helloEntity.getMessage());

        return helloDto;
    }

    @Override
    public List<HelloEntity> getAll() {
        return helloMapper.findAll();
    }

    @Override
    public void add(HelloEntity entity) {
        helloMapper.add(entity);
    }


    @Override
    public void delete(Long id) {
        helloMapper.deleteById(id);
    }

    @Override
    public void update(HelloEntity entity) {
        helloMapper.update(entity);
    }
}

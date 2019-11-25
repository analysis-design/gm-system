package com.xzit.garden.service.impl;

import com.xzit.garden.bean.dto.HelloDto;
import com.xzit.garden.bean.entity.HelloEntity;
import com.xzit.garden.mapper.HelloMapper;
import com.xzit.garden.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {

    @Autowired
    private HelloMapper helloMapper;
    @Override
    public HelloDto getDto() {

        HelloEntity helloEntity = helloMapper.findById(1L);

        HelloDto helloDto = new HelloDto();
        helloDto.setName(helloEntity.getName());
        return helloDto;
    }
}

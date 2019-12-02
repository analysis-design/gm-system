package com.xzit.garden.service;

import com.xzit.garden.bean.dto.HelloDto;
import com.xzit.garden.bean.entity.HelloEntity;

import java.util.List;

public interface HelloService {

    HelloDto getHelloById(Long id);

    List<HelloEntity> getAll();

    void add(HelloEntity entity);

    void delete(Long id);

    void update(HelloEntity entity);
}

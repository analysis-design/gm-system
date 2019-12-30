package com.xzit.garden.service.impl;

import com.xzit.garden.bean.dto.AuthorityDto;
import com.xzit.garden.bean.dto.UserDto;
import com.xzit.garden.bean.entity.Authority;
import com.xzit.garden.mapper.AuthorityMapper;
import com.xzit.garden.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorityServiceImpl implements AuthorityService {
    @Autowired
    private AuthorityMapper authorityMapper;

    @Override
    public AuthorityDto getAllAuthority() {

        return UserDto.loadAuthority(authorityMapper.findAll());
    }

    @Override
    public void add(Authority authority) {
        Long parentId = authority.getParentId();
        Authority temp = authorityMapper.findById(parentId);
        if (temp == null)
            throw new RuntimeException("指定的父级权限不存在");

        authorityMapper.add(authority);
    }

    @Override
    public Authority deleteById(Long authId) {
        Authority temp = authorityMapper.findById(authId);
        if (temp == null)
            throw new RuntimeException("指定的删除的权限不存在");
        authorityMapper.deleteById(authId);
        return temp;
    }

    @Override
    public void updateById(Authority authority) {
        Authority temp = authorityMapper.findById(authority.getId());
        if (temp == null)
            throw new RuntimeException("指定的修改的权限不存在");

        Authority temp2 = authorityMapper.findById(authority.getParentId());
        if (temp2 == null)
            throw new RuntimeException("指定的父级权限不存在");

        authorityMapper.update(authority);
    }
}

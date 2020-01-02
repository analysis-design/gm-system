package com.xzit.garden.service.impl;

import com.xzit.garden.bean.dto.AuthorityDto;
import com.xzit.garden.bean.dto.UserDto;
import com.xzit.garden.bean.entity.Authority;
import com.xzit.garden.bean.model.PageModel;
import com.xzit.garden.exception.ObjNotFoundException;
import com.xzit.garden.mapper.AuthorityMapper;
import com.xzit.garden.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorityServiceImpl implements AuthorityService {
    @Autowired
    private AuthorityMapper authorityMapper;

    @Override
    public AuthorityDto getAllAuthorityTree() {

        return UserDto.loadAuthority(authorityMapper.findAll());
    }

    @Transactional
    @Override
    public void add(Authority authority) {
        Long parentId = authority.getParentId();
        if (parentId != null && parentId != -1) {
            Authority temp = authorityMapper.findById(parentId);
            if (temp == null)
                throw new RuntimeException("指定的父级权限不存在");
        } else authority.setParentId(null);

        authorityMapper.add(authority);
    }

    @Transactional
    @Override
    public Authority deleteById(Long authId) {
        Authority temp = authorityMapper.findById(authId);
        if (temp == null)
            throw new RuntimeException("指定的删除的权限不存在");
        authorityMapper.deleteById(authId);
        return temp;
    }

    @Transactional
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

    @Override
    public List<Authority> getAllAuthorityList(PageModel<List<Authority>> page) {
        Integer limit = page.getLimit();
        List<Authority> authorityList = authorityMapper.findPage((page.getPage() - 1) * limit, limit);
        if (authorityList == null)
            authorityList = new ArrayList<>();

        int count = authorityMapper.countList();
        page.setCount(count);
        return authorityList;
    }

    @Override
    public Authority getById(Long authId) {
        Authority authority = authorityMapper.findById(authId);
        if (authority == null)
            throw new ObjNotFoundException("指定的修改的权限编号不存在");

        return authority;
    }

    @Override
    public List<Authority> deleteAllById(List<Long> authList) {
        List<Authority> list = new ArrayList<>();

        for (Long authId : authList) {
            Authority authority = authorityMapper.findById(authId);
            if (authority == null)
                throw new ObjNotFoundException("指定的修改的权限编号" + authId + "不存在");
            list.add(authority);
        }

        authorityMapper.deleteByIdList(authList);
        return list;
    }


}

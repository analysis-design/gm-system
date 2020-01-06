package com.xzit.garden.service;

import com.xzit.garden.bean.dto.AuthorityDto;
import com.xzit.garden.bean.entity.Authority;
import com.xzit.garden.bean.model.PageModel;

import java.util.List;

public interface AuthorityService {
    /**
     * @return 获取所有的权限表示
     */
    AuthorityDto getAllAuthorityTree();

    /**
     * 添加权限
     *
     * @param authority 权限
     */
    void add(Authority authority);

    /**
     * 根据权限id删除权限
     *
     * @param authId 权限id
     * @return 删除的权限对象
     */
    Authority deleteById(Long authId);

    /**
     * 修改权限
     *
     * @param authority 修改的权限对象
     */
    void updateById(Authority authority);

    /**
     * @param page 分页对象
     * @return 获取所有的权限列表
     */
    List<Authority> getAllAuthorityList(PageModel<List<Authority>> page);

    /**
     * 根据权限id获取权限
     *
     * @param authId 权限id
     * @return 权限对象
     */
    Authority getById(Long authId);

    /**
     * 批量删除权限
     *
     * @param authList 删除的权限的id
     * @return 删除的权限列表
     */
    List<Authority> deleteAllById(List<Long> authList);

    /**
     * 根据URI获取当前URI的子URI
     *
     * @param uri 权限的URI
     * @return 子URI的Authority列表
     */
    List<Authority> findChildrenByParentURI(String uri);
}

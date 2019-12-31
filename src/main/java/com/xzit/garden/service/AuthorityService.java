package com.xzit.garden.service;

import com.xzit.garden.bean.dto.AuthorityDto;
import com.xzit.garden.bean.entity.Authority;

public interface AuthorityService {
    /**
     * @return 获取所有的权限表示
     */
    AuthorityDto getAllAuthority();

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
}

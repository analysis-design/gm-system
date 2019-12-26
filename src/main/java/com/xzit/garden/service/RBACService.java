package com.xzit.garden.service;

import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;

/**
 * 用于使用RABC方式验证用户的操作权限
 * RBAC(Role-based access control和Resource-based access control)
 */
public interface RBACService {

    /**
     * 验证用户访问的路径是否有权限
     *
     * @param request        请求对象
     * @param authentication 已认证的用户
     * @return 如果有操作资源的权限返回true，否则返回false
     */
    boolean hasPermission(HttpServletRequest request, Authentication authentication);
}

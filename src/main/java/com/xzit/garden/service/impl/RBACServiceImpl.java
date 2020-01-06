package com.xzit.garden.service.impl;

import com.xzit.garden.bean.entity.Authority;
import com.xzit.garden.mapper.AuthorityMapper;
import com.xzit.garden.service.AuthorityService;
import com.xzit.garden.service.RBACService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.util.AntPathMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * 用于使用RABC方式验证用户的操作权限
 * RBAC(Role-based access control和Resource-based access control)
 */
@Service("RBACService")
public class RBACServiceImpl implements RBACService {

    private AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Autowired
    private AuthorityMapper authorityMapper;

    @Autowired
    private AuthorityService authorityService;

    @Override
    public boolean hasPermission(HttpServletRequest request, Authentication authentication) {
        Object principal = authentication.getPrincipal();

        // 首先判断先当前用户是否是我们UserDetails对象
        if (!(principal instanceof UserDetails)) return false;

        boolean hasPermission = false;
        String username = ((UserDetails) principal).getUsername();

        Set<String> urls = new HashSet<>();
        authorityMapper.findByUserName(username).forEach(authority -> urls.add(authority.getUrl()));

        putAuthority(request);
        // 注意这里不能用equal来判断，因为有些URL是有参数的，所以要用AntPathMatcher来比较
        String requestURI = request.getRequestURI();
        for (String url : urls) {
            String contextPath = request.getServletContext().getContextPath();
            if (requestURI.contains(contextPath))
                requestURI = requestURI.substring(contextPath.length());

            if (!antPathMatcher.match(url, requestURI)) continue;

            hasPermission = true;
            break;
        }

        return hasPermission;
    }

    public void putAuthority(HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        String contextPath = request.getServletContext().getContextPath();

        if (requestURI.contains(contextPath))
            requestURI = requestURI.substring(contextPath.length());
        if (requestURI.contains("error"))
            return;
        List<Authority> authorityList = authorityService.findChildrenByParentURI(requestURI);

        List<Integer> typeFlag = new ArrayList<>();
        Map<Integer, String> authorityMap = new HashMap<>();
        for (Authority authority : authorityList) {
            typeFlag.add(authority.getTypeFlag());
            authorityMap.put(authority.getTypeFlag(), authority.getUrl());
        }

        request.setAttribute("operation", typeFlag);
        request.setAttribute("operationMap", authorityMap);
    }
}

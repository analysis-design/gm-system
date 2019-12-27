package com.xzit.garden.service.impl;

import com.xzit.garden.bean.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class SecurityAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private UserDetailsService detailsService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String userName = authentication.getName();// 这个获取表单输入中返回的用户名;
        String password = (String) authentication.getCredentials();// 这个是表单中输入的密码；
        // 这里构建来判断用户是否存在和密码是否正确
        User user = (User) detailsService.loadUserByUsername(userName); // 这里调用我们的自己写的获取用户的方法；
        if (user == null) {
            throw new BadCredentialsException("用户名不存在");
        }
//        // 这里我们还要判断密码是否正确，实际应用中，我们的密码一般都会加密，以Md5加密为例
//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        // 这里第个参数，是salt
//        // 就是加点盐的意思，这样的好处就是用户的密码如果都是123456，
//        // 由于盐的不同，密码也是不一样的，就不用怕相同密码泄漏之后，不会批量被破解。
//        String encodePwd = passwordEncoder.encode(password);
        //这里判断密码正确与否
        if (!user.getPassword().equals(password)) {
            throw new BadCredentialsException("密码不正确");
        }
        //这里还可以加一些其他信息的判断，比如用户账号已停用等判断，这里为了方便我接下去的判断，我就不用加密了。

        Collection<? extends GrantedAuthority> authorities = user.getAuthorities();
        // 构建返回的用户登录成功的token
        return new UsernamePasswordAuthenticationToken(user, password, authorities);
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}

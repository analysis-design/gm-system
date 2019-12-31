package com.xzit.garden.config;

import com.xzit.garden.handler.AuthenticationSuccessHandler;
import com.xzit.garden.service.impl.SecurityAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private SecurityAuthenticationProvider provider;
    @Autowired
    private AuthenticationSuccessHandler successHandler;
    @Autowired
    private AuthenticationFailureHandler failureHandler;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private DataSource dataSource;   //是在application.properites

    @Value("${auth.restful.enable}")
    private boolean authEnable;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        if (isNotAuthEnable(http)) return;

        http.formLogin().loginPage("/auth/form").loginProcessingUrl("/auth/form")
                .successHandler(successHandler)
                .failureHandler(failureHandler)
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/auth/form")
                .deleteCookies("JSESSIONID")
                .and()
                .rememberMe()
                .rememberMeParameter("remember-me").userDetailsService(userDetailsService)
                .tokenRepository(persistentTokenRepository())
                .tokenValiditySeconds(60)
                .and()
                .authorizeRequests()
                .antMatchers("/index").hasAnyAuthority("ROLE_USER")
                .antMatchers("/css/**", "/webjars/**", "/images/**", "/js/**").permitAll()
                .antMatchers(HttpMethod.POST, "/auth").permitAll()
//                .antMatchers("/whoim").hasRole("ADMIN") //这就表示/whoim的这个资源需要有ROLE_ADMIN的这个角色才能访问。不然就会提示拒绝访问
//                .anyRequest().authenticated() //必须经过认证以后才能访问
//                .and()
//                .csrf().disable();
                .anyRequest().access("@RBACService.hasPermission(request,authentication)")    //必须经过认证以后才能访问
                .and()
                .csrf().disable();
        http.headers().frameOptions().sameOrigin();
    }

    private boolean isNotAuthEnable(HttpSecurity http) throws Exception {
        if (!authEnable) {
            http.authorizeRequests().anyRequest().permitAll();
            http.headers().frameOptions().sameOrigin();
        }
        return !authEnable;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(provider);
    }

    /**
     * 记住我功能的token存取器配置
     *
     * @return 操作token的repository
     */
    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
        tokenRepository.setDataSource(dataSource);
        return tokenRepository;
    }
}

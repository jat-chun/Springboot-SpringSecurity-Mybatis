package com.spring.mybatis.security;

import com.spring.mybatis.common.CustomUserService;
import com.spring.mybatis.security.handler.LoginFailHandler;
import com.spring.mybatis.security.handler.LoginSuccessHandler;
import com.spring.mybatis.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration          // 配置文件
@EnableWebSecurity      // 开启Security
//@EnableGlobalMethodSecurity(prePostEnabled = true)  //AOP
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//    @Autowired
//    LoginAuthenticationProvider provider;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        //路由策略和访问权限的简单配置
        http
//                .authorizeRequests()
//                .anyRequest().authenticated()//所有请求必须登录后访问
//                .and()
                .formLogin().loginPage("/login")                      //启用默认登陆页面
                .failureHandler(loginFailureHandler())
                .successHandler(loginSuccessHandler())
                .permitAll()                        //登陆页面全部权限可访问
                .and()
                .logout()
                .permitAll();       //注销请求可以直接访问

        super.configure(http);
    }

    /**
     * 注册UserDetailService的bean
     * @return
     */
    @Bean
    UserDetailsService customUserService(){
        return new CustomUserService();
    }

    /**
     * 配置内存用户
     */
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        //user detail Service验证
        //使用自带的来进行验证
        auth.userDetailsService(customUserService()).passwordEncoder(new PasswordEncoder() {
            @Override
            public String encode(CharSequence rawPassword) {
                return MD5Util.encode((String) rawPassword);
            }
            @Override
            public boolean matches(CharSequence rawPassword, String encodePassword) {
                return encodePassword.equals(MD5Util.encode((String) rawPassword));
            }
        });

        //到provider进行验证
//        auth.authenticationProvider(provider);
    }


    private AuthenticationSuccessHandler loginSuccessHandler(){
        return new LoginSuccessHandler();
    }

    private AuthenticationFailureHandler loginFailureHandler(){
        return new LoginFailHandler();
    }

}
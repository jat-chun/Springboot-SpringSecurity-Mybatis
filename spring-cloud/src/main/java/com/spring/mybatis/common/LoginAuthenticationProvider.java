package com.spring.mybatis.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.SaltSource;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.authentication.encoding.PlaintextPasswordEncoder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class LoginAuthenticationProvider implements AuthenticationProvider {

//    //密码加密器
//    private PasswordEncoder passwordEncoder = new PlaintextPasswordEncoder();
//
//    private SaltSource saltSource;
//
//    @Autowired
//    private CustomUserService customUserService;
//
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//        String username = authentication.getName();
//        String password = (String) authentication.getCredentials();
//        UserDetails userDetails = customUserService.loadUserByUsername(username);
//        if(userDetails == null){
//            throw new BadCredentialsException("Username not found.");
//        }
//
//        //加密过程在这里体现
////        if (!password.equals(user.getPassword())) {
////            throw new BadCredentialsException("Wrong password.");
////        }
////
////        Collection<? extends GrantedAuthority> authorities = user.getAuthorities();
////        return new UsernamePasswordAuthenticationToken(user, password, authorities);
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }

//    public PasswordEncoder getPasswordEncoder() {
//        return passwordEncoder;
//    }
//
//    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
//        this.passwordEncoder = passwordEncoder;
//    }
//
//    public SaltSource getSaltSource() {
//        return saltSource;
//    }
//
//    public void setSaltSource(SaltSource saltSource) {
//        this.saltSource = saltSource;
//    }
//
//    public CustomUserService getCustomUserService() {
//        return customUserService;
//    }
//
//    public void setCustomUserService(CustomUserService customUserService) {
//        this.customUserService = customUserService;
//    }
}

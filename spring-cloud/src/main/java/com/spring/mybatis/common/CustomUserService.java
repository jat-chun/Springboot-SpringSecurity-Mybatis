package com.spring.mybatis.common;

import com.spring.mybatis.model.User;
import com.spring.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CustomUserService implements UserDetailsService{
    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userService.selectByUserName(userName);
        if (user==null){
            throw new UsernameNotFoundException("用户名不存在");
        }
        //用户权限列表
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        //用于添加用户的权限。只要把用户权限添加到authorities 就ok了。
//        for(SysRole role:user.getRoles())
//        {
//            authorities.add(new SimpleGrantedAuthority(role.getName()));
//            System.out.println(role.getName());
//        }
        return new org.springframework.security.core.userdetails.User(user.getUserName(),
                user.getPassword(), authorities);
    }
}

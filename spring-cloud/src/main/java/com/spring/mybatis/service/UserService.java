package com.spring.mybatis.service;


import com.spring.mybatis.model.User;

import java.util.List;

/**
 * Created by Administrator on 2017/8/16.
 */
public interface UserService {

    int addUser(User user);

    List<User> findAllUser(int pageNum, int pageSize);

    User selectByID(int id);

    User selectByUserName(String userName);
}
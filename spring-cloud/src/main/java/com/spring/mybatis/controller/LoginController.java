package com.spring.mybatis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class LoginController {

    @RequestMapping(value = "/home")
    public String viewHome() {
        return "home";
    }

    @RequestMapping(value = "/login")
    public String viewLogin() {
        return "login";
    }

}

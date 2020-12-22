package com.atzzuli.imovie.controller;

import com.atzzuli.imovie.entity.User;
import com.atzzuli.imovie.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    LoginService loginService;

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/login.action")
    public String login1(User user, HttpServletRequest request, HttpSession session)throws Exception{
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        user.setUsername(username);
        user.setPassword(password);
        user = this.loginService.login(user);
        if(user!=null) {
            return "widgets";
        }
        else {
            return "login";
        }
    }
}

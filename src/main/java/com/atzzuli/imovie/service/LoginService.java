package com.atzzuli.imovie.service;

import com.atzzuli.imovie.DAO.LoginDAO;
import com.atzzuli.imovie.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    //注入DAO层
    @Autowired
    LoginDAO loginDAO;

    public User login(User user){
        return loginDAO.login(user);
    }
}

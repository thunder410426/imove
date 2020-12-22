package com.atzzuli.imovie.service;

import com.atzzuli.imovie.DAO.RegistryDAO;
import com.atzzuli.imovie.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistryService {

    //注入DAO层
    @Autowired
    RegistryDAO registryDAO;

    /**
     * 注册
     * @param user
     */
    public void registry(User user){
        registryDAO.registry(user);
    }

    /**
     * 判断是否已经注册
     * @param username
     * @return
     */
    public String ifregistry(String username){
        return registryDAO.ifregistry(username);
    }
}

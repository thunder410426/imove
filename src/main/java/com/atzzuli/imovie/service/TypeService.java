package com.atzzuli.imovie.service;

import com.atzzuli.imovie.DAO.TypeDAO;
import com.atzzuli.imovie.entity.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeService {

    @Autowired
    TypeDAO typeDAO;

    /**
     * 新增类别
     * @param type
     */
    public void addType(Type type){
        typeDAO.addType(type);
    }

    /**
     * 删除类别
     * @param type
     */
    public void deleType(Type type){
        typeDAO.deleteType(type);
    }


    /**
     * 查找所有类别
     * @return
     */
    public List<Type> retrieveType(){
        return typeDAO.retrieveType();
    }


    /*    *//**
     * 查找类别
     * @param type
     * @return
     *//*
    public Type retrieveTypeById(Type type){
        return typeDAO.retriveTypeById(type);
    }

    *//**
     * 修改类别
     * @param type
     *//*
    public void updateType(Type type){
        typeDAO.updateType(type);
    }*/




}

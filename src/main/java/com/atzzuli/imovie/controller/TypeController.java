package com.atzzuli.imovie.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.atzzuli.imovie.entity.Type;
import com.atzzuli.imovie.service.TypeService;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@Controller
public class TypeController {

    @Autowired
    TypeService typeService;


    /**
     * 新增种类
     * @param type
     * @return
     */
    @RequestMapping("/addType")
    @ResponseBody
    public void addType(Type type){
        typeService.addType(type);
    }

    /**
     * 查找种类
     * @param modelAndView
     * @return
     */
    @RequestMapping("/retrieveType")
    @ResponseBody
    public ModelAndView retrieveType(ModelAndView modelAndView){
        List<Type> typeList = typeService.retrieveType();
        //将typeList传到前台
        modelAndView.setViewName("type");
        modelAndView.addObject("typeList",typeList);
        return modelAndView;
    }


    /**
     * 删除类别
     * @param type
     */
    @RequestMapping("/deleteType")
    public void deleteType(Type type){
        //删除数据
        typeService.deleType(type);
/*        //需要返回修改后的数据
        List<Type> typeList = typeService.retrieveType();
        //将typeList传到前台
        model.addAttribute("typeList",typeList);*/
    }

    /**
     * 修改类别
     * @param typeremoved
     * @param typeupdate
     * @param type
     * @param type1
     */
    @RequestMapping("/updateType")
    public void updateType(@RequestParam("type1") String typeremoved, @RequestParam("typeupdate") String typeupdate,Type type,Type type1){
        System.out.println(typeremoved);
        System.out.println(typeupdate);
/*        JSONObject jsonObject = JSONObject.parseObject(typeremoved);
        Type type2 = JSONObject.toJavaObject(jsonObject,Type.class);
        typeService.deleType(type2);
        //需要将转化为JSON转换为实体类对象
        JSONObject jsonObject1 = JSONObject.parseObject(typeupdate);
        Type type3 = JSONObject.toJavaObject(jsonObject1,Type.class);
        typeService.addType(type3);*/
        type.setType1(typeremoved);
        typeService.deleType(type);
        type1.setType1(typeupdate);
        typeService.addType(type1);
    }
/*    String str="" +
            "2020-12-21 13:34:58.345  WARN 3788 --- [nio-8080-exec-1] .w.s.m.s.DefaultHandlerExceptionResolver :\n" +
            "Resolved [org.springframework.web.method.annotation.MethodArgumentConversionNotSupportedException:\n" +
            "Failed to convert value of type 'java.lang.String' to required type 'com.atzzuli.imovie.entity.Type';\n" +
            "nested exception is java.lang.IllegalStateException: Cannot convert value of type 'java.lang.String' to required type\n" +
            "'com.atzzuli.imovie.entity.Type':\n" +
            "no matching editors or conversion strategy found]"*/
}




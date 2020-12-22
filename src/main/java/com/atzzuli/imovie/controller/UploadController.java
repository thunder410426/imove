package com.atzzuli.imovie.controller;

import com.atzzuli.imovie.entity.Movie;
import com.atzzuli.imovie.service.UploadService;
import com.atzzuli.imovie.util.UploadUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class UploadController {

    @Autowired
    UploadService uploadService;

    //返回上传页面
    @RequestMapping("/upload1")
    public String upload1(){
        return "upload";
    }

    /**
     * 上传文件
     * @param request
     * @param movie
     */

    @ResponseBody
    @RequestMapping(value = "/upload")
    public void upload(HttpServletRequest request, Movie movie){
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        //获取multipart混合数据中的每个元素
        List<MultipartFile> file1 = multipartRequest.getFiles("picname1");
        List<MultipartFile> file2 = multipartRequest.getFiles("filename1");
        String type = multipartRequest.getParameter("type");
        String name = multipartRequest.getParameter("name");
        String date = multipartRequest.getParameter("date");
        String actors = multipartRequest.getParameter("actors");
        String introduction = multipartRequest.getParameter("introduction");
        //设置存入数据库的文件名为../file/xxx
        String path1 = "/";
        String picname = path1+file1.get(0).getOriginalFilename();
        String filename = path1+file2.get(0).getOriginalFilename();
        String path = "C:\\Users\\刘京毫\\Desktop\\作业,实训,实验\\人机交互实验报告\\imovie\\src\\main\\resources\\file";
//        //上传照片文件
//        if(!"".equals(picname)){
//            String suffixName1 = filename.substring(picname.lastIndexOf("."));
//            picname = picname + suffixName1;
//        }
//
//
//        //上传影片
//        if(!"".equals(filename)){
//            String suffixName2 = filename.substring(filename.lastIndexOf("."));
//            filename = filename + suffixName2;
//        }
        //使用上传工具类
        UploadUtils.upload(file1.get(0),path,picname);
        UploadUtils.upload(file2.get(0),path,filename);



        movie.setType(type);
        movie.setName(name);
        movie.setDate(date);
        movie.setActors(actors);
        movie.setIntroduction(introduction);
        movie.setPicname(picname);
        movie.setFilename(filename);
        uploadService.upload(movie);
    }

        //文件处理
//        try{
//            if (files.length > 0){
//                for (MultipartFile file:files) {
//                    System.out.println(file.getOriginalFilename());
//                    // 文件处理
//                    String fileName = file.getOriginalFilename();
//                    System.out.println(fileName);
//                    String fileExtension = fileName.substring(fileName.lastIndexOf(".") + 1,fileName.length());
//                    String filePath = "C:\\Users\\刘京毫\\Desktop\\作业,实训,实验\\人机交互实验报告\\imovie\\src\\main\\resources\\file";
//                    File targetFile = new File(filePath);
//                    if(!targetFile.exists()) {
//                        targetFile.mkdirs();
//                    }
//
//                    // 文件存到服务器
//                    try {
//                        FileOutputStream out = null;
//                        out = new FileOutputStream(filePath + fileName);
//                        out.write(file.getBytes());
//                        out.flush();
//                        out.close();
//                        System.out.println("文件写入成功！");
//                    } catch (Exception e){
//                        System.out.println("文件写入失败！");
//                    }
//                }


//            movie.setFilename(files[0].getOriginalFilename());
//            movie.setPicname(files[1].getOriginalFilename());

        }



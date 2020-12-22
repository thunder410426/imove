package com.atzzuli.imovie.controller;

import com.atzzuli.imovie.entity.Movie;
import com.atzzuli.imovie.service.MsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MsgController {

    @Autowired
    MsgService msgService;

    /**
     * 查询电影信息
     * @param modelAndView
     * @return
     */
    @RequestMapping("/retrieveMsg")
    @ResponseBody
    public ModelAndView retrieveMsg(ModelAndView modelAndView){
        List<Movie> movieList = msgService.retrieveMovie();
        modelAndView.setViewName("msg");
        modelAndView.addObject("movieList",movieList);
        return modelAndView;
    }

    /**
     * 获取用户输入的新movie信息，并以原movie的name删除所在行并添加新数据
     * @param name2
     * @param nameremoved
     * @param type2
     * @param date2
     * @param actors2
     * @param picname2
     * @param filenameremove
     * @param introduction2
     * @param movie
     */
    @RequestMapping("/updateMsg")
    @ResponseBody
    public void updateMsg(@RequestParam("name") String name2,
                          @RequestParam("nameremoved") String nameremoved, @RequestParam("type") String type2,
                          @RequestParam("date") String date2, @RequestParam("actors") String actors2,
                          @RequestParam("picname") String picname2, @RequestParam("filename") String filenameremove,
                          @RequestParam("introduction") String introduction2,Movie movie){

        msgService.deleteMovie(nameremoved);

        movie.setName(name2);
        movie.setType(type2);
        movie.setDate(date2);
        movie.setActors(actors2);
        movie.setIntroduction(introduction2);
        movie.setFilename(filenameremove);
        movie.setPicname(picname2);
        msgService.insertMovie(movie);
    }

    @RequestMapping("/deleteMsg")
    public void daleteMsg(@RequestParam("nameremoved") String nameremoved){
        msgService.deleteMovie(nameremoved);
    }
}

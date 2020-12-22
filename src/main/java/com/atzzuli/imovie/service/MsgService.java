package com.atzzuli.imovie.service;

import com.atzzuli.imovie.DAO.MsgDAO;
import com.atzzuli.imovie.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Service
public class MsgService {

    @Autowired
    MsgDAO msgDAO;

    /**
     * 查询电影
     * @return
     */
    public List<Movie> retrieveMovie(){
        return msgDAO.retrieveMovie();
    }

    /**
     * 删除电影（用于修改）
     * @param name
     */
    public void deleteMovie(String name){
        msgDAO.deleteMovie(name);
    }

    /**
     * 新增电影（用于修改）
     * @param movie
     */
    public void insertMovie(Movie movie){
        msgDAO.insertMovie(movie);
    }
}

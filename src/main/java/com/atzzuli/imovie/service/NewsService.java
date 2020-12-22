package com.atzzuli.imovie.service;

import com.atzzuli.imovie.DAO.NewsDAO;
import com.atzzuli.imovie.entity.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsService {

    @Autowired
    NewsDAO newsDAO;

    /**
     * 新增新闻
     * @param news
     */
    public void addNews(News news){
        newsDAO.addNews(news);
    }

    /**
     * 删除新闻
     * @param news
     */
    public void deleteNews(String news){
        newsDAO.deleteNews(news);
    }

    /**
     * 查询新闻
     * @return
     */
    public List<News> retrieveNews(){
        return newsDAO.retrieveNews();
    }
}

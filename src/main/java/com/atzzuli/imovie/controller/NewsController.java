package com.atzzuli.imovie.controller;

import com.atzzuli.imovie.entity.News;
import com.atzzuli.imovie.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class NewsController {

    @Autowired
    NewsService newsService;

    /**
     * 查询新闻
     * @return
     */
    @RequestMapping("/retrieveNews")
    @ResponseBody
    public ModelAndView retrieveNews(ModelAndView modelAndView){
        List<News> newsList = newsService.retrieveNews();
        modelAndView.addObject("newsList",newsList);
        modelAndView.setViewName("news");
        return modelAndView;
    }

    /**
     * 新增新闻
     * @param news
     */
    @RequestMapping("/addNews")
    public void insertNews(News news){
        newsService.addNews(news);
    }

    /**
     * 删除新闻
     * @param news
     */
    @RequestMapping("/deleteNews")
    public void deleteNews(@RequestParam("news") String news){
        newsService.deleteNews(news);
    }

    /**
     * 修改新闻
     * @param news
     * @param date
     * @param newsremove
     * @param news1
     */

    @RequestMapping("/updateNews")
    public void updateNews(@RequestParam("news") String news,@RequestParam("date") String date,
                           @RequestParam("newsremove") String newsremove,News news1 ){
        //删除新闻所在行
        newsService.deleteNews(newsremove);
        //插入修改后的新闻数据
        news1.setDate(date);
        news1.setNews(news);
        newsService.addNews(news1);
    }


}

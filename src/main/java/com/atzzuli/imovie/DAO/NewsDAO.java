package com.atzzuli.imovie.DAO;

import com.atzzuli.imovie.entity.News;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface NewsDAO {

    /**
     * 新增新闻
     * @param news
     */
    void addNews(News news);

    /**
     * 删除新闻
     * @param news
     */
    void deleteNews(String news);

    /**
     * 查询新闻
     * @return
     */
    List<News> retrieveNews();

}

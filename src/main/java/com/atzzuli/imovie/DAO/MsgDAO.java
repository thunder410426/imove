package com.atzzuli.imovie.DAO;

import com.atzzuli.imovie.entity.Movie;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MsgDAO {

    /**
     * 查询所有电影信息
     * @return
     */
    List<Movie> retrieveMovie();

    /**
     * 删除电影信息(用于修改)
     * @param name
     */
    void deleteMovie(String name);

    /**
     * 新增电影信息（用于修改）
     * @param movie
     */
    void insertMovie(Movie movie);
}

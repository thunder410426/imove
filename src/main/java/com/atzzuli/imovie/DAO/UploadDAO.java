package com.atzzuli.imovie.DAO;

import com.atzzuli.imovie.entity.Movie;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UploadDAO {

    /**
     * 上传电影
     * @param movie
     */
    void upload(Movie movie);

}

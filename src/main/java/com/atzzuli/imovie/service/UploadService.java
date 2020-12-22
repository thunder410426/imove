package com.atzzuli.imovie.service;

import com.atzzuli.imovie.DAO.UploadDAO;
import com.atzzuli.imovie.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UploadService {

    @Autowired
    UploadDAO uploadDAO;

    public void upload(Movie movie){
        uploadDAO.upload(movie);
    }
}

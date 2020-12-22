package com.atzzuli.imovie.DAO;

import com.atzzuli.imovie.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface LoginDAO {
    /**
     * 注册
     * @param user
     * @return
     */
    User login(User user);
}

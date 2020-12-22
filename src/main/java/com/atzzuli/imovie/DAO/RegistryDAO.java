package com.atzzuli.imovie.DAO;

import com.atzzuli.imovie.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface RegistryDAO {

    /**
     * 注册
     * @param user
     */
    void registry(User user);

    /**
     * 查询是否已经注册
     * @param username
     * @return
     */
    String ifregistry(String username);
}

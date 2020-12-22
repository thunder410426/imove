package com.atzzuli.imovie.DAO;

import com.atzzuli.imovie.entity.Type;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TypeDAO {

    /**
     * 新增类别
     * @param type
     */
    void addType(Type type);

    /**
     * 查找类别
     * @return
     */
    List<Type> retrieveType();


    /**
     * 删除类别
     * @param type
     */
    void deleteType(Type type);
/*

    */
/**
     * 查找类别
     * @param type
     * @return
     *//*

    Type retriveTypeById(Type type);

    */
/**
     * 修改类别
     * @param type
     * @return
     *//*


    void updateType(Type type);
*/


}

package com.hongtian.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.List;

/**
 * @author weed
 * @date 2020/11/30 0030 10:35
 * @description
 */
public abstract class BaseDao<T> {

    @Autowired
    protected MongoTemplate mongoTemplate;

    // 返回失败数
    public abstract void insert(List<T> list);

    public void insert(T t) {
        mongoTemplate.insert(t);
    }

    public void insert(T t,String collectionName) {
        mongoTemplate.insert(t,collectionName);
    }

    public void save(T t,String collectionName){
        try {
            mongoTemplate.save(t,collectionName);
        } catch (Exception e) {
            System.out.println("2222");
        }
    }

    public void save(T t){
        mongoTemplate.save(t);
    }
}
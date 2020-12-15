package com.hongtian.dao.redisDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author weed
 * @date 2020/12/15 0015 14:06
 * @description 操作人脸抓拍记录
 */
@Repository
public class RlzpjlRedisDao {

    @Autowired
    private RedisTemplate redisTemplate;

    // 增加人脸抓拍记录
    public void insert() {}

    // 取出人脸抓拍记录
}

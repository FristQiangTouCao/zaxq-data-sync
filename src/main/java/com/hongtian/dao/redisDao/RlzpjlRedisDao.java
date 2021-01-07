package com.hongtian.dao.redisDao;

import com.hongtian.entity.PztJmxqRlzpjlDahua;
import com.hongtian.service.PztJmxqRlzpjlDahuaService;
import com.hongtian.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * @author weed
 * @date 2020/12/15 0015 14:06
 * @description 操作人脸抓拍记录
 */
@Repository
public class RlzpjlRedisDao {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private PztJmxqRlzpjlDahuaService pztJmxqRlzpjlDahuaService;

    // 增加人脸抓拍记录
    public void sdfds() {

    }

    public void insertList(List<PztJmxqRlzpjlDahua> list) {
        ArrayList<PztJmxqRlzpjlDahua> pztJmxqRlzpjlDahuas = new ArrayList<>(list);
        redisTemplate.opsForList().leftPush(Constant.REDIS_RLZPLD,pztJmxqRlzpjlDahuas);
    }

    // 取出人脸抓拍记录
    public List<PztJmxqRlzpjlDahua> getList() {
        Object o = redisTemplate.opsForList().rightPop(Constant.REDIS_RLZPLD);
        return  o == null ? new ArrayList<>() : (List<PztJmxqRlzpjlDahua>)o;
    }

    public long getSize() {
        return redisTemplate.opsForList().size(Constant.REDIS_RLZPLD);
    }
}

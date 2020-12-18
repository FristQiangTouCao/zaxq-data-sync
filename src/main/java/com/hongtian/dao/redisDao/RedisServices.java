package com.hongtian.dao.redisDao;

import com.hongtian.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * @author weed
 * @date 2020/12/18 0018 14:02
 * @description
 */
@Component
public class RedisServices {

    @Autowired
    private RedisTemplate redisTemplate;

    public HashMap<String, Object> getRedisInfo() {
        HashMap<String, Object> map = new HashMap<>();
        Properties info = redisTemplate.getRequiredConnectionFactory().getConnection().info();
        map.put("keysInfo",keysInfo());
        Set<Object> objects = info.keySet();
        for(Object o:objects) {
            map.put(String.valueOf(o),info.get(o));
        }
        return map;
    }

    public List<HashMap<String, Object>> keysInfo() {
        List<HashMap<String, Object>> list = new ArrayList<>();
        list.add(createMap(Constant.REDIS_RYJB,redisTemplate.opsForHash().size(Constant.REDIS_RYJB)));
        list.add(createMap(Constant.REDIS_JCSS,redisTemplate.opsForSet().size(Constant.REDIS_JCSS)));
        list.add(createMap(Constant.REDIS_RLZPLD,redisTemplate.opsForList().size(Constant.REDIS_RLZPLD)));
        return list;
    }

    public HashMap<String, Object> createMap(String key,Object value) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("key",key);
        map.put("value",value);
        return map;
    }
}

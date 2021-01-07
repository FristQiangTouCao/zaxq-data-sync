package com.hongtian.dao.redisDao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hongtian.entity.PztRyJb;
import com.hongtian.mapper.PztRyJbMapper;
import com.hongtian.util.Constant;
import com.hongtian.util.DateTimeUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * @author weed
 * @date 2020/12/18 0018 10:57
 * @description
 */
@Component
@Slf4j
public class PztRyJbRedisDao {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private PztRyJbMapper pztRyJbMapper;

    @Value("${start-redis-cache:false}")
    private boolean startRedisCache;

    /**
     * 加载所有的人员数据
     */
    @PostConstruct
    public void init() {
        if(!startRedisCache) return;
        QueryWrapper<PztRyJb> query = new QueryWrapper<>();
        if(size() > 0) {
            query.ge("cjsj", DateTimeUtils.addDays(DateTimeUtils.now(),-30));
        }
        int page = 0,size = 10000;
        log.info("人员基本信息开始加载。。。。");
        while(true) {
            Page<PztRyJb> ryJbPage = new Page<>(page, size);
            Page<PztRyJb> result = pztRyJbMapper.selectPage(ryJbPage, query);
            List<PztRyJb> records = result.getRecords();
            if(CollectionUtils.isEmpty(records)) {
                break;
            }
            records.forEach(item -> {
                insert(item);
            });
            page++;
        }
        log.info("人员基本信息加载完毕！");
    }




    public void insert(PztRyJb pztRyJb) {
        if(StringUtils.isEmpty(pztRyJb.getGmsfhm())) return;
        redisTemplate.opsForHash().put(Constant.REDIS_RYJB,pztRyJb.getGmsfhm(),pztRyJb.getXm());
    }

    public String get(String gmsfhm) {
        Object o = redisTemplate.opsForHash().get(Constant.REDIS_RYJB, gmsfhm);
        return o == null ? null : (String) o;
    }
    public long size() {
        return redisTemplate.opsForHash().size(Constant.REDIS_RYJB);
    }

}

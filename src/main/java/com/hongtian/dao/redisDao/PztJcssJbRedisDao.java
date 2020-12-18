package com.hongtian.dao.redisDao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hongtian.entity.PztJcssJb;
import com.hongtian.mapper.PztJcssJbMapper;
import com.hongtian.util.Constant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * @author weed
 * @date 2020/12/18 0018 11:08
 * @description
 */
@Component
@Slf4j
public class PztJcssJbRedisDao {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private PztJcssJbMapper pztJcssJbMapper;

    /**
     * 加载人脸设备和一体机的基本信息
     */
    @PostConstruct
    public void init() {
        int page = 0,size = 10000;
        QueryWrapper query = new QueryWrapper();
        query.in("sslx","SS18","SS20");
        log.info("基础设施基本信息开始加载。。。。");
        while(true) {
            Page<PztJcssJb> ryJbPage = new Page<>(page, size);
            Page<PztJcssJb> result = pztJcssJbMapper.selectPage(ryJbPage, new QueryWrapper<>());
            List<PztJcssJb> records = result.getRecords();
            if(CollectionUtils.isEmpty(records)) {
                break;
            }
            records.forEach(item -> {
                insert(item);
            });
            page++;
        }
        log.info("基础设施基本信息加载完毕！");
    }

    public void insert(PztJcssJb pztJcssJb) {
        if(StringUtils.isEmpty(pztJcssJb.getSsbh())) return;
        redisTemplate.opsForSet().add(Constant.REDIS_JCSS,pztJcssJb.getSsbh());
    }


    public boolean contains(String ssbh) {
        return redisTemplate.opsForSet().isMember(Constant.REDIS_JCSS, ssbh);
    }

    public long size() {
        return  redisTemplate.opsForSet().size(Constant.REDIS_JCSS);
    }
}

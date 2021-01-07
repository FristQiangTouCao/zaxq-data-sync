package com.hongtian.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hongtian.dao.redisDao.PztJcssJbRedisDao;
import com.hongtian.entity.PztJcssJb;
import com.hongtian.mapper.PztJcssJbMapper;
import com.hongtian.service.PztJcssJbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 基础设施 服务实现类
 * </p>
 *
 * @author weed
 * @since 2020-12-15
 */
@Service
public class PztJcssJbServiceImpl extends ServiceImpl<PztJcssJbMapper, PztJcssJb> implements PztJcssJbService {

    @Autowired
    private PztJcssJbRedisDao pztJcssJbRedisDao;

    @Autowired
    private PztJcssJbMapper pztJcssJbMapper;

    @Value("${start-redis-cache:false}")
    private boolean startRedisCache;

    @Override
    public boolean existsJcss(String ssbh) {
        boolean contain = false;
        if(startRedisCache) {
            contain = pztJcssJbRedisDao.contains(ssbh);
        } else{
            QueryWrapper query = new QueryWrapper();
            query.eq("ssbh",ssbh);
            query.eq("yxbz","1");
            List list = pztJcssJbMapper.selectList(query);
            contain = list.size() > 0 ? true:false;
        }
        return contain;
    }
}

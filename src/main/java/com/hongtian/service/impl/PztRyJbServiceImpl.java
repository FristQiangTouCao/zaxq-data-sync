package com.hongtian.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hongtian.dao.redisDao.PztRyJbRedisDao;
import com.hongtian.entity.PztRyJb;
import com.hongtian.mapper.PztRyJbMapper;
import com.hongtian.service.PztRyJbService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author weed
 * @since 2020-12-15
 */
@Service
public class PztRyJbServiceImpl extends ServiceImpl<PztRyJbMapper, PztRyJb> implements PztRyJbService {

    @Autowired
    private PztRyJbRedisDao pztRyJbRedisDao;

    @Autowired
    private PztRyJbMapper pztRyJbMapper;

    @Value("${start-redis-cache:false}")
    private boolean startRedisCache;


    @Override
    public PztRyJb matchByGmsfzhm(String gmsfzhm) {
        PztRyJb pztRyJb = null;
        if(startRedisCache) {
            String xm = pztRyJbRedisDao.get(gmsfzhm);
            if(xm == null){
                return null;
            }
            pztRyJb = new PztRyJb();
            pztRyJb.setXm(xm);
            pztRyJb.setGmsfhm(gmsfzhm);
        } else {
            QueryWrapper<PztRyJb> query = new QueryWrapper();
            query.eq("gmsfhm",gmsfzhm);
            List<PztRyJb> list = pztRyJbMapper.selectList(query);
            pztRyJb = list.size()> 0 ? list.get(0) : null;
        }
        return pztRyJb;
    }
}

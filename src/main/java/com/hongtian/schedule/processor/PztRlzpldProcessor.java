package com.hongtian.schedule.processor;

import com.hongtian.component.PztJmxqRlzpjlLdOperator;
import com.hongtian.dao.redisDao.RlzpjlRedisDao;
import com.hongtian.entity.PztJmxqRlzpjlDahua;
import com.hongtian.entity.SjClLog;
import com.hongtian.mapper.PztJmxqRlzpjlDahuaBackMapper;
import com.hongtian.schedule.BaseProcessor;
import com.hongtian.schedule.Job;
import com.hongtian.schedule.ThreadPool;
import com.hongtian.service.PztJcssJbService;
import com.hongtian.service.PztJmxqRlzpjlDahuaService;
import com.hongtian.service.PztRyJbService;
import com.hongtian.service.PztRyRlzpjlService;
import com.hongtian.util.ThreadUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author weed
 * @date 2020/12/18 0018 9:58
 * @description 人脸抓拍落地
 */
@Component
@Slf4j
public class PztRlzpldProcessor extends BaseProcessor<PztJmxqRlzpjlDahua> {

    @Autowired
    private PztJmxqRlzpjlDahuaService pztJmxqRlzpjlDahuaService;
    @Autowired
    private PztRyRlzpjlService pztRyRlzpjlService;
    @Autowired
    private RlzpjlRedisDao rlzpjlRedisDao;


    @Autowired
    private PztRyJbService pztRyJbService;

    @Autowired
    private PztJcssJbService pztJcssJbService;

    @Autowired
    private com.hongtian.dao.mongo.SjClLogDao sjClLogDao;

    @Autowired
    private PztJmxqRlzpjlDahuaBackMapper pztJmxqRlzpjlDahuaBackMapper;



    private ThreadPool threadPool;

    @Override
    public Job getType() {
        return Job.RY_RLZPJL_LD;
    }

    @PostConstruct
    public void init() {
        this.threadPool = new ThreadPool();
        this.threadPool.init(30,30);
        log.info("落地数据线程池初始化完成，核心线程：30,最大线程：30.");
    }

    @Override
    public void execute(SjClLog SjClLog) {
        for(int i = 0; i < 30; i++) {
            threadPool.excute(new PztJmxqRlzpjlLdOperator(rlzpjlRedisDao,pztRyRlzpjlService,pztJmxqRlzpjlDahuaService,
                    SjClLog,this,pztRyJbService,pztJcssJbService,pztJmxqRlzpjlDahuaBackMapper));
            ThreadUtils.sleep(100);
        }
        // 将处理线程放入线程池中
        while(true) {
            if (threadPool.activeThreadCount() == 0) {
                break;
            }else {
                if(rlzpjlRedisDao.getSize() > 100 && threadPool.activeThreadCount() < 10) {
                    for(int i = 0 ; i < (30-threadPool.activeThreadCount()); i++) {
                        threadPool.excute(new PztJmxqRlzpjlLdOperator(rlzpjlRedisDao,pztRyRlzpjlService,pztJmxqRlzpjlDahuaService,
                                SjClLog,this,pztRyJbService,pztJcssJbService,pztJmxqRlzpjlDahuaBackMapper));
                        ThreadUtils.sleep(100);
                    }
                }
            }
//            log.warn("落地线程活动数量：{}。",threadPool.activeThreadCount());
            ThreadUtils.sleep(10000);
        }
    }

    public void updateLog(String id,int count) {
        Update update = new Update();
        update.inc("total",count);
        update.inc("successCount",count);
        update.set("updateTime", System.currentTimeMillis());
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(id));
        sjClLogDao.update(query,update,"sjClLog");
        processorContext.processorUpdateTime(this);
    }

    @Override
    public void updateLog(SjClLog SjClLog) {

    }
}

package com.hongtian.schedule.processor;

import com.hongtian.component.PztJmxqRlzpjlLdOperator;
import com.hongtian.dao.redisDao.PztJcssJbRedisDao;
import com.hongtian.dao.redisDao.PztRyJbRedisDao;
import com.hongtian.dao.redisDao.RlzpjlRedisDao;
import com.hongtian.entity.PztJmxqRlzpjlDahua;
import com.hongtian.entity.SjClLog;
import com.hongtian.schedule.BaseProcessor;
import com.hongtian.schedule.Job;
import com.hongtian.schedule.ThreadPool;
import com.hongtian.service.PztJmxqRlzpjlDahuaService;
import com.hongtian.service.PztRyRlzpjlService;
import com.hongtian.util.ThreadUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
    private RlzpjlRedisDao rlzpjlRedisDao;
    @Autowired
    private PztRyJbRedisDao pztRyJbRedisDao;
    @Autowired
    private PztJcssJbRedisDao pztJcssJbRedisDao;
    @Autowired
    private PztRyRlzpjlService pztRyRlzpjlService;

    @Autowired
    private com.hongtian.dao.mongo.SjClLogDao sjClLogDao;


    private ThreadPool threadPool;

    @Override
    public Job getType() {
        return Job.RY_RLZPJL_LD;
    }

    @PostConstruct
    public void init() {
        this.threadPool = new ThreadPool();
        this.threadPool.init(10,100);
        log.info("落地数据线程池初始化完成，核心线程：10,最大线程：100.");
    }

    @Override
    public void execute(SjClLog SjClLog) {
        for(int i = 0; i < 100; i++) {
            threadPool.excute(new PztJmxqRlzpjlLdOperator(rlzpjlRedisDao,pztRyJbRedisDao,pztJcssJbRedisDao,
                    pztRyRlzpjlService,pztJmxqRlzpjlDahuaService,SjClLog,this));
        }
        // 将处理线程放入线程池中
        while(true) {
            if (threadPool.activeThreadCount() == 0) {
                break;
            }
            ThreadUtils.sleep(2000);
        }
    }

    public void updateLog(String id,int count) {
        synchronized (PztRlzpldProcessor.class) {
            SjClLog sjClLog = sjClLogDao.getById(id);
            sjClLog.setTotal(sjClLog.getTotal() + count);
            sjClLog.setSuccessCount(sjClLog.getSuccessCount() + count);
            sjClLog.setUpdateTime(System.currentTimeMillis());
            sjClLogDao.save(sjClLog);
        }
    }
}

package com.hongtian.schedule;

import com.hongtian.dao.SjBfLogDao;
import com.hongtian.entity.SjBfLog;
import com.hongtian.util.DateTimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;

/**
 * @author weed
 * @date 2020/11/30 0030 10:25
 * @description
 */
public abstract class BaseProcessor<T> {

    @Autowired
    private ProcessorContext processorContext;

    // 启动时间
    protected long startTime;

    // 最后执行时间
    protected long lastActiveTime;

    // 执行状态
    protected boolean executeStatus = false;

    // 最后一次执行结果0:程序重启空闲,1:执行中,2:成功，3:失败
    protected int resultCode = 0;

    @Autowired
    protected MongoTemplate mongoTemplate;

    @Autowired
    protected SjBfLogDao sjBfLogDao;

    private String corn;

    // 任务名称
    public abstract Job getType();

    // 执行间隔时间
    public abstract JobProcessorIntervalTime intervalTime();


    // 启用多线程
    public boolean startThreadPool(){
        return false;
    }

    @Scheduled(cron = "0 */1 * * * ?")
    public void run() {
        System.out.println("执行"+new Date()+getType());
        SjBfLog sjBfLog = executeBefore();
        try {
            execute(sjBfLog);
            sjBfLog.setStatus(1);
            resultCode = 2;
        }catch (Exception e) {
            sjBfLog.setStatus(2);
            e.printStackTrace();
            sjBfLog.setBz(e.getMessage());
            resultCode = 3;
        }finally {
            executeAfter();
            sjBfLog.setEndTime(DateTimeUtils.now());
            updateLog(sjBfLog);
            executeStatus = false;
            lastActiveTime = System.currentTimeMillis();
        }
    }

    public SjBfLog executeBefore() {
        processorContext.processorStart(this);
        startTime = System.currentTimeMillis();
        executeStatus = true;
        resultCode = 1;
        lastActiveTime = startTime;
        SjBfLog sjBfLog = new SjBfLog();
        sjBfLog.setStatus(0);
        sjBfLog.setStartTime(DateTimeUtils.now());
        sjBfLog.setType(getType().getName());
        return sjBfLog;
    }

    public void execute(SjBfLog sjBfLog) {
        throw new NullPointerException("此方法需要实现！");
    }

    public void executeAfter() {
        processorContext.processorEnd(this);
    }

    public void updateLog(SjBfLog sjBfLog) {
        sjBfLog.setUpdateTime(DateTimeUtils.now());
        sjBfLogDao.save(sjBfLog);
    }

}

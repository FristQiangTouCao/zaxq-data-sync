package com.hongtian.schedule;

import com.hongtian.dao.mongo.SjClLogDao;
import com.hongtian.entity.SjClLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * @author weed
 * @date 2020/11/30 0030 10:25
 * @description
 */
public abstract class BaseProcessor<T> {

    @Autowired
    protected ProcessorContext processorContext;

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
    protected SjClLogDao SjClLogDao;

    private String corn;

    // 任务名称
    public abstract Job getType();


    // 启用多线程 -- 目前没有实现
    public boolean startThreadPool(){
        return false;
    }


    public void run() {
        SjClLog SjClLog = executeBefore();
        try {
            execute(SjClLog);
            SjClLog.setStatus(1);
            resultCode = 2;
        }catch (Exception e) {
            SjClLog.setStatus(2);
            e.printStackTrace();
            SjClLog.setBz(e.getMessage());
            resultCode = 3;
        }finally {
            executeAfter();
            SjClLog.setEndTime(System.currentTimeMillis());
            updateLog(SjClLog);
            executeStatus = false;
            lastActiveTime = System.currentTimeMillis();
        }
    }

    public SjClLog executeBefore() {
        processorContext.processorStart(this);
        startTime = System.currentTimeMillis();
        executeStatus = true;
        resultCode = 1;
        lastActiveTime = startTime;
        SjClLog SjClLog = new SjClLog();
        SjClLog.setStatus(0);
        SjClLog.setStartTime(startTime);
        SjClLog.setType(getType().getName());
        SjClLogDao.insert(SjClLog);
        return SjClLog;
    }

    public void execute(SjClLog SjClLog) {
        throw new NullPointerException("此方法需要实现！");
    }

    public void executeAfter() {
        processorContext.processorEnd(this);
    }

    public void updateLog(SjClLog SjClLog) {
        SjClLog.setUpdateTime(System.currentTimeMillis());
        SjClLogDao.save(SjClLog);
    }

}

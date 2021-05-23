package com.hongtian.xxl_job;


import com.hongtian.schedule.processor.PztRlzpldProcessor;
import com.xxl.job.core.handler.annotation.XxlJob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 落地数据处理
 */
@Component
public class LdsjclJob {

    @Autowired
    private PztRlzpldProcessor pztRlzpldProcessor;

    @XxlJob("LdsjclJob")
    public void handle() {
        pztRlzpldProcessor.run();
    }




}

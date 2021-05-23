package com.hongtian.xxl_job;

import com.hongtian.schedule.processor.PztPztClcrjlSbJobProcessor;
import com.xxl.job.core.handler.annotation.XxlJob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 车辆上报
 */
@Component
public class ClSbJob {

    @Autowired
    private PztPztClcrjlSbJobProcessor pztPztClcrjlSbJobProcessor;

    @XxlJob("ClSbJob")
    public void handle() {
        pztPztClcrjlSbJobProcessor.run();
    }
}

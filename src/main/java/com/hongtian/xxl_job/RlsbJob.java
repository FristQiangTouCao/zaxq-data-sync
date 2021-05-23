package com.hongtian.xxl_job;

import com.hongtian.schedule.processor.PztRyrlapjlSbJobProcessor;
import com.xxl.job.core.handler.annotation.XxlJob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 人脸上报 30天以前
 */
@Component
public class RlsbJob {

    @Autowired
    private PztRyrlapjlSbJobProcessor pztRyrlapjlSbJobProcessor;

    @XxlJob("RlsbJob")
    public void handle() {
        pztRyrlapjlSbJobProcessor.run();
    }

}

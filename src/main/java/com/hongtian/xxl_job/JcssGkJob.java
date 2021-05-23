package com.hongtian.xxl_job;

import com.hongtian.schedule.processor.JcssGkProcessor;
import com.xxl.job.core.handler.annotation.XxlJob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 基础设施概况统计
 */
@Component
public class JcssGkJob {

    @Autowired
    private JcssGkProcessor jcssGkProcessor;

    @XxlJob("JcssGkJob")
    public void handle() {
        jcssGkProcessor.run();
    }
}

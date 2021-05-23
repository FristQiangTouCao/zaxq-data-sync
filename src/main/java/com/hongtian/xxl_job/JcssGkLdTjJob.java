package com.hongtian.xxl_job;

import com.hongtian.schedule.processor.JcssGkLdTj;
import com.xxl.job.core.handler.annotation.XxlJob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 基础设施落地数据统计任务
 */
@Component
public class JcssGkLdTjJob {

    @Autowired
    private JcssGkLdTj jcssGkLdTj;

    @XxlJob("JcssGkLdTjJob")
    public void handle() {
        jcssGkLdTj.run();
    }
}

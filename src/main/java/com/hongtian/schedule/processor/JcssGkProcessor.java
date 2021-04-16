package com.hongtian.schedule.processor;

import com.hongtian.component.JcssGkTjOperator;
import com.hongtian.entity.PztJmxqRlzpjlDahua;
import com.hongtian.entity.SjClLog;
import com.hongtian.mapper.PztJcssJbMapper;
import com.hongtian.schedule.BaseProcessor;
import com.hongtian.schedule.Job;
import com.hongtian.service.PztJcssJbService;
import com.hongtian.service.PztJmxqRlzpjlDahuaService;
import com.hongtian.service.PztJmxqSsgkService;
import com.hongtian.service.PztRyRlzpjlService;
import com.hongtian.util.DateTimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author weed
 * @date 2021/1/7 0007 13:58
 * @description
 */
@Component
public class JcssGkProcessor extends BaseProcessor<PztJmxqRlzpjlDahua> {
    @Autowired
    private PztJcssJbMapper pztJcssJbMapper;
    @Autowired
    private PztJmxqSsgkService pztJmxqSsgkService;
    @Autowired
    private PztJcssJbService pztJcssJbService;
    @Autowired
    private PztJmxqRlzpjlDahuaService pztJmxqRlzpjlDahuaService;
    @Autowired
    private PztRyRlzpjlService pztRyRlzpjlService;

    @Override
    public Job getType() {
        return Job.JCSS_GK;
    }

    @Override
    public void execute(SjClLog SjClLog) {
        String dqrq = DateTimeUtils.today();
        JcssGkTjOperator jcssGkTjOperator = new JcssGkTjOperator(
                pztJcssJbMapper, pztJmxqSsgkService, pztJcssJbService,
                pztJmxqRlzpjlDahuaService, pztRyRlzpjlService
        );
        jcssGkTjOperator.compute(DateTimeUtils.addDays(dqrq,-1));
        jcssGkTjOperator.compute(dqrq);
        processorContext.processorUpdateTime(this);
    }
}

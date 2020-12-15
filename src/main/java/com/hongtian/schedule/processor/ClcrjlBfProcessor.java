package com.hongtian.schedule.processor;

import com.hongtian.dao.PztClCrjlDao;
import com.hongtian.entity.PztClCrjl;
import com.hongtian.schedule.BaseProcessor;
import com.hongtian.schedule.Job;
import com.hongtian.schedule.JobProcessorIntervalTime;
import com.hongtian.service.PztClCrjlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author weed
 * @date 2020/11/30 0030 10:20
 * @description 车辆出入记录同步
 */
@Component
public class ClcrjlBfProcessor extends BaseProcessor<PztClCrjl> {

    @Autowired
    private PztClCrjlService pztClCrjlService;

    @Autowired
    private PztClCrjlDao pztClCrjlDao;


    @Override
    public Job getType() {
        return Job.CL_CRJL_BACK;
    }

    @Override
    public JobProcessorIntervalTime intervalTime() {
        return JobProcessorIntervalTime.TEN_MINUTES;
    }
}

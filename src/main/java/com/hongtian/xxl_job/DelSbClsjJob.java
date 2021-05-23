package com.hongtian.xxl_job;

import com.hongtian.schedule.DeletePztClcrjl;
import com.xxl.job.core.handler.annotation.XxlJob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 删除上报车辆数据
 */
@Component
public class DelSbClsjJob {

    @Autowired
    private DeletePztClcrjl deletePztClcrjl;
    @XxlJob("DelSbClsjJob")
    public void handle() {
        deletePztClcrjl.delete();
    }
}

package com.hongtian.xxl_job;

import com.hongtian.schedule.DeletePztRyrlzpjl;
import com.xxl.job.core.handler.annotation.XxlJob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 删除上报的人脸数据
 */
@Component
public class DelSbRlsjJob {

    @Autowired
    private DeletePztRyrlzpjl deletePztRyrlzpjl;

    @XxlJob("DelSbRlsjJob")
    public void handle() {
        deletePztRyrlzpjl.delete();
    }

}

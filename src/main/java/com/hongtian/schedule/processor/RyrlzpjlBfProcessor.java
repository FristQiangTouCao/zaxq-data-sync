package com.hongtian.schedule.processor;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hongtian.dao.PztRyrlzpjlDao;
import com.hongtian.entity.PztRyRlzpjl;
import com.hongtian.entity.SjBfLog;
import com.hongtian.schedule.BaseProcessor;
import com.hongtian.schedule.Job;
import com.hongtian.schedule.JobProcessorIntervalTime;
import com.hongtian.service.PztRyRlzpjlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author weed
 * @date 2020/11/30 0030 10:21
 * @description 人员抓拍记录同步
 */
@Component
public class RyrlzpjlBfProcessor extends BaseProcessor<PztRyRlzpjl> {
    @Autowired
    private PztRyRlzpjlService pztRyRlzpjlService;

    @Autowired
    private PztRyrlzpjlDao pztRyrlzpjlDao;
    @Override
    public Job getType() {
        return Job.RY_LZPJL_BACK;
    }

    @Override
    public JobProcessorIntervalTime intervalTime() {
        return JobProcessorIntervalTime.TEN_MINUTES;
    }

    @Override
    public void execute(SjBfLog sjBfLog) {
        boolean recordedTotal = false;
        while(true){
            // 获取记录
            Page<PztRyRlzpjl> page  = pztRyRlzpjlService.getUnHandleJl();
            List<PztRyRlzpjl> list = page.getRecords();
            if(CollectionUtils.isEmpty(list)) {
                break;
            }
            // 备份记录
            pztRyrlzpjlDao.insert(list);
            // 更新日志
            if(!recordedTotal) {
                sjBfLog.setTotal((int)page.getTotal());
                recordedTotal = true;
            }
            sjBfLog.setSuccessCount(sjBfLog.getSuccessCount() + list.size());
            updateLog(sjBfLog);
        }
    }
}

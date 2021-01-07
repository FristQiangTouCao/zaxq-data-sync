package com.hongtian.schedule.processor;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hongtian.dao.PztClCrjlDao;
import com.hongtian.entity.PztClCrjl;
import com.hongtian.entity.SjClLog;
import com.hongtian.schedule.BaseProcessor;
import com.hongtian.schedule.Job;
import com.hongtian.service.PztClCrjlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;

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
    public void execute(SjClLog SjClLog) {
        while(true){
            // 获取记录
            Page<PztClCrjl> page  = pztClCrjlService.getUnHandleJl();
            List<PztClCrjl> list = page.getRecords();
            if(CollectionUtils.isEmpty(list)) {
                break;
            }
            // 备份记录
            pztClCrjlDao.insert(list);
            // 更新日志
            SjClLog.setTotal(SjClLog.getTotal() + list.size());
            SjClLog.setSuccessCount(SjClLog.getSuccessCount() + list.size());
            updateLog(SjClLog);
            processorContext.processorUpdateTime(this);
        }
    }

}

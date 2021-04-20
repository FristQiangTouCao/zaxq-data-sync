package com.hongtian.schedule.processor;

import com.hongtian.component.PztRyrlzpjlSbComponent;
import com.hongtian.entity.PztRyRlzpjl;
import com.hongtian.entity.SjClLog;
import com.hongtian.mapper.PztRyRlzpjlMapper;
import com.hongtian.schedule.BaseProcessor;
import com.hongtian.schedule.Job;
import com.hongtian.service.PztRyRlzpjlYjxgService;
import com.hongtian.util.DateTimeUtils;
import com.hongtian.util.ThreadUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author weed
 * @date 2021/4/20 0020 14:23
 * @description
 */
@Slf4j
@Component
public class PztRyrlapjlSbJobProcessor extends BaseProcessor<PztRyRlzpjl> {

    @Autowired
    private PztRyRlzpjlMapper pztRyRlzpjlMapper;

    @Autowired
    private PztRyRlzpjlYjxgService pztRyRlzpjlYjxgService;


    volatile int thread = 0;

    volatile int total = 0;
    @Override
    public Job getType() {
        return Job.PZT_RY_RLZPJL_SB;
    }

    @Override
    public void execute(SjClLog sjClLog) {
        for(int i = 0; i < 5; i++){
            new Thread(new runnable(),i*2+"").start();
        }
        while(true) {
            ThreadUtils.sleep(5000);
            if(thread == 0) {
                break;
            }else {
                sjClLog.setTotal(total);
                sjClLog.setSuccessCount(total);
                sjClLog.setUpdateTime(System.currentTimeMillis());
                SjClLogDao.save(sjClLog);
                log.info("更新人脸数据上报日志：total:{}",total);
            }
        }
    }


    public class runnable implements Runnable{
        public PztRyrlzpjlSbComponent sbComponent = new PztRyrlzpjlSbComponent(pztRyRlzpjlMapper,pztRyRlzpjlYjxgService);
        @Override
        public void run() {
            thread++;
            int startPage = Integer.parseInt(Thread.currentThread().getName());
            while(true) {
                int page = startPage;
                List<PztRyRlzpjl> list = getList(page,1000);
                if(CollectionUtils.isEmpty(list) ){
                    break;
                }
                sbComponent.upload(list);
                total += list.size();
            }
            thread--;
        }
    }

    public List<PztRyRlzpjl> getList(int page, int size) {
        int start  = page * size;
        int end  = (page + 1) * size;
        List<PztRyRlzpjl> ryrlapjlByStartAndEnd = pztRyRlzpjlMapper.getRyrlapjlByStartAndEndCurrentMonth(start, end,DateTimeUtils.addDays(DateTimeUtils.today(),-30));
        return ryrlapjlByStartAndEnd;
    }
}

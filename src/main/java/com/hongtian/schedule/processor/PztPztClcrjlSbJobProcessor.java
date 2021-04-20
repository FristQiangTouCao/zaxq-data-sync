package com.hongtian.schedule.processor;

import com.hongtian.component.PztClcrjlSbComponent;
import com.hongtian.entity.PztClCrjl;
import com.hongtian.entity.SjClLog;
import com.hongtian.mapper.PztClCrjlMapper;
import com.hongtian.schedule.BaseProcessor;
import com.hongtian.schedule.Job;
import com.hongtian.service.PztClCrjlYjxgService;
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
public class PztPztClcrjlSbJobProcessor extends BaseProcessor<PztClCrjl> {

    @Autowired
    private PztClCrjlMapper pztClCrjlMapper;

    @Autowired
    private PztClCrjlYjxgService pztClCrjlYjxgService;


    volatile int thread = 0;

    volatile int total = 0;
    @Override
    public Job getType() {
        return Job.PZT_CL_CRJL_SB;
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
        public PztClcrjlSbComponent sbComponent = new PztClcrjlSbComponent(pztClCrjlMapper,pztClCrjlYjxgService);
        @Override
        public void run() {
            thread++;
            int startPage = Integer.parseInt(Thread.currentThread().getName());
            while(true) {
                int page = startPage;
                List<PztClCrjl> list = getList(page,1000);
                if(CollectionUtils.isEmpty(list) ){
                    break;
                }
                sbComponent.upload(list);
                total += list.size();
            }
            thread--;
        }
    }

    public List<PztClCrjl> getList(int page, int size) {
        int start  = page * size;
        int end  = (page + 1) * size;
        List<PztClCrjl> ryrlapjlByStartAndEnd = pztClCrjlMapper.getClcrjljlByStartAndEndCurrentMonth(start, end,DateTimeUtils.addDays(DateTimeUtils.today(),-30));
        return ryrlapjlByStartAndEnd;
    }
}

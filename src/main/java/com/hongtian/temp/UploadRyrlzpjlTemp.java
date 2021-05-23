package com.hongtian.temp;

import com.hongtian.component.PztRyrlzpjlSbComponentTemp;
import com.hongtian.dao.mongo.SjClLogDao;
import com.hongtian.entity.PztRyRlzpjl;
import com.hongtian.entity.SjClLog;
import com.hongtian.mapper.PztRyRlzpjlMapper;
import com.hongtian.schedule.Job;
import com.hongtian.service.PztRyRlzpjlYjxgService;
import com.hongtian.util.DateTimeUtils;
import com.hongtian.util.ThreadUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author weed
 * @date 2021/4/19 0019 10:38
 * @description 上传人员人脸抓拍
 */
@Service
@Slf4j
public class UploadRyrlzpjlTemp {

    @Autowired
    private PztRyRlzpjlMapper pztRyrlzpjlDao;

    @Autowired
    private PztRyRlzpjlYjxgService pztRyRlzpjlYjxgService;

    @Autowired
    private SjClLogDao sjClLogDao;

    volatile int total = 0;

    public void upload(int threadCount) {
        SjClLog sjClLog = new SjClLog();
        sjClLog.setStatus(0);
        sjClLog.setStartTime(System.currentTimeMillis());
        sjClLog.setType(Job.PZT_RY_RLZPJL_SB.getName());
        sjClLogDao.insert(sjClLog);
        for(int i = 0; i < threadCount;i++) {
            new Thread(new runnable(),i*2 + "").start();
        }
        // 更新上传数量
        new Thread(new Runnable() {
            int record = 0;
            long time = System.currentTimeMillis();
            @Override
            public void run() {
                while(true) {
                    if(record != total) {
                        sjClLog.setTotal(total);
                        sjClLog.setSuccessCount(total);
                        sjClLog.setUpdateTime(System.currentTimeMillis());
                        sjClLogDao.save(sjClLog);
                        record = total;
                        log.info("更新人脸数据上报日志：total:{}",total);
                    }else {
                        if(System.currentTimeMillis() - time > 3600000){
                            break;
                        }
                    }
                    ThreadUtils.sleep(2000);
                }
            }
        });
    }

    public class runnable implements Runnable{
        public PztRyrlzpjlSbComponentTemp sbComponent = new PztRyrlzpjlSbComponentTemp(pztRyrlzpjlDao,pztRyRlzpjlYjxgService);
        @Override
        public void run() {
            int startPage = Integer.parseInt(Thread.currentThread().getName());
            while(true) {
                int page = startPage;
                List<PztRyRlzpjl> list = getList(page,1000);
                if(CollectionUtils.isEmpty(list) ||
                        DateTimeUtils.addDays(DateTimeUtils.today(),-30).compareTo(list.get(0).getJlsj()) < 0){
                    break;
                }
                sbComponent.upload(list);
                total += list.size();
            }
        }
    }

    public List<PztRyRlzpjl> getList(int page, int size) {
        int start  = page * size;
        int end  = (page + 1) * size;
        List<PztRyRlzpjl> ryrlapjlByStartAndEnd = pztRyrlzpjlDao.getRyrlapjlByStartAndEnd(start, end,"20210101");
        return ryrlapjlByStartAndEnd;
    }
}

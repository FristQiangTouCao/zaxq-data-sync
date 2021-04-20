package com.hongtian.schedule;

import com.hongtian.mapper.PztClCrjlMapper;
import com.hongtian.util.DateTimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author weed
 * @date 2021/4/20 0020 14:52
 * @description 删除人员人脸抓拍记录
 */
@Component
public class DeletePztClcrjl {

    @Autowired
    private PztClCrjlMapper pztClCrjlMapper;

    @Scheduled(cron = "0 0 */1 * * ?")
//    @Scheduled(cron = "0 */1 * * * ?")
    public void delete() {
        while(true) {
            int i = pztClCrjlMapper.deleteClcrjl(DateTimeUtils.addDays(DateTimeUtils.today(),-30));
            if(i == 0) {
                break;
            }
        }

    }
}

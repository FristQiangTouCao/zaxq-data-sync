package com.hongtian.schedule;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hongtian.dao.redisDao.RlzpjlRedisDao;
import com.hongtian.entity.PztJmxqRlzpjlDahua;
import com.hongtian.service.PztJmxqRlzpjlDahuaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author weed
 * @date 2020/12/18 0018 10:48
 * @description 向redis中补充需要处理的落地数据
 */
@Component
public class PztRyrlzpjlSupplement {

    @Autowired
    private PztJmxqRlzpjlDahuaService pztJmxqRlzpjlDahuaService;

    @Autowired
    private RlzpjlRedisDao rlzpjlRedisDao;

    @Scheduled(cron = "0 */1 * * * ?")
    public void supplement() {
        while(rlzpjlRedisDao.getSize() < 1000) {
            Page<PztJmxqRlzpjlDahua> unHandleJl = pztJmxqRlzpjlDahuaService.getUnHandleJl();
            List<PztJmxqRlzpjlDahua> records = unHandleJl.getRecords();
            if(CollectionUtils.isEmpty(records)) {
                break;
            }
            rlzpjlRedisDao.insertList(records);
            // 更新数据的处理状态
            records.forEach(item -> {
                item.setClbz("-1");
            });
            pztJmxqRlzpjlDahuaService.updateBatchById(records);
        }
    }

}

package com.hongtian.schedule;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hongtian.dao.mongo.XtpzDao;
import com.hongtian.dao.redisDao.RlzpjlRedisDao;
import com.hongtian.entity.PztJmxqRlzpjlDahua;
import com.hongtian.entity.XtPz;
import com.hongtian.service.PztJmxqRlzpjlDahuaService;
import com.hongtian.util.Constant;
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
    private XtpzDao xtpzDao;
    private volatile int page = 0;
    private int size = 1000;
    private boolean start = false;

    @Autowired
    private RlzpjlRedisDao rlzpjlRedisDao;


    @Scheduled(cron = "*/10 * * * * ?")
    public void supplement() {
        load();
    }

    public void handle(List<PztJmxqRlzpjlDahua> records){
        rlzpjlRedisDao.insertList(records);
        // 更新数据的处理状态
        records.forEach(item -> {
            item.setClbz("-1");
            pztJmxqRlzpjlDahuaService.updateByLsid(item);
        });
    }

    /**
     * 使用页码  是为了防止多个线程同时查询  查询到同一个数据
     */
    public void load() {
        start = true;
        while(rlzpjlRedisDao.getSize() < 10000) {
            // 获取已经在队列中的长度
            int unHandleCount = pztJmxqRlzpjlDahuaService.getUnHandleCount();
            // 获取时间
            XtPz xtPz = xtpzDao.getXtPz(Constant.DAHUA_LDSJ_HANDLE_START_TIME);
            String time = xtPz == null ? null:xtPz.getValue();
            Page<PztJmxqRlzpjlDahua> unHandleJl = pztJmxqRlzpjlDahuaService.getUnHandleJl(unHandleCount,size,time);
            List<PztJmxqRlzpjlDahua> records = unHandleJl.getRecords();
            if(CollectionUtils.isEmpty(records)) {
                break;
            }
            Integer count = records.size(); // 记录总数
            Integer pageCount = 0; // 页数
            Integer pageSize = 10;
            if (count % pageSize == 0) {
                pageCount = count / pageSize;
            } else {
                pageCount = count / pageSize + 1;
            }

            int fromIndex = 0; // 开始索引
            int toIndex = 0; // 结束索引
//        int pageNum = 1;
            for(int pageNum = 1; pageNum <= pageCount; pageNum++) {
                if (pageNum != pageCount) {
                    fromIndex = (pageNum - 1) * pageSize;
                    toIndex = fromIndex + pageSize;
                } else {
                    fromIndex = (pageNum - 1) * pageSize;
                    toIndex = count;
                }
                List<PztJmxqRlzpjlDahua> pztJmxqRlzpjlDahuas = records.subList(fromIndex, toIndex);
                handle(pztJmxqRlzpjlDahuas);
            }

        }
        start = false;
    }



}

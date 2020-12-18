package com.hongtian.component;

import com.hongtian.dao.redisDao.PztJcssJbRedisDao;
import com.hongtian.dao.redisDao.PztRyJbRedisDao;
import com.hongtian.dao.redisDao.RlzpjlRedisDao;
import com.hongtian.entity.*;
import com.hongtian.schedule.processor.PztRlzpldProcessor;
import com.hongtian.service.PztJmxqRlzpjlDahuaService;
import com.hongtian.service.PztRyRlzpjlService;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author weed
 * @date 2020/12/18 0018 10:22
 * @description 落地数据算子
 */

public class PztJmxqRlzpjlLdOperator implements Runnable{


    private RlzpjlRedisDao rlzpjlRedisDao;

    private PztRyJbRedisDao pztRyJbRedisDao;

    private PztJcssJbRedisDao pztJcssJbRedisDao;

    private PztRyRlzpjlService pztRyRlzpjlService;

    private PztJmxqRlzpjlDahuaService pztJmxqRlzpjlDahuaService;

    private SjClLog sjClLog;

    private PztRlzpldProcessor pztRlzpldProcessor;

    public PztJmxqRlzpjlLdOperator(RlzpjlRedisDao rlzpjlRedisDao, PztRyJbRedisDao pztRyJbRedisDao,
                                   PztJcssJbRedisDao pztJcssJbRedisDao, PztRyRlzpjlService pztRyRlzpjlService,
                                   PztJmxqRlzpjlDahuaService pztJmxqRlzpjlDahuaService, SjClLog sjClLog,
                                           PztRlzpldProcessor pztRlzpldProcessor) {
        this.rlzpjlRedisDao = rlzpjlRedisDao;
        this.pztRyJbRedisDao = pztRyJbRedisDao;
        this.pztJcssJbRedisDao = pztJcssJbRedisDao;
        this.pztRyRlzpjlService = pztRyRlzpjlService;
        this.pztJmxqRlzpjlDahuaService = pztJmxqRlzpjlDahuaService;
        this.sjClLog = sjClLog;
        this.pztRlzpldProcessor = pztRlzpldProcessor;
    }

    @Override
    public void run() {
       while(true) {
           // 获取未落地数据 -- 在redis中
           List<PztJmxqRlzpjlDahua> list = rlzpjlRedisDao.getList();
           //根据faceid去人脸记录表中查询
           if(CollectionUtils.isEmpty(list)) {
               break;
           }
           list.forEach(item -> {
               List<PztRyRlzpjl> pztRyRlzpjls = pztRyRlzpjlService.getZpjlByFaceId(item.getLsid());
               if(CollectionUtils.isEmpty(pztRyRlzpjls)) {
                   // 根据设施编号  去基础设施表找
                   if(!pztJcssJbRedisDao.contains(item.getSbbh())) {
                       item.setClbz("2");
                   } else {
                       item.setClbz("3");
                   }
               }else {
                   String gmsfhm = item.getGmsfhm();
                   if(StringUtils.isEmpty(gmsfhm)) {
                       item.setClbz("9");
                   } else{
                       //根据身份证号码人员基本表中查看
                       String xm = pztRyJbRedisDao.get(gmsfhm);
                       if(xm != null) {
                           pztRyRlzpjls.forEach(ryRlzpjl -> {
                               if("1".equals(ryRlzpjl.getLdbz())) return;
                               ryRlzpjl.setXm(xm);
                               ryRlzpjl.setLdbz("1");
                               pztRyRlzpjlService.updateById(ryRlzpjl);
                           });
                       }
                       item.setClbz("1");
                   }
               }
               pztJmxqRlzpjlDahuaService.updateById(item);
           });
           pztRlzpldProcessor.updateLog(sjClLog.getId(),list.size());
       }
    }
}

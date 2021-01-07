package com.hongtian.component;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hongtian.dao.redisDao.RlzpjlRedisDao;
import com.hongtian.entity.*;
import com.hongtian.mapper.PztJmxqRlzpjlDahuaBackMapper;
import com.hongtian.schedule.processor.PztRlzpldProcessor;
import com.hongtian.service.PztJcssJbService;
import com.hongtian.service.PztJmxqRlzpjlDahuaService;
import com.hongtian.service.PztRyJbService;
import com.hongtian.service.PztRyRlzpjlService;
import org.springframework.beans.BeanUtils;
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



    private PztRyRlzpjlService pztRyRlzpjlService;

    private PztJmxqRlzpjlDahuaService pztJmxqRlzpjlDahuaService;

    private PztRyJbService pztRyJbService;

    private SjClLog sjClLog;

    private PztRlzpldProcessor pztRlzpldProcessor;
    PztJcssJbService pztJcssJbService;
    private PztJmxqRlzpjlDahuaBackMapper pztJmxqRlzpjlDahuaBackMapper;


    public PztJmxqRlzpjlLdOperator(RlzpjlRedisDao rlzpjlRedisDao, PztRyRlzpjlService pztRyRlzpjlService,
                                   PztJmxqRlzpjlDahuaService pztJmxqRlzpjlDahuaService, SjClLog sjClLog,
                                   PztRlzpldProcessor pztRlzpldProcessor, PztRyJbService pztRyJbService,
                                   PztJcssJbService pztJcssJbService,PztJmxqRlzpjlDahuaBackMapper pztJmxqRlzpjlDahuaBackMapper) {
        this.rlzpjlRedisDao = rlzpjlRedisDao;
        this.pztRyRlzpjlService = pztRyRlzpjlService;
        this.pztJmxqRlzpjlDahuaService = pztJmxqRlzpjlDahuaService;
        this.sjClLog = sjClLog;
        this.pztRlzpldProcessor = pztRlzpldProcessor;
        this.pztRyJbService = pztRyJbService;
        this.pztJcssJbService =pztJcssJbService;
        this.pztJmxqRlzpjlDahuaBackMapper = pztJmxqRlzpjlDahuaBackMapper;
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
                   if(!pztJcssJbService.existsJcss(item.getSbbh())) {
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
                       PztRyJb pztRyJb = pztRyJbService.matchByGmsfzhm(gmsfhm);
                       pztRyRlzpjls.forEach(ryRlzpjl -> {
                           if("1".equals(ryRlzpjl.getLdbz())) return;
                           if(pztRyJb != null) {
                               ryRlzpjl.setXm(pztRyJb.getXm());
                           }
                           ryRlzpjl.setGmsfhm(gmsfhm);
                           ryRlzpjl.setLdbz("1");
                           pztRyRlzpjlService.updateById(ryRlzpjl);
                       });
                       item.setClbz("1");
                   }
               }
//               pztJmxqRlzpjlDahuaService.updateByLsid(item);
               PztJmxqRlzpjlDahuaBack pztJmxqRlzpjlDahuaBack = new PztJmxqRlzpjlDahuaBack();
               BeanUtils.copyProperties(item, pztJmxqRlzpjlDahuaBack);
               savePztRyrlzpjl(pztJmxqRlzpjlDahuaBack);
               // 删除
               pztJmxqRlzpjlDahuaService.remove(new QueryWrapper<PztJmxqRlzpjlDahua>().eq("lsid",item.getLsid()));
           });
           pztRlzpldProcessor.updateLog(sjClLog.getId(),list.size());
       }
    }

    public void savePztRyrlzpjl(PztJmxqRlzpjlDahuaBack pztJmxqRlzpjlDahuaBack) {
        try{
            // 备份
            pztJmxqRlzpjlDahuaBackMapper.insert(pztJmxqRlzpjlDahuaBack);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package com.hongtian.schedule.processor;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hongtian.entity.*;
import com.hongtian.schedule.BaseProcessor;
import com.hongtian.schedule.Job;
import com.hongtian.service.PztJcssJbService;
import com.hongtian.service.PztJmxqRlzpjlDahuaService;
import com.hongtian.service.PztJmxqSsgkService;
import com.hongtian.service.PztRyRlzpjlService;
import com.hongtian.util.DateTimeUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author weed
 * @date 2021/4/16 0016 11:27
 * @description
 */
@Component
@Slf4j
public class JcssGkLdTj extends BaseProcessor<PztJcssJb> {

    @Autowired
    private PztJmxqSsgkService pztJmxqSsgkService;
    @Autowired
    private PztJcssJbService pztJcssJbService;
    @Autowired
    private PztJmxqRlzpjlDahuaService pztJmxqRlzpjlDahuaService;
    @Autowired
    private PztRyRlzpjlService pztRyRlzpjlService;

    @Override
    public Job getType() {
        return Job.JCSS_GK_LD;
    }

    @Override
    public void execute(SjClLog SjClLog) {
        int page = 0;
        int size = 100;
        String dqrq = DateTimeUtils.today();
        List<PztJmxqSsgk> pztJmxqSsgkList = pztJmxqSsgkService.list(

        );
        log.warn("开始更新落地数据：drqp:{}.date:{}.",dqrq,new Date());
        while(true) {
            Page<PztJmxqSsgk> ssgkPage = new Page<>();
            Page<PztJmxqSsgk> result = pztJmxqSsgkService.page(ssgkPage, new QueryWrapper<PztJmxqSsgk>()
                    .eq("sslx", "SS18")
                    .eq("tjrq", dqrq)
                    .orderByDesc("nbbh"));
            List<PztJmxqSsgk> records = result.getRecords();
            if(CollectionUtils.isEmpty(records)){
                break;
            }
            handle(records,dqrq);
            page++;
        }
        log.warn("落地数据更新结束：drqp:{}.",dqrq);
        SjClLog.setTotal(pztJmxqSsgkList.size());
        SjClLog.setSuccessCount(pztJmxqSsgkList.size());
    }

    public void handle(List<PztJmxqSsgk> pztJmxqSsgkList,String dqrq) {
        pztJmxqSsgkList.stream().forEach(item -> {
            PztJcssJb pztJcssJb = null;
            List<PztJcssJb> list = pztJcssJbService.list(
                    new QueryWrapper<PztJcssJb>()
                            .eq("ssbh",item.getSbbh())
                            .eq("sslx",item.getSslx())
            );
            if(!CollectionUtils.isEmpty(list)){
                pztJcssJb = list.get(0);
            }
            try {
                if (pztJcssJb!= null && StringUtils.isNotBlank(pztJcssJb.getTdbm())) {
                    // 统计落地数量
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
                    long jlsj1 = sdf.parse(dqrq + "000000").getTime();
                    long jlsj2time = sdf.parse(dqrq + "235959").getTime();
                    int total = pztJmxqRlzpjlDahuaService.count(
                            new QueryWrapper<PztJmxqRlzpjlDahua>()
                                    .eq("sbbh",pztJcssJb.getTdbm())
                                    .between("jlsj",jlsj1,jlsj2time)
                    );
                    item.setQtsl(new BigDecimal(total));
                    // 统计人脸抓拍数量
                    QueryWrapper<PztRyRlzpjl> queryRlzpjl = new QueryWrapper<PztRyRlzpjl>()
                            .eq("sslx", "SS18")
                            .eq("sbbh", pztJcssJb.getSsbh())
                            .between("jlsj", dqrq + "000000", dqrq + "235959");
//                    long rlzpjls = pztRyRlzpjlService.count(queryRlzpjl);
                    item.setRlzpsl(item.getTjsl());
                    // 统计实际落地数量
                    queryRlzpjl.eq("ldbz","1");
                    long sjlds = pztRyRlzpjlService.count(queryRlzpjl);
                    item.setSjldsl(new BigDecimal(sjlds));
                    // 计算落地数据的各项比率
                    item.computeGroundDate();
                    pztJmxqSsgkService.updateById(item);
//                    log.warn("更新设备的落地数据,ssbh:{},sslx:{}.dqrq：{}",pztJcssJb.getSsbh(),pztJcssJb.getSslx(),dqrq);
                }
            } catch (Exception e) {
                log.error("计算落地数据错误：", e.getMessage());
            }
        });
    }
}

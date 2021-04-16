package com.hongtian.component;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hongtian.entity.PztJmxqSsgk;
import com.hongtian.entity.dto.JcssGkVo;
import com.hongtian.mapper.PztJcssJbMapper;
import com.hongtian.service.PztJcssJbService;
import com.hongtian.service.PztJmxqRlzpjlDahuaService;
import com.hongtian.service.PztJmxqSsgkService;
import com.hongtian.service.PztRyRlzpjlService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author weed
 * @date 2021/1/7 0007 14:07
 * @description
 */
public class JcssGkTjOperator {

    private static final Logger logger = LoggerFactory.getLogger(JcssGkTjOperator.class);
    private PztJcssJbMapper pztJcssJbMapper;

    private PztJmxqSsgkService pztJmxqSsgkService;

    private PztJcssJbService pztJcssJbService;

    private PztJmxqRlzpjlDahuaService pztJmxqRlzpjlDahuaService;

    private PztRyRlzpjlService pztRyRlzpjlService;

    public JcssGkTjOperator(PztJcssJbMapper pztJcssJbMapper, PztJmxqSsgkService pztJmxqSsgkService, PztJcssJbService pztJcssJbService, PztJmxqRlzpjlDahuaService pztJmxqRlzpjlDahuaService, PztRyRlzpjlService pztRyRlzpjlService) {
        this.pztJcssJbMapper = pztJcssJbMapper;
        this.pztJmxqSsgkService = pztJmxqSsgkService;
        this.pztJcssJbService = pztJcssJbService;
        this.pztJmxqRlzpjlDahuaService = pztJmxqRlzpjlDahuaService;
        this.pztRyRlzpjlService = pztRyRlzpjlService;
    }

    public void compute(String dqrq) {
        String jlsj2 = dqrq + "235959";


        List<String> zlcl = new ArrayList<String>(){{
            add("SS071"); add("SS073"); add("SS19");add("SS20");
        }};
//       车辆出入记录
        List<JcssGkVo> cllstj = pztJcssJbMapper.cllstj(zlcl, dqrq+"000000", jlsj2);
        logger.warn("车辆流水设备个数：{} start。dqrq：{}",cllstj.size(),dqrq);
        cllstj.stream().parallel().forEach(item -> {
            try{
                String sbbh = item.getSbbh();
                if(StringUtils.isBlank(sbbh)) {
                    return;
                }
//                logger.warn("车辆设备---->：sbbh:{},sslx:{},count:{}.dqrq：{}",sbbh,item.getSslx(),item.getCount(),dqrq);
                processJmxqSsgk(dqrq, item.getCount().intValue(), sbbh,true);
            }catch (Exception e) {
                e.printStackTrace();
                logger.error("设备概况统计，发生错误！车辆ssbh:{},dqrq：{}",item.getSbbh(),dqrq);
            }
        });
        logger.warn("车辆流水设备个数：{} end。,dqrq：{}",cllstj.size(),dqrq);


//        芝立人脸照片记录
        List<String> zlry = new ArrayList<String>(){{
            add("SS071"); add("SS072");add("SS074");add("SS075"); add("SS18");add("SS20");
        }};
        List<JcssGkVo> rllstj = pztJcssJbMapper.rllstj(zlry, dqrq+"000000", jlsj2);
        logger.warn("人脸感知流水设备个数：{}，start。dqrq：{}",rllstj.size(),dqrq);
        rllstj.stream().parallel().forEach(item -> {
            try{
                String sbbh = item.getSbbh();
                if(StringUtils.isBlank(sbbh)) {
                    return;
                }
//                logger.error("人脸设备---->sbbh:{},sslx:{},count:{}.dqrq：{}",sbbh,item.getSslx(),item.getCount(),dqrq);
                processJmxqSsgk(dqrq, item.getCount().intValue(),sbbh,false);
            }catch (Exception e){
                e.printStackTrace();
                logger.error("设备概况统计，发生错误！人脸ssbh:{},dqrq：{}",item.getSbbh(),dqrq);
            }
        });
        // 异常设备标记清除
        pztJcssJbMapper.updateYcSbTargetClean();
        // 异常设备标记
        pztJcssJbMapper.updateYcSbTarget();
    }


    public void processJmxqSsgk(String tjrq, Integer tjsl,String ssbh,boolean isCl) {

        PztJmxqSsgk pztJmxqSsgk = null;
        List<PztJmxqSsgk> pztJmxqSsgks = pztJmxqSsgkService.list(
                new QueryWrapper<PztJmxqSsgk>()
                .eq("tjrq",tjrq)
                .eq("sbbh",ssbh)
        );
        if(!CollectionUtils.isEmpty(pztJmxqSsgks)) {
            pztJmxqSsgk = pztJmxqSsgks.get(0);
        }
        // 如果是大门门禁或者人脸一体机，计算的流水总数是车辆和人员通行记录的总和
        if(StringUtils.isNotBlank(pztJmxqSsgk.getSslx()) && ("SS20".equals(pztJmxqSsgk.getSslx()) || "SS071".equals(pztJmxqSsgk.getSslx()))) {
            int count = 0;
            if(!isCl) {
                count = pztJmxqSsgk.getTjsl() == null ? 0 : pztJmxqSsgk.getTjsl().intValue();
            }
            pztJmxqSsgk.setTjsl(new BigDecimal(count + tjsl));
        } else{
            pztJmxqSsgk.setTjsl(new BigDecimal(tjsl));
        }
        pztJmxqSsgk.setQtsl(new BigDecimal(0));
        if (StringUtils.isBlank(pztJmxqSsgk.getNbbh())) {
            pztJmxqSsgkService.save(pztJmxqSsgk);
        } else {
            pztJmxqSsgkService.updateById(pztJmxqSsgk);
        }
    }

}

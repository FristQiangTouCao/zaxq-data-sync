package com.hongtian.component;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hongtian.entity.PztJcssJb;
import com.hongtian.entity.PztJmxqRlzpjlDahua;
import com.hongtian.entity.PztJmxqSsgk;
import com.hongtian.entity.PztRyRlzpjl;
import com.hongtian.entity.dto.JcssGkVo;
import com.hongtian.mapper.PztJcssJbMapper;
import com.hongtian.service.PztJcssJbService;
import com.hongtian.service.PztJmxqRlzpjlDahuaService;
import com.hongtian.service.PztJmxqSsgkService;
import com.hongtian.service.PztRyRlzpjlService;
import com.hongtian.util.DateTimeUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
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

    public void compute() {
        String dqrq = StringUtils.substring(DateTimeUtils.now(), 0, 8);
        String jlsj2 = dqrq + "235959";


        List<String> zlcl = new ArrayList<String>(){{
            add("SS071"); add("SS073"); add("SS19");add("SS20");
        }};
//       车辆出入记录
        List<JcssGkVo> cllstj = pztJcssJbMapper.cllstj(zlcl, dqrq+"000000", jlsj2);
        logger.warn("车辆流水设备个数：{} start。dqrq：{}",zlcl.size(),dqrq);
        cllstj.forEach(item -> {
            try{
                String sbbh = item.getSbbh();
                if(StringUtils.isBlank(sbbh)) {
                    return;
                }
                logger.warn("车辆设备---->：sbbh:{},sslx:{},count:{}.dqrq：{}",sbbh,item.getSslx(),item.getCount(),dqrq);
                processJmxqSsgk(dqrq, sbbh, item.getCount().intValue(), item.getSslx(),true);
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
        logger.warn("人脸感知流水设备个数：{}，start。dqrq：{}",zlry.size(),dqrq);
        rllstj.forEach(item -> {
            try{
                String sbbh = item.getSbbh();
                if(StringUtils.isBlank(sbbh)) {
                    return;
                }
                logger.error("人脸设备---->sbbh:{},sslx:{},count:{}.dqrq：{}",sbbh,item.getSslx(),item.getCount(),dqrq);
                processJmxqSsgk(dqrq, sbbh, item.getCount().intValue(), item.getSslx(),false);
            }catch (Exception e){
                e.printStackTrace();
                logger.error("设备概况统计，发生错误！人脸ssbh:{},dqrq：{}",item.getSbbh(),dqrq);
            }
        });
        logger.warn("人脸感知流水设备个数：{}，end。dqrq：{}",rllstj.size(),dqrq);
        List<PztJmxqSsgk> pztJmxqSsgkList = pztJmxqSsgkService.list(
                new QueryWrapper<PztJmxqSsgk>()
                .eq("sslx","SS18")
                .eq("tjrq",dqrq)
        );
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
                            .between("jlsj", jlsj1, jlsj2time);
                    long rlzpjls = pztRyRlzpjlService.count(queryRlzpjl);
                    item.setRlzpsl(new BigDecimal(rlzpjls));
                    // 统计实际落地数量
                    queryRlzpjl.eq("ldbz","1");
                    long sjlds = pztRyRlzpjlService.count(queryRlzpjl);
                    item.setSjldsl(new BigDecimal(sjlds));
                    // 计算落地数据的各项比率
                    item.computeGroundDate();
                    pztJmxqSsgkService.updateById(item);
                    logger.warn("更新设备的落地数据,ssbh:{},sslx:{}.dqrq：{}",pztJcssJb.getSsbh(),pztJcssJb.getSslx(),dqrq);
                }
            } catch (Exception e) {
                logger.error("计算落地数据错误：", e.getMessage());
            }
        });
        // 异常设备标记清除
        pztJcssJbMapper.updateYcSbTargetClean();
        // 异常设备标记
        pztJcssJbMapper.updateYcSbTarget();
    }

    public void processJmxqSsgk(String tjrq, String sbbh, Integer tjsl, String sslx,boolean isCl) {
        PztJcssJb pztJcssJb = null;
        List<PztJcssJb> list =  pztJcssJbService.list(new QueryWrapper<PztJcssJb>()
        .eq("ssbh",sbbh)
        .eq("sslx",sslx));
        if(!CollectionUtils.isEmpty(list)){
            pztJcssJb = list.get(0);
        }
        processJmxqSsgk(tjrq, pztJcssJb, tjsl,isCl);
    }

    public void processJmxqSsgk(String tjrq, PztJcssJb pztJcssJb, Integer tjsl,boolean isCl) {
        if(pztJcssJb == null) return;
        PztJmxqSsgk pztJmxqSsgk = null;
        List<PztJmxqSsgk> pztJmxqSsgks = pztJmxqSsgkService.list(
                new QueryWrapper<PztJmxqSsgk>()
                .eq("tjrq",tjrq)
                .eq("sbbh",pztJcssJb.getSsbh())
        );
        if(!CollectionUtils.isEmpty(pztJmxqSsgks)) {
            pztJmxqSsgk = pztJmxqSsgks.get(0);
        }
        if (pztJmxqSsgk == null) {
            pztJmxqSsgk = new PztJmxqSsgk();
            pztJmxqSsgk.setTjrq(tjrq);
            pztJmxqSsgk.setSbbh(pztJcssJb.getSsbh());
        }
        if (pztJcssJb != null && StringUtils.equals(pztJcssJb.getSfzhaf(), "1")) {

        }if (StringUtils.isBlank(pztJmxqSsgk.getJmxqbh())) {
            pztJmxqSsgk.setJmxqbh(pztJcssJb.getJmxqbh());
            pztJmxqSsgk.setSjgsdw(pztJcssJb.getSsxq());
        }
        if (StringUtils.isBlank(pztJmxqSsgk.getSslx())) {
            pztJmxqSsgk.setSslx(pztJcssJb.getSslx());
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

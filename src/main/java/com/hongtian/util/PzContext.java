package com.hongtian.util;

import com.hongtian.mapper.PztRyGldxMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * @author weed
 * @date 2021/4/19 0019 11:36
 * @description
 */
@Slf4j
@Component
public class PzContext {

    /** 重点车辆车牌号码列表 */
    private List<String> zdClList = new ArrayList<>();

    /** 重点人员身份证号码列表 */
    private List<String> zdRyList = new ArrayList<>();

    private List<String> zdrylx = new ArrayList<String>(){{
        add(PzConstants.RYLX_ZDSDRY);add(PzConstants.RYLX_YDSDRY);add(PzConstants.RYLX_SDTSRY);
        add(PzConstants.RYLX_BDSDRY);add(PzConstants.RYLX_XDRY);add(PzConstants.RYLX_SHRY);
        add(PzConstants.RYLX_SDRY);add(PzConstants.RYLX_JGDX_BDZZQL);add(PzConstants.RYLX_JSB_ZSZH);
        add(PzConstants.RYLX_YYBFSHRY);add(PzConstants.RYLX_JTBL);add(PzConstants.RYLX_XJZS);
    }};
    // RY0072   RY0076  RY0073   RY00761   RY0071  RY0121  RY0111    RY0042  RY7202  RY53  RY54  RY531

    @Autowired
    private PztRyGldxMapper pztRyGldxDao;

    /**
     * 初始化记载重点人员车辆信息
     */
    @PostConstruct
    public void init() {
        zdClList = pztRyGldxDao.getZdrycphm(zdrylx);
        log.warn("加载重点人员车辆信息完成,size:{}.",zdClList.size());
        zdRyList = pztRyGldxDao.getZdryGmsfhm(zdrylx);
        log.warn("加载重点人员信息完成,size:{}",zdRyList.size());
    }

    public  boolean containGmsghm(String gmsfhm){
        return zdRyList.contains(gmsfhm);
    }


    public boolean containCphm(String cphm){
        return  zdClList.contains(cphm);
    }

    public List<String> getZdClList() {
        return zdClList;
    }

    public void setZdClList(List<String> zdClList) {
        this.zdClList = zdClList;
    }

    public List<String> getZdRyList() {
        return zdRyList;
    }

    public void setZdRyList(List<String> zdRyList) {
        this.zdRyList = zdRyList;
    }

    public List<String> getZdrylx() {
        return zdrylx;
    }

    public void setZdrylx(List<String> zdrylx) {
        this.zdrylx = zdrylx;
    }
}

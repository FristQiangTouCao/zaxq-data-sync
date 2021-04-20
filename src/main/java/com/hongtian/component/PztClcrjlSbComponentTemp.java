package com.hongtian.component;

import com.alibaba.fastjson.JSON;
import com.hongtian.entity.PztClCrjl;
import com.hongtian.entity.dto.MotorVehicleEvent;
import com.hongtian.entity.dto.Register;
import com.hongtian.entity.dto.RegisterObject;
import com.hongtian.mapper.PztClCrjlMapper;
import com.hongtian.service.PztClCrjlYjxgService;
import com.hongtian.util.EntityToXmlUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author weed
 * @date 2021/4/19 0019 11:53
 * @description
 */
@Slf4j
@Component
public class PztClcrjlSbComponentTemp {
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
    public static  String url="http://41.188.131.157:8230/zhian/PSPC/SC/Community/MotorVehicleEvent";
    public static  String Registerurl="http://41.188.131.157:8230/zhian/PSPC/SC/System/Register";
    /** 上报数据重传次数 */
    private static final int reUpCount = 3;
    @Autowired
    PztClCrjlMapper pztClCrjlMapper;

    @Autowired
    PztClCrjlYjxgService pztClCrjlYjxgService;

    public PztClcrjlSbComponentTemp(PztClCrjlMapper pztClCrjlMapper, PztClCrjlYjxgService pztClCrjlYjxgService) {
        this.pztClCrjlMapper = pztClCrjlMapper;
        this.pztClCrjlYjxgService = pztClCrjlYjxgService;
    }


    public int upload(List<PztClCrjl> list) {
        try{
            register();
            if(CollectionUtils.isEmpty(list)) {
                return 0;
            }
            // 分片上传
            Integer count = list.size(); // 记录总数
            Integer pageCount = 0; // 页数
            Integer pageSize = 100;
            if (count % pageSize == 0) {
                pageCount = count / pageSize;
            } else {
                pageCount = count / pageSize + 1;
            }
            int fromIndex = 0; // 开始索引
            int toIndex = 0; // 结束索引
            // 上传的序列
            List<List<PztClCrjl>> upQuery = new ArrayList<>();
            for(int pageNum = 1; pageNum <= pageCount; pageNum++) {
                if (pageNum != pageCount) {
                    fromIndex = (pageNum - 1) * pageSize;
                    toIndex = fromIndex + pageSize;
                } else {
                    fromIndex = (pageNum - 1) * pageSize;
                    toIndex = count;
                }
                List<PztClCrjl> sub = list.subList(fromIndex, toIndex);
                log.warn("分组切片同步：startId:{},endId:{}",fromIndex,toIndex);
                upQuery.add(sub);
            }
            upQuery.stream().parallel().forEach(item -> {
                Map<String,Map<String,List<MotorVehicleEvent>>> faceCapture  = getMotorVehicleEvent(item);
                String faceCaptureResult = JSON.toJSONString(faceCapture);
                upData(url,faceCaptureResult);
                item.stream().parallel().forEach(ls ->{
                    log.warn("重点车辆检查");
                    pztClCrjlYjxgService.zdcljc(ls);
                    log.warn("删除已上报数据");
                    pztClCrjlMapper.deleteById(ls.getNbbh());
                });
            });
            log.warn("上报车辆数据：count:{}",list.size());
            return list.size();
        }catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }



    public boolean register() {
        RegisterObject registerRequest = getRequestZc();
        String registerRequestResult = JSON.toJSONString(registerRequest);
//        logger.warn("去注册，start");
        Boolean admin3302000000 = EntityToXmlUtil.doPostDigest(Registerurl, "admin3302000000", "Ningbo123+", registerRequestResult);
//        logger.error("注册结果：{}。",admin3302000000);
        return admin3302000000;
    }

    public RegisterObject getRequestZc(){
        RegisterObject registerObject = new RegisterObject();
        Register registerRequest = new Register();
        registerRequest.setZHAFXQXTBS("33020000009030000001");
        registerRequest.setVersion("1.0.0");
        registerObject.setRegisterObject(registerRequest);
        return registerObject;
    }
    /** 数据上传（重试） */
    public boolean upData(String url,String data) {
        int count = reUpCount;
        do{
            if (EntityToXmlUtil.doPostProcessor(url, data)) {
                return true;
            } else {
                register();
                log.warn("人脸数据上报异常，重新注冊.");
            }
            log.warn("上传失败，重试：{}。",4-count);
        }while(count-- > 1);
        return false;
    }

    public Map<String,Map<String,List<MotorVehicleEvent>>> getMotorVehicleEvent(List<PztClCrjl> pztRyRlzpjlPage){
        List<MotorVehicleEvent> motorVehicleEventList = new ArrayList<>();
        Map<String,List<MotorVehicleEvent>> map = new HashMap<>();
        Map<String,Map<String,List<MotorVehicleEvent>>> mapMap = new HashMap<>();
        MotorVehicleEvent motorVehicleEvent = null;
        for (PztClCrjl pztClCrjl : pztRyRlzpjlPage){
            motorVehicleEvent = new MotorVehicleEvent();
            motorVehicleEvent.setJdcgcxxbz(pztClCrjl.getNbbh());

            if (pztClCrjl.getJcbz() != null){
                motorVehicleEvent.setGcfx(pztClCrjl.getJcbz());
            }else {
                motorVehicleEvent.setGcfx("0");
            }

            if (pztClCrjl.getCphm() != null){
                motorVehicleEvent.setJdchphm(pztClCrjl.getCphm());
            }else {
                motorVehicleEvent.setJdchphm("00");
            }
            motorVehicleEvent.setZsjzxdhzb("0");
            motorVehicleEvent.setZsjzxdzzb("0");
            motorVehicleEvent.setYxjzxdhzb("0");
            motorVehicleEvent.setYxjzxdzzb("0");
            motorVehicleEvent.setJdccllxdm("0");
            motorVehicleEvent.setClpp("0");
            motorVehicleEvent.setJdccsysdm("0");
            motorVehicleEvent.setClxh("0");
            motorVehicleEvent.setFxcdbh("0");

            if (pztClCrjl.getSbbh() != null){
                motorVehicleEvent.setCjsbxxbz(pztClCrjl.getSbbh());
            }else {
                motorVehicleEvent.setCjsbxxbz("00");
            }
            motorVehicleEvent.setSftgcpdbz("0");
            motorVehicleEvent.setZjsrrlbz("0");

            if (pztClCrjl.getYjzpurl() != null){
                motorVehicleEvent.setClqjtxbz(pztClCrjl.getYjzpurl());
            }else {
                motorVehicleEvent.setClqjtxbz("00");
            }

            if(pztClCrjl.getCpzpurl() != null){
                motorVehicleEvent.setClhptxbz(pztClCrjl.getCpzpurl());
            }else {
                motorVehicleEvent.setClhptxbz("00");
            }
            motorVehicleEvent.setFjsrrlbz("00");

            if (pztClCrjl.getHpzl() != null){
                motorVehicleEvent.setJdchpzldm(pztClCrjl.getHpzl());
            }else {
                motorVehicleEvent.setJdchpzldm("00");
            }
            motorVehicleEvent.setSfwzdclpdbz("0");

            if (pztClCrjl.getHpys() != null){
                motorVehicleEvent.setJdchpysdm(pztClCrjl.getHpys());
            }else {
                motorVehicleEvent.setJdchpysdm("00");
            }
            if(StringUtils.isEmpty(pztClCrjl.getJlsj())){
                motorVehicleEvent.setCjsj(pztClCrjl.getCjsj());

            }{
                motorVehicleEvent.setCjsj(pztClCrjl.getJlsj());
            }
            motorVehicleEventList.add(motorVehicleEvent);
        }
        map.put("MotorVehicleEventObject",motorVehicleEventList);
        mapMap.put("MotorVehicleEventList",map);
        return mapMap;
    }

}

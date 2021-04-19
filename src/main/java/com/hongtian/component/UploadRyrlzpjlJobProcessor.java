package com.hongtian.component;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hongtian.entity.FwtJobLog;
import com.hongtian.entity.ICrjl;
import com.hongtian.entity.PztClCrjl;
import com.hongtian.entity.PztRyRlzpjl;
import com.hongtian.entity.dto.FaceCapture;
import com.hongtian.entity.dto.Register;
import com.hongtian.entity.dto.RegisterObject;
import com.hongtian.mapper.FwtJobLogMapper;
import com.hongtian.mapper.PztRyRlzpjlMapper;
import com.hongtian.util.DateTimeUtils;
import com.hongtian.util.EntityToXmlUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author weed
 * @date 2021/4/16 0016 16:41
 * @description 上报人员人脸抓拍记录
 */
@Slf4j
public class UploadRyrlzpjlJobProcessor{

    private static final String DEFAULT_LAST_SYNC_TIME = "20100101000000";
    private static final String KEY_LAST_SYNC_TIME = "vPztJcss.last-sync-time";
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
    private String lastSyncTime;
    private String lastRecordTime;
    public static  String url="http://41.188.131.157:8230/zhian/PSPC/SC/Community/FaceCapture";
    public static  String Registerurl="http://41.188.131.157:8230/zhian/PSPC/SC/System/Register";
    private RestTemplate restTemplate = new RestTemplate();
    /** 上报数据重传次数 */
    private static final int reUpCount = 3;

    public static String  proxyurl = "http://10.119.30.14:8080/proxy/getUTFImg?url=";

    @Autowired
    PztRyRlzpjlMapper pztRyRlzpjlDao;
    @Autowired
    private PztRyRlzpjlMapper pztRyRlzpjlMapper;

    @Autowired
    private FwtJobLogMapper fwtJobLogMapper;

//    @Autowired
//    private PztRyRlzpjlYjxgServiceImpl pztRyRlzpjlYjxgService;


    public void doExecute(Map<String, Object> params, FwtJobLog fwtJobLog) throws Exception {
        int total = 0;
        int finish = 0;
        int fails = 0;
        while(true) {
            try{
                lastSyncTime = DateTimeUtils.addDays(DateTimeUtils.now(),-30);
                register();
                List<PztRyRlzpjl> list = getList();
                if(CollectionUtils.isEmpty(list)) {
                    break;
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
                List<List<PztRyRlzpjl>> upQuery = new ArrayList<>();
                for(int pageNum = 1; pageNum <= pageCount; pageNum++) {
                    if (pageNum != pageCount) {
                        fromIndex = (pageNum - 1) * pageSize;
                        toIndex = fromIndex + pageSize;
                    } else {
                        fromIndex = (pageNum - 1) * pageSize;
                        toIndex = count;
                    }
                    List<PztRyRlzpjl> sub = list.subList(fromIndex, toIndex);
                    log.warn("分组切片同步：startId:{},endId:{}",fromIndex,toIndex);
                    upQuery.add(sub);
                }
                upQuery.stream().parallel().forEach(item -> {
                    Map<String,Map<String,List<FaceCapture>>> faceCapture = getFaceCapture(item);
                    String faceCaptureResult = JSON.toJSONString(faceCapture);
                    upData(url,faceCaptureResult);
                    item.stream().parallel().forEach(ls ->{
                        log.warn("重点人员检查");
//                        pztRyRlzpjlYjxgService.zdryjc(ls);
                        log.warn("删除已上报数据");
                        pztRyRlzpjlDao.deleteById(ls.getNbbh());
                    });
                });
                total += list.size();
                finish += list.size();
                log.warn("上报人脸数据：time:{},count:{},total:{}.",lastSyncTime,list.size(),total);
                updateExecute(fwtJobLog,total,finish);
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
        fwtJobLog.setWcs(total);
        fwtJobLog.setCgs(finish);
        fwtJobLog.setSbs(fails);
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


    // todo
    public List<PztRyRlzpjl> getList() {
        QueryWrapper<PztRyRlzpjl> query = new QueryWrapper<>();
        query.orderByAsc("cjsj");
        Page<Object> page = new Page<>();
        throw new NullPointerException("实现获取人脸抓拍记录列表");
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

    public Map<String,Map<String,List<FaceCapture>>> getFaceCapture(List<PztRyRlzpjl> pztRyRlzpjlPage){
        List<FaceCapture> faceCaptureArrayList = new ArrayList<>();
//        FaceCapture faceCapture = null;
        Map<String,List<FaceCapture>> map = new HashMap<>();
        Map<String,Map<String,List<FaceCapture>>> map1 = new HashMap<>();
        pztRyRlzpjlPage.stream().parallel().forEach(pztRyRlzpjl -> {
            FaceCapture faceCapture = new FaceCapture();
            faceCapture.setRLZPXXBZ(pztRyRlzpjl.getNbbh());

            if (pztRyRlzpjl.getFaceid() != null){
                faceCapture.setSPTXXXYYSXDXBZ(pztRyRlzpjl.getFaceid());
            }else {
                faceCapture.setSPTXXXYYSXDXBZ("00000");
            }
            if (pztRyRlzpjl.getFsbz() != null){
                faceCapture.setSPTXXXCJFSDM(pztRyRlzpjl.getFsbz());
            }
            if (pztRyRlzpjl.getSbbh() != null){
                faceCapture.setCJSBXXBZ(pztRyRlzpjl.getSbbh());
            }
            if (pztRyRlzpjl.getZpdtlj() != null){
                try{
                    String zpurl = pztRyRlzpjl.getZpktlj();

                    if (StringUtils.isNotBlank(zpurl)) {
                        zpurl = getProxyUrl(pztRyRlzpjl) + zpurl;
                    }
                    faceCapture.setTP(zpurl);
                }catch (Exception e){
                    e.printStackTrace();
                    log.error("下载图片资源出错。id:{}",pztRyRlzpjl.getNbbh());
                }
            }
            if (StringUtils.isNotEmpty(pztRyRlzpjl.getJlsj())){
                faceCapture.setCJSJ(pztRyRlzpjl.getJlsj());
            }else {
                faceCapture.setCJSJ(DateTimeUtils.now());
            }

            faceCapture.setNLSX("");
            faceCapture.setNLXX("");
            faceCapture.setXBDM("");
            faceCapture.setMZDM("");
            faceCapture.setSFBKRY_PDBZ("");
            faceCapture.setSFGZRY_PDBZ("");
            faceCapture.setZSJ_ZXDHZB("");
            faceCapture.setZSJ_ZXDZZB("");
            faceCapture.setYXJ_ZXDHZB("");
            faceCapture.setYXJ_ZXDZZB("");
            faceCapture.setTXR_RS(0);
            faceCapture.setSFDKZ_PDBZ("");
            faceCapture.setZMTZDM("");
            faceCapture.setSFJSY_PDBZ("");
            faceCapture.setPDYJTZDM("");
            faceCapture.setXBTZDM("");
            faceCapture.setSSZZTZDM("");
            faceCapture.setXSZZTZDM("");
            faceCapture.setZXTZDM("");
            faceCapture.setSY_YS("");
            faceCapture.setXZ_YS("");
            faceCapture.setXZ_YS("");
            faceCapture.setKZ_YS("");
            faceCaptureArrayList.add(faceCapture);
        });
        map.put("FaceCaptureObject",faceCaptureArrayList);
        map1.put("FaceCaptureList",map);
        return map1;
    }
    protected String getProxyUrl(ICrjl iCrjl){
        Boolean isAddProxy = iCrjl instanceof PztClCrjl ||
                (iCrjl instanceof PztRyRlzpjl && StringUtils.equals(((PztRyRlzpjl) iCrjl).getSjly(), "02"));
        if (isAddProxy) {
            return proxyurl;
        }
        return "";
    }

    private void updateExecute(FwtJobLog fwtJobLog,int wcs,int cgs) {
        try {
            if (fwtJobLog != null) {
                fwtJobLog.setWcs(wcs);
                fwtJobLog.setCgs(cgs);
                fwtJobLog.setXgsj(DateTimeUtils.now());
                fwtJobLogMapper.updateById(fwtJobLog);
            }
            log.debug("正在执行总共:{}, 成功:{}", fwtJobLog.getWcs(),fwtJobLog.getCgs());
        } catch (Exception e) {
            log.error("更新执行情况发生错误", e);
        }
    }


}

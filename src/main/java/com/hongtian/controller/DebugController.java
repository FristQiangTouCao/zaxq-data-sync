package com.hongtian.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hongtian.entity.PztJmxqSsgk;
import com.hongtian.entity.PztRyRlzpjl;
import com.hongtian.service.PztJmxqSsgkService;
import com.hongtian.service.PztRyRlzpjlService;
import com.hongtian.temp.UploadClcrjlTemp;
import com.hongtian.temp.UploadRyrlzpjlTemp;
import com.hongtian.util.DateTimeUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author weed
 * @date 2021/2/20 0020 16:48
 * @description
 */
@RestController
@RequestMapping("/debug")
@Slf4j
public class DebugController {

    @Autowired
    private PztJmxqSsgkService pztJmxqSsgkService;

    @Autowired
    private PztRyRlzpjlService pztRyRlzpjlService;

    @Autowired
    private UploadRyrlzpjlTemp uploadRyrlzpjlTemp;

    @Autowired
    private UploadClcrjlTemp uploadClcrjlTemp;

    @RequestMapping("/openLd")
    public Object openLd(@RequestParam("open") boolean open) {
        pztRyRlzpjlService.setOpen(open);
        return "ok";
    }

    @RequestMapping("/ssgkupdate")
    public Object ssgkUpdate(@RequestParam String ksrq) {
        int page = 1;
        int size = 1000;
        while(DateTimeUtils.today().compareTo(ksrq) > 0) {
            QueryWrapper<PztJmxqSsgk> query = new QueryWrapper<>();
            query.eq("tjrq",ksrq);
            query.eq("sslx","SS18");
            while(true) {
                Page pageAble = new Page(page,size);
                Page result = pztJmxqSsgkService.page(pageAble, query);
                List<PztJmxqSsgk> records = result.getRecords();
                if(CollectionUtils.isEmpty(records)){
                    break;
                }
                handle(records);
                log.info("handle ssgk page:{},rq:{}.",page,ksrq);
                page++;
            }
            ksrq = DateTimeUtils.addDays(ksrq,1);
            page = 1;
        }
        return "ok";
    }


    public void handle(List<PztJmxqSsgk> list) {
        list.stream().forEach(item -> {
            QueryWrapper<PztRyRlzpjl> query = new QueryWrapper<>();
            query.eq("sbbh", item.getSbbh())
                    .between("jlsj", item.getTjrq()+"000000",item.getTjrq()+"235959");
//            int rlzpsl = pztRyRlzpjlService.count(query);
            item.setRlzpsl(item.getTjsl());
            // 统计实际落地数量
            query.eq("ldbz","1");
            long sjlds = pztRyRlzpjlService.count(query);
            item.setSjldsl(new BigDecimal(sjlds));
            // 计算落地数据的各项比率
            item.computeGroundDate();
            item.setXz("1");
            pztJmxqSsgkService.updateById(item);
        });
    }


    @GetMapping("/uploadRyrlzpjl")
    public Object uploadRyrlzpjl(@RequestParam("size") int thread) {
        uploadRyrlzpjlTemp.upload(thread);
        return "ok";
    }

    @GetMapping("/uploadClcrjl")
    public Object uploadClcrjl(@RequestParam("size") int thread) {
        uploadClcrjlTemp.upload(thread);
        return "ok";
    }
}

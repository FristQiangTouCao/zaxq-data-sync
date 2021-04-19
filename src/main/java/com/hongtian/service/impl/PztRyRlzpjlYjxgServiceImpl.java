package com.hongtian.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hongtian.entity.PztRyRlzpjl;
import com.hongtian.entity.PztRyRlzpjlYjxg;
import com.hongtian.mapper.PztRyRlzpjlYjxgMapper;
import com.hongtian.service.PztRyRlzpjlYjxgService;
import com.hongtian.util.PzContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 人脸流水异常预警--关联流水 服务实现类
 * </p>
 *
 * @author weed
 * @since 2021-04-19
 */
@Service
@Slf4j
public class PztRyRlzpjlYjxgServiceImpl extends ServiceImpl<PztRyRlzpjlYjxgMapper, PztRyRlzpjlYjxg> implements PztRyRlzpjlYjxgService {

    @Autowired
    private PztRyRlzpjlYjxgService pztRyRlzpjlYjxgService;

    @Autowired
    private PzContext pztContext;


    @Override
    public void zdryjc(PztRyRlzpjl pztRyRlzpjl) {
        try{
            if (pztContext.containGmsghm(pztRyRlzpjl.getGmsfhm())) {
                log.warn("发现重点人员，身份证号码:{}。",pztRyRlzpjl.getGmsfhm());
                PztRyRlzpjlYjxg pztRyRlzpjlYjxg = new PztRyRlzpjlYjxg();
                BeanUtils.copyProperties(pztRyRlzpjl,pztRyRlzpjlYjxg);
                pztRyRlzpjlYjxgService.saveOrUpdate(pztRyRlzpjlYjxg);
            }
        }catch (Exception e) {
            log.error("保存中点人员出入信息发生错误！");
            e.printStackTrace();
        }
    }
}

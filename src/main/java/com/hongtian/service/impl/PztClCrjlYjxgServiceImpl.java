package com.hongtian.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hongtian.entity.PztClCrjl;
import com.hongtian.entity.PztClCrjlYjxg;
import com.hongtian.mapper.PztClCrjlYjxgMapper;
import com.hongtian.service.PztClCrjlYjxgService;
import com.hongtian.util.PzContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 异常预警相关联车辆流水 服务实现类
 * </p>
 *
 * @author weed
 * @since 2021-04-19
 */
@Service
@Slf4j
public class PztClCrjlYjxgServiceImpl extends ServiceImpl<PztClCrjlYjxgMapper, PztClCrjlYjxg> implements PztClCrjlYjxgService {

    @Autowired
    private PztClCrjlYjxgService pztClCrjlYjxgService;

    @Autowired
    private PzContext pztContext;

    @Override
    public void zdcljc(PztClCrjl pztClCrjl) {
        try{
            if (pztContext.containCphm(pztClCrjl.getCphm())) {
                log.warn("发现重点车辆：{}。",pztClCrjl.getCphm());
                PztClCrjlYjxg pztClCrjlYjxg = new PztClCrjlYjxg();
                BeanUtils.copyProperties(pztClCrjl,pztClCrjlYjxg);
                pztClCrjlYjxgService.saveOrUpdate(pztClCrjlYjxg);
            }
        }catch (Exception e) {
            log.error("保存中点人员车辆出入信息发生错误！");
            e.printStackTrace();
        }
    }
}

package com.hongtian.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hongtian.entity.PztClCrjl;
import com.hongtian.entity.PztClCrjlYjxg;

/**
 * <p>
 * 异常预警相关联车辆流水 服务类
 * </p>
 *
 * @author weed
 * @since 2021-04-19
 */
public interface PztClCrjlYjxgService extends IService<PztClCrjlYjxg> {
    void zdcljc(PztClCrjl pztClCrjl);

}

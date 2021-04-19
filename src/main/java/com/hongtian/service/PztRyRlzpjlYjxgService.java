package com.hongtian.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hongtian.entity.PztRyRlzpjl;
import com.hongtian.entity.PztRyRlzpjlYjxg;

/**
 * <p>
 * 人脸流水异常预警--关联流水 服务类
 * </p>
 *
 * @author weed
 * @since 2021-04-19
 */
public interface PztRyRlzpjlYjxgService extends IService<PztRyRlzpjlYjxg> {

    void zdryjc(PztRyRlzpjl pztRyRlzpjl);
}

package com.hongtian.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hongtian.entity.PztJmxqRlzpjlDahua;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author weed
 * @since 2020-12-15
 */
public interface PztJmxqRlzpjlDahuaService extends IService<PztJmxqRlzpjlDahua>,BaseService<PztJmxqRlzpjlDahua> {
    void updateByLsid(PztJmxqRlzpjlDahua pztJmxqRlzpjlDahua);

    Page<PztJmxqRlzpjlDahua> getUnHandleJl(int start,int size,String time);

    int getUnHandleCount();
}

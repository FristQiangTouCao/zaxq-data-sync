package com.hongtian.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * @author weed
 * @date 2020/11/30 0030 10:16
 * @description
 */
public interface BaseService<T> {

    default int getSize(){
        return 1000;
    }

    default int getPage() {
        return 0;
    }

    Page<T> getUnHandleJl();
}

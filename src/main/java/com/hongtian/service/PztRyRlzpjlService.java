package com.hongtian.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hongtian.entity.PztRyRlzpjl;

import java.util.List;

/**
 * <p>
 * 人员人脸抓拍记录 服务类
 * </p>
 *
 * @author weed
 * @since 2020-11-08
 */
public interface PztRyRlzpjlService extends IService<PztRyRlzpjl>, BaseService<PztRyRlzpjl>{

    List<PztRyRlzpjl> getZpjlByFaceId(String faceId);

    boolean getOpen();
    boolean setOpen(boolean open);
}

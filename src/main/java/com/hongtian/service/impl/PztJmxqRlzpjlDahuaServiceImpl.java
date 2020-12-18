package com.hongtian.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hongtian.entity.PztJmxqRlzpjlDahua;
import com.hongtian.mapper.PztJmxqRlzpjlDahuaMapper;
import com.hongtian.service.PztJmxqRlzpjlDahuaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author weed
 * @since 2020-12-15
 */
@Service
public class PztJmxqRlzpjlDahuaServiceImpl extends ServiceImpl<PztJmxqRlzpjlDahuaMapper, PztJmxqRlzpjlDahua> implements PztJmxqRlzpjlDahuaService {

    @Autowired
    private PztJmxqRlzpjlDahuaMapper pztJmxqRlzpjlDahuaMapper;


    @Override
    public Page<PztJmxqRlzpjlDahua> getUnHandleJl() {
        Page<PztJmxqRlzpjlDahua> page = new Page<>(getPage(), getSize());
        QueryWrapper<PztJmxqRlzpjlDahua> query = new QueryWrapper<>();
        query.eq("clbz","0").or().isNull("clbz");
        query.orderByAsc("jlsj");
        return pztJmxqRlzpjlDahuaMapper.selectPage(page,query);
    }


}

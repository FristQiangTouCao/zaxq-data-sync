package com.hongtian.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hongtian.entity.PztClCrjl;
import com.hongtian.mapper.PztClCrjlMapper;
import com.hongtian.service.PztClCrjlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 车辆出入记录 服务实现类
 * </p>
 *
 * @author weed
 * @since 2020-11-08
 */
@Service
public class PztClCrjlServiceImpl extends ServiceImpl<PztClCrjlMapper, PztClCrjl> implements PztClCrjlService {

    @Autowired
    private PztClCrjlMapper pztClCrjlMapper;


    @Override
    public Page<PztClCrjl> getUnHandleJl() {
        Page<PztClCrjl> page = new Page<PztClCrjl>(getPage(),getSize());
        QueryWrapper<PztClCrjl> query = new QueryWrapper<PztClCrjl>();
        query.ne("clbz","0").or().isNull("clbz");
        query.orderByAsc("jlsj");
        Page<PztClCrjl> pztClCrjlPage = pztClCrjlMapper.selectPage(page, query);
        return pztClCrjlPage;
    }
}


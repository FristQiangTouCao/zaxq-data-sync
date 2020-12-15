package com.hongtian.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hongtian.entity.PztRyRlzpjl;
import com.hongtian.mapper.PztRyRlzpjlMapper;
import com.hongtian.service.PztRyRlzpjlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 人员人脸抓拍记录 服务实现类
 * </p>
 *
 * @author weed
 * @since 2020-11-08
 */
@Service
public class PztRyRlzpjlServiceImpl extends ServiceImpl<PztRyRlzpjlMapper, PztRyRlzpjl> implements PztRyRlzpjlService{

    @Autowired
    private PztRyRlzpjlMapper pztRyRlzpjlMapper;

    @Override
    public Page<PztRyRlzpjl> getUnHandleJl() {
        Page<PztRyRlzpjl> page = new Page<PztRyRlzpjl>(getPage(),getSize());
        QueryWrapper<PztRyRlzpjl> query = new QueryWrapper<PztRyRlzpjl>();
        query.ne("clbz","1").or().isNull("clbz");
        query.orderByAsc("jlsj");
        Page<PztRyRlzpjl> pztClCrjlPage = pztRyRlzpjlMapper.selectPage(page, query);
        return pztClCrjlPage;
    }
}

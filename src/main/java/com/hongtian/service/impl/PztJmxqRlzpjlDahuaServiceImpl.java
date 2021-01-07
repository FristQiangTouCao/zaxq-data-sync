package com.hongtian.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hongtian.entity.PztJmxqRlzpjlDahua;
import com.hongtian.mapper.PztJmxqRlzpjlDahuaMapper;
import com.hongtian.service.PztJmxqRlzpjlDahuaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        List<PztJmxqRlzpjlDahua> unHandleList = pztJmxqRlzpjlDahuaMapper.getUnHandleList();
        page.setRecords(unHandleList);
        return page;
    }

    @Override
    public Page<PztJmxqRlzpjlDahua> getUnHandleJl(int start,int size,String time) {
        Page<PztJmxqRlzpjlDahua> page = new Page<>(getPage(), getSize());
        List<PztJmxqRlzpjlDahua> unHandleList = pztJmxqRlzpjlDahuaMapper.getUnHandleListByStart(start,start + size,time);
        page.setRecords(unHandleList);
        return page;
    }

    @Override
    public int getUnHandleCount() {
        return pztJmxqRlzpjlDahuaMapper.selectCount(new QueryWrapper<PztJmxqRlzpjlDahua>().eq("clbz","-1"));
    }



    @Override
    public void updateByLsid(PztJmxqRlzpjlDahua pztJmxqRlzpjlDahua) {
        QueryWrapper<PztJmxqRlzpjlDahua> query = new QueryWrapper();
        query.eq("lsid",pztJmxqRlzpjlDahua.getLsid());
        pztJmxqRlzpjlDahuaMapper.update(pztJmxqRlzpjlDahua,query);
    }
}

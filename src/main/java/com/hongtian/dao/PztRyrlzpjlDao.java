package com.hongtian.dao;

import com.hongtian.entity.PztRyRlzpjl;
import com.hongtian.mapper.PztRyRlzpjlMapper;
import com.hongtian.util.CommonUtils;
import com.hongtian.util.DateTimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class PztRyrlzpjlDao extends BaseDao<PztRyRlzpjl>{

    @Autowired
    private PztRyRlzpjlMapper pztRyRlzpjlMapper;
    @Override
    @Transactional
    public void insert(List<PztRyRlzpjl> list) {
        try{
            Map<String, List<PztRyRlzpjl>> groups = list.stream().collect(Collectors.groupingBy(m -> (m.getJlsj().substring(0, 8))));
            Set<String> keys = groups.keySet();
            for(String key:keys){
                List<PztRyRlzpjl> ryRlzpjls = groups.get(key);
                String collectionsName = CommonUtils.getRlCollectionNameSpecDay(key);
                if(collectionsName != null){
                    ryRlzpjls.parallelStream().forEach(item -> {
                        try{
                            save(item,collectionsName);
                            item.setXgsj(DateTimeUtils.now());
                            item.setClbz("1");
                            pztRyRlzpjlMapper.updateById(item);
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    });
                }
            }
        }catch (Exception e){
        }
    }
}

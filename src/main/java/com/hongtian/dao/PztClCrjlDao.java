package com.hongtian.dao;

import com.hongtian.entity.PztClCrjl;
import com.hongtian.mapper.PztClCrjlMapper;
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
public class PztClCrjlDao extends BaseDao<PztClCrjl>{

    @Autowired
    private PztClCrjlMapper pztClCrjlMapper;
    @Override
    @Transactional
    public void insert(List<PztClCrjl> list) {
        try{
            Map<String, List<PztClCrjl>> groups = list.stream().collect(Collectors.groupingBy(m -> (m.getJlsj().substring(0, 8))));
            Set<String> keys = groups.keySet();
            for(String key:keys){
                List<PztClCrjl> pztClCrjls = groups.get(key);
                String collectionsName = CommonUtils.getClCollectionNameSpecDay(key);
                if(collectionsName != null) {
                    pztClCrjls.parallelStream().forEach(item -> {
                        try{
                            save(item,collectionsName);
                            item.setClbz("1");
                            item.setXgsj(DateTimeUtils.now());
                            pztClCrjlMapper.updateById(item);
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    });
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

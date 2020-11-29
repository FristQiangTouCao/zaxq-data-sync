package com.hongtian.dao;

import com.hongtian.entity.PztClCrjl;
import com.hongtian.util.CommonUtils;
import com.mongodb.DuplicateKeyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PztClCrjlDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    public void insert() {
        mongoTemplate.insert(new PztClCrjl(), CommonUtils.getClCollectionNameThisDay());
    }

    public void insert(List<PztClCrjl> list) {
        try{
            mongoTemplate.insert(list, CommonUtils.getClCollectionNameThisDay());
        }catch (DuplicateKeyException e){
            list.parallelStream().forEach(item -> {
                try{
                    mongoTemplate.insert(item, CommonUtils.getClCollectionNameThisDay());
                }catch (Exception ex){
                }
            });
        }

    }
}

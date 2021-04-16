package com.hongtian.dao.mongo;

import com.hongtian.dao.BaseDao;
import com.hongtian.entity.XtPz;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author weed
 * @date 2020/12/17 0017 16:29
 * @description 系统配置类
 */
@Component
public class XtpzDao extends BaseDao<XtPz> {

    @Override
    public void insert(List<XtPz> list) {

    }
    // 根据id获取系统配置
    public XtPz getXtPz(String key) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(key));
        return mongoTemplate.findOne(query, XtPz.class);
    }

    public void update(XtPz xtPz) {
        mongoTemplate.save(xtPz);
    }

}

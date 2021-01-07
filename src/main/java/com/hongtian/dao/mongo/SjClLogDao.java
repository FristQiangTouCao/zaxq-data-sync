package com.hongtian.dao.mongo;

import com.hongtian.dao.BaseDao;
import com.hongtian.entity.SjClLog;
import com.mongodb.client.result.UpdateResult;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

/**
 * @author weed
 * @date 2020/11/30 0030 10:50
 * @description
 */
@Repository
public class SjClLogDao extends BaseDao<SjClLog> {


    @Override
    public void insert(SjClLog sjClLog) {
        UUID uuid = UUID.randomUUID();
        sjClLog.setId(uuid.toString().replaceAll("-",""));
        sjClLog.setUpdateTime(System.currentTimeMillis());
        super.insert(sjClLog);
    }

    @Override
    public void insert(List<SjClLog> list) {

    }

    public List<HashMap> getTodayTaskInfoList(long time) {
        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.match(Criteria.where("updateTime").gte(time)),
                Aggregation.group("type").first("type").as("taskName").count().as("runningCount").sum("total").as("total")
        );
        AggregationResults<HashMap> aggregate = mongoTemplate.aggregate(aggregation, "sjClLog", HashMap.class);
        List<HashMap> mappedResults = aggregate.getMappedResults();
        return mappedResults;
    }

    public SjClLog getById(String id) {
        return mongoTemplate.findById(id,SjClLog.class);
    }

    public UpdateResult update(Query query, Update update,String collectionName) {
        UpdateResult updateResult = mongoTemplate.updateMulti(query, update, collectionName);
        return updateResult;
    }
}

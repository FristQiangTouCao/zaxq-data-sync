package com.hongtian;

import com.hongtian.dao.mongo.SjClLogDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;

/**
 * @author weed
 * @date 2020/12/17 0017 13:50
 * @description
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class SjClDaoTest {

    @Autowired
    private SjClLogDao sjClLogDao;

    @Test
    public void test() {
        List<HashMap> todayTaskInfoList = sjClLogDao.getTodayTaskInfoList(1);
    }



}

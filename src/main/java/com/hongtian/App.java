package com.hongtian;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hongtian.dao.PztClCrjlDao;
import com.hongtian.entity.PztClCrjl;
import com.hongtian.mapper.PztClCrjlMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.domain.Pageable;

@SpringBootApplication
@MapperScan("com.hongtian.mapper")
public class App {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(App.class);
        PztClCrjlMapper bean = run.getBean(PztClCrjlMapper.class);
        IPage<PztClCrjl> objectPage = new Page<>(1, 10);
        IPage<PztClCrjl> pztClCrjlIPage = bean.selectPage(objectPage, new QueryWrapper<PztClCrjl>());
        System.out.println();
        PztClCrjlDao bean1 = run.getBean(PztClCrjlDao.class);
        bean1.insert(pztClCrjlIPage.getRecords());

    }
}

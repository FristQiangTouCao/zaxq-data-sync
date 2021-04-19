package com.hongtian.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hongtian.entity.PztClCrjl;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 车辆出入记录 Mapper 接口
 * </p>
 *
 * @author weed
 * @since 2020-11-08
 */
@Repository
@DS("pz")
public interface PztClCrjlMapper extends BaseMapper<PztClCrjl> {
    List<PztClCrjl> getUnHandleData();

    List<PztClCrjl> getClcrjljlByStartAndEnd(int start, int end);
}

package com.hongtian.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.hongtian.entity.PztClCrjl;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

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

}

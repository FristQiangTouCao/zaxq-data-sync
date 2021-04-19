package com.hongtian.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.hongtian.entity.PztRyGldx;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author weed
 * @since 2021-04-19
 */
@DS("pz")
public interface PztRyGldxMapper extends BaseMapper<PztRyGldx> {

    List<String> getZdrycphm(@Param("rylxs") List<String> rylxs);


    List<String> getZdryGmsfhm(@Param("rylxs") List<String> rylxs);
}

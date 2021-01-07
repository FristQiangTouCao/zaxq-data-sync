package com.hongtian.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.hongtian.entity.PztJmxqRlzpjlDahua;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author weed
 * @since 2020-12-15
 */
@DS("nbdh")
public interface PztJmxqRlzpjlDahuaMapper extends BaseMapper<PztJmxqRlzpjlDahua> {
    List<PztJmxqRlzpjlDahua> getUnHandleList();

    List<PztJmxqRlzpjlDahua> getUnHandleListByStart(@Param("start") int start, @Param("end") int end,@Param("time")String time);
}

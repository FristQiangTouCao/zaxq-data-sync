package com.hongtian.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hongtian.entity.PztJcssJb;
import com.hongtian.entity.dto.JcssGkVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 基础设施 Mapper 接口
 * </p>
 *
 * @author weed
 * @since 2020-12-15
 */
@DS("pz")
public interface PztJcssJbMapper extends BaseMapper<PztJcssJb> {
    List<JcssGkVo> cllstj(@Param("sslxs") List<String> sslxs, @Param("startTime")String startTime, @Param("endTime")String endTime);
    List<JcssGkVo> rllstj(@Param("sslxs") List<String> sslxs, @Param("startTime")String startTime, @Param("endTime")String endTime);

    void updateYcSbTargetClean();

    void updateYcSbTarget();
}

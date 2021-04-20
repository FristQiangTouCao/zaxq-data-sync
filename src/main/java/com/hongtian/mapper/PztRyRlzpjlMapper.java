package com.hongtian.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.hongtian.entity.PztRyRlzpjl;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 人员人脸抓拍记录 Mapper 接口
 * </p>
 *
 * @author weed
 * @since 2020-11-08
 */
@Repository
@DS("pz")
public interface PztRyRlzpjlMapper extends BaseMapper<PztRyRlzpjl> {
    List<PztRyRlzpjl> getUnHandleData();

    List<PztRyRlzpjl> getRyrlapjlByStartAndEnd(@Param("start") int start, @Param("end") int end, @Param("time") String time);

    List<PztRyRlzpjl> getRyrlapjlByStartAndEndCurrentMonth(@Param("start") int start, @Param("end") int end, @Param("time") String time);

    int deleteFsRlzpjl(@Param("time") String time);

}

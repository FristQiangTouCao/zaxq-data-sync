package com.hongtian.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.hongtian.util.DateTimeUtils;
import lombok.Data;
import org.apache.commons.lang3.time.DateUtils;

import java.util.Date;

/**
 * 后台任务日志
 */
@Data
@TableName("FWT_JOB_LOG")
public class FwtJobLog {

    /**
     * 内部编号.
     */
    @TableId(type = IdType.ASSIGN_ID)
    private String nbbh;

    /**
     * 开始时间.
     */
    private String kssj;

    /**
     * 结束时间.
     */
    private String jssj;

    /**
     * 任务名称.
     */
    private String rwmc;

    /**
     * 日志记录器名称.
     */
    private String rzjlqmc;

    /**
     * 完成数.
     */
    private Integer wcs = 0;

    /**
     * 成功数.
     */
    private Integer cgs = 0;

    /**
     * 失败数.
     */
    private Integer sbs = 0;

    /**
     * 无需完成数.
     */
    private Integer wxwcs = 0;

    /**
     * 备注.
     */
    private String bz;

    private String jsbz;

    private String xgsj;

    private String zxxc; //执行线程


    public Long getDuration() {
        try {
            Date start = DateUtils.parseDate(kssj, DateTimeUtils.DATETIME_PATTERN);
            Date end = DateUtils.parseDate(jssj, DateTimeUtils.DATETIME_PATTERN);
            long diff = end.getTime() - start.getTime();
            return diff / 1000;
        } catch (Exception e) {
            return null;
        }

    }

}


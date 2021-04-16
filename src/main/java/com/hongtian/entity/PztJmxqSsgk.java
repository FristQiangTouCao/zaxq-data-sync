package com.hongtian.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.hongtian.util.NumberUtils;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 
 * </p>
 *
 * @author weed
 * @since 2021-01-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("PZT_JMXQ_SSGK")
public class PztJmxqSsgk extends Model<PztJmxqSsgk> {

    private static final long serialVersionUID = 1L;

    @TableId("NBBH")
    private String nbbh;

    @TableField("SSLX")
    private String sslx;

    @TableField("TJRQ")
    private String tjrq;

    @TableField("TJSL")
    private BigDecimal tjsl;

    @TableField("JMXQBH")
    private String jmxqbh;

    @TableField("SBBH")
    private String sbbh;

    @TableField("SJGSDW")
    private String sjgsdw;

    @TableField("QTSL")
    private BigDecimal qtsl;

    /**
     * 实际落地数量
     */
    @TableField("SJLDSL")
    private BigDecimal sjldsl;

    /**
     * 人脸抓拍数量
     */
    @TableField("RLZPSL")
    private BigDecimal rlzpsl;


    /**
     * 人脸流水数与落地数量的比率
     */
    @TableField(exist = false)
    private double rlzpslVSlqtsl;

    /**
     * 带有落地标志的数量与总的流水数量的比率(落地率)
     */
    @TableField(exist = false)
    private double sjldslVSrlzpsl;

    /**
     * 落地数据使用率
     */
    @TableField(exist = false)
    private double sjldslVSqtsl;

    @TableField("xz")
    private String xz;

    @Override
    protected Serializable pkVal() {
        return this.nbbh;
    }

    public void computeGroundDate() {
        this.rlzpslVSlqtsl = NumberUtils.division(rlzpsl.longValue(),qtsl.intValue(),2);
        this.sjldslVSrlzpsl = NumberUtils.division(sjldsl.longValue(),rlzpsl.intValue(),2);
        this.sjldslVSqtsl = NumberUtils.division(sjldsl.longValue(),qtsl.intValue(),2);
    }

}

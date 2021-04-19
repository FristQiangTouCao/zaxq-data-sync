package com.hongtian.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 异常预警相关联车辆流水
 * </p>
 *
 * @author weed
 * @since 2021-04-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("PZT_CL_CRJL_YJXG")
public class PztClCrjlYjxg extends Model<PztClCrjlYjxg> {

    private static final long serialVersionUID = 1L;

    @TableField("NBBH")
    private String nbbh;

    @TableField("JMXQBH")
    private String jmxqbh;

    @TableField("SBBH")
    private String sbbh;

    @TableField("JLSJ")
    private String jlsj;

    @TableField("JCBZ")
    private String jcbz;

    @TableField("SJGSDW")
    private String sjgsdw;

    @TableField("CLSJ")
    private String clsj;

    @TableField("CPHM")
    private String cphm;

    @TableField("HPZL")
    private String hpzl;

    @TableField("BZ")
    private String bz;

    @TableField("GLM")
    private String glm;

    @TableField("CJR")
    private String cjr;

    @TableField("CJRJH")
    private String cjrjh;

    @TableField("CJRXQ")
    private String cjrxq;

    @TableField("CJRZRQ")
    private String cjrzrq;

    @TableField("CJRIP")
    private String cjrip;

    @TableField("CJSJ")
    private String cjsj;

    @TableField("XGR")
    private String xgr;

    @TableField("XGRJH")
    private String xgrjh;

    @TableField("XGRIP")
    private String xgrip;

    @TableField("XGRXQ")
    private String xgrxq;

    @TableField("XGRZRQ")
    private String xgrzrq;

    @TableField("XGSJ")
    private String xgsj;

    @TableField("YXBZ")
    private String yxbz;

    @TableField("FSBZ")
    private String fsbz;

    @TableField("CLBZ")
    private String clbz;

    @TableField("SBBZ")
    private String sbbz;

    @TableField("SBMC")
    private String sbmc;

    @TableField("CLBH")
    private String clbh;

    @TableField("RKBM")
    private String rkbm;

    @TableField("XM")
    private String xm;

    @TableField("GMSFHM")
    private String gmsfhm;

    @TableField("JCSSBH")
    private String jcssbh;

    @TableField("JMXQMC")
    private String jmxqmc;

    @TableField("JJZPURL")
    private String jjzpurl;

    @TableField("CPZPURL")
    private String cpzpurl;

    @TableField("YJZPURL")
    private String yjzpurl;

    @TableField("HCTURL")
    private String hcturl;

    @TableField("SLTURL")
    private String slturl;

    @TableField("GCJLXH")
    private String gcjlxh;

    @TableField("GCJLBH")
    private String gcjlbh;

    @TableField("HPYS")
    private String hpys;

    @TableField("SFZHAF")
    private String sfzhaf;

    @TableField("SSLX")
    private String sslx;

    /**
     * 异常预警关联编号
     */
    @TableField("YCYJBH")
    private String ycyjbh;


    @Override
    protected Serializable pkVal() {
        return null;
    }

}

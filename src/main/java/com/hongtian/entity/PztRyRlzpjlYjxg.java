package com.hongtian.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 人脸流水异常预警--关联流水
 * </p>
 *
 * @author weed
 * @since 2021-04-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("PZT_RY_RLZPJL_YJXG")
public class PztRyRlzpjlYjxg extends Model<PztRyRlzpjlYjxg> {

    private static final long serialVersionUID = 1L;

    @TableId("NBBH")
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

    @TableField("XM")
    private String xm;

    @TableField("GMSFHM")
    private String gmsfhm;

    @TableField("LYBS")
    private String lybs;

    @TableField("XXFL")
    private String xxfl;

    @TableField("JSYBZ")
    private String jsybz;

    @TableField("SWRYBZ")
    private String swrybz;

    @TableField("SARYBZ")
    private String sarybz;

    @TableField("ZYRYBZ")
    private String zyrybz;

    @TableField("BHRBZ")
    private String bhrbz;

    @TableField("KYRBZ")
    private String kyrbz;

    @TableField("ZPDTLJ")
    private String zpdtlj;

    @TableField("ZPKTLJ")
    private String zpktlj;

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

    @TableField("FACEID")
    private String faceid;

    @TableField("JCSSBH")
    private String jcssbh;

    @TableField("RKBM")
    private String rkbm;

    @TableField("JMXQMC")
    private String jmxqmc;

    @TableField("SJLY")
    private String sjly;

    @TableField("SIMLARITY")
    private String simlarity;

    @TableField("LDBZ")
    private String ldbz;

    @TableField("SFZHAF")
    private String sfzhaf;

    @TableField("SSLX")
    private String sslx;

    @TableField("RLJLID")
    private String rljlid;

    /**
     * 异常预警编号
     */
    @TableField("YCYJBH")
    private String ycyjbh;


    @Override
    protected Serializable pkVal() {
        return this.nbbh;
    }

}

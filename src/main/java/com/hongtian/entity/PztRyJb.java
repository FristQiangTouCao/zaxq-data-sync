package com.hongtian.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author weed
 * @since 2020-12-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("PZT_RY_JB")
public class PztRyJb extends Model<PztRyJb> {

    private static final long serialVersionUID = 1L;

    @TableId("RKBM")
    private String rkbm;

    @TableField("XM")
    private String xm;

    @TableField("CYM")
    private String cym;

    @TableField("BMCH")
    private String bmch;

    @TableField("XB")
    private String xb;

    @TableField("GJDQ")
    private String gjdq;

    @TableField("JG")
    private String jg;

    @TableField("MZ")
    private String mz;

    @TableField("CSRQ")
    private String csrq;

    @TableField("GMSFHM")
    private String gmsfhm;

    @TableField("HJDSSXQ")
    private String hjdssxq;

    @TableField("HJDXZ")
    private String hjdxz;

    @TableField("HJDXQ")
    private String hjdxq;

    @TableField("HJDDZBM")
    private String hjddzbm;

    @TableField("XZDSSXQ")
    private String xzdssxq;

    @TableField("XZDXZ")
    private String xzdxz;

    @TableField("XZDXQ")
    private String xzdxq;

    @TableField("XZDDZBM")
    private String xzddzbm;

    @TableField("LXDH")
    private String lxdh;

    @TableField("YWX")
    private String ywx;

    @TableField("YWM")
    private String ywm;

    @TableField("ZJZL")
    private String zjzl;

    @TableField("ZJHM")
    private String zjhm;

    @TableField("JWRYSF")
    private String jwrysf;

    @TableField("RJRQ")
    private String rjrq;

    @TableField("JLSY")
    private String jlsy;

    @TableField("NLKRQ")
    private String nlkrq;

    @TableField("WHCD")
    private String whcd;

    @TableField("HYZK")
    private String hyzk;

    @TableField("ZY")
    private String zy;

    @TableField("ZYLB")
    private String zylb;

    @TableField("FWCS")
    private String fwcs;

    @TableField("ZJXY")
    private String zjxy;

    @TableField("ZZMM")
    private String zzmm;

    @TableField("BYZK")
    private String byzk;

    @TableField("XX")
    private String xx;

    @TableField("LKRQ")
    private String lkrq;

    @TableField("QWDGJ")
    private String qwdgj;

    @TableField("QWDSSXQ")
    private String qwdssxq;

    @TableField("QWDXZ")
    private String qwdxz;

    @TableField("SWRQ")
    private String swrq;

    @TableField("ZXRQ")
    private String zxrq;

    @TableField("ZXBS")
    private String zxbs;

    @TableField("ZASJLY")
    private String zasjly;

    @TableField("LJSL")
    private BigDecimal ljsl;

    @TableField("YXLJSL")
    private BigDecimal yxljsl;

    @TableField("RYID")
    private String ryid;

    @TableField("HHID")
    private String hhid;

    @TableField("HHNBID")
    private String hhnbid;

    @TableField("HH")
    private String hh;

    @TableField("YHZGX")
    private String yhzgx;

    @TableField("SMJB")
    private BigDecimal smjb;

    @TableField("RYGLCC")
    private String ryglcc;

    @TableField("XMPY")
    private String xmpy;

    @TableField("CJR")
    private String cjr;

    @TableField("XGR")
    private String xgr;

    @TableField("CJSJ")
    private String cjsj;

    @TableField("XGSJ")
    private String xgsj;

    /**
     * 英文姓名
     */
    @TableField("ZWXM")
    private String zwxm;

    @TableField("HJDX")
    private BigDecimal hjdx;

    @TableField("HJDY")
    private BigDecimal hjdy;

    @TableField("HJDZ")
    private BigDecimal hjdz;

    @TableField("XZDX")
    private BigDecimal xzdx;

    @TableField("XZDY")
    private BigDecimal xzdy;

    @TableField("XZDZ")
    private BigDecimal xzdz;

    @TableField("HJDZRQ")
    private String hjdzrq;

    @TableField("XZDZRQ")
    private String xzdzrq;

    @TableField("ZW")
    private String zw;

    @TableField("DNA")
    private String dna;

    @TableField("SG")
    private String sg;

    @TableField("SFQRBZ")
    private String sfqrbz;

    @TableField("CJRJH")
    private String cjrjh;

    @TableField("CJRXQ")
    private String cjrxq;

    @TableField("CJRZRQ")
    private String cjrzrq;

    @TableField("CJRIP")
    private String cjrip;

    @TableField("XGRJH")
    private String xgrjh;

    @TableField("XGRXQ")
    private String xgrxq;

    @TableField("XGRZRQ")
    private String xgrzrq;

    @TableField("XGRIP")
    private String xgrip;

    @TableField("DWZZJG")
    private String dwzzjg;

    @TableField("HFAJBH")
    private String hfajbh;

    @TableField("ZDGZBZ")
    private String zdgzbz;

    @TableField("GZDSSXQ")
    private String gzdssxq;

    @TableField("GZDXZ")
    private String gzdxz;

    @TableField("GZDXQ")
    private String gzdxq;

    @TableField("GZDDZBM")
    private String gzddzbm;

    @TableField("GZDX")
    private BigDecimal gzdx;

    @TableField("GZDY")
    private BigDecimal gzdy;

    @TableField("GZDZ")
    private BigDecimal gzdz;

    @TableField("GZDZRQ")
    private String gzdzrq;

    @TableField("YXBZ")
    private String yxbz;

    @TableField("SBBZ")
    private String sbbz;

    @TableField("GLM")
    private String glm;

    @TableField("FSBZ")
    private String fsbz;

    @TableField("CLBZ")
    private String clbz;

    @TableField("BZ")
    private String bz;

    @TableField("RYDYLB")
    private String rydylb;

    @TableField("QZZL")
    private String qzzl;

    @TableField("QZHM")
    private String qzhm;

    @TableField("HJDJMXQBH")
    private String hjdjmxqbh;

    @TableField("XZDJMXQBH")
    private String xzdjmxqbh;

    @TableField("RKGLLBDM")
    private String rkgllbdm;

    @TableField("SYRKDZZDJLXDM")
    private String syrkdzzdjlxdm;

    @TableField("RHYZBS")
    private String rhyzbs;

    @TableField("GABXZDDZBM")
    private String gabxzddzbm;

    @TableField("GABHJDDZBM")
    private String gabhjddzbm;

    @TableField("DJDW_GAJGJGDM")
    private String djdwGajgjgdm;

    @TableField("DJDW_GAJGMC")
    private String djdwGajgmc;

    @TableField("SJGSDWMC")
    private String sjgsdwmc;

    @TableField("SJGSDWDM")
    private String sjgsdwdm;


    @Override
    protected Serializable pkVal() {
        return this.rkbm;
    }

}

package com.hongtian.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 基础设施
 * </p>
 *
 * @author weed
 * @since 2020-12-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("PZT_JCSS_JB")
public class PztJcssJb extends Model<PztJcssJb> {

    private static final long serialVersionUID = 1L;

    /**
     * 内部编号
     */
    @TableId("NBBH")
    private String nbbh;

    /**
     * 设施编号
     */
    @TableField("SSBH")
    private String ssbh;

    /**
     * 设施类型
     */
    @TableField("SSLX")
    private String sslx;

    /**
     * 所属辖区
     */
    @TableField("SSXQ")
    private String ssxq;

    /**
     * 设施地址
     */
    @TableField("SSDZ")
    private String ssdz;

    /**
     * 房屋地址编码
     */
    @TableField("FWDZBM")
    private String fwdzbm;

    /**
     * 属性描述
     */
    @TableField("SXMS")
    private String sxms;

    /**
     * 重点关注标志
     */
    @TableField("ZDGZBZ")
    private String zdgzbz;

    /**
     * 设施状态
     */
    @TableField("SSZT")
    private String sszt;

    /**
     * 最近检查人
     */
    @TableField("ZJJCR")
    private String zjjcr;

    /**
     * 最近检查辖区
     */
    @TableField("ZJJCXQ")
    private String zjjcxq;

    /**
     * 最近检查时间
     */
    @TableField("ZJJCSJ")
    private String zjjcsj;

    /**
     * 下次检查时间
     */
    @TableField("XCJCSJ")
    private String xcjcsj;

    /**
     * 建立人警号(V_DFK_YH)
     */
    @TableField("JLR")
    private String jlr;

    /**
     * 建立该信息的民警所在的部门
     */
    @TableField("JLXQ")
    private String jlxq;

    /**
     * 建立日期
     */
    @TableField("JLSJ")
    private String jlsj;

    /**
     * 撤消人警员号(V_DFK_YH)
     */
    @TableField("ZXR")
    private String zxr;

    /**
     * 撤消派出所机构代码(V_DFK_DWDM)
     */
    @TableField("ZXXQ")
    private String zxxq;

    /**
     * 注销原因
     */
    @TableField("ZXYY")
    private String zxyy;

    /**
     * 注销时间
     */
    @TableField("ZXSJ")
    private String zxsj;

    /**
     * web链接地址
     */
    @TableField("WEBURL")
    private String weburl;

    /**
     * 备注
     */
    @TableField("BZ")
    private String bz;

    /**
     * 过滤码
     */
    @TableField("GLM")
    private String glm;

    /**
     * 创建人
     */
    @TableField("CJR")
    private String cjr;

    /**
     * 创建人IP
     */
    @TableField("CJRIP")
    private String cjrip;

    /**
     * 入本库时间
     */
    @TableField("CJSJ")
    private String cjsj;

    /**
     * 修改人
     */
    @TableField("XGR")
    private String xgr;

    /**
     * 修改人IP
     */
    @TableField("XGRIP")
    private String xgrip;

    /**
     * 本库最后修改时间
     */
    @TableField("XGSJ")
    private String xgsj;

    /**
     * 有效标志(9004)
     */
    @TableField("YXBZ")
    private String yxbz;

    /**
     * 发送标志
     */
    @TableField("FSBZ")
    private String fsbz;

    /**
     * 1——未处理到图层
3——已处理到图层
     */
    @TableField("CLBZ")
    private String clbz;

    /**
     * 坐标X
     */
    @TableField("X")
    private BigDecimal x;

    /**
     * 坐标Y
     */
    @TableField("Y")
    private BigDecimal y;

    /**
     * 坐标Z
     */
    @TableField("Z")
    private BigDecimal z;

    @TableField("ZRQ")
    private String zrq;

    /**
     * 联系人
     */
    @TableField("LXR")
    private String lxr;

    /**
     * 联系电话
     */
    @TableField("LXDH")
    private String lxdh;

    @TableField("CJRJH")
    private String cjrjh;

    @TableField("CJRXQ")
    private String cjrxq;

    @TableField("CJRZRQ")
    private String cjrzrq;

    @TableField("XGRJH")
    private String xgrjh;

    @TableField("XGRXQ")
    private String xgrxq;

    @TableField("XGRZRQ")
    private String xgrzrq;

    @TableField("SSMC")
    private String ssmc;

    @TableField("JZWDZBM")
    private String jzwdzbm;

    /**
     * 街路巷名称
     */
    @TableField("JLXMC")
    private String jlxmc;

    /**
     * 街路巷代码
     */
    @TableField("JLXDM")
    private String jlxdm;

    @TableField("GXMJJH")
    private String gxmjjh;

    @TableField("GXMJ")
    private String gxmj;

    @TableField("GXDW")
    private String gxdw;

    @TableField("THIRDID")
    private String thirdid;

    @TableField("JMXQBH")
    private String jmxqbh;

    @TableField("LXRGMSFHM")
    private String lxrgmsfhm;

    @TableField("SBBZ")
    private String sbbz;

    @TableField("ZHLSSJ")
    private String zhlssj;

    @TableField("TDBM")
    private String tdbm;

    /**
     * 是否智安小区，0否1是
     */
    @TableField("SFZHAF")
    private String sfzhaf;

    @TableField("JGID")
    private String jgid;

    /**
     * 排查人
     */
    @TableField("PCR")
    private String pcr;

    /**
     * 排查人警号
     */
    @TableField("PCRJH")
    private String pcrjh;

    /**
     * 排查时间
     */
    @TableField("PCSJ")
    private String pcsj;

    /**
     * 排查标志
     */
    @TableField("PCBZ")
    private String pcbz;

    /**
     * 进出标志
     */
    @TableField("JCBZ")
    private String jcbz;

    @TableField("JMXQMC3")
    private String jmxqmc3;

    @TableField("JMXQMC2")
    private String jmxqmc2;

    @TableField("JMXQMC")
    private String jmxqmc;

    @TableField("PPXH")
    private String ppxh;

    @TableField("IPDZ")
    private String ipdz;

    @TableField("WLDKH")
    private String wldkh;

    @TableField("XZQHDM")
    private String xzqhdm;

    @TableField("CSDM")
    private String csdm;

    @TableField("SXJWZLX")
    private String sxjwzlx;

    @TableField("SJLY")
    private String sjly;

    /**
     * 异常标志
     */
    @TableField("YCBZ")
    private String ycbz;

    @TableField("SQXCBH")
    private String sqxcbh;

    /**
     * 是否可播放视频
     */
    @TableField("SFKBFSP")
    private String sfkbfsp;


    @Override
    protected Serializable pkVal() {
        return this.nbbh;
    }

}

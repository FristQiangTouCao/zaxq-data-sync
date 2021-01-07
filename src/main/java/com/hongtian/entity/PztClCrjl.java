package com.hongtian.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.data.annotation.Id;

/**
 * <p>
 * 车辆出入记录
 * </p>
 *
 * @author weed
 * @since 2020-11-08
 */
@Data
@TableName("PZT_CL_CRJL")
public class PztClCrjl{

    private static final long serialVersionUID = 1L;

    /**
     * 内部编号
     */
    @TableId("NBBH")
    @Id
    private String nbbh;

    /**
     * 居民小区编号
     */
    @TableField("JMXQBH")
    private String jmxqbh;

    /**
     * 设备编号
     */
    @TableField("SBBH")
    private String sbbh;

    /**
     * 记录时间
     */
    @TableField("JLSJ")
    private String jlsj;

    /**
     * 进出标志
     */
    @TableField("JCBZ")
    private String jcbz;

    /**
     * 数据归属单位
     */
    @TableField("SJGSDW")
    private String sjgsdw;

    /**
     * 处理时间
     */
    @TableField("CLSJ")
    private String clsj;

    /**
     * 车牌号码
     */
    @TableField("CPHM")
    private String cphm;

    /**
     * 号牌种类
     */
    @TableField("HPZL")
    private String hpzl;

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
     * 创建人警号
     */
    @TableField("CJRJH")
    private String cjrjh;

    /**
     * 创建人辖区
     */
    @TableField("CJRXQ")
    private String cjrxq;

    /**
     * 创建人责任区
     */
    @TableField("CJRZRQ")
    private String cjrzrq;

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
     * 修改人警号
     */
    @TableField("XGRJH")
    private String xgrjh;

    /**
     * 修改人IP
     */
    @TableField("XGRIP")
    private String xgrip;

    /**
     * 修改人辖区
     */
    @TableField("XGRXQ")
    private String xgrxq;

    /**
     * 修改人责任区
     */
    @TableField("XGRZRQ")
    private String xgrzrq;

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
     * 0:未处理, 1:无需处理, 2:处理中, 3:处理成功, 4:处理失败, 9:不再处理
     */
    @TableField("CLBZ")
    private String clbz;

    /**
     * 设备标志
     */
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
}

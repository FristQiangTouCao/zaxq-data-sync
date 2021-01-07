package com.hongtian.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 人员人脸抓拍记录
 * </p>
 *
 * @author weed
 * @since 2020-11-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("PZT_RY_RLZPJL")
public class PztRyRlzpjl {

    private static final long serialVersionUID = 1L;

    /**
     * 内部编号
     */
    @TableId("NBBH")
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
     * 姓名
     */
    @TableField("XM")
    private String xm;

    /**
     * 公民身份号码
     */
    @TableField("GMSFHM")
    private String gmsfhm;

    /**
     * 来源标识
     */
    @TableField("LYBS")
    private String lybs;

    /**
     * 信息分类
     */
    @TableField("XXFL")
    private String xxfl;

    /**
     * 0:否;1:是;2:不确定
     */
    @TableField("JSYBZ")
    private String jsybz;

    /**
     * 0:否;1:是;2:不确定
     */
    @TableField("SWRYBZ")
    private String swrybz;

    /**
     * 0:否;1:是;2:不确定
     */
    @TableField("SARYBZ")
    private String sarybz;

    /**
     * 0:否;1:是;2:不确定
     */
    @TableField("ZYRYBZ")
    private String zyrybz;

    /**
     * 0:否;1:是;2:不确定
     */
    @TableField("BHRBZ")
    private String bhrbz;

    /**
     * 0:否;1:是;2:不确定
     */
    @TableField("KYRBZ")
    private String kyrbz;

    /**
     * 抓拍大图链接
     */
    @TableField("ZPDTLJ")
    private String zpdtlj;

    /**
     * 抓拍抠图链接
     */
    @TableField("ZPKTLJ")
    private String zpktlj;

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

    /**
     * 人脸抓拍记录唯一主键
     */
    @TableField("RLJLID")
    private String rljlid;

    @TableField("DTYPE")
    private String dtype;

}
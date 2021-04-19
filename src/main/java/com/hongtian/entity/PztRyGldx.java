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
 * @since 2021-04-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("PZT_RY_GLDX")
public class PztRyGldx extends Model<PztRyGldx> {

    private static final long serialVersionUID = 1L;

    @TableId("RYYWBM")
    private String ryywbm;

    @TableField("RKBM")
    private String rkbm;

    @TableField("XM")
    private String xm;

    /**
     * 曾用名
     */
    @TableField("CYM")
    private String cym;

    /**
     * 别名绰号
     */
    @TableField("BMCH")
    private String bmch;

    @TableField("XMPY")
    private String xmpy;

    @TableField("XB")
    private String xb;

    /**
     * 国家地区(G178)
     */
    @TableField("GJDQ")
    private String gjdq;

    @TableField("JG")
    private String jg;

    /**
     * 民族(G179)
     */
    @TableField("MZ")
    private String mz;

    @TableField("CSRQ")
    private String csrq;

    /**
     * 公民身份号码
     */
    @TableField("GMSFHM")
    private String gmsfhm;

    @TableField("LXDH")
    private String lxdh;

    /**
     * 户籍地省市县(区)(G173)
扩展到12位表示户籍所在地辖区
     */
    @TableField("HJDSSXQ")
    private String hjdssxq;

    /**
     * 户籍地详址
     */
    @TableField("HJDXZ")
    private String hjdxz;

    @TableField("HJDXQ")
    private String hjdxq;

    @TableField("HJDZRQ")
    private String hjdzrq;

    @TableField("HJDDZBM")
    private String hjddzbm;

    /**
     * 暂住地省市县区G173
扩展到12位表示现住地辖区
     */
    @TableField("XZDSSXQ")
    private String xzdssxq;

    /**
     * 现住地详址
市（县、区）名称+街（路、巷、里弄）+门牌号。
示例：北京市朝阳区东长安街XX号XX号楼XX单元XX号
广州市东山区XX街XX号院XX号楼XX单元XX号

     */
    @TableField("XZDXZ")
    private String xzdxz;

    @TableField("XZDXQ")
    private String xzdxq;

    @TableField("XZDZRQ")
    private String xzdzrq;

    @TableField("XZDDZBM")
    private String xzddzbm;

    @TableField("GZDSSXQ")
    private String gzdssxq;

    /**
     * 现住地详址
市（县、区）名称+街（路、巷、里弄）+门牌号。
示例：北京市朝阳区东长安街XX号XX号楼XX单元XX号
广州市东山区XX街XX号院XX号楼XX单元XX号

     */
    @TableField("GZDXZ")
    private String gzdxz;

    @TableField("GZDXQ")
    private String gzdxq;

    @TableField("GZDDZBM")
    private String gzddzbm;

    /**
     * 人员的管理级别

A——老板、经理
B——管理层
C——
D——保安
E——娱乐场所的小姐

     */
    @TableField("RYGLCC")
    private String ryglcc;

    @TableField("DWZZJG")
    private String dwzzjg;

    /**
     * 职业类别G169

SQL Statement which produced this data:
  select csdm,csmc from xt_xtcs where cslb = 'G169'  order by csdm

CSDM    CSMC
0100    国家公务员
0200    企事业管理人员
0300    企事业职员
0400    工人
0500    农民
0501    农民（务农）
0502    农民（务工）
0503    农民（经商）
0504    农民（服务）
0599    农民（其他）
0600    在校学生
0601    小学生
0602    初中生
0603    高中生
0604    大学生
0700    个体工商业者
0800    离退休人员
0900    无业人员
1000    现役军人
1100    内部保卫人员
2200    外籍人员
2300    港澳台人员
9900    其他

     */
    @TableField("ZYLB")
    private String zylb;

    @TableField("FWCS")
    private String fwcs;

    @TableField("RYLX")
    private String rylx;

    /**
     * 派综中的代码
00    从未上过学
10    研究生
11    研究生毕业
19    研究生肄业
20    大学本科（简称大学）
21    大学毕业
28    相当大学毕业
29    大学肄业
30    大学专科和专科学校
31    专科毕业
38    相当专科毕业
39    专科肄业
40    中专或中等技术学校
41    中专毕业
42    中技毕业
48    相当中专或中技毕业
49    中专或中技肄业
50    技工学校
51    技工学校毕业
59    技工学校肄业
60    高中
61    高中毕业
62    职业高中毕业
63    农业高中毕业
68    相当高中毕业
69    高中肄业
70    初中
71    初中毕业
72    职业初中毕业
73    农业初中毕业
78    相当初中毕业
79    初中肄业
80    小学
81    小学毕业
82    初识
88    相当小学毕业
89    小学肄业
90    文盲或半文盲

原船舶船民系统中的代码
1    文盲
2    初小
3    高小
4    小学
5    初中
6    高中
7    大专
8    本科
9    研究

湖州水上系统的代码
1    小学
2    初中
3    高中
4    高小
5    文盲
6    大专

     */
    @TableField("WHCD")
    private String whcd;

    @TableField("HYZK")
    private String hyzk;

    /**
     * 政治面貌(G184)
     */
    @TableField("ZZMM")
    private String zzmm;

    /**
     * 职业
     */
    @TableField("ZY")
    private String zy;

    /**
     * 工作单位
     */
    @TableField("GZDW")
    private String gzdw;

    /**
     * GA 324.6
血型G123
SQL Statement which produced this data:
  select csdm,csmc from xt_xtcs where cslb = 'G123'  order by csdm

CSDM    CSMC
0    不明
1    A型
2    B型
3    O型
4    AB型

     */
    @TableField("XX")
    private String xx;

    @TableField("SG")
    private String sg;

    @TableField("DNA")
    private String dna;

    @TableField("ZW")
    private String zw;

    @TableField("SXMS")
    private String sxms;

    /**
     * 撤消人警员号(V_DFK_YH)
     */
    @TableField("ZXR")
    private String zxr;

    @TableField("ZXRJH")
    private String zxrjh;

    /**
     * 撤消派出所机构代码(V_DFK_DWDM)
     */
    @TableField("ZXRXQ")
    private String zxrxq;

    @TableField("ZXRZRQ")
    private String zxrzrq;

    @TableField("ZXRIP")
    private String zxrip;

    @TableField("ZXSJ")
    private String zxsj;

    @TableField("ZXYY")
    private String zxyy;

    @TableField("GKJZRQ")
    private String gkjzrq;

    @TableField("ZLBZ")
    private String zlbz;

    @TableField("ZLBH")
    private String zlbh;

    @TableField("ZLSJ")
    private String zlsj;

    @TableField("GXDW")
    private String gxdw;

    @TableField("GXMJ")
    private String gxmj;

    @TableField("GXMJJH")
    private String gxmjjh;

    @TableField("GXMJLXDH")
    private String gxmjlxdh;

    @TableField("SFQRBZ")
    private String sfqrbz;

    @TableField("GKBZ")
    private String gkbz;

    @TableField("ZJGKSJ")
    private String zjgksj;

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

    @TableField("GZDX")
    private BigDecimal gzdx;

    @TableField("GZDY")
    private BigDecimal gzdy;

    @TableField("GZDZ")
    private BigDecimal gzdz;

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

    /**
     * 入本库时间
     */
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

    @TableField("FSBZ")
    private String fsbz;

    /**
     * 1——未处理到图层
3——已处理到图层
     */
    @TableField("CLBZ")
    private String clbz;

    @TableField("SBBZ")
    private String sbbz;

    @TableField("ZXZT")
    private String zxzt;

    @TableField("LGZT")
    private String lgzt;

    @TableField("HJDGXDW")
    private String hjdgxdw;

    @TableField("HJDGXMJ")
    private String hjdgxmj;

    @TableField("HJDGXMJJH")
    private String hjdgxmjjh;

    @TableField("HJDGXMJLXDH")
    private String hjdgxmjlxdh;

    @TableField("HJDJMXQBH")
    private String hjdjmxqbh;

    @TableField("XZDJMXQBH")
    private String xzdjmxqbh;

    @TableField("JSBRBDQK")
    private String jsbrbdqk;

    /**
     * 是否再监狱
     */
    @TableField("SFZJY")
    private String sfzjy;

    /**
     * 工作力量人员类型
     */
    @TableField("GZLLYKLX")
    private String gzllyklx;


    @Override
    protected Serializable pkVal() {
        return this.ryywbm;
    }

}

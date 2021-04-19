package com.hongtian.util;

/**
 * Created by cyetstar on 15-7-22.
 */
public class PzConstants {

    public static final String ZASJLY_PZ = "00";//00派综
    public static final String ZASJLY_PZXFJ = "01";//派综协辅警

    public static final String ZASJLY_CZRK = "11";//11常住人口系统
    public static final String ZASJLY_LDRK = "25";//25流动人口

    public static final String ZASJLY_JWZH = "51";//51警务综合

    public static final String ZASJLY_DFK = "75";//75 打防控
    public static final String ZASJLY_JQ = "76";//76 110警情系统
    public static final String ZASJLY_JWRY = "77";//77 境外人员
    public static final String ZASJLY_ZZ = "78";//78 众智

    public static final String ZASJLY_RALGT = "80";//瑞安流管通
    public static final String ZASJLY_NBALJC = "81";//宁波阿拉警察
    public static final String ZASJLY_ENB = "82";//e宁波（网格）
    public static final String ZASJLY_NBJJ = "83";//83 宁波交警
    public static final String ZASJLY_WYF = "84";//84 芝立网约房代码
    public static final String ZASJLY_LQFGT = "85";//85 路桥房管通

    /*********** 人脸抓拍数据来源 ***********/
    public static final String RLZPSJLY_ZL = "01"; //
    public static final String RLZPSJLY_HS = "02"; // 海曙
    public static final String RLZPSJLY_FH = "03"; // 奉化
    public static final String RLZPSJLY_XS = "04"; // 象山

    /*********** 通用 ***********/
    /**
     * 处理标志
     */
    public static final String CLBZ_WCL = "0"; //未处理
    public static final String CLBZ_WXCL = "1"; //无需处理
    public static final String CLBZ_CLZ = "2"; //处理中
    public static final String CLBZ_CLCG = "3"; //处理成功
    public static final String CLBZ_CLSB = "4"; //处理失败CLBZ_SJBWZ ="4"; //数据不完整
    public static final String CLBZ_DZWPP = "5"; //地址未匹配
    public static final String CLBZ_DSFCL = "8";  //第三方处理
    public static final String CLBZ_BZCL = "9";  //不再处理//老框架是无需处理

    /**
     * 巡查标志
     */
    public static final String XCBZ_DXC = "0"; // 巡查标志--待巡查
    public static final String XCBZ_HG = "1"; // 巡查标志--合格
    public static final String XCBZ_BHG = "2";// 巡查标志--不合格
    /**
     * 巡查类型
     */
    public static final String XCLX_ZQRW = "1"; // 巡查类型-周期任务
    public static final String XCLX_GZZL = "2"; // 巡查类型-工作指令

    /**
     * 排查类型
     */
    public static final String PCLX_HYCSSPJR = "1"; // 排查类型-行业场所视频接入
    public static final String PCLX_NBDWGZSJJR = "2"; // 排查类型-内保单位感知数据接入排查

    /**
     * 肇事肇祸精神病人注销状态
     */
    public static final String ZXZT_WZX = "0"; // 注销状态-未注销
    public static final String ZXZT_XZDZX = "1"; // 注销状态-现住地注销
    public static final String ZXZT_HJDZX = "2";// 注销状态-户籍地注销
    public static final String ZXZT_YZX = "3";// 注销状态-已注销
    /**
     * 肇事肇祸精神病人列管状态
     */
    public static final String LGZT_DLG = "1"; // 列管状态-单列管
    public static final String LGZT_SLG = "2"; // 列管状态-双列管

    /**
     * 草稿箱
     */
    public static final String CGX_CGLX_XFJDWCJ = "11";  //协辅警单位采集
    public static final String CGX_CGLX_XFJWPCJ = "12";  //协辅警物品采集
    public static final String CGX_CGLX_MJGLDXCJ = "21";  //民警管理对象采集
    public static final String CGX_CGLX_MJJWZLCJ = "22";  //民警警务助理采集
    public static final String CGX_CGLX_MJXJWPCJ = "23";  //民警邪教物品采集

    /**
     * 地址匹配标志
     */
    public static final String DZPPBZ_WPP = "0";//未匹配
    public static final String DZPPBZ_SJJYSB = "1";//数据校验失败
    public static final String DZPPBZ_SQZHSB = "2"; //社区转换失败
    public static final String DZPPBZ_PPCW = "3"; //匹配错误
    public static final String DZPPBZ_PPSB = "4"; //匹配失败
    public static final String DZPPBZ_DZBCZ = "5"; //标准地址不存在
    public static final String DZPPBZ_HLPP = "6"; //忽略匹配
    public static final String DZPPBZ_PPCG = "7"; //匹配成功
    public static final String DZPPBZ_RGPP = "8"; //人工匹配
    public static final String DZPPBZ_WXPP = "9"; //无需匹配

    /**
     * 地址匹配标志
     */
    public static final String DZGFBZ_BGF = "0";//不规范
    public static final String DZGFBZ_GF = "1";//规范
    public static final String DZGFBZ_GFDSH = "2";//规范待审核

    /**
     * 学校类型
     */
    //幼儿园
    public static final String XXFL_YEY = "1";
    //小学
    public static final String XXFL_XX = "2";
    //中学
    public static final String XXFL_ZX = "3";

    /**
     * 门禁预警类型
     */
    //门禁类型 -- 页面显示
    public static final String MJYJ_QYZXLKSQ = "11";  //企业考勤注销流口授权
    public static final String MJYJ_CZFZXLKSQ = "01"; //出租房注销流口授权
    public static final String MJYJ_CZFWSYSB = "02"; //出租房未使用设备 #
    public static final String MJYJ_CZFBZXSB = "03"; //出租房未在线设备 #
    public static final String MJYJ_DZBG = "04";//地址变更人员
    public static final String MJYJ_MJSBWSK = "05"; //门禁设备未刷卡
    public static final String MJYJ_CZFWDJLKSQ = "06"; //出租房未登记流口授权#

    public static final String MJYJ_WGRY = "07";  //晚归人员 #
    public static final String MJYJ_YRDFRY = "08";  //一人多房人员 #
    public static final String MJYJ_ZXDJLK = "12";  //注销登记流口 = 企业考勤注销流口 + 出租房注销流口 #
    public static final String MJYJ_WDJLK = "13";  //未登记流口授权 = 企业考勤未登记流口 + 出租房未登记流口 #

    public static final String ZTRY_XJZT = "9"; //刑拘在逃

    /**
     * 打防控-案件类别
     */
    //温州
    public static final String DFK_AJ = "DFKAJ"; //打防控案件

    public static final String DFK_AJ_RHQJ = "050101"; //入户抢劫案件 050101  01050101
    public static final String DFK_AJ_RHDQ = "050201"; //入户盗窃案件 050201  01050201
    public static final String DFK_AJ_DDCDQ = "050227DD"; //盗窃电动车案件 050227DD
    public static final String DFK_AJ_DXZP = "050300DX"; //电信诈骗 050300DX
    public static final String DFK_AJ_WLZP = "050300wl"; //网络诈骗 050300wl
    public static final String DFK_AJ_JZDWCL = "050101"; //电信诈骗 050300DX
    public static final String DFK_AJ_JDCWCL = "050101"; //网络诈骗 050300wl
    //宁波
    public static final String DFK_AJ_DQA = "050200"; //盗窃案 a_ajlb
    public static final String DFK_AJ_QDA = "050400"; //抢夺案
    public static final String DFK_AJ_ZPA = "050300"; //诈骗案
    public static final String DFK_AJ_GYSHA = "040103"; //故意伤害案

    /**
     * ******** 工作指令 ********
     */

    //优先级
    public static final String GZZL_YXJ_D = "1";//低
    public static final String GZZL_YXJ_Z = "2"; //中
    public static final String GZZL_YXJ_G = "3"; //高

    //指令标志
    public static final String GZZL_ZLBZ_DCL = "0"; //待处理
    public static final String GZZL_ZLBZ_DSH = "1"; //待审核
    public static final String GZZL_ZLBZ_YCL = "9"; //已处理
    public static final String GZZL_ZLBZ_XTWC = "91"; //系统完成

    //3303温州
    public static final String GZZL_ZLLX_AJHF_RHQJ = "01" + DFK_AJ_RHQJ; //入户抢劫案件 010001
    public static final String GZZL_ZLLX_AJHF_RHDQ = "01" + DFK_AJ_RHDQ; //入户盗窃案件 010001
    public static final String GZZL_ZLLX_AJHF_DXZP = "01" + DFK_AJ_DXZP; //电信诈骗 010002
    public static final String GZZL_ZLLX_AJHF_DDCDQ = "01" + DFK_AJ_DDCDQ; //盗窃电动车案件 010003
    public static final String GZZL_ZLLX_AJHF_WLZP = "01" + DFK_AJ_WLZP; //网络诈骗 010004
    public static final String GZZL_ZLLX_AJHF_JZDWCL = "01" + DFK_AJ_JZDWCL; //盗窃电动车案件 010003
    public static final String GZZL_ZLLX_AJHF_JDDWWCL = "01" + DFK_AJ_JDCWCL; //网络诈骗 010004

    //3303温州（晓彰）
    public static final String GZZL_ZLLX_ZAXQYJTS = "01060001"; //智安小区预警推送
    public static final String GZZL_ZLLX_LKJDXXTS = "01070001"; //流口寄递信息推送

    //3302宁波
    public static final String GZZL_ZLLX_AJHF_DQA = "01" + DFK_AJ_DQA; //盗窃案
    public static final String GZZL_ZLLX_AJHF_QDA = "01" + DFK_AJ_QDA; //抢夺案
    public static final String GZZL_ZLLX_AJHF_ZPA = "01" + DFK_AJ_ZPA; //诈骗案
    public static final String GZZL_ZLLX_AJHF_GYSHA = "01" + DFK_AJ_GYSHA; //故意伤害案

    //重点人员--02xxxx
    public static final String GZZL_ZLLX_ZDRY_TFRY = "020001"; //在逃人员
    public static final String GZZL_ZLLX_ZDRY_XDRY = "020002"; //吸毒人员

    //人员管控-03xxxx
    public static final String GZZL_ZLLX_RYGK_GZRY = "030001"; //人员管控--关注人员
    public static final String GZZL_ZLLX_RYGK_JGDX = "030002"; //人员管控--监管对象

    //门禁预警--04xxxx
    public static final String GZZL_ZLLX_MJYJ_ZXDJLK = "040001"; //注销登记流口
    public static final String GZZL_ZLLX_MJYJ_WDJLK = "040002"; //未登记流口
    public static final String GZZL_ZLLX_MJYJ_WGRY = "040003"; //晚归人员
    public static final String GZZL_ZLLX_MJYJ_YRDFRY = "040004"; //一人多房人员
    public static final String GZZL_ZLLX_MJYJ_WZXSB = "040005"; //未在线设备
    public static final String GZZL_ZLLX_MJYJ_WSYSB = "040006"; //未使用设备
    public static final String GZZL_ZLLX_MJYJ_SWTYJ = "040007"; //视网通预警

    //提醒: 05xxxx
    public static final String GZZL_ZLLX_TX_ZGDQ = "050001"; //行业场所检查整改到期
    public static final String GZZL_ZLLX_TX_JQSJ = "050400"; //警情事件提醒
    public static final String GZZL_ZLLX_TX_JQJFSJ = "050401"; //警情纠纷事件提醒    永嘉专属

    //警情自定义提醒： JQZDY0001
    public static final String GZZL_ZLLX_JQZDYTX_PREFIX = "JQZDY";

    //330382 乐清
    public static final String GZZL_ZLLX_TX_JQDF = "050501"; //警情事件提醒-警情多发
    public static final String GZZL_ZLLX_TX_MGJQ = "050502"; //警情事件提醒-敏感警情

    //网格化: 06xxxx
    public static final String GZZL_ZLLX_GRID_RHFL = "060101"; //现住地提醒
    public static final String GZZL_ZLLX_GRID_LDRKDJ = "060102"; //流动人口为登记提醒
    public static final String GZZL_ZLLX_GRID_LDRKBG = "060103"; //流动人口变更提醒
    public static final String GZZL_ZLLX_GRID_ZFYC = "060201"; //走访异常提醒
    public static final String GZZL_ZLLX_GRID_SJDCL = "060202"; //网格事件待处理
    public static final String GZZL_ZLLX_GRID_SJSJ = "060203"; //网格三级以上事件提醒
    public static final String GZZL_ZLLX_GRID_HYCSDJ = "060301"; //行业场所登记提醒
    public static final String GZZL_ZLLX_GRID_HYCSZX = "060302"; //行业场所注销提醒

    /**
     * 永嘉 START
     */
    //寄递业提醒
    public static final String GZZL_ZLLX_JDG_JJRYWDJTX = "070001"; // 寄件人员未登记提醒

    public static final String GZZL_ZLLX_JDG_JFCFJQTX = "071001"; // 纠纷重复警情提醒
    /**
     * 永嘉 END
     */
    // 智安小区指令
    public static final String GZZL_ZLLX_ZAXQ_YJTX = "ZAXQ0001"; // 智安小区预警提醒

    public static final String ZLLX_RY = "RY0001"; // 智安小区预警提醒

    public static final String GZZL_ZLLX_QT = "99"; //其他

    //发布标志
    public static final String FBBZ_WFB = "0"; //发布标志:未发布
    public static final String FBBZ_YFB = "1"; //发布标志:已发布
    public static final String FBBZ_HL = "9"; //发布标志:忽略

    @Deprecated
    public static final String GZZL_ZLSFBZ_DJS = "01"; //待接收

    public static final String GZZL_ZLSFBZ_DCL = "02"; //待处理
    public static final String GZZL_ZLSFBZ_DCY = "03"; //待查阅
    public static final String GZZL_ZLSFBZ_YFK = "11"; //已反馈
    public static final String GZZL_ZLSFBZ_YHT = "12"; //已回退
    public static final String GZZL_ZLSFBZ_YZF = "13"; //已转发
    public static final String GZZL_ZLSFBZ_YWC = "21"; //已处理
    public static final String GZZL_ZLSFBZ_YCY = "22"; //已查阅

    public static final String GZZL_FKBZ_WFK = "0"; //未反馈
    public static final String GZZL_FKBZ_YFK = "1"; //已反馈
    public static final String GZZL_FKBZ_WXFK = "2"; //无需反馈
    public static final String GZZL_FKBZ_YCK = "5"; //已查看

    public static final String SHBZ_DSH = "0";//待审核
    public static final String SHBZ_SHBTG = "1";//审核不通过
    public static final String SHBZ_WXSH = "2"; //无需审核
    public static final String SHBZ_SHTG = "9";//审核通过

    public static final String YGFG_HCBZ_DHC = "0";//待核查
    public static final String YGFG_HCBZ_KHC = "3";//可核查
    public static final String YGFG_HCBZ_YHC = "9";//已核查
    /**
     * 案件回访
     */
    public static final String DWPPBZ_WPP = "0"; //未匹配
    public static final String DWPPBZ_PPCG = "1"; //定位匹配成功
    public static final String DWPPBZ_PPSB = "2"; //定位匹配失败

    public static final String GZZL_FKFS_SDHF = "01"; //实地回访
    public static final String GZZL_FKFS_DHHF = "02"; //电话回访
    public static final String GZZL_FKFS_QTHF = "03"; //其他回访

    /**
     * 事件
     */
    //事件来源
    public static final String EVENT_SJLY_ENB = "0"; //e宁波
    public static final String EVENT_SJLY_GA = "1"; //公安

    public static final String EVENT_CZLX_SB = "sb"; //上报
    public static final String EVENT_CZLX_SBBC = "sbbc"; //上报补充
    public static final String EVENT_CZLX_BJ = "bj"; //办结
    public static final String EVENT_CZLX_BJBC = "bjbc"; //办结补充
    public static final String EVENT_CZLX_GB = "gb"; //关闭

    public static final String EVENT_SJZT_WCL = "wcl"; //未处理
    public static final String EVENT_SJZT_CLZ = "clz"; //处理中
    public static final String EVENT_SJZT_YCL = "ycl"; //已处理

    public static final String GRID_TBBZ_WTB = "0"; //未同步
    public static final String GRID_TBBZ_YTB = "1"; //已同步
    public static final String GRID_TBBZ_TBSB = "2"; //同步失败

    /**
     * ******** 警种核查 **********
     */

    public static final String JZHC_JZHCLB_JZHD = "1";//警种核对
    public static final String JZHC_JZHCLB_YPXX = "0";//研判信息

    public static final String JZHC_HCJGBZ_XXYZ = "1";//信息一致
    public static final String JZHC_HCJGBZ_XXBZ = "0";//信息补正

    public static final String JZHC_FCCLBZ_WCL = "0";//未处理
    public static final String JZHC_FCCLBZ_WXCL = "1";//无需处理
    public static final String JZHC_FCCLBZ_DDXTCL = "3";//等待系统自动处理
    public static final String JZHC_FCCLBZ_YCL = "9";//已处理

    /**
     * ******** 房屋 ********
     */

    public static final String FW_ACT_SAVE = "save";
    public static final String FW_ACT_DELETE = "delete";

    public static final String FW_JFLX_HOUSE = "0"; //住房
    public static final String FW_JFLX_SHOP = "1"; //店铺
    public static final String FW_JFLX_BASEMENT = "2"; //地下室

    public static final String FW_FWSYQK_KZ = "0"; //空置
    public static final String FW_FWSYQK_ZY = "1"; //自用
    public static final String FW_FWSYQK_HY = "2";//合用
    public static final String FW_FWSYQK_CZ = "4";//出租
    public static final String FW_FWSYQK_QZ = "49";//群租
    public static final String FW_FWSYQK_QZDC = "491";//群租待查
    public static final String FW_FWSYQK_CJ = "7";//出借
    public static final String FW_FWSYQK_FKZ = "9";//非空置

    public static final String JZLX_JZW = "1";//建筑物
    public static final String JZLX_FW = "2";//房屋

    public static final String SPBZ_DSP = "0";//待审批
    public static final String SPBZ_SPBTG = "1";//审批不通过
    public static final String SPBZ_SPTG = "9";//审批通过

    public static final String PCBZ_WPC = "0";//未排查
    public static final String PCBZ_YPC = "1";//已排查
    public static final String PCBZ_WFC = "2";//未复查
    public static final String PCBZ_YFC = "3";//已复查



    //*************************************************************//
    // 人员类型、机构类型、设施类型进行重定义，与图层类型进行合并
    //*************************************************************//
    //1字头 常口相关
    public static final String RYLX_CZRK = "RY0010";//常住人口 RY0010
    public static final String RYLX_RHFL = "RY0093";//人户分离人员 RY0093
    public static final String RYLX_RHFLRY_RZ = "RY00931"; //人在户不在人员 RY00931
    public static final String RYLX_RHFLRY_HZ = "RY00932"; //户在人不在人员 RY00932
    public static final String RYLX_WLCZRK = "RY0015";//未落常住人口 RY0015
    public static final String RYLX_LDRK = "RY0020";//流动人口 RY0020
    public static final String RYLX_JWRY = "RY0030";//境外人员 RY0030
    public static final String RYLX_JWRY_CZ = "RY00301";//常住境外人员 RY0031
    public static final String RYLX_JWRY_LZ = "RY00302";//临住境外人员 RY0031
    public static final String RYLX_JWRY_ZDRY = "RY00303";//境外重点人员 RY0032

    public static final String RYLX_JGDX = "RY0040";//监管对象 RY0040
    public static final String RYLX_JGDX_GZ = "RY0041";//被依法判处管制的罪犯 RY0041
    public static final String RYLX_JGDX_BDZZQL = "RY0042";//被依法剥夺政治权利的罪犯 RY0042
    public static final String RYLX_JGDX_HX = "RY0043";//被依法判处缓刑的罪犯 RY0043
    public static final String RYLX_JGDX_JS = "RY0044";//被假释的罪犯 RY0044
    public static final String RYLX_JGDX_JWZX = "RY0045";//暂予监外执行的犯罪分子 RY0045
    public static final String RYLX_JGDX_JWZX_BWJY = "RY00451";//有严重疾病需要保外就医的 RY00451
    public static final String RYLX_JGDX_JWZX_HYBR = "RY00452";//怀孕或正在哺乳自己婴儿的妇女 RY00452
    public static final String RYLX_JGDX_JWZX_SHBNZL = "RY00453";//生活不能自理，适用暂予监外执行不致危害社会的 RY00453
    public static final String RYLX_JGDX_LDJY = "RY0046";//劳动教养所外执行人员 RY0046
    public static final String RYLX_JGDX_QBHS = "RY0047";//取保候审人员 RY0047
    public static final String RYLX_JGDX_JSJZ = "RY0048";//监视居住人员 RY0048
    public static final String RYLX_JGDX_SXRQ = "RY0049";//视线人群 RY0049

    public static final String RYLX_CSRY_LJS = "RY0052";//劳教所出所人员 RY0052
    public static final String RYLX_CSRY_KSS = "RY0053";//看守所出所人员（刑满释放） RY0053
    public static final String RYLX_CSRY_JLS = "RY0054";//拘留所出所人员 RY0054
    public static final String RYLX_CSRY_JDS = "RY0055";//戒毒所出所人员 RY0055
    public static final String RYLX_CSRY_FJS = "RY0056";//妇教所出所人员 RY0056
    public static final String RYLX_CSRY_SJS = "RY0057";//少教所出所人员 RY0057
    public static final String RYLX_CSRY_AKYY = "RY0058";//安康医院出所人员 RY0058
    public static final String RYLX_CSRY_SQJZ = "RY0059";//社区矫正对象 RY0059

    public static final String RYLX_CSRY_SQFXRY = "RY0060";//社区服刑人员 RY0059，永嘉

    public static final String RYLX_ZDSDRY = "RY0072";//重点涉毒人员 RY0072，永嘉、温州：吸毒重点人排查管控
    public static final String RYLX_YDSDRY = "RY0076";//异地涉毒人员 RY0076, 宁波
    public static final String RYLX_BDSDRY = "RY00761";//本地涉毒人员 RY00761, 宁波，暂先临时增加给北仑使用
    public static final String RYLX_SDTSRY = "RY0073";//涉毒脱失人员

    public static final String RYLX_DFK = "RY0075";//打防控 RY0075
    public static final String RYLX_DFK_DCRY = "RY00751";//打防控打处人员
    public static final String RYLX_DFK_SHR = "RY00752";//打防控受害人
    public static final String RYLX_XSJJ = "RY0061";//刑释解教人员 归正人员 RY0061
    public static final String RYLX_GWRK = "RY0066";//高危人口 RY0066
    public static final String RYLX_ZDRK = "RY0068";//重点人口 RY0068
    public static final String RYLX_XDRY = "RY0071";//吸毒人员 RY0071
    public static final String RYLX_GZDX = "RY70";//关注对象
    public static final String RYLX_JSB_ZSZH = "RY7202";//精神病肇事肇祸  // 路桥：重性精神病人
    public static final String RYLX_JSB_DS = "RY0092";//精神病呆傻人员 RY0092
    public static final String RYLX_FZCSW = "RY0095";//非正常死亡 RY0095


    public static final String RYLX_SDRY = "RY0111";//涉赌人员 RY0111
    public static final String RYLX_SHRY = "RY0121";//涉黄人员 RY0121

    public static final String RYLX_QKRY = "RY50";//前科人员 RY50
    public static final String RYLX_ZDQKLJ = "RY501";//有可能继续作案的重点刑事犯罪前科人员 RY501 原RY7098

    @Deprecated
    public static final String RYLX_JDXWR = "RY67";//极端行为人//有实施个人极端暴力犯罪倾向人员 RY67   与扬言报复社会是同一个类型
    public static final String RYLX_WSSBYHXX = "RY671";//经常在网上散布谣言或发布政治类有害信息的人员 RY671 原RY7099 // 温州废弃

    public static final String RYLX_FFFWRY = "RY72";//非法访问人员    // 温州废弃（路桥启用）
    public static final String RYLX_GAKXFZDR = "RY721";//公安口信访重点人 RY721
    public static final String RYLX_FGAKXFZDR = "RY722";//非公安口信访重点人 RY722

    public static final String RYLX_CXWFFZRY = "RY75";//传销违法犯罪人员 RY75
    public static final String RYLX_CXRY_CXFZQKRY = "RY751";//传销犯罪前科人员 RY751 // 温州废弃
    public static final String RYLX_CXRY_YSFJLCXZDRY = "RY752";//有上访记录的传销重点人员 RY752 // 温州废弃

    public static final String RYLX_CSRY = "RY79";//涉财人员
    public static final String RYLX_SZXJJFZ_AJZDRY = "RY791";//涉众型经济犯罪案件重点人员 RY791
    //    public static final String RYLX_SZXJJFZ_SHR = "RY795";//涉众型经济犯罪受害人 RY795 原RY7095
    public static final String RYLX_SZXQCFZ_SHR = "RY796";//涉众型侵财犯罪受害人 RY796 原RY7096

    public static final String RYLX_CYRY = "RY80";// 从业人员
    public static final String RYLX_CYRY_ZFJGSY = "DW20NC"; //政府机构事业 DW20NC
    public static final String RYLX_CYRY_YHJR = "DW10NC"; //银行金融 DW10NC
    public static final String RYLX_CYRY_XX = "XX10NC"; //学校 XX10NC
    public static final String RYLX_CYRY_GCQY = "DW30NC"; //工厂企业 DW30NC
    public static final String RYLX_CYRY_SCCS = "DW40NC"; //商场超市 DW40NC
    public static final String RYLX_CYRY_SDDP = "DW41NC"; //商店店铺 DW41NC
    public static final String RYLX_CYRY_CYFW = "DW50NC"; //餐饮服务 DW50NC
    public static final String RYLX_CYRY_GWYLCS = "GF10C"; //歌舞娱乐场所 GF10C
    public static final String RYLX_CYRY_JB = "GF15C"; //酒吧 GF15C
    public static final String RYLX_CYRY_YY = "GF17C"; //演艺 GF17C
    public static final String RYLX_CYRY_YXYXCS = "GF20C"; //游戏游艺场所 GF20C
    public static final String RYLX_CYRY_SWFWCS = "GF30NC"; //上网服务场所 GF30NC
    public static final String RYLX_CYRY_LXFYCS = "GF40NC"; //录像放映场所 GF40NC
    public static final String RYLX_CYRY_SNXY = "GF61C"; //桑拿洗浴 GF61C
    public static final String RYLX_CYRY_ZY = "GF63C"; //足浴 GF63C
    public static final String RYLX_CYRY_MSMF = "GF65C"; //美容美发 GF65C
    public static final String RYLX_CYRY_QPS = "GF71C"; //棋牌室 GF71C
    public static final String RYLX_CYRY_LGY = "TZ10C"; //旅馆业 TZ10C
    public static final String RYLX_CYRY_KZY = "TZ20C"; //刻章业 TZ20C
    public static final String RYLX_CYRY_JDCXLY = "TZ32C"; //机动车修理业 TZ32C
    public static final String RYLX_CYRY_TCC = "TZ33NC"; //停车场 TZ33NC
    public static final String RYLX_CYRY_YSY = "TZ40NC"; //印刷业 TZ40NC
    public static final String RYLX_CYRY_DDY = "TZ53C"; //典当业 TZ53C
    public static final String RYLX_CYRY_FJJS = "TZ55C"; //废旧金属 TZ55C
    public static final String RYLX_CYRY_TJ = "TZ58C"; //调剂 TZ58C
    public static final String RYLX_CYRY_PM = "TZ59NC"; //拍卖 TZ59NC
    public static final String RYLX_CYRY_JDY = "TZ65NC"; //寄递业 TZ65NC
    public static final String RYLX_CYRY_JYZ = "TZ67C"; //加油站 TZ67C
    public static final String RYLX_CYRY_WXWPDW = "WX10NC"; //危险物品单位 WX10NC
    public static final String RYLX_CYRY_QTDW = "XQ99NC"; //其他单位 XQ99NC

    public static final String RYLX_GZRY = "XQ15C"; //工作人员 XQ15C,XQ99C
    public static final String RYLX_GZRY_PCS = "XQ82C";//派出所工作人员 Pzt_pcs_jb XQ82C
    public static final String RYLX_MJ = "XQ82MJ";//派出所工作人员 - 派出所民警 XQ82MJ
    public static final String RYLX_XJ = "XQ82XJ";//派出所工作人员 - 派出所协警 XQ82XJ
    public static final String RYLX_WGY = "XQ82WGY";//派出所工作人员 - 网格员
    public static final String RYLX_TJY = "XQ82TJY";//调解员
    public static final String RYLX_GZRY_ZRQ = "RY83JG1013";//责任区工作人员
    public static final String RYLX_GZRY_SQXC = "XQ86C";//社区乡村工作人员 Pzt_sqxc_jb XQ86C
    public static final String RYLX_BARY = "XQ10BA";//保安人员
    public static final String RYLX_JWZL = "XQ82JW";//警务助理 原RY1000
    public static final String RYLX_JYYW = "XQ82JY";//见义勇为
    public static final String RYLX_ZYZQLL = "RY0101";//专业执勤力量

    public static final String RYLX_ZMRS = "RY0091";//知名人士 RY0091
    public static final String RYLX_QFQZZZRY = "RY0081";//群防群治组织人员 RY0081
    public static final String RYLX_QTRY = "RY0099";//其他人员 RY0099
    public static final String RYLX_QBXXR = "RY0100";//情报信息员

    public static final String RYLX_YYBFSHRY = "RY53";//扬言报复社会人员(宁波叫极端倾向) //路桥：极端暴力倾向人员
    public static final String RYLX_XJZS = "RY531";//酗酒滋事人员
    public static final String RYLX_JTBL = "RY54";//家庭暴力人员
    public static final String RYLX_SXZDRY = "RY55";//涉校重点人员

    public static final String RYLX_SQSBZDR = "RY1010";//涉枪涉爆重点人员
    public static final String RYLX_LSSHSXWZXQZGLJDSYQXRY = "RY1020";//流散社会涉刑未执行强制隔离戒毒剩余期限人员

    public static final String RYLX_GRID_GGLL = "RY9010";//骨干力量
    public static final String RYLX_GRID_FWDX = "RY9020";//服务对象
    public static final String RYLX_GRID_GKRY = "RY9030";//管控人员
    public static final String RYLX_TWJR = "RY81";//永嘉：退伍军人 //路桥：涉军重点人员

    //路桥重点人员类型
    public static final String RYLX_SKRY = "RY82";//涉恐人员
    public static final String RYLX_MGGJWGR = "RY83";//敏感国家外国人
    public static final String RYLX_XFZDRY = "RY84";//信访重点人员
    public static final String RYLX_GBZDRY = "RY85";//国保重点人员
    public static final String RYLX_JZZDRY = "RY86";//经侦重点人员

    //*************************************************************/
    // 机构类型
    //*************************************************************/
    public static final String JGLX_ZJCS = "DW05"; //宗教场所 DW05
    public static final String JGLX_ZJCS_SM = "DW051"; //寺庙 DW051
    public static final String JGLX_ZJCS_JT = "DW053"; //教堂 DW053
    public static final String JGLX_ZJCS_QT = "DW059"; //其他宗教场所

    public static final String JGLX_YHJR = "DW10"; //银行金融 DW10
    public static final String JGLX_LJR = "DW109"; //类金融 DW109
    public static final String JGLX_ZFJGSY = "DW20"; //政府机构事业 DW20

    public static final String JGLX_RMTT = "DW21"; //人民团体
    public static final String JLGX_BXY = "DW22"; //保险业
    public static final String JLGX_WFZG = "DW23"; //文化展馆
    public static final String JLGX_TYYL = "DW24"; //体育游乐
    public static final String JLGX_WWBH = "DW25"; //文物保护
    public static final String JLGX_SCSK = "DW26"; //水厂水库
    public static final String JGLX_JGKY = "DW27"; //军工科研
    public static final String JGLX_TXCS = "DW28"; //通讯传输
    public static final String JGLX_GBDS = "DW29"; //广播电视
    public static final String JGLX_XWCB = "DW33"; //新闻出版
    public static final String JGLX_CKCB = "DW34"; //仓库储备
    public static final String JGLX_JCGK = "DW35"; //机场港口
    public static final String JGLX_JCZDDW = "DW351"; //机场重点单位
    public static final String JGLX_JTYS = "DW36"; //交通运输
    public static final String JGLX_DQSD = "DW37"; //大桥隧道
    public static final String JGLX_WHQY = "DW38"; //危化企业
    public static final String JGLX_DXQY = "DW39"; //大型企业
    public static final String JLGX_ZQY = "DW44"; //证券业
    public static final String JLGX_WBDW = "DW45"; //文博单位
    public static final String JLGX_GJZDJSDW = "DW46"; //国家重点建设单位

    //学校类
    public static final String JGLX_XX = "DW15"; //学校 XX10
    public static final String JGLX_ZXXX = "DW151"; //中小学校
    public static final String JGLX_QTJYDW = "DW152"; //其他教育单位
    public static final String JGLX_PXJG = "DW154"; //培训机构 DW44
    public static final String JGLX_YEY = "DW155"; //幼儿园
    public static final String JGLX_GDYX = "DW156"; //高等院校

    public static final String JGLX_GCQY = "DW30"; //工厂企业 DW30
    public static final String JGLX_3DDYXGDW = "DW301"; //3D打印相关单位 DW301

    //交通类
    public static final String JGLX_CZMT = "DW31"; //车站码头 DW31
    public static final String JGLX_CTKYZ = "DW313"; //长途客运站 DW33
    public static final String JGLX_GJCZ = "DW314"; //公交车站 DW34
    public static final String JGLX_GJGS = "DW315"; //公交公司 DW315

    //供水供电类
    public static final String JGLX_SDYQ = "DW32"; //水电油气 DW32
    public static final String JGLX_GSDW = "DW325"; //供水单位 DW35(永嘉)
    public static final String JGLX_GDDW = "DW326"; //供电单位 DW36(永嘉)、电力企业(宁波)
    public static final String JGLX_RQJYDW = "DW327"; //燃气经营单位 DW37(永嘉)
    public static final String JGLX_YQHG = "DW328"; //油气化工(宁波)

    public static final String JGLX_QTZDDW = "DW99"; //其他重点单位
    public static final String JGLX_SCCS = "DW40"; //商场超市 DW40
    public static final String JGLX_DXSCCS = "DW401"; //大型超市
    public static final String JGLX_DXSDDP = "DW402"; //大型商场
    public static final String JGLX_SDDP = "DW41"; //商店店铺 DW41
    public static final String JGLX_CYFW = "DW50"; //餐饮服务 DW50
    public static final String JGLX_FWZJ = "DW54"; //房屋中介
    public static final String JGLX_FYGS = "DW55"; //物业公司 DW55
    public static final String JGLX_BAY = "DW56"; //保安业 DW56

    //医院类
    public static final String JGLX_YYWSS = "DW80"; //医院
    public static final String JGLX_YIYUAN = "DW801"; //卫生院及以上医院 DW81
    public static final String JGLX_WSS = "DW802"; //卫生室 DW82
    public static final String JGLX_ZS = "DW805"; //诊所 DW85
    public static final String JGLX_QTYLJG = "DW809"; //其他医疗机构

    public static final String JGLX_ZDMBDW = "DW83"; //重点目标单位 DW83
    public static final String JGLX_JRFXDW = "DW84"; //金融风险单位 DW84
    public static final String JGLX_JYXFWCS_JD = "DW85"; //经营性服务场所（禁毒）温州
    public static final String JGLX_GWYLCS = "GF10"; //歌舞娱乐场所 GF10
    public static final String JGLX_AMFFCS = "GF11"; //按摩服务场所 GF61-》GF11
    public static final String JGLX_JB = "GF15"; //酒吧 GF15
    public static final String JGLX_YY = "GF17"; //演艺 GF17
    public static final String JGLX_YXYXCS = "GF20"; //游戏游艺场所 GF20
    public static final String JGLX_SWFWCS = "GF30"; //上网服务场所 GF30
    public static final String JGLX_LWDW = "GF32"; //联网单位 GF32
    public static final String JGLX_WB = "GF35"; //网吧 GF35
    public static final String JGLX_LXFYCS = "GF40"; //录像放映场所 GF40
    public static final String JGLX_SNXY = "GF61"; //桑拿洗浴 GF61
    public static final String JGLX_ZY = "GF63"; //足浴 GF63
    public static final String JGLX_MRMF = "GF65"; //美容美发 GF65
    public static final String JGLX_YSMT = "GF67"; //养生美体 GF67
    public static final String JGLX_QPS = "GF71"; //棋牌室 GF71
    public static final String JGLX_JYXFWCS = "GF72"; //经营性服务场所（禁毒）

    //旅馆类
    public static final String JGLX_LGY = "TZ10"; //旅馆业 TZ10
    public static final String JGLX_LGY_LG = "TZ101"; //旅馆 TZ101
    public static final String JGLX_LGY_SYYS = "TZ103"; //宿夜浴室 TZ103
    public static final String JGLX_LGY_JDSGY = "TZ105"; //酒店式公寓 TZ105
    public static final String JGLX_LGY_MS = "TZ107"; //民宿民居
    public static final String JGLX_LGY_NJL = "TZ109"; //农家乐

    //刻章类
    public static final String JGLX_KZY = "TZ20"; //刻章业 TZ20
    public static final String JGLX_KZY_GZ = "TZ201"; //公章 TZ201
    public static final String JGLX_KZY_SZ = "TZ203"; //私章 TZ203

    public static final String JGLX_DDCXX = "TZ30"; //电动车销售 TZ30
    public static final String JGLX_FJDCXLY = "TZ31"; //非机动车修理业 TZ31
    public static final String JGLX_JDCXLY = "TZ32"; //机动车修理业 TZ32
    public static final String JGLX_JDCXLY_QC = "TZ321"; //汽车 TZ321
    public static final String JGLX_JDCXLY_MTC = "TZ322"; //摩托车 TZ322
    public static final String JGLX_TCC = "TZ33"; //停车场 TZ33
    public static final String JGLX_YSY = "TZ40"; //印刷业 TZ40
    public static final String JGLX_DDY = "TZ53"; //典当业 TZ53
    public static final String JGLX_FJJS = "TZ55"; //废旧金属 TZ55
    public static final String JGLX_FJJS_SCX = "TZ551"; //生产性废旧金属 TZ551
    public static final String JGLX_FJJS_FSCX = "TZ552"; //非生产性废旧金属 TZ552
    public static final String JGLX_ESC_QC = "TZ571"; //二手车(汽车) TZ571
    public static final String JGLX_TJ = "TZ58"; //旧货调剂 TZ58
    public static final String JGLX_PM = "TZ59"; //拍卖 TZ59
    public static final String JGLX_WLHY = "TZ64"; //物流行业 TZ64
    public static final String JGLX_JDY = "TZ65"; //寄递业 TZ65
    public static final String JGLX_YZHY = "TZ66"; // 邮政行业 TZ66
    public static final String JGLX_JYZ = "TZ67"; //加油站 TZ67
    public static final String JGLX_MGW = "TZ68"; //敏感物 TZ68
    public static final String JGLX_ESSJ = "TZ56"; //二手手机交易 TZ56
    public static final String JGLX_YHCB = "TZ70"; //沿海船舶 TZ70
    public static final String JGLX_WRDY = "TZ71"; //无人岛屿 TZ71
    public static final String JGLX_KSY = "TZ80"; //开锁业 TZ80
    public static final String JGLX_FFMQZD = "TZ81"; //非法煤气站点 TZ81
    public static final String JGLX_YHQGYD = "TZ82"; //液化气供应点 TZ82
    public static final String JGLX_FFJYZ = "TZ83"; //非法加油站 TZ83
    public static final String JGLX_GZXSD = "TZ84"; //钢珠销售店 TZ84
    public static final String JGLX_PLHCXSD = "TZ85"; //批量火柴销售店 TZ85
    public static final String JGLX_SGDTXSD = "TZ86"; //水管堵头销售店 TZ86
    public static final String JGLX_DJXSD = "TZ87"; //刀具销售店 TZ87

    public static final String JGLX_WXWPDW = "WX10";    //危险物品单位  WX10
    public static final String JGLX_YHBZDW = "WX11";    //烟花爆竹经营单位  WX11
    public static final String JGLX_YHBZCCK = "WX111";    //烟花爆竹存储库
    public static final String JGLX_FSXWZDW = "WX12";   //放射性物质从业单位  WX12
    public static final String JGLX_GZDJDW = "WX13";    //管制刀具经营单位（生产销售）   WX13
    public static final String JGLX_MYBZWPDW = "WX14";  //民用爆炸物品从业单位  WX14
    public static final String JGLX_MYBZWPCCK = "WX141";  //民用爆炸物品存储库
    public static final String JGLX_BPZYXC = "WX142";  //爆破作业现场
    public static final String JGLX_MYQZDYDW = "WX15";  //民用枪支弹药从业单位  WX15
    public static final String JGLX_JDHXPDW = "WX16";   //剧毒化学品从业单位  WX16
    public static final String JGLX_GYQZDW = "WX17";    //公用枪支（包括公安、非公安）使用单位  WX17
    public static final String JGLX_YZBHXPDW = "WX18";  //易制爆化学品销售单位  WX18
    public static final String JGLX_YZDHXPDW = "WX22";  //易制毒化学品销售单位  WX22
    public static final String JGLX_NZZSYDW = "WX23";  //涉弩制造使用单位  WX23
    public static final String JGLX_QTDW = "XQ99"; //其他单位 XQ99

    //****************3303*********
    //温州, 机构单位
    //*****************************
    public static final String JGLX_SMLSD = "DW42"; //数码零售店 DW42
    public static final String JGLX_JYJGD = "DW43"; //金银加工店 DW43
    public static final String JGLX_ESCQC = "TZ571"; //二手车(汽车) TZ571

    //****************330324*********
    //温州永嘉, 机构单位
    //*****************************
    public static final String JGLX_WWBHDW = "DW101"; //文物保护单位 DW101
    public static final String JGLX_QCZLDW = "TZ572";//汽车租赁单位 TZ572 永嘉、宁波
    public static final String JGLX_FPHSZ = "TZ54";//废品回收站 TZ54 永嘉

    public static final String JGLX_GAHFDW = "DW47"; // 公安海防单位
    public static final String JGLX_GAHFDW_CB = "DW471"; // 船舶
    public static final String JGLX_GAHFDW_CBXZQY = "DW472"; // 船舶修造企业（个人）
    public static final String JGLX_GAHFDW_HSXXCBJYDW = "DW473"; // 海上休闲船舶经营单位（场所或个人）
    public static final String JGLX_GAHFDW_GAK = "DW474"; // 港岙口
    public static final String JGLX_GAHFDW_MT = "DW475"; // 码头
    public static final String JGLX_GAHFDW_TBD = "DW476"; // 停泊点
    public static final String JGLX_GAHFDW_WRDY = "DW477"; // 无人岛屿
    public static final String JGLX_GAHFDW_CBWXD = "DW478"; // 船舶维修点

    public static final String JGLX_NPSC = "DW401"; // 农批市场
    public static final String JGLX_NMSC = "DW402"; // 农贸市场
    public static final String JGLX_YD = "DW411"; // 药店
    public static final String JGLX_LTCS = "DW90"; // 露天场所
    public static final String JGLX_YLJG = "DW81"; // 养老机构

    /**
     * 基础设施
     */
    public static final String SSLX_JZ = "SS01"; //基站
    public static final String SSLX_SHJK = "SS02"; //社会监控
    public static final String SSLX_ZALFGT = "SS03"; //治安联防岗亭
    public static final String SSLX_JDGC = "SS04"; //警灯工程
    public static final String SSLX_XCZD = "SS05"; //宣传阵地
    public static final String SSLX_MJ = "SS07"; //门禁(芝立人员、车辆)
    public static final String SSLX_MJ_DM = "SS071"; //大门门禁（小区）
    public static final String SSLX_MJ_DYL = "SS072"; //单元楼门禁（小区）
    public static final String SSLX_MJ_CL = "SS073"; //车辆门禁（小区）
    public static final String SSLX_MJ_RL = "SS074"; //人脸门禁（小区）
    public static final String SSLX_MJ_RZFKJ = "SS075"; //人证访客机（小区）
    public static final String SSLX_WRDY = "SS08"; //无人岛屿
    public static final String SSLX_FQCD = "SS09"; //废弃厂房仓库场地
    public static final String SSLX_AFTYG = "SS10"; //安防体验馆
    public static final String SSLX_V3 = "SS11"; //v3设备

    public static final String SSLX_RLSB = "SS12"; //人脸识别
    public static final String SSLX_CLZP = "SS13";// 车辆抓拍
    public static final String SSLX_FKXT = "SS14";// 访客系统,  访客门禁（宁波）

    public static final String SSLX_SPSB = "SS15"; // 视频监控（小区）
    public static final String SSLX_RFIDSB = "SS17"; //  RFID设备（小区）
    public static final String SSLX_RLGZSB = "SS18"; //  人脸感知设备(大华)（小区）
    public static final String SSLX_CLKK = "SS19"; //  车辆卡口(大华)（小区）
    public static final String SSLX_RLYTJ = "SS20"; //  一体机(大华)（小区）

    // 设备数据来源
    public static final String JCSS_SJLY_DAHUA = "01";   //大华
    public static final String JCSS_SJLY_ZHILI = "02";   //芝立
    public static final String JCSS_SJLY_DAHUA_SP = "04"; //大华视频

    //    温州
    public static final String SSLX_PASK = "SS20"; // 平安哨卡
    public static final String SSLX_GYDH = "SS21"; // 公用电话
    public static final String SSLX_MSGJ = "SS22"; // 名胜古迹
    public static final String SSLX_ZWD = "SS23"; // 治污点
    public static final String SSLX_TXT = "SS24"; // 通讯塔
    public static final String SSLX_LSGS = "SS25"; // 历史古树
    public static final String SSLX_GJZ = "SS26"; // 公交站
    public static final String SSLX_QL = "SS27"; // 桥梁
    public static final String SSLX_HD = "SS28"; // 涵洞
    public static final String SSLX_ATM = "SS29"; // ATM
    public static final String SSLX_XFS = "SS30"; // 消防栓
    public static final String SSLX_GGCSZDBW = "SS31"; // 公共场所重点部位
    public static final String SSLX_YJYZ = "SS32"; // 义警驿站

    //物品管理
    public static final String WPLX_DMXFXMB = "WP01";//低慢小飞行目标
    public static final String WPLX_XXLYCB = "WP07"; //休闲旅游船舶 WP07
    public static final String WPLX_YHCB = "WP08"; //沿海船舶 WP08
    //public static final String WPLX_WXWP = "WP10";    //危险物品  WP10
    public static final String WPLX_YHBZ = "WP11";    //烟花爆竹  WP11
    public static final String WPLX_FSXHXP = "WP12";   //放射性化学品  WP12
    //public static final String WPLX_GZDJ = "WP13";    //管制刀具   WP13
    public static final String WPLX_MYBZWP = "WP14";  //民用爆炸物品  WP14
    public static final String WPLX_MYQZDY = "WP15";  //民用枪支弹药  WP15
    public static final String WPLX_YDQZ = "WP151";  //运动枪支
    public static final String WPLX_JDHXP = "WP16";   //剧毒化学品  WP16
    //public static final String WPLX_GYQZ = "WP17";    //公用枪支（包括公安、非公安）  WP17
    public static final String WPLX_YZBHXP = "WP18";  //易制爆化学品  WP18
    public static final String WPLX_YZDHXP = "WP19";  //易制毒化学品  WP19
    public static final String WPLX_QC = "WP20";  //汽车  WP20
    public static final String WPLX_MGWZ = "WP21";  //敏感物资
    public static final String WPLX_XCP = "WP22";  //宣传屏
    //    内保单位专属物品
    public static final String WPLX_YCC = "WP23";  //运钞车
    public static final String WPLX_ZYSS = "WP24";  //重要设施
    public static final String WPLX_ZYSB = "WP25";  //重要设备
    public static final String WPLX_ZYCP = "WP26";  //重要产品
    public static final String WPLX_ZYWZ = "WP27";  //重要物资

    public static final String WPLX_WHP = "WP28";  //危化品(温州)

    public static final String WPLX_YSXJWP = "WP50";  //疑似邪教物品

    /**
     * 基础台账
     */
    public static final String TZLX_AQFFXC = "TZ01"; //安全防范宣传
    public static final String TZLX_FZJY = "TZ02"; //法制教育
    public static final String TZLX_JMKT = "TZ03"; //警民恳谈
    public static final String TZLX_ZZDBXL = "TZ04"; //着装带班巡逻
    public static final String TZLX_BADYSPC = "TZ05"; //不安定因素排查
    public static final String TZLX_JWZLGZJL = "TZ06"; //警务助理工作记录
    public static final String TZLX_QFQZRYGZJL = "TZ07"; //群防群治人员工作记录
    public static final String TZLX_LQJS = "TZ09"; //两区建设
    public static final String TZLX_MDJF = "TZ11"; //矛盾纠纷
    public static final String TZLX_AFXJ = "TZ12"; //安防宣教
    public static final String TZLX_ZCLH = "TZ13"; //驻村联户
    public static final String TZLX_JQJLH = "TZ14"; //警群交流会

    //警情 三类有效警情
    public static final String JQ_XSAJ = "10"; //刑事案件
    public static final String JQ_ZASJ = "20"; //治安事件
    public static final String JQ_JBTS = "90"; //举报投诉

    //bjlxdm
    public static final String JQ_TGXS = "900100"; //提供线索

    //辖区划分标志
    public static final String DFKJQ_XQHFBZ_WHF = "00";//未划分
    public static final String DFKJQ_XQHFBZ_CW = "10";//错误
    public static final String DFKJQ_XQHFBZ_WXCL = "20";//无需处理
    public static final String DFKJQ_XQHFBZ_ZQ = "90";//正确
    /**
     * 地图图层
     */
    public static final String MAPTIER_DZ_PTFW = "DZ00";//普通房屋
    public static final String MAPTIER_DZ_CZFW = "DZ10";//出租房屋
    public static final String MAPTIER_DZ_CZFW_XFBHG = "DZ12";//出租房屋消防不合格，红色
    public static final String MAPTIER_DZ_CZFW_XFHG = "DZ13";//出租房屋消防合格，绿色
    public static final String MAPTIER_DZ_CZFW_XFWJC = "DZ14";//出租房屋消防未检查，灰色
    public static final String MAPTIER_DZ_CZFW_XFDPCGDTFYH = "DZ15";//出租房屋消防电瓶车过道停放隐患，黄色
    public static final String MAPTIER_DZ_QZF = "DZ18";//群租房
    public static final String MAPTIER_DZ_LSFW = "DZ20";//临时房屋
    public static final String MAPTIER_DZ_WYF = "DZ21";//网约房
    public static final String MAPTIER_DZ_CQFW = "DZ90";//拆迁房屋
    ////////////////////////////////////////////////////////////
    public static final String MAPTIER_RY_CZRK = "RY00";//常住人口
    public static final String MAPTIER_RY_WLHK = "RY01";//未落户口
    public static final String MAPTIER_RY_LDRK = "RY10";//流动人口
    public static final String MAPTIER_RY_RZHBZ = "RY11";//人在户不在
    public static final String MAPTIER_RY_HZRBZ = "RY12";//户在人不在
    public static final String MAPTIER_RY_JWRY = "RY20";//境外人员
    public static final String MAPTIER_RY_GWRY = "RY30";//高危人员
    public static final String MAPTIER_RY_ZDRY = "RY31";//重点人员
    public static final String MAPTIER_RY_XDRY = "RY32";//吸毒人员
    public static final String MAPTIER_RY_JGDX = "RY40";//监管对象
    public static final String MAPTIER_RY_JSBDSRY = "RY50";//精神病呆傻人员
    public static final String MAPTIER_RY_ZMRS = "RY60";//知名人士
    public static final String MAPTIER_RY_QFQZRY = "RY61";//群防群治人员
    /////////////////////////////////////////////////////////////////
    public static final String MAPTIER_DW_LGY = "DW00";//旅馆业单位
    public static final String MAPTIER_DW_KZY = "DW01";//刻章业单位
    public static final String MAPTIER_DW_YSY = "DW02";//印刷业单位
    public static final String MAPTIER_DW_DDY = "DW03";//典当业单位
    public static final String MAPTIER_DW_TJY = "DW04";//调剂寄售业单位
    public static final String MAPTIER_DW_FJJSSG = "DW05";//废旧金属收购单位
    public static final String MAPTIER_DW_JDCXL = "DW06";//机动车修理单位
    public static final String MAPTIER_DW_PMH = "DW07";//拍卖行单位
    public static final String MAPTIER_DW_TCC = "DW08";//停车场
    public static final String MAPTIER_DW_GWYL = "DW50";//歌舞娱乐场所
    public static final String MAPTIER_DW_JB = "DW51";//酒吧
    public static final String MAPTIER_DW_YY = "DW52";//演艺
    public static final String MAPTIER_DW_YXYY = "DW53";//游戏游艺场所
    public static final String MAPTIER_DW_SWFW = "DW54";//上网服务场所
    public static final String MAPTIER_DW_AMFW = "DW55";//按摩服务场所
    public static final String MAPTIER_DW_ZY = "DW56";//足浴
    public static final String MAPTIER_DW_MRMF = "DW57";//美容美发
    public static final String MAPTIER_DW_QPS = "DW58";//棋牌室
    public static final String MAPTIER_DW_LXFY = "DW59";//录像放映场所
    public static final String MAPTIER_DW_JDY = "DW65";//寄递业
    public static final String MAPTIER_DW_JYZ = "DW67";//加油站
    public static final String MAPTIER_DW_WX = "DW70";//危险物品单位
    public static final String MAPTIER_DW_XX = "DW80";//学校
    public static final String MAPTIER_DW_YYWS = "DW81";//医院 卫生所
    public static final String MAPTIER_DW_YHJR = "DW90";//银行金融
    public static final String MAPTIER_DW_ZFJGSY = "DW91";//政府机关事业
    public static final String MAPTIER_DW_GCQY = "DW92";//工厂企业
    public static final String MAPTIER_DW_SCCS = "DW93";//商场超市
    public static final String MAPTIER_DW_SDDP = "DW94";//商店店铺
    public static final String MAPTIER_DW_CYFW = "DW95";//餐饮服务
    ////////////////////////////////////////////////////////////
    public static final String MAPTIER_XQ_PCS = "XQ82";//派出所
    public static final String MAPTIER_XQ_JWQ = "XQ83";//警务区
    /////////////////////////////////////////////////////////////
    public static final String MAPTIER_SS_ATM = "ATM";//ATM机
    public static final String MAPTIER_SS_CAM = "CAM";//摄像头
    //////////////////////////////////////////////////////////
    public static final String MAPTIER_SS_ZCTX = "SS01";//基站
    public static final String MAPTIER_SS_SHJK = "SS02";//社会监控
    //public static final String MAPTIER_SS_SHJK_A = "SS021";//A类社会监控
    //public static final String MAPTIER_SS_SHJK_B = "SS022";//B类社会监控
    public static final String MAPTIER_SS_ZALFGT = "SS03";//治安联防岗亭
    public static final String MAPTIER_SS_JD = "SS04";//警灯
    public static final String MAPTIER_SS_XCZD = "SS05";//宣传阵地
    public static final String MAPTIER_SS_MJ = "SS07";//门禁
    public static final String MAPTIER_SS_WRDY = "SS08";//无人岛屿
    /////////////////////////////////////////////////////////
    public static final String MAPTIER_DFK_AJ = "DFKAJ";//打防控案件
    public static final String MAPTIER_DFK_DDCDQ = "DFKDDCDQ";//打防控电动车盗窃
    public static final String MAPTIER_DFK_RHDQ = "DFKRHDQ";//打防控入户盗窃
    public static final String MAPTIER_DFK_DXZP = "DFKDXZP";//打防控电信诈骗

    public static final String MAPTIER_DFK_WLZP = "DFKWLZP";//打防控网络诈骗
    public static final String MAPTIER_DFK_DQA = "DFKDQA";//盗窃案
    public static final String MAPTIER_DFK_QDA = "DFKQDA";//抢夺案
    public static final String MAPTIER_DFK_ZPA = "DFKZPA";//诈骗案

    public static final String MAPTIER_DFK_GYSHA = "DFKGYSHA";//故意伤害案
    /////////////////////////////////////////////////////////////////
    public static final String MAPTIER_JQ_JJ = "JQJJ";//警情全部
    public static final String MAPTIER_JQ_XSAJ = "JQXSAJ";//刑事案件
    public static final String MAPTIER_JQ_ZASJ = "JQZASJ";//治安事件

    public static final String MAPTIER_JQ_JBTS = "JQJBTS";//举报投诉

    public static final String MAPTIER_YDSB_ALL = "YDSB00"; //移动设备
    public static final String MAPTIER_YDSB_ZX = "YDSB01"; //移动设备在线
    public static final String MAPTIER_YDSB_LX = "YDSB02"; //移动设备离线

    public static final String MAPTIER_ZQRW_JGJC = "ZQRW01";//机构检查

    //记分管理
    public static final String JFGL_PDZT_WPD = "0"; //未评定
    public static final String JFGL_PDZT_PCSPD = "1"; //派出所已评定
    public static final String JFGL_PDZT_YPD = "2"; //已评定
    public static final String JFGL_JFDJ_A = "A"; //A
    public static final String JFGL_JFDJ_B = "B"; //B
    public static final String JFGL_JFDJ_C = "C"; //C

    public static final String JFGL_JLYY_JGJC = "1"; //机构检查
    public static final String JFGL_JLYY_JL = "2"; //奖励情况
    public static final String JFGL_JLYY_FA = "3"; //发案情况
    public static final String JFGL_JLYY_JFJC = "4"; //记分检查

    public static final String JFGL_BDYY_JRJFGL = "1"; //进入记分管理
    public static final String JFGL_BDYY_SJ = "4"; //升级
    public static final String JFGL_BDYY_JJ = "5"; //降级
    public static final String JFGL_BDYY_TRJFGL = "8"; //退出记分管理
    public static final String JFGL_JCBZ_WJ = "1"; //未检
    public static final String JFGL_JCBZ_ZJ = "2"; //已检但检查次数不够
    public static final String JFGL_JCBZ_YJ = "3"; //已检
    //周期
    public static final String PERIOD_1_DAY = "00";
    public static final String PERIOD_1_WEEK = "01";
    public static final String PERIOD_2_WEEK = "02"; //半月
    public static final String PERIOD_1_MONTH = "04";
    public static final String PERIOD_2_MONTH = "08";
    public static final String PERIOD_3_MONTH = "12";
    public static final String PERIOD_6_MONTH = "26";

    public static final String PERIOD_1_YEAR = "52";
    //周期任务 xtpz
    public static final String ZQRW_DAILY = "zqrw.daily"; //每天
    public static final String ZQRW_WEEKLY = "zqrw.weekly"; //每周
    public static final String ZQRW_FORTNIGHTLY = "zqrw.fortnightly";//每两周
    public static final String ZQRW_MONTHLY = "zqrw.monthly"; //每月

    public static final String ZQRW_SEMIANNUAL = "zqrw.semiannual"; //每半年

    public static final String ZQPZLX_PUBLICSECURITY = "1"; // 公安月
    public static final String ZQPZLX_NATURAL = "2"; // 自然月
    public static final String ZQRW_ZXRWLX_ZQXRW = "1"; // 周期性任务
    public static final String ZQRW_ZXRWLX_QZRQXRW = "2"; // 起止日期性任务

    //周期任务类型
    public static final String ZQRW_RWLX_AQFFXC = "01"; //安全防范宣传、集中宣传
    public static final String ZQRW_RWLX_FZJY = "02"; //法制教育
    public static final String ZQRW_RWLX_JMKT = "03"; //警民恳谈
    public static final String ZQRW_RWLX_ZZDBXL = "04"; //着装巡逻
    public static final String ZQRW_RWLX_BADYSPC = "05"; //不安定因素排查
    public static final String ZQRW_RWLX_XFJC = "06"; //消防检查
    public static final String ZQRW_RWLX_RHDC = "07"; //入户调查
    public static final String ZQRW_RWLX_QYPX = "08"; //企业培训
    public static final String ZQRW_RWLX_AFXJ = "11"; //安防宣教（路桥）
    public static final String ZQRW_RWLX_ZCLH = "12"; //驻村联户（路桥）
    public static final String ZQRW_RWLX_JCJLH = "13"; //警群交流会（路桥）
    public static final String ZQRW_RWLX_DPC = "14"; //大排查

    public static final String ZQRW_RWLX_JGJC = "81"; //机构检查
    public static final String ZQRW_RWLX_WPJC = "82"; //物品检查
    public static final String ZQRW_RWLX_RYGK = "83"; //人员管控
    public static final String ZQRW_RWLX_JFJC = "84"; //记分检查
    //层级
    public static final String ZQRW_CJ_ST = "2";//市局
    public static final String ZQRW_CJ_SJ = "4";//市局
    public static final String ZQRW_CJ_QX = "6";//区县

    public static final String ZQRW_CJ_PCS = "9";//派出所
    //任务状态
    public static final String RWZT_WWC = "0";//未完成
    public static final String RWZT_ASWC = "1";//按时完成
    public static final String RWZT_BLWC = "2";//补录完成

    public static final String RWZT_YQWWC = "3";//逾期未完成
    public static final String RWZT_WXCL = "4";//无需处理
    //工作日志创建方式
    public static final String GZRZ_CJFS_XT = "9";//系统创建

    public static final String GZRZ_CJFS_RG = "1";//人工创建

    //工作日志类型
    public static final String GZRZ_RZLX_QT = "7";//其他

    //工作日志 采集方式
    public static final String GZRZ_RZCJFS_AJHF = "8"; //案件回访

    //民调类型
    public static final String MDLB_WFDXPJ = "01";//服务对象评价
    public static final String MDLB_SXDPJ = "02";//熟悉度评价
    public static final String MDLB_DWLDPJ = "03";//单位领导评价

    //情报线索
    public static final String QBXS_XSLX_FXYH = "05"; //风险隐患
    public static final String QBXS_XSLX_SQMY = "11"; //社情民意
    public static final String QBXS_XSLX_DPC = "20"; //大排查
    public static final String QBXS_XSLY_HYCSJC = "06"; //行业场所检查

    public static final String QBXS_XSZT_WSB = "00"; //未上报
    public static final String QBXS_XSZT_XFJSB = "10"; //协辅警上报
    public static final String QBXS_XSZT_MJSB = "11"; //民警上报
    public static final String QBXS_XSZT_PCSSB = "12"; //派出所上报
    public static final String QBXS_XSZT_QXSB = "13"; //区县上报
    public static final String QBXS_XSZT_XFJBJ = "20"; //协辅警办结
    public static final String QBXS_XSZT_MJBJ = "21"; //民警办结
    public static final String QBXS_XSZT_PCSBJ = "22";  //派出所办结
    public static final String QBXS_XSZT_QXBJ = "23"; //区县办结
    public static final String QBXS_XSZT_SJBJ = "24"; //市局办结
    public static final String QBXS_XSZT_WXSB = "80"; //无需上报

    public static final String XSQB_XSZT_WSB = "0"; //暂存草稿(未上报)
    public static final String XSQB_XSZT_MJSB = "1"; //民警上报
    public static final String XSQB_XSZT_PCSSB = "2"; //派出所上报
    public static final String XSQB_XSZT_QXSB = "3"; //区县上报

    public static final String XSQB_XSZT_YPD = "9"; //已评定
    public static final String XSQB_XSJZ_YJZ = "1"; //有价值
    public static final String XSQB_XSJZ_WJZ = "9"; //无价值

    public static final String XSQB_CZQK_YWC = "01"; //已完成
    public static final String XSQB_CZQK_YSB = "02"; //已上报
    public static final String XSQB_CZQK_ZGZ = "03"; //整改中

    public static final String JGJC_ZGBZ_WXZG = "0"; //无需整改
    public static final String JGJC_ZGBZ_XYZG = "1"; //需要整改
    public static final String JGJC_ZGBZ_DCZG = "2"; //当场整改
    public static final String JGJC_ZGBZ_YZG = "4"; //已经整改

    public static final String PYGK_RWZT_NO = "0"; //未完成
    public static final String PYGK_RWZT_YQ = "1"; //已逾期
    public static final String PYGK_RWZT_YES = "2"; //已完成

    /**
     * 违法人员落脚点核对
     */
    public static final String ZH_RDLC_XJL = "00";//新记录同步结果
    public static final String ZH_RDLC_AJJBXX = "10";//案件基本信息
    public static final String ZH_RDLC_CBXX = "20";//承办信息
    public static final String ZH_RDLC_BAMJ = "30";//办案民警信息处理
    public static final String ZH_RDLC_DZPP = "40";//地址匹配
    public static final String ZH_RDLC_DZWPP = "50";//地址未匹配
    public static final String ZH_RDLC_ZHRQ = "80";//抓获日期
    public static final String ZH_RDLC_AQJF = "90";//案前建房

    //办案民警评估结果//上级部门裁定结果//最终评估结果
    public static final String ZH_ZZPGJG_LKYDJ = "20";//流口已登记
    public static final String ZH_ZZPGJG_LKWDJ = "30";//流口未登记
    public static final String ZH_ZZPGJG_LGYDJ = "40";//旅馆已登记
    public static final String ZH_ZZPGJG_LGWDJ = "50";//旅馆未登记
    public static final String ZH_ZZPGJG_CKRHYZ = "80";//常口人户一致
    public static final String ZH_ZZPGJG_CKRHFL = "90";//常口人户分离

    //落脚点类型
    public static final String ZH_JZDLX_LG = "1";//旅馆
    public static final String ZH_JZDLX_LK = "2";//流口
    public static final String ZH_JZDLX_CK = "3";//自有房

    //社区民警核对结果

    public static final String ZH_HDJG_TY = "20";
    public static final String ZH_HDJG_YYY = "30";

    //核查流程阶段
    public static final String HCCLJD_XCF = "0";
    public static final String HCCLJD_SJSJWC = "01";//标准地址已匹配未评估

    public static final String HCCLJD_BAMJPG_YPG = "03"; // 已评估

    public static final String HCCLJD_SQMJHDWC_YYY = "05";//社区民警已核对有异议

    public static final String HCCLJD_LCWC_WXCD = "07";
    public static final String HCCLJD_SJBMCD_WC = "08";

    public static final String HCCLJD_WFZDAJBH = "11";//无法找到案件编号
    public static final String HCCLJD_WFZDAJXX = "12";//无法找到案件信息
    public static final String HCCLJD_WFZDAJBLXX = "13";//无法找到案件办理信息
    public static final String HCCLJD_WFZDBAMJSFZH = "14";//无法找到办案民警身份证信息
    public static final String HCCLJD_WFZDBAMJXX = "15";//无法找到办案民警信息
    public static final String HCCLJD_WFZDBAMJDWXX = "16";//无法找到办案民警单位信息
    public static final String HCCLJD_DZWPP = "20"; //地址未匹配, 非标准地址未评估
    public static final String HCCLJD_DZWPP_BAMJYPG = "21"; //非标准地址,办案民警已评估
    public static final String HCCLJD_WGDCS = "22"; //无固定住址
    public static final String HCCLJD_WM16Y = "25"; //非本省市
    public static final String HCCLJD_BSBSS = "26"; //非本省市

    //处理标志
    public static final String ZH_CLBZ_WCL = "0"; //未处理
    public static final String ZH_CLBZ_YCL = "3";  //已处理
    public static final String ZH_CLBZ_SJBWZ = "4"; //数据不完整
    public static final String ZH_CLBZ_DZWPP = "5"; //地址未匹配

    //信息不完全标志
    public static final String JG_XXBWQBZ_WZ = "0"; // 信息完整
    public static final String JG_XXBWQBZ_BTXBQ = "1"; // 必填项是否不全
    public static final String JG_XXBWQBZ_GXMJBYZ = "2"; // 管辖民警与管辖单位不一致

    //案前/案后建房人房关联类型
    public static final String ZH_RFGLLX_LK = "2";//流口
    public static final String ZH_RFGLLX_CK = "3";//常口人户一致
    public static final String ZH_RFGLLX_RHFL = "4";//常口人户分离

    public static final String ZH_CLBZ_WXCL = "9";  //无需处理

    public static final String MDMYD_BMY = "1"; //不满意
    public static final String MDMYD_BTMY = "3"; //不太满意
    public static final String MDMYD_JBMY = "5"; //基本满意

    //民调
    public static final String MDMYD_MY = "7"; //满意
    public static final String MDSXD_BZD = "1"; //不知道
    public static final String MDSXD_ZD = "3"; //知道

    public static final String MDSXD_SGM = "5"; //上过门

    public static final String FJ_CCXS_DB = "db";//数据库
    public static final String FJ_CCXS_FS = "fs";//文件系统
    public static final String FJ_CCXS_FTP = "ftp";//FTP文件系统
    public static final String FJ_CCXS_OSS = "oss";//云存储

    public static final String CGBZ_WSB = "0";//未上报
    public static final String CGBZ_YSB = "2";//已上报

    public static final String CGBZ_YCG = "4";//已抄告

    /**
     * 辖区代码整理
     */
    public static final String XQDMZL_DMLX_PCS = "11";//派出所
    public static final String XQDMZL_DMLX_JWH = "12";//居委会

    public static final String XQDMZL_ZLBZ_WZL = "0";//未整理
    public static final String XQDMZL_ZLBZ_QR = "1";//确认
    public static final String XQDMZL_ZLBZ_FQ = "2";//废弃

    /**
     * 地区代码
     */
    public static final String DQDM_NB = "3302";//宁波

    public static final String DQDM_WZ = "3303";//温州
    /**
     * 二维码-房码前缀，值{@value}
     */
    public static final String QRCODE_PREFIX_FW = "fw";
    /**
     * 二维码-业码前缀，值{@value}
     */
    public static final String QRCODE_PREFIX_DW = "dw";
    //二维码扫描类型：关联二维码或扫描二维码后做检查
    public static final String QRCODE_SMLX_GL = "01";//关联
    public static final String QRCODE_SMLX_JC = "02";//检查
    public static final String QRCODE_SMDXLX_DW = "pztJgJb";//单位

    public static final String JYQK_ZCJY = "1"; //正常经营
    public static final String JYQK_XY = "5"; //歇业
    public static final String JYQK_TY = "8"; //停业

    /**
     * 境外人员发送标志-新增未发送.
     */
    public static final String JWRY_FSBZ_XZWFS = "0";

    /**
     * 境外人员发送标志-更新未发送.
     */
    public static final String JWRY_FSBZ_GXWFS = "1";

    /**
     * 境外人员发送标志-新增发送失败.
     */
    public static final String JWRY_FSBZ_XZFSSB = "2";

    /**
     * 境外人员发送标志-更新发送失败.
     */
    public static final String JWRY_FSBZ_GXFSSB = "3";

    /**
     * 境外人员发送标志-发送成功.
     */
    public static final String JWRY_FSBZ_FSCG = "4";

    /**
     * 境外人员发送标志-境外人员系统导入数据无需发送.
     */
    public static final String JWRY_FSBZ_DRSJ = "5";

    /**
     * 境外人员数据来源-派出所综合.
     */
    public static final String JWRY_SJLY_CRJ = "1";
    public static final String JWRY_SJLY_LGY = "3";
    public static final String JWRY_SJLY_PCSZH = "4";

    public static final String ZZMJLB_ZRMJ = "1";
    public static final String ZZMJLB_ZRMJ_JZ = "3";
    public static final String ZZMJLB_ZGY = "2";
    public static final String ZZMJLB_AKYYGLY = "6";//安康医院管理员
    public static final String ZZMJLB_ZADDGLY = "7";//治安大队管理员
    public static final String ZZMJLB_XFJ = "8";
    public static final String ZZMJLB_FGFSZ = "9";

    /**
     * 区域类型
     */
    public static final String QYLX_ZHAFXQ = "1"; //智慧安防小区

    /**
     * 警务室类型
     */
    public static final String JWSLX_JWS = "1"; //警务室
    public static final String JWSLX_JWLLS = "2"; //警务联络室
    public static final String JWSLX_JWLLD = "3"; //警务联络点

    /**
     * 责任区类型
     */
    public static final String ZRQLX_ZRQ = "1";// 责任区
    public static final String ZRQLX_ZRQK = "2";// 责任区块

    /**
     * 案事件类型-非法上访
     */
    public static final String ASJLX_FFSF = "0";

    /**
     * 案事件类型-越级上访
     */
    public static final String ASJLX_YJSF = "1";

    /**
     * 案事件类型-消防违法
     */
    public static final String ASJLX_XFWF = "2";

    /**
     * 案事件类型-火灾事故
     */
    public static final String ASJLX_HZSG = "3";

    /**
     * 案事件类型-人员重大事件
     */
    public static final String ASJLX_RYZDSJ = "4";

    public static final String QXZ_SUPER_ADMIN = "0";
    public static final String QXZ_SJ_ADMIN = "2";
    public static final String QXZ_QX_ADMIN = "4";
    public static final String QXZ_PCS_ADMIN = "8";
    public static final String QXZ_ZRMJ = "10";
    public static final String QXZ_XFJ = "20";

    /**
     * 评价标志
     */
    public static final String PJBZ_WPJ = "0";
    public static final String PJBZ_YX = "1";
    public static final String PJBZ_WX = "2";
    public static final String PJBZ_WXPJ = "9";

    public static final String KHDXLX_MJ = "1";
    public static final String KHDXLX_PCS = "2";
    public static final String KHDXLX_QX = "3";

    //纠纷调解-当事人类型
    public static final String JFTJ_DSRLX_SQR = "1";
    public static final String JFTJ_DSRLX_BSQR = "2";

    public static final String JJZ_ZJZT_DFZ = "1";
    public static final String JJZ_ZJZT_ZC = "2";
    public static final String JJZ_ZJZT_DQZ = "3";

    public static class JobName {
        /**
         * 定时任务
         */
        public static final String LOGGING_EVNET_DEL = "系统日志超期自动清除";
        public static final String JOB_LOG_DEL = "后台任务日志超期自动清除";
        public static final String DFKCASE_DEAL = "打防控案件处理";
        public static final String DFKBADPERSON_DEAL = "打防控打击人员处理";
        public static final String DFKSHR_DEAL = "打防控受害人处理";
        public static final String JQSJ_DEAL = "110警情处理";
        public static final String GZRZ_3302 = "工作日志(3302)数据转换";
        public static final String GZRZ_3303 = "工作日志(3303)数据转换";
        public static final String GZZL_OVERDUE = "工作指令超期处理";
        public static final String DFKCASE_GZZL = "打防控案件工作指令生成";
        public static final String JQSJ_GZZL = "110警情工作指令生成";
        public static final String DFKBADPERSON_GZZL = "打防控打击人员工作指令生成";
        public static final String MJYJ_GZZL = "门禁预警工作指令生成";
        public static final String TFYJ_GZZL = "逃犯人员工作指令生成";
        public static final String GZRY_GZZL = "流口关注人员工作指令生成";
        public static final String GLDX_GZZL = "管理对象工作指令生成";
        public static final String GLDX_ZX_GZZL = "管理对象注销提醒生成";
        public static final String JGJC_GZZL = "单位检查工作指令生成";
        public static final String MJ_ZQRW = "民警周期任务生成";
        public static final String JCSS_SXMS = "基础设施属性描述处理";
        public static final String JG_SXMS = "实有单位属性描述处理";
        public static final String SQJW_GK = "首页辖区概况统计";
        public static final String MJ_GZL = "民警工作量统计";
        public static final String SYSINFO_UPDATE = "系统控制信息补全";
        public static final String DZCZF_SYNC = "出租房信息同步（派综到流口）";
        public static final String ZLFWXX_SYNC = "出租房信息同步（流口到派综）";
        public static final String RHFLXX_SYNC = "常口人户分离信息同步";
        public static final String JQSJ_SYNC = "110警情数据同步";
        public static final String JWRY_SYNC = "境外人员临住信息同步";
        public static final String JWRY_SYNC_SAVE = "境外人员临住信息更新";
        public static final String DEVICE_SYNC = "基站同步";
        public static final String CZRK_RFGL = "常口人房关联处理";
        public static final String LDRK_RFGL = "流口人房关联处理";
        public static final String FJ_DEAL = "附件处理";
        public static final String ZRQ_HP_DEAL = "责任区首页更新";
        public static final String ZRQ_LINK_DATA = "业务数据关联责任区";
        public static final String JMXQ_LINK_DATA = "业务数据关联居民小区";
        public static final String WFRYLJD_AHRFGL = "违法人员落脚点案后人房关联数据处理业务";
        public static final String WFRYLJD_RDLC_XJL = "违法人员落脚点新触发记录";//新记录同步结果
        public static final String WFRYLJD_RDLC_AJJBXX = "违法人员落脚点案件基本信息";//案件基本信息
        public static final String WFRYLJD_RDLC_CBXX = "违法人员落脚点承办信息";//承办信息
        public static final String WFRYLJD_RDLC_BAMJ = "违法人员落脚点办案民警信息";//办案民警信息
        public static final String WFRYLJD_RDLC_XYRXX = "违法人员落脚点地址匹配";//嫌疑人信息,地址匹配
        public static final String OFFLINE_FORM_DISPATCH = "离线表单数据调度";//嫌疑人信息,地址匹配
        public static final String XFAQ_DEAL = "消防检查整改事项处理";//嫌疑人信息,地址匹配
        public static final String FWCZ_DEAL = "出租房转换";
        public static final String CZF_DEAL = "出租房错误数据处理";
        public static final String GRID_INTERVIEW_DEAL = "走访巡查处理（网格）";
        public static final String GRID_EVENT_CLOSE_DEAL = "已处置事件处理（网格）";
        public static final String GRID_EVENT_EVENT_GA_PUSH_DEAL = "公安推送事件处理（网格）";
        public static final String GRID_EVENT_EVENT_ENB_PUSH_DEAL = "网格推送事件处理（网格）";
        public static final String GRID_ADDRESS_DEAL = "现住地差异数据处理(网格)";
        public static final String GRID_MORE_WL_DEAL = "流口差异数据处理(网格)";
        public static final String GRID_MORE_HJ_DEAL = "户籍差异数据处理(网格)";
        public static final String GRID_IMPORTANT_PEOPLE_DEAL = "重点人员处理(网格)";

    }

    public static class Dz {
        public static final String DZYSLXDM_SSXQ = "10";//省市县（区）
        public static final String DZYSLXDM_SHEN = "11";//	省
        public static final String DZYSLXDM_SHI = "12";//	市
        public static final String DZYSLXDM_QX = "13";//	县（区）
        public static final String DZYSLXDM_LXZQY = "19";//	类行政区域 包括经济技术开发区、高新技术开发区等
        public static final String DZYSLXDM_XZJD = "20";//乡镇(街道)
        public static final String DZYSLXDM_JZX = "21";//建制乡
        public static final String DZYSLXDM_JZZ = "22";//建制镇
        public static final String DZYSLXDM_JDBSC = "23";//街道办事处
        public static final String DZYSLXDM_TSQY = "29";//特殊区域
        public static final String DZYSLXDM_SQJCWH = "30";//社区、居(村)委会
        public static final String DZYSLXDM_SQ = "31";//社区
        public static final String DZYSLXDM_JWH = "32";//居委会
        public static final String DZYSLXDM_CWH = "33";//村委会
        public static final String DZYSLXDM_JMXZZRC = "34";//  居民小组、自然村（屯）
        public static final String DZYSLXDM_WG = "35";//社区（警务）网格
        public static final String DZYSLXDM_JLXXQ = "40";//街路巷(小区)
        public static final String DZYSLXDM_JLX = "41";//  街路巷
        public static final String DZYSLXDM_JMXQ = "42";//  小区
        public static final String DZYSLXDM_DWY = "43";//  单位（住宅）院
        public static final String DZYSLXDM_ZRC = "44";//  自然村
        public static final String DZYSLXDM_JZW = "50";//建筑物
        public static final String DZYSLXDM_FW = "60";//建筑物单元房屋
        public static final String DZYSLXDM_DY = "61";//单元（门）;
    }

    public static class Jmxq {

        //对象类型
        public static final String DXLX_RY = "ry"; //人员
        public static final String DXLX_FW = "fw"; //房屋
        public static final String DXLX_CL = "cl"; //车辆

        //异常类型
        public static final String YCLX_RHFL = "10"; //人户分离
        public static final String YCLX_LKWDJ = "11"; //流口未登记
        public static final String YCLX_LKYLK = "12"; //流口已离开

        public static final String YCLX_YSXQCL = "21"; //疑似小区车辆

        public static final String YCLX_ZFYCRY = "31"; //昼伏夜出人员
        public static final String YCLX_PFYCRY = "32"; //频繁夜出人员
        public static final String YCLX_YBGSRY = "33"; //夜不归宿人员
        public static final String YCLX_CQWGRY = "34"; //超期未归人员
        public static final String YCLX_DDPXRY = "35"; //多地频现人员
        public static final String YCLX_SJJCRY = "36"; //深居简出人员
        public static final String YCLX_YSDQRY = "37"; //疑似盗窃人员

        public static final String YCLX_NHYCFW = "41"; //能耗异常房屋
        public static final String YCLX_YSQZF = "42"; //疑似群租房
        public static final String YCLX_YSSDPWD = "43"; //疑似涉毒窝点
        public static final String YCLX_YSSHWD = "44"; //疑似涉黄窝点
        public static final String YCLX_YSSDBWD = "45"; //疑似涉赌窝点

        public static final String YCLX_ZFYCCL = "51"; //昼伏夜出车辆
        public static final String YCLX_PFYCCL = "52"; //频繁夜出车辆
        public static final String YCLX_YBGSCL = "53"; //夜不归宿车辆
        public static final String YCLX_JSCL = "54"; //僵尸车辆
        public static final String YCLX_DDCX = "55"; //多地出现


        public static final String YCLX_ZRWLS = "61";   //昨日无流水
        public static final String YCLX_J7RLSYC = "62";  //近7日流水异常
        public static final String YCLX_LSYC = "63";     //流水异常
        public static final String YCLX_LDLSYC = "66";     //落地数据异常
        public static final String YCLX_ZBYC = "67";     //坐标异常

        public static final String CZFS_HL = "11"; //忽略
        public static final String CZFS_ZL = "21"; //指令
        public static final String CZFS_BMD = "39"; //加入白名单
        public static final String CZFS_DJCL = "31"; //登记为小区车辆

    }

    /**
     * 生活缴费
     */
    public static class Shjf {
        public static final String JFLX_GSXX = "1"; //供水
        public static final String JFLX_GDXX = "2"; //供电
        public static final String JFLX_GQXX = "3"; //供气
    }

    public static class YQ {
        public static final String PCLY_LK = "1"; //流口
        public static final String PCLY_CK = "2"; //常口
        public static final String PCLY_ENB = "3"; //E宁波
        public static final String PCLY_PCS = "5"; //派出所平台
        public static final String PCLY_YXM = "6"; //甬行码
        public static final String PCLY_HCKK = "7"; //核查卡口
        public static final String PCLY_RYSBDJ = "8"; //入甬申报登记
        public static final String PCLY_FRMZ = "9"; //发热门诊

        public static final String JZZT_BZY = "0"; //不在甬
        public static final String JZZT_ZY = "1"; //在甬

        public static final String SJLY_CK = "1"; //常口
        public static final String SJLY_LK = "2"; //流口
        public static final String SJLY_CLKK = "3"; //车辆卡口
        public static final String SJLY_HB = "5"; //湖北

        public static final String LYRQBZ_YZZ = "0"; //一直在
        public static final String LYRQBZ_GL = "1"; //刚来
    }

    public static class Jwry {
        public static final String HZYWLX_HZDQ = "01";//护照证件到期;
        public static final String HZYWLX_QZDQ = "02";//签证证件到期;
        public static final String HZYWLX_QZYQ = "03";//签证证件延期;

        public static final String JZZT_ZZ = "1"; //在住
        public static final String JZZT_ZL = "2"; //暂离
        public static final String JZZT_LK = "3"; //离开
    }

    public static class Jg {
        public static final String GAJGFJGXLB_NO = "0";//公安机关分级管辖类别-不是;
        public static final String GAJGFJGXLB_PCS = "1";//公安机关分级管辖类别-所级单位;
        public static final String GAJGFJGXLB_QX = "2";//公安机关分级管辖类别-县级单位;
        public static final String GAJGFJGXLB_SJ = "3";//公安机关分级管辖类别-市级单位;
    }

    public static final Integer FREQUENCY_ONE_SECOND = 1000;
    public static final Integer FREQUENCY_ONE_MINUTE = 60000;
    public static final Integer FREQUENCY_FIVE_MINUTE = FREQUENCY_ONE_MINUTE * 5;
    public static final Integer FREQUENCY_TEN_MINUTE = FREQUENCY_ONE_MINUTE * 10;
    public static final Integer FREQUENCY_ONE_HOUR = FREQUENCY_ONE_MINUTE * 60;
    public static final Integer FREQUENCY_SIX_HOUR = FREQUENCY_ONE_HOUR * 6;
    //    每个周一早上8点15分执行
    public static final Integer FREQUENCY_MONDAY_EIGHT_FIFTEEN = FREQUENCY_ONE_HOUR * 24 * 7;
    //每天执行一次
    public static final Integer FREQUENCY_ONE_DAY = FREQUENCY_ONE_HOUR * 24;

    /**
     * 入户走访类型
     */
    public static final String ZFLX_PTZF = "0";//普通走访
    public static final String ZFLX_BWJJQWJ = "1";//百万警进千万家

    public static final String JSBRBDBZ_WBD = "0";//未比对
    public static final String JSBRBDBZ_BCZ = "1";//不存在
    public static final String JSBRBDBZ_BYZ = "2";//不一致
    public static final String JSBRBDBZ_WXBD = "9";//无需比对
    public static final String JSBRBDBZ_CY = "8";//出院预警
    public static final String JSBRBDBZ_ZY = "7";//住院预警

    /**
     * 重点流动人口清理挤压率
     * 注销标志
     */
    public static final String ZDLDRK_YZX = "true";
    public static final String ZDLDRK_WZX = "false";

    /**
     * 路桥报警类别
     */
    public static final String JQLB_YXJQ = "01";        //有效警情
    public static final String JQLB_XS = "02";          //刑事
    public static final String JQLB_ZA = "03";          //治安
    public static final String JQLB_JF = "04";          //纠纷
    public static final String JQLB_DQP = "05";         //盗抢骗
    public static final String JQLB_LQ = "06";          //两抢
    public static final String JQLB_ZP = "07";          //诈骗
    public static final String JQLB_DXZP_ZA = "08";     //电讯诈骗_治安
    public static final String JQLB_DXZP_XS = "09";     //电讯诈骗_刑事
    public static final String JQLB_DQ = "10";          //盗窃
    public static final String JQLB_RSDQ = "11";        //入室盗窃
    public static final String JQLB_DQLC = "12";        //盗窃两车
    public static final String JQLB_DQCNWP = "13";      //盗窃车内物品
    public static final String JQLB_DQDP = "14";        //盗窃电瓶
    public static final String JQLB_BQ = "15";          //扒窃
    public static final String JQLB_QCX = "16";         //侵财型
    public static final String JQLB_HZ = "17";          //火灾
    public static final String JQLB_SH = "18";          //涉黄
    public static final String JQLB_SD = "19";          //涉赌
    public static final String JQLB_SD2 = "20";         //涉毒
    public static final String JQLB_JTSG = "21";        //交通事故
    public static final String JQLB_YY = "22";          //扬言

    /**
     * 流管通流动人口登记核查_操作类型
     */
    public static final String CZLX_CY = "1";//查验
    public static final String CZLX_DJ = "2";//登记
    public static final String CZLX_ZX = "3";//注销
    public static final String CZLX_QZ = "4";//居住地变更
    public static final String CZLX_QC = "5";//工作地变更
    public static final String CZLX_CZFW_DJ = "6";//登记出租房
    public static final String CZLX_CZFW_XG = "7";//出租房修改
    public static final String CZLX_CZFW_ZX = "8";//注销出租房
    public static final String CZLX_LDDJ_XG = "9";//流动登记修改

    /**
     * 路桥社区级别
     */
    public static final String SQJB_YJ = "1";//一级社区
    public static final String SQJB_EJ = "2";//二级社区
    public static final String SQJB_SJ = "3";//三级社区

    /**
     * 智安小区-预警信息-处理标志
     */
    public static String YJXX_CLBZ_WCL = "0";  //未处理
    public static String YJXX_CLBZ_WXCL = "1"; //无需处理
    public static String YJXX_CLBZ_CLZ = "2";  //处理中
    public static String YJXX_CLBZ_YCL = "3"; //已处理
    public static String YJXX_CLBZ_CLSB = "4"; //处理失败

    public static String GKPZ_GKXQLB_HJD="1"; //户籍地管辖
    public static String GKPZ_GKXQLB_XZD="2"; //现住地管辖
    public static String GKPZ_GKXQLB_GZD="3"; //工作地管辖
}

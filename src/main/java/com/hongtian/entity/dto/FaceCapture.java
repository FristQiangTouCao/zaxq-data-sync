package com.hongtian.entity.dto;

import com.alibaba.fastjson.annotation.JSONField;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "FaceCapture")
public class FaceCapture {
    //人臉抓拍信息標誌(必填)
    @JSONField( name = "RLZPXXBZ")
    private String RLZPXXBZ;
    //抓拍人臉標示(必填)
    @JSONField( name = "SPTXXXYYSXDXBZ")
    private String SPTXXXYYSXDXBZ;
    //人臉採集方式代碼
    @JSONField( name = "SPTXXXCJFSDM")
    private String SPTXXXCJFSDM;
    //年齡上限
    @JSONField( name = "NLSX")
    private String NLSX;
    //年齡下限
    @JSONField( name = "NLXX")
    private String NLXX;
    //性別代碼
    @JSONField( name = "XBDM")
    private String XBDM;
    //民族代碼
    @JSONField( name = "MZDM")
    private String MZDM;

    //是否布控人員判斷表示
    @JSONField( name = "SFBKRY_PDBZ")
    private String SFBKRY_PDBZ;
    //是否關注人員判斷標誌
    @JSONField( name = "SFGZRY_PDBZ")
    private String SFGZRY_PDBZ;
    //采集设备信息标识(必填)
    @JSONField( name = "CJSBXXBZ")
    private String CJSBXXBZ;
    //左上角中心点横坐标
    @JSONField( name = "ZSJ_ZXDHZB")
    private String ZSJ_ZXDHZB;
    //左上角中心点纵坐标
    @JSONField( name = "ZSJ_ZXDZZB")
    private String ZSJ_ZXDZZB;
    //右下角中心点横坐标
    @JSONField( name = "YXJ_ZXDHZB")
    private String YXJ_ZXDHZB;
    //右下角中心点纵坐标
    @JSONField( name = "YXJ_ZXDZZB")
    private String YXJ_ZXDZZB;
    //同行人人数
    @JSONField( name = "TXR_RS")
    private int TXR_RS;
    //是否佩戴口罩判断标识
    @JSONField( name = "SFDKZ_PDBZ")
    private String SFDKZ_PDBZ;
    //着帽特征代码
    @JSONField( name = "ZMTZDM")
    private String ZMTZDM;
    //是否驾驶员判断标识
    @JSONField( name = "SFJSY_PDBZ")
    private String SFJSY_PDBZ;
    //佩戴眼镜特征代码
    @JSONField( name = "PDYJTZDM")
    private String PDYJTZDM;
    //携包特征代码
    @JSONField( name = "XBTZDM")
    private String XBTZDM;
    //上身着装特征代码
    @JSONField( name = "SSZZTZDM")
    private String SSZZTZDM;
    //下身着装特征代码
    @JSONField( name = "XSZZTZDM")
    private String XSZZTZDM;
    //着鞋特征代码
    @JSONField( name = "ZXTZDM")
    private String ZXTZDM;
    //上衣颜色
    @JSONField( name = "SY_YS")
    private String SY_YS;
    //裤子颜色
    @JSONField( name = "KZ_YS")
    private String KZ_YS;
    //鞋子颜色
    @JSONField( name = "XZ_YS")
    private String XZ_YS;
    //帽子颜色
    @JSONField( name = "MZ_YS")
    private String MZ_YS;
    //口罩颜色
    @JSONField( name = "KZ_YSS")
    private String KZ_YSS;
    //人脸图片(必填)
    @JSONField( name = "TP")
    private String TP;
    //采集时间(必填)
    @JSONField( name = "CJSJ")
    private String CJSJ;
    @JSONField( name = "RLZPXXBZ")
    public String getRLZPXXBZ() {
        return RLZPXXBZ;
    }
    @JSONField( name = "RLZPXXBZ")
    public void setRLZPXXBZ(String RLZPXXBZ) {
        this.RLZPXXBZ = RLZPXXBZ;
    }
    @JSONField( name = "SPTXXXYYSXDXBZ")
    public String getSPTXXXYYSXDXBZ() {
        return SPTXXXYYSXDXBZ;
    }
    @JSONField( name = "SPTXXXYYSXDXBZ")
    public void setSPTXXXYYSXDXBZ(String SPTXXXYYSXDXBZ) {
        this.SPTXXXYYSXDXBZ = SPTXXXYYSXDXBZ;
    }
    @JSONField( name = "SPTXXXCJFSDM")
    public String getSPTXXXCJFSDM() {
        return SPTXXXCJFSDM;
    }
    @JSONField( name = "SPTXXXCJFSDM")
    public void setSPTXXXCJFSDM(String SPTXXXCJFSDM) {
        this.SPTXXXCJFSDM = SPTXXXCJFSDM;
    }
    @JSONField( name = "NLSX")
    public String getNLSX() {
        return NLSX;
    }
    @JSONField( name = "NLSX")
    public void setNLSX(String NLSX) {
        this.NLSX = NLSX;
    }
    @JSONField( name = "NLXX")
    public String getNLXX() {
        return NLXX;
    }
    @JSONField( name = "NLXX")
    public void setNLXX(String NLXX) {
        this.NLXX = NLXX;
    }
    @JSONField( name = "XBDM")
    public String getXBDM() {
        return XBDM;
    }
    @JSONField( name = "XBDM")
    public void setXBDM(String XBDM) {
        this.XBDM = XBDM;
    }
    @JSONField( name = "MZDM")
    public String getMZDM() {
        return MZDM;
    }
    @JSONField( name = "MZDM")
    public void setMZDM(String MZDM) {
        this.MZDM = MZDM;
    }
    @JSONField( name = "SFBKRY_PDBZ")
    public String getSFBKRY_PDBZ() {
        return SFBKRY_PDBZ;
    }
    @JSONField( name = "SFBKRY_PDBZ")
    public void setSFBKRY_PDBZ(String SFBKRY_PDBZ) {
        this.SFBKRY_PDBZ = SFBKRY_PDBZ;
    }
    @JSONField( name = "SFGZRY_PDBZ")
    public String getSFGZRY_PDBZ() {
        return SFGZRY_PDBZ;
    }
    @JSONField( name = "SFGZRY_PDBZ")
    public void setSFGZRY_PDBZ(String SFGZRY_PDBZ) {
        this.SFGZRY_PDBZ = SFGZRY_PDBZ;
    }
    @JSONField( name = "CJSBXXBZ")
    public String getCJSBXXBZ() {
        return CJSBXXBZ;
    }
    @JSONField( name = "CJSBXXBZ")
    public void setCJSBXXBZ(String CJSBXXBZ) {
        this.CJSBXXBZ = CJSBXXBZ;
    }
    @JSONField( name = "ZSJ_ZXDHZB")
    public String getZSJ_ZXDHZB() {
        return ZSJ_ZXDHZB;
    }
    @JSONField( name = "ZSJ_ZXDHZB")
    public void setZSJ_ZXDHZB(String ZSJ_ZXDHZB) {
        this.ZSJ_ZXDHZB = ZSJ_ZXDHZB;
    }
    @JSONField( name = "ZSJ_ZXDZZB")
    public String getZSJ_ZXDZZB() {
        return ZSJ_ZXDZZB;
    }
    @JSONField( name = "ZSJ_ZXDZZB")
    public void setZSJ_ZXDZZB(String ZSJ_ZXDZZB) {
        this.ZSJ_ZXDZZB = ZSJ_ZXDZZB;
    }
    @JSONField( name = "YXJ_ZXDHZB")
    public String getYXJ_ZXDHZB() {
        return YXJ_ZXDHZB;
    }
    @JSONField( name = "YXJ_ZXDHZB")
    public void setYXJ_ZXDHZB(String YXJ_ZXDHZB) {
        this.YXJ_ZXDHZB = YXJ_ZXDHZB;
    }
    @JSONField( name = "YXJ_ZXDZZB")
    public String getYXJ_ZXDZZB() {
        return YXJ_ZXDZZB;
    }
    @JSONField( name = "YXJ_ZXDZZB")
    public void setYXJ_ZXDZZB(String YXJ_ZXDZZB) {
        this.YXJ_ZXDZZB = YXJ_ZXDZZB;
    }
    @JSONField( name = "TXR_RS")
    public int getTXR_RS() {
        return TXR_RS;
    }
    @JSONField( name = "TXR_RS")
    public void setTXR_RS(int TXR_RS) {
        this.TXR_RS = TXR_RS;
    }
    @JSONField( name = "SFDKZ_PDBZ")
    public String getSFDKZ_PDBZ() {
        return SFDKZ_PDBZ;
    }
    @JSONField( name = "SFDKZ_PDBZ")
    public void setSFDKZ_PDBZ(String SFDKZ_PDBZ) {
        this.SFDKZ_PDBZ = SFDKZ_PDBZ;
    }
    @JSONField( name = "ZMTZDM")
    public String getZMTZDM() {
        return ZMTZDM;
    }
    @JSONField( name = "ZMTZDM")
    public void setZMTZDM(String ZMTZDM) {
        this.ZMTZDM = ZMTZDM;
    }
    @JSONField( name = "SFJSY_PDBZ")
    public String getSFJSY_PDBZ() {
        return SFJSY_PDBZ;
    }
    @JSONField( name = "SFJSY_PDBZ")
    public void setSFJSY_PDBZ(String SFJSY_PDBZ) {
        this.SFJSY_PDBZ = SFJSY_PDBZ;
    }
    @JSONField( name = "PDYJTZDM")
    public String getPDYJTZDM() {
        return PDYJTZDM;
    }
    @JSONField( name = "PDYJTZDM")
    public void setPDYJTZDM(String PDYJTZDM) {
        this.PDYJTZDM = PDYJTZDM;
    }
    @JSONField( name = "XBTZDM")
    public String getXBTZDM() {
        return XBTZDM;
    }
    @JSONField( name = "XBTZDM")
    public void setXBTZDM(String XBTZDM) {
        this.XBTZDM = XBTZDM;
    }
    @JSONField( name = "SSZZTZDM")
    public String getSSZZTZDM() {
        return SSZZTZDM;
    }
    @JSONField( name = "SSZZTZDM")
    public void setSSZZTZDM(String SSZZTZDM) {
        this.SSZZTZDM = SSZZTZDM;
    }
    @JSONField( name = "XSZZTZDM")
    public String getXSZZTZDM() {
        return XSZZTZDM;
    }
    @JSONField( name = "XSZZTZDM")
    public void setXSZZTZDM(String XSZZTZDM) {
        this.XSZZTZDM = XSZZTZDM;
    }
    @JSONField( name = "ZXTZDM")
    public String getZXTZDM() {
        return ZXTZDM;
    }
    @JSONField( name = "ZXTZDM")
    public void setZXTZDM(String ZXTZDM) {
        this.ZXTZDM = ZXTZDM;
    }
    @JSONField( name = "SY_YS")
    public String getSY_YS() {
        return SY_YS;
    }
    @JSONField( name = "SY_YS")
    public void setSY_YS(String SY_YS) {
        this.SY_YS = SY_YS;
    }
    @JSONField( name = "KZ_YS")
    public String getKZ_YS() {
        return KZ_YS;
    }
    @JSONField( name = "KZ_YS")
    public void setKZ_YS(String KZ_YS) {
        this.KZ_YS = KZ_YS;
    }
    @JSONField( name = "XZ_YS")
    public String getXZ_YS() {
        return XZ_YS;
    }
    @JSONField( name = "XZ_YS")
    public void setXZ_YS(String XZ_YS) {
        this.XZ_YS = XZ_YS;
    }
    @JSONField( name = "MZ_YS")
    public String getMZ_YS() {
        return MZ_YS;
    }
    @JSONField( name = "MZ_YS")
    public void setMZ_YS(String MZ_YS) {
        this.MZ_YS = MZ_YS;
    }
    @JSONField( name = "KZ_YSS")
    public String getKZ_YSS() {
        return KZ_YSS;
    }
    @JSONField( name = "KZ_YSS")
    public void setKZ_YSS(String KZ_YSS) {
        this.KZ_YSS = KZ_YSS;
    }
    @JSONField( name = "TP")
    public String getTP() {
        return TP;
    }
    @JSONField( name = "TP")
    public void setTP(String TP) {
        this.TP = TP;
    }
    @JSONField( name = "CJSJ")
    public String getCJSJ() {
        return CJSJ;
    }
    @JSONField( name = "CJSJ")
    public void setCJSJ(String CJSJ) {
        this.CJSJ = CJSJ;
    }
}

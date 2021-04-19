package com.hongtian.entity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "FaceCapture")
public class FaceCapture {
    //人臉抓拍信息標誌(必填)
    @JsonProperty(value = "RLZPXXBZ")
    private String RLZPXXBZ;
    //抓拍人臉標示(必填)
    @JsonProperty(value = "SPTXXXYYSXDXBZ")
    private String SPTXXXYYSXDXBZ;
    //人臉採集方式代碼
    @JsonProperty(value = "SPTXXXCJFSDM")
    private String SPTXXXCJFSDM;
    //年齡上限
    @JsonProperty(value = "NLSX")
    private String NLSX;
    //年齡下限
    @JsonProperty(value = "NLXX")
    private String NLXX;
    //性別代碼
    @JsonProperty(value = "XBDM")
    private String XBDM;
    //民族代碼
    @JsonProperty(value = "MZDM")
    private String MZDM;

    //是否布控人員判斷表示
    @JsonProperty(value = "SFBKRY_PDBZ")
    private String SFBKRY_PDBZ;
    //是否關注人員判斷標誌
    @JsonProperty(value = "SFGZRY_PDBZ")
    private String SFGZRY_PDBZ;
    //采集设备信息标识(必填)
    @JsonProperty(value = "CJSBXXBZ")
    private String CJSBXXBZ;
    //左上角中心点横坐标
    @JsonProperty(value = "ZSJ_ZXDHZB")
    private String ZSJ_ZXDHZB;
    //左上角中心点纵坐标
    @JsonProperty(value = "ZSJ_ZXDZZB")
    private String ZSJ_ZXDZZB;
    //右下角中心点横坐标
    @JsonProperty(value = "YXJ_ZXDHZB")
    private String YXJ_ZXDHZB;
    //右下角中心点纵坐标
    @JsonProperty(value = "YXJ_ZXDZZB")
    private String YXJ_ZXDZZB;
    //同行人人数
    @JsonProperty(value = "TXR_RS")
    private int TXR_RS;
    //是否佩戴口罩判断标识
    @JsonProperty(value = "SFDKZ_PDBZ")
    private String SFDKZ_PDBZ;
    //着帽特征代码
    @JsonProperty(value = "ZMTZDM")
    private String ZMTZDM;
    //是否驾驶员判断标识
    @JsonProperty(value = "SFJSY_PDBZ")
    private String SFJSY_PDBZ;
    //佩戴眼镜特征代码
    @JsonProperty(value = "PDYJTZDM")
    private String PDYJTZDM;
    //携包特征代码
    @JsonProperty(value = "XBTZDM")
    private String XBTZDM;
    //上身着装特征代码
    @JsonProperty(value = "SSZZTZDM")
    private String SSZZTZDM;
    //下身着装特征代码
    @JsonProperty(value = "XSZZTZDM")
    private String XSZZTZDM;
    //着鞋特征代码
    @JsonProperty(value = "ZXTZDM")
    private String ZXTZDM;
    //上衣颜色
    @JsonProperty(value = "SY_YS")
    private String SY_YS;
    //裤子颜色
    @JsonProperty(value = "KZ_YS")
    private String KZ_YS;
    //鞋子颜色
    @JsonProperty(value = "XZ_YS")
    private String XZ_YS;
    //帽子颜色
    @JsonProperty(value = "MZ_YS")
    private String MZ_YS;
    //口罩颜色
    @JsonProperty(value = "KZ_YSS")
    private String KZ_YSS;
    //人脸图片(必填)
    @JsonProperty(value = "TP")
    private String TP;
    //采集时间(必填)
    @JsonProperty(value = "CJSJ")
    private String CJSJ;
    @JsonProperty(value = "RLZPXXBZ")
    public String getRLZPXXBZ() {
        return RLZPXXBZ;
    }
    @JsonProperty(value = "RLZPXXBZ")
    public void setRLZPXXBZ(String RLZPXXBZ) {
        this.RLZPXXBZ = RLZPXXBZ;
    }
    @JsonProperty(value = "SPTXXXYYSXDXBZ")
    public String getSPTXXXYYSXDXBZ() {
        return SPTXXXYYSXDXBZ;
    }
    @JsonProperty(value = "SPTXXXYYSXDXBZ")
    public void setSPTXXXYYSXDXBZ(String SPTXXXYYSXDXBZ) {
        this.SPTXXXYYSXDXBZ = SPTXXXYYSXDXBZ;
    }
    @JsonProperty(value = "SPTXXXCJFSDM")
    public String getSPTXXXCJFSDM() {
        return SPTXXXCJFSDM;
    }
    @JsonProperty(value = "SPTXXXCJFSDM")
    public void setSPTXXXCJFSDM(String SPTXXXCJFSDM) {
        this.SPTXXXCJFSDM = SPTXXXCJFSDM;
    }
    @JsonProperty(value = "NLSX")
    public String getNLSX() {
        return NLSX;
    }
    @JsonProperty(value = "NLSX")
    public void setNLSX(String NLSX) {
        this.NLSX = NLSX;
    }
    @JsonProperty(value = "NLXX")
    public String getNLXX() {
        return NLXX;
    }
    @JsonProperty(value = "NLXX")
    public void setNLXX(String NLXX) {
        this.NLXX = NLXX;
    }
    @JsonProperty(value = "XBDM")
    public String getXBDM() {
        return XBDM;
    }
    @JsonProperty(value = "XBDM")
    public void setXBDM(String XBDM) {
        this.XBDM = XBDM;
    }
    @JsonProperty(value = "MZDM")
    public String getMZDM() {
        return MZDM;
    }
    @JsonProperty(value = "MZDM")
    public void setMZDM(String MZDM) {
        this.MZDM = MZDM;
    }
    @JsonProperty(value = "SFBKRY_PDBZ")
    public String getSFBKRY_PDBZ() {
        return SFBKRY_PDBZ;
    }
    @JsonProperty(value = "SFBKRY_PDBZ")
    public void setSFBKRY_PDBZ(String SFBKRY_PDBZ) {
        this.SFBKRY_PDBZ = SFBKRY_PDBZ;
    }
    @JsonProperty(value = "SFGZRY_PDBZ")
    public String getSFGZRY_PDBZ() {
        return SFGZRY_PDBZ;
    }
    @JsonProperty(value = "SFGZRY_PDBZ")
    public void setSFGZRY_PDBZ(String SFGZRY_PDBZ) {
        this.SFGZRY_PDBZ = SFGZRY_PDBZ;
    }
    @JsonProperty(value = "CJSBXXBZ")
    public String getCJSBXXBZ() {
        return CJSBXXBZ;
    }
    @JsonProperty(value = "CJSBXXBZ")
    public void setCJSBXXBZ(String CJSBXXBZ) {
        this.CJSBXXBZ = CJSBXXBZ;
    }
    @JsonProperty(value = "ZSJ_ZXDHZB")
    public String getZSJ_ZXDHZB() {
        return ZSJ_ZXDHZB;
    }
    @JsonProperty(value = "ZSJ_ZXDHZB")
    public void setZSJ_ZXDHZB(String ZSJ_ZXDHZB) {
        this.ZSJ_ZXDHZB = ZSJ_ZXDHZB;
    }
    @JsonProperty(value = "ZSJ_ZXDZZB")
    public String getZSJ_ZXDZZB() {
        return ZSJ_ZXDZZB;
    }
    @JsonProperty(value = "ZSJ_ZXDZZB")
    public void setZSJ_ZXDZZB(String ZSJ_ZXDZZB) {
        this.ZSJ_ZXDZZB = ZSJ_ZXDZZB;
    }
    @JsonProperty(value = "YXJ_ZXDHZB")
    public String getYXJ_ZXDHZB() {
        return YXJ_ZXDHZB;
    }
    @JsonProperty(value = "YXJ_ZXDHZB")
    public void setYXJ_ZXDHZB(String YXJ_ZXDHZB) {
        this.YXJ_ZXDHZB = YXJ_ZXDHZB;
    }
    @JsonProperty(value = "YXJ_ZXDZZB")
    public String getYXJ_ZXDZZB() {
        return YXJ_ZXDZZB;
    }
    @JsonProperty(value = "YXJ_ZXDZZB")
    public void setYXJ_ZXDZZB(String YXJ_ZXDZZB) {
        this.YXJ_ZXDZZB = YXJ_ZXDZZB;
    }
    @JsonProperty(value = "TXR_RS")
    public int getTXR_RS() {
        return TXR_RS;
    }
    @JsonProperty(value = "TXR_RS")
    public void setTXR_RS(int TXR_RS) {
        this.TXR_RS = TXR_RS;
    }
    @JsonProperty(value = "SFDKZ_PDBZ")
    public String getSFDKZ_PDBZ() {
        return SFDKZ_PDBZ;
    }
    @JsonProperty(value = "SFDKZ_PDBZ")
    public void setSFDKZ_PDBZ(String SFDKZ_PDBZ) {
        this.SFDKZ_PDBZ = SFDKZ_PDBZ;
    }
    @JsonProperty(value = "ZMTZDM")
    public String getZMTZDM() {
        return ZMTZDM;
    }
    @JsonProperty(value = "ZMTZDM")
    public void setZMTZDM(String ZMTZDM) {
        this.ZMTZDM = ZMTZDM;
    }
    @JsonProperty(value = "SFJSY_PDBZ")
    public String getSFJSY_PDBZ() {
        return SFJSY_PDBZ;
    }
    @JsonProperty(value = "SFJSY_PDBZ")
    public void setSFJSY_PDBZ(String SFJSY_PDBZ) {
        this.SFJSY_PDBZ = SFJSY_PDBZ;
    }
    @JsonProperty(value = "PDYJTZDM")
    public String getPDYJTZDM() {
        return PDYJTZDM;
    }
    @JsonProperty(value = "PDYJTZDM")
    public void setPDYJTZDM(String PDYJTZDM) {
        this.PDYJTZDM = PDYJTZDM;
    }
    @JsonProperty(value = "XBTZDM")
    public String getXBTZDM() {
        return XBTZDM;
    }
    @JsonProperty(value = "XBTZDM")
    public void setXBTZDM(String XBTZDM) {
        this.XBTZDM = XBTZDM;
    }
    @JsonProperty(value = "SSZZTZDM")
    public String getSSZZTZDM() {
        return SSZZTZDM;
    }
    @JsonProperty(value = "SSZZTZDM")
    public void setSSZZTZDM(String SSZZTZDM) {
        this.SSZZTZDM = SSZZTZDM;
    }
    @JsonProperty(value = "XSZZTZDM")
    public String getXSZZTZDM() {
        return XSZZTZDM;
    }
    @JsonProperty(value = "XSZZTZDM")
    public void setXSZZTZDM(String XSZZTZDM) {
        this.XSZZTZDM = XSZZTZDM;
    }
    @JsonProperty(value = "ZXTZDM")
    public String getZXTZDM() {
        return ZXTZDM;
    }
    @JsonProperty(value = "ZXTZDM")
    public void setZXTZDM(String ZXTZDM) {
        this.ZXTZDM = ZXTZDM;
    }
    @JsonProperty(value = "SY_YS")
    public String getSY_YS() {
        return SY_YS;
    }
    @JsonProperty(value = "SY_YS")
    public void setSY_YS(String SY_YS) {
        this.SY_YS = SY_YS;
    }
    @JsonProperty(value = "KZ_YS")
    public String getKZ_YS() {
        return KZ_YS;
    }
    @JsonProperty(value = "KZ_YS")
    public void setKZ_YS(String KZ_YS) {
        this.KZ_YS = KZ_YS;
    }
    @JsonProperty(value = "XZ_YS")
    public String getXZ_YS() {
        return XZ_YS;
    }
    @JsonProperty(value = "XZ_YS")
    public void setXZ_YS(String XZ_YS) {
        this.XZ_YS = XZ_YS;
    }
    @JsonProperty(value = "MZ_YS")
    public String getMZ_YS() {
        return MZ_YS;
    }
    @JsonProperty(value = "MZ_YS")
    public void setMZ_YS(String MZ_YS) {
        this.MZ_YS = MZ_YS;
    }
    @JsonProperty(value = "KZ_YSS")
    public String getKZ_YSS() {
        return KZ_YSS;
    }
    @JsonProperty(value = "KZ_YSS")
    public void setKZ_YSS(String KZ_YSS) {
        this.KZ_YSS = KZ_YSS;
    }
    @JsonProperty(value = "TP")
    public String getTP() {
        return TP;
    }
    @JsonProperty(value = "TP")
    public void setTP(String TP) {
        this.TP = TP;
    }
    @JsonProperty(value = "CJSJ")
    public String getCJSJ() {
        return CJSJ;
    }
    @JsonProperty(value = "CJSJ")
    public void setCJSJ(String CJSJ) {
        this.CJSJ = CJSJ;
    }
}

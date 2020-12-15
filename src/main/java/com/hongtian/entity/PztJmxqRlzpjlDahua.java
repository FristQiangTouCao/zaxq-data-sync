package com.hongtian.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
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
@TableName("PZT_JMXQ_RLZPJL_DAHUA")
public class PztJmxqRlzpjlDahua extends Model<PztJmxqRlzpjlDahua> {

    private static final long serialVersionUID = 1L;

    @TableField("ID")
    private String id;

    @TableField("LSID")
    private String lsid;

    @TableField("SBBH")
    private String sbbh;

    @TableField("IMGURL1")
    private String imgurl1;

    @TableField("IMGURL2")
    private String imgurl2;

    @TableField("GMSFHM")
    private String gmsfhm;

    @TableField("JLSJ")
    private String jlsj;

    @TableField("JCBZ")
    private String jcbz;

    @TableField("XSD")
    private Float xsd;

    @TableField("RID")
    private String rid;

    @TableField("BL1")
    private String bl1;

    @TableField("BL2")
    private String bl2;


    @Override
    protected Serializable pkVal() {
        return null;
    }

}

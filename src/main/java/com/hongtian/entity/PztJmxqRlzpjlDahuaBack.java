package com.hongtian.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

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
@TableName("nbdh.PZT_JMXQ_RLZPJL_BACK")
public class PztJmxqRlzpjlDahuaBack extends Model<PztJmxqRlzpjlDahuaBack> {

    private static final long serialVersionUID = 1L;

    @Id
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

    @TableField("CLBZ")
    private String clbz;


    @Override
    protected Serializable pkVal() {
        return null;
    }

}

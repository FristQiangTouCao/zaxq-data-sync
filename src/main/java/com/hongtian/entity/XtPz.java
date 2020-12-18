package com.hongtian.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

/**
 * @author weed
 * @date 2020/12/17 0017 16:30
 * @description
 */
@Data
public class XtPz {

    @Id
    private String id;


    private String value;
}

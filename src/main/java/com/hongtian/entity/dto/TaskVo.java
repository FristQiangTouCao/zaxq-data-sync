package com.hongtian.entity.dto;

import lombok.Data;

/**
 * @author weed
 * @date 2021/4/15 0015 11:37
 * @description 任务vo
 */
@Data
public class TaskVo {

    private String taskKey;

    private String taskName;

    private boolean isStart;

}

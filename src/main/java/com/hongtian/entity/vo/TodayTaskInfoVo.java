package com.hongtian.entity.vo;

import lombok.Data;

/**
 * @author weed
 * @date 2020/12/17 0017 11:39
 * @description
 */
@Data
public class TodayTaskInfoVo {
    // 任务的名称
    private String taskName;
    // 运行的次数
    private int runningCount;
    // 运行的状态
    private boolean running;
    // 最近一次运行的时间
    private long lastRunningTime;
    // 运行的间隔
    private String runningIntervalTime;
    // 处理的总数
    private int handleCount;
}

package com.hongtian.entity.vo;

import lombok.Data;

/**
 * @author weed
 * @date 2020/12/17 0017 11:39
 * @description
 */
@Data
public class TodayTaskInfoVo implements Comparable<TodayTaskInfoVo>{
    // 任务的名称
    private String taskName;
    // 运行的次数
    private int runningCount;
    // 运行的状态
    private boolean running;
    // 开始的时间
    private long startTime;
    // 更新的时间
    private long updateTime;
    // 最近一次运行的时间
    private long lastRunningTime;
    // 运行的间隔
    private String runningIntervalTime;
    // 处理的总数
    private int handleCount;

    @Override
    public int compareTo(TodayTaskInfoVo o) {
        int i = 0;
        i = this.handleCount < o.getHandleCount() ? 1 : -1;
        return i;
    }
}

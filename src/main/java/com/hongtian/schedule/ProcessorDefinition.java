package com.hongtian.schedule;

import lombok.Data;

/**
 * @author weed
 * @date 2020/12/15 0015 15:14
 * @description 任务的定义
 */
@Data
public class ProcessorDefinition {

    // 是否运行
    private boolean isRunning = false;

    // 任务执行内容
    private BaseProcessor baseProcessor;

    // 线程
    private ThreadPool threadPool;

    // 是否开启线程池
    private boolean startThreadPool;

    // 间隔时间组
    private JobProcessorIntervalTime jobProcessorIntervalTime;

    // 任务名称
    private String jobProcessorType;

    // 最近一次运行的时间
    private long lastRunningTime;

    // 开始时间
    private long startTime;

    // 更新时间
    private long updateTime;
}

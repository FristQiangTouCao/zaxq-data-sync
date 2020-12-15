package com.hongtian.schedule;

import java.util.List;

/**
 * @author weed
 * @date 2020/12/15 0015 17:30
 * @description 任务执行线程
 */
public class TaskExecuteThread implements Runnable{

    // 执行的时间表达式
    private JobProcessorIntervalTime intervalTime;

    // 任务容器
    private ProcessorContext processorContext;

    public TaskExecuteThread(ProcessorContext processorContext, JobProcessorIntervalTime intervalTime) {
        this.intervalTime = intervalTime;
        this.processorContext = processorContext;
    }
    @Override
    public void run() {
        while(true) {
            // 判断corn表达式
            if(true) {
                System.out.println("执行");
//                check();
            }
        }
    }

    public void check() {
        List<ProcessorDefinition> processorDefinitions = processorContext.processorByGroup.get(this.intervalTime);
        processorDefinitions.forEach(item -> {
            boolean running = item.isRunning();
            if(!running) {
                execute(item);
            }
        });
    }


    public void execute(ProcessorDefinition processorDefinition) {
        BaseProcessor baseProcessor = processorDefinition.getBaseProcessor();
        baseProcessor.run();
    }

}

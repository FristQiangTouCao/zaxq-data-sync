package com.hongtian.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author weed
 * @date 2020/12/16 0016 11:13
 * @description 动态创建定时任务
 */
@Component
public class ScheduleDynamicCreate implements SchedulingConfigurer {

    @Autowired
    private ProcessorContext processorContext;

    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        processorContext.init();
        List<JobProcessorIntervalTime> intervalTimes = processorContext.processorIntervalTimes;
        intervalTimes.forEach(item -> {
            scheduledTaskRegistrar.addCronTask(() -> {
                List<ProcessorDefinition> processorDefinitions = processorContext.processorByGroup.get(item);
                if(CollectionUtils.isEmpty(processorDefinitions)){
                    return;
                }
                processorDefinitions.forEach(processorDefinition -> {
                    if(!processorContext.startTasks.contains(processorDefinition.getBaseProcessor().getType().toString())) {
                        return;
                    }
                    String name = processorDefinition.getBaseProcessor().getType().getName();
                    if (!processorDefinition.isRunning()) {
                        System.out.println("开始运行---->"+processorDefinition.getBaseProcessor().getType().getName());
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                processorDefinition.getBaseProcessor().run();
                            }
                        }).start();
                    }else {
                        System.out.println("正在运行---->"+processorDefinition.getBaseProcessor().getType().getName());
                    }
                });
            },item.getInterval());
        });
        scheduledTaskRegistrar.addCronTask(() -> {
            processorContext.loadStartTasks();
        },"0 */1 * * * ?");
    }
}

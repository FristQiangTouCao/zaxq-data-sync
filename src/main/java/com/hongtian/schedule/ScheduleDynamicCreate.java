//package com.hongtian.schedule;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.batch.BatchProperties;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.scheduling.annotation.SchedulingConfigurer;
//import org.springframework.scheduling.config.ScheduledTaskRegistrar;
//import org.springframework.stereotype.Component;
//import org.springframework.util.CollectionUtils;
//
//import java.lang.reflect.Method;
//import java.util.List;
//import java.util.concurrent.Executors;
//
///**
// * @author weed
// * @date 2020/12/16 0016 11:13
// * @description 动态创建定时任务
// */
////@Component
//public class ScheduleDynamicCreate implements SchedulingConfigurer {
//
//    @Autowired
//    private ProcessorContext processorContext;
//
//    @Override
//    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
//        processorContext.init();
//        List<JobProcessorIntervalTime> intervalTimes = processorContext.processorIntervalTimes;
//        // 定时更新开启的任务列表
//        scheduledTaskRegistrar.addCronTask(() -> {
//            processorContext.loadStartTasks();
//        },"0 */1 * * * ?");
//        intervalTimes.forEach(item -> {
//            scheduledTaskRegistrar.addCronTask(() -> {
//                List<ProcessorDefinition> processorDefinitions = processorContext.processorByGroup.get(item);
//                if(CollectionUtils.isEmpty(processorDefinitions)){
//                    return;
//                }
//                processorDefinitions.forEach(processorDefinition -> {
//                    if(!processorContext.startTasks.contains(processorDefinition.getBaseProcessor().getType().toString())) {
//                        return;
//                    }
//                    String name = processorDefinition.getBaseProcessor().getType().getName();
//                    if (!processorDefinition.isRunning()) {
//                        System.out.println("开始运行---->"+processorDefinition.getBaseProcessor().getType().getName());
//                        new Thread(new Runnable() {
//                            @Override
//                            public void run() {
//                                processorDefinition.getBaseProcessor().run();
//                            }
//                        }).start();
//                    }else {
//                        System.out.println("正在运行---->"+processorDefinition.getBaseProcessor().getType().getName());
//                    }
//                });
//            },item.getInterval());
//        });
//
//    }
//
//
//    public void configurationTask(ScheduledTaskRegistrar taskRegistrar) {
//        Method[] methods = BatchProperties.Job.class.getMethods();
//        int defaultPoolSize = 10;
//        int corePoolSize = 0;
//        if (methods != null && methods.length > 0) {
//            for (Method method : methods) {
//                Scheduled annotation = method.getAnnotation(Scheduled.class);
//                if (annotation != null) {
//                    corePoolSize++;
//                }
//            }
//            if (defaultPoolSize > corePoolSize)
//                corePoolSize = defaultPoolSize;
//        }
//        taskRegistrar.setScheduler(Executors.newScheduledThreadPool(corePoolSize));
//    }
//}

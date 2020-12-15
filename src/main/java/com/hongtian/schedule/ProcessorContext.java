package com.hongtian.schedule;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author weed
 * @date 2020/12/15 0015 16:38
 * @description 处理程序容器
 */
@Component
public class ProcessorContext implements ApplicationContextAware {

    private ThreadPool threadPool = new ThreadPool();

    public ApplicationContext applicationContext;

    // 所有的处理程序
    public List<BaseProcessor> processors;

    // 所有的任务
    private List<Job> jobs;

    private Map<Job,ProcessorDefinition> processorDefinitions = new HashMap<>();

    // 通过时间间隔分组
    public Map<JobProcessorIntervalTime,List<ProcessorDefinition>> processorByGroup = new ConcurrentHashMap<>();

    @PostConstruct
    public void init() {
        // 加载所有的任务配置枚举
        loadAllJobs();
        // 加载所有的处理程序
        loadAllProcessor();
        // 处理程序通过时间分类
        processorGroup();
        // 创建线程
        createTaskThread();
    }

    private void loadAllJobs() {
        Job[] enumConstants = Job.class.getEnumConstants();
        this.jobs = Arrays.asList(enumConstants);
    }

    private void loadAllProcessor(){
        Map<String, BaseProcessor> beans = applicationContext.getBeansOfType(BaseProcessor.class);
        Collection<BaseProcessor> values = beans.values();
        this.processors = new ArrayList<>();
        values.forEach(item -> {
            this.processors.add(item);
        });
    }

    private void processorGroup(){
        if(CollectionUtils.isEmpty(processors)) {
            return;
        }
        processors.forEach(item -> {
            JobProcessorIntervalTime intervalTime = item.intervalTime();
            List<ProcessorDefinition> list = null;
            if (processorByGroup.containsKey(intervalTime)) {
                list = processorByGroup.get(intervalTime);
            } else {
                list = new ArrayList<>();
            }
            ProcessorDefinition processorDefinition = new ProcessorDefinition();
            processorDefinition.setBaseProcessor(item);
            processorDefinition.setStartThreadPool(item.startThreadPool());
            processorDefinition.setJobProcessorType(item.getType().getName());
            processorDefinition.setJobProcessorIntervalTime(intervalTime);
            if(item.startThreadPool()) {
                processorDefinition.setThreadPool(new ThreadPool());
            }
            list.add(processorDefinition);
            processorByGroup.put(intervalTime,list);
            processorDefinitions.put(item.getType(),processorDefinition);
        });
    }

    public void createTaskThread() {
        int size = processorByGroup.size();
        if(size == 0) {
            System.out.println("无需执行任务");
        }
        Set<JobProcessorIntervalTime> jobTime = processorByGroup.keySet();
        threadPool.init(size,size);
        for(JobProcessorIntervalTime processorIntervalTime: jobTime) {
            threadPool.excute(new TaskExecuteThread(this,processorIntervalTime));
        }
    }

    public void processorStart(BaseProcessor baseProcessor) {
        ProcessorDefinition definition = processorDefinitions.get(baseProcessor.getType());
        if(definition != null) {
            definition.setRunning(true);
        }
    }
    public void processorEnd(BaseProcessor baseProcessor) {
        ProcessorDefinition definition = processorDefinitions.get(baseProcessor.getType());
        if(definition != null) {
            definition.setRunning(false);
        }
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}

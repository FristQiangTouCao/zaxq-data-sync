package com.hongtian.component;

import com.hongtian.dao.mongo.SjClLogDao;
import com.hongtian.entity.vo.TodayTaskInfoVo;
import com.hongtian.schedule.Job;
import com.hongtian.schedule.ProcessorContext;
import com.hongtian.schedule.ProcessorDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * @author weed
 * @date 2020/12/17 0017 11:43
 * @description
 */
@Component
public class SystemInfoComponent {

    @Autowired
    private SjClLogDao sjClLogDao;

    @Autowired
    private ProcessorContext processorContext;


    public List<TodayTaskInfoVo> getTodayTaskInfo() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY,0);
        calendar.set(Calendar.MINUTE,0);
        calendar.set(Calendar.SECOND,0);
        Date time = calendar.getTime();
        return getTaskInfoByTime(time.getTime());
    }

    public List<TodayTaskInfoVo> getTaskInfoByTime(long time) {
        List<HashMap> todayTaskInfoList = sjClLogDao.getTodayTaskInfoList(time);
        List<Job> jobs = processorContext.jobs;
        Map<String, Job> jobMaps = new HashMap<>();
        jobs.forEach(item -> {
            jobMaps.put(item.getName(),item);
        });
        List<TodayTaskInfoVo> list = new ArrayList<>();
        todayTaskInfoList.forEach(item -> {
            TodayTaskInfoVo todayTaskInfoVo = new TodayTaskInfoVo();
            list.add(todayTaskInfoVo);
            todayTaskInfoVo.setTaskName((String) item.get("taskName"));
            todayTaskInfoVo.setRunningCount((int)item.get("runningCount"));
            todayTaskInfoVo.setHandleCount((int)item.get("total"));
            // 获取job信息
            Job job = jobMaps.get(todayTaskInfoVo.getTaskName());
            if(job == null) return;
            ProcessorDefinition definition = processorContext.processorDefinitions.get(job);
            if(definition == null) return;
            todayTaskInfoVo.setRunning(definition.isRunning());
            todayTaskInfoVo.setLastRunningTime(definition.getLastRunningTime());
            todayTaskInfoVo.setRunningIntervalTime(job.getJobProcessorIntervalTime().getName());
        });
        return list;
    }
}

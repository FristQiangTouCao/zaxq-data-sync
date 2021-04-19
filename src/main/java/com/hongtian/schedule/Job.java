package com.hongtian.schedule;
import java.util.*;

/**
 * @author weed
 * @date 2020/12/15 0015 16:27
 * @description
 */
public enum  Job implements Comparable<Job>{

    // 落地任务
    RY_RLZPJL_LD("人脸抓拍落地",JobProcessorIntervalTime.ONE_MINUTES),
    RY_RLZPJL_BACK("人脸抓拍记录备份",JobProcessorIntervalTime.ONE_MINUTES),
    CL_CRJL_BACK("车辆出入记录备份",JobProcessorIntervalTime.ONE_MINUTES),
    JCSS_GK("基础设施概况",JobProcessorIntervalTime.ONT_HOUR),
    JCSS_GK_LD("基础设施概况-落地",JobProcessorIntervalTime.ONT_HOUR),
    PZT_RY_RLZPJL_SB("人脸抓拍记录上报",JobProcessorIntervalTime.ONT_HOUR);


    // 名称
    private String name;
    // 时间
    private JobProcessorIntervalTime jobProcessorIntervalTime;
    // 排序
    private int order = 99;

    Job(String name,JobProcessorIntervalTime jobProcessorIntervalTime,int order) {
        this.name = name;
        this.jobProcessorIntervalTime = jobProcessorIntervalTime;
        this.order = order;
    }

    Job(String name,JobProcessorIntervalTime jobProcessorIntervalTime) {
        this.name = name;
        this.jobProcessorIntervalTime = jobProcessorIntervalTime;
    }

     Job(String name) {
        this.name = name;
        jobProcessorIntervalTime = JobProcessorIntervalTime.ZORE;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public JobProcessorIntervalTime getJobProcessorIntervalTime() {
        return jobProcessorIntervalTime;
    }

    public void setJobProcessorIntervalTime(JobProcessorIntervalTime jobProcessorIntervalTime) {
        this.jobProcessorIntervalTime = jobProcessorIntervalTime;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }


    public static Map<String,String> getJobDes() {
        Job[] values = Job.values();
        Map<String, String> map = new HashMap<>();
        for(Job job:values) {
            map.put(job.name(),job.getName());
        }
        return map;
    }
}

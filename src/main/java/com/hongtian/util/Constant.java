package com.hongtian.util;

public interface Constant {

    // 车脸集合的后缀
    String CL_SUFFIX = "_cl";

    // 人脸集合后缀
    String RL_SUFFIX = "_rl";

    String TIME_FORMAT_ALL = "yyyyMMddHHmmss";
    String TIME_FORMAT_DAY = "yyyyMMdd";
    String TIME_FORMAT_MONTH = "yyyyMM";


    // 系统配置- 启动的任务
    String START_TASK = "interval_start_task";

    /***************************************redis数据集名称***************************************/
    // 人脸抓拍落地数据
    String REDIS_RLZPLD = "jmxq_rlzpld";
    // 人员信息
    String REDIS_RYJB = "ryjb";
    // 基础设施
    String REDIS_JCSS = "jcss";
}

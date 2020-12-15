package com.hongtian.schedule;

/**
 * @author weed
 * @date 2020/12/15 0015 16:16
 * @description 间隔时间组
 */
public enum  JobProcessorIntervalTime {
    ONE_MINUTES("一分钟",1), //一分钟
    TEN_MINUTES("十分钟",10), //十分钟
    HALF_HOUR("半小时",30),   //半小时
    ONT_HOUR("一小时",60),     //一小时
    ZORE("二十四点",0);        // 零点

    JobProcessorIntervalTime(String name,int interval) {
        this.interval = interval;
        this.name = name;
    }
    // 名称
    private String name;
    // 间隔
    private int interval;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getInterval() {
        return interval;
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }
}

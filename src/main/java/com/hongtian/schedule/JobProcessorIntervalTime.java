package com.hongtian.schedule;

/**
 * @author weed
 * @date 2020/12/15 0015 16:16
 * @description 间隔时间组
 */
public enum  JobProcessorIntervalTime {
    ONE_MINUTES("一分钟","0 */1 * * * ?"), //一分钟
    TEN_MINUTES("十分钟","0 */10  * * * ?"), //十分钟
    HALF_HOUR("半小时","0 */30  * * * ?"),   //半小时
    ONT_HOUR("一小时","0 0 */1 * * ?"),     //一小时
    ZORE("二十四点","0 0 0 * * ?");        // 零点

    JobProcessorIntervalTime(String name,String interval) {
        this.interval = interval;
        this.name = name;
    }
    // 名称
    private String name;
    // 间隔
    private String interval;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInterval() {
        return interval;
    }

    public void setInterval(String interval) {
        this.interval = interval;
    }
}

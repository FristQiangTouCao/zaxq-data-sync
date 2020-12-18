package com.hongtian.entity;

import org.springframework.data.annotation.Id;

/**
 * @author weed
 * @date 2020/11/30 0030 10:45
 * @description 数据备份日志
 */
public class SjClLog {
    @Id
    private String id;
    // 开始时间
    private long startTime;
    // 结束时间
    private long endTime;
    // 修改时间
    private long updateTime;
    // 总数
    private int total;
    // 成功数
    private int successCount;
    // 失败数
    private int failCount;
    /**
     * 同步类型：1:cl,2:ry
     */
    private String type;
    /**
     * 状态， 0:同步中，1:同步成功，2:同步失败
     */
    private int status;

    // 备注
    private String bz;

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getSuccessCount() {
        return successCount;
    }

    public long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
    }

    public void setSuccessCount(int successCount) {
        this.successCount = successCount;
    }

    public int getFailCount() {
        return failCount;
    }

    public void setFailCount(int failCount) {
        this.failCount = failCount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getBz() {
        return bz;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }
}

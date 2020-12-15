package com.hongtian.util;

import java.text.ParseException;

public class CommonUtils {

    // 获取车脸当天的集合的名称
    public static String getClCollectionNameThisDay() {
        String now = DateTimeUtils.now();
        return now.substring(0,8) + Constant.CL_SUFFIX;
    }

    // 获取车辆执行时间的集合的名称
    public static String getClCollectionNameSpecDay(String time) throws ParseException {
        if(time == null || time.length() < 8) {
            return null;
        }
        time = time.substring(0,8);
        return time + Constant.CL_SUFFIX;
    }

    // 获取人脸当天的集合的名称
    public static String getRlCollectionNameThisDay() {
        String now = DateTimeUtils.now();
        return now.substring(0,8) + Constant.RL_SUFFIX;
    }

    // 获取人脸执行时间的集合的名称
    public static String getRlCollectionNameSpecDay(String time) throws ParseException {
        if(time == null || time.length() < 8) {
            throw new ParseException("时间格式必须是yyyyMMddHHmmss,字符串长度不可少与8",1);
        }
        time = time.substring(0,8);
        return time + Constant.RL_SUFFIX;
    }
}

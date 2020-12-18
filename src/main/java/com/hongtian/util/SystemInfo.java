package com.hongtian.util;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author weed
 * @date 2020/11/30 0030 14:09
 * @description
 */
public class SystemInfo {
    public static String startTime = String.valueOf(new Date().getTime());

    public static String dataDir = "";

    public static int clRunningCount = 0;

    public static int rlRunningCount = 0;

    public static int clJlCount = 0;

    public static int rlJlCount = 0;

    public static Map<String,Object> getInfo() {
        File file = new File(dataDir);
        Map<String, Object> map= new HashMap<>();
        map.put("startTime",startTime);
        map.put("clRunningCount",clRunningCount);
        map.put("rlRunningCount",rlRunningCount);
        map.put("clJlCount",clJlCount);
        map.put("rlJlCount",rlJlCount);
        map.put("freeSpace",file.length()/(1024*1024)/1024 + "G");
        map.put("totalSpace",file.getFreeSpace()/(1024*1024)/1024 + "G");
        return map;
    }
}

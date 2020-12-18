package com.hongtian.util;

/**
 * @author weed
 * @date 2020/12/17 0017 10:59
 * @description
 */
public class ThreadUtils {

    private ThreadUtils(){}

    public static void sleep(int seconds) {
        try {
            Thread.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

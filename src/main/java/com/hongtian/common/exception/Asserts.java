package com.hongtian.common.exception;


import com.hongtian.common.response.PzCodeBase;

/**
 * @author weed
 * @date 2020/10/10 0010 20:44
 * @description 断言处理类，用于抛出各种API异常
 */
public class Asserts {
    public static void fail(String message) {
        throw new ApiException(message);
    }

    public static void fail(PzCodeBase errorCode) {
        throw new ApiException(errorCode);
    }
}

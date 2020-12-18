package com.hongtian.common.response;

/**
 * @author weed
 * @date 2020/10/10 0010 17:59
 * @description
 */
public enum ResponseCode implements PzCodeBase {
    ERROR(-1, "error"),
    SUCCESS(0, "success"),
    REQUEST_PARAMS_ERROR(1004, "请求参数错误"),
    UN_PERMISSION(1005, "没有权限访问！"),
    USER_NOT_LOGIN(1003, "用户未登录,请登录后访问！");
    private final int code;
    private final String msg;

    ResponseCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}

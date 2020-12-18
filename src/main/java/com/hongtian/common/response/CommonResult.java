package com.hongtian.common.response;


import lombok.experimental.Accessors;


@Accessors(chain = true)
public class CommonResult<T> {

    private Integer resultCode;

    private String message;

    private T data;

    public CommonResult(Integer code,String msg,T data) {
        this.resultCode= code;
        this.message = msg;
        this.data = data;
    }

    public static <T> CommonResult success(T data, String msg) {
        return response(ResponseCode.SUCCESS,data,msg);
    }

    public static <T> CommonResult successData(T data) {
        ResponseCode success = ResponseCode.SUCCESS;
        return response(success.getCode(),success.getMsg(),data);
    }

    public static CommonResult success() {
        return successData(null);
    }

    public static CommonResult error() {
        return error(ResponseCode.ERROR);
    }

    public static CommonResult error(String msg) {
        return error(ResponseCode.ERROR,msg);
    }

    public static CommonResult error(PzCodeBase responseCode) {
        return response(responseCode,null,responseCode.getMsg());
    }

    public static CommonResult error(PzCodeBase responseCode,String msg) {
        return response(responseCode,null,msg);
    }


    public static <T> CommonResult response(PzCodeBase responseCode, T data, String msg) {
        return response(responseCode.getCode(),msg,data);
    }

    public static <T> CommonResult response(int code, String msg, T data) {
        return new CommonResult(code,msg,data);
    }

    public Integer getResultCode() {
        return resultCode;
    }

    public void setResultCode(Integer resultCode) {
        this.resultCode = resultCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setPzData(T data) {
        this.data = data;
    }
}
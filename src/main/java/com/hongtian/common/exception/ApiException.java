package com.hongtian.common.exception;


import com.hongtian.common.response.PzCodeBase;

/**
 * @author weed
 * @date 2020/10/10 0010 20:42
 * @description
 */
public class ApiException extends RuntimeException {

    PzCodeBase errorCode;

    public ApiException(PzCodeBase errorCode) {
        super(errorCode.getMsg());
        this.errorCode = errorCode;
    }

    public ApiException(String message) {
        super(message);
    }

    public ApiException(Throwable cause) {
        super(cause);
    }

    public ApiException(String message, Throwable cause) {
        super(message, cause);
    }

    public PzCodeBase getErrorCode() {
        return errorCode;
    }
}

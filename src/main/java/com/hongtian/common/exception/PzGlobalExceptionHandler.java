package com.hongtian.common.exception;


import com.hongtian.common.response.CommonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author weed
 * @date 2020/10/10 0010 20:44
 * @description 全局controller异常处理
 */
@Deprecated
//@ControllerAdvice
public class PzGlobalExceptionHandler {
    @ResponseBody
    @ExceptionHandler(value = ApiException.class)
    public CommonResult handle(ApiException e) {
        if (e.getErrorCode() != null) {
            return CommonResult.error(e.getErrorCode());
        }
        return CommonResult.error(e.getMessage());
    }
}

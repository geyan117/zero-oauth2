package com.zero.lab.oauth2.infra.web.handler;

import com.zero.lab.oauth2.common.exception.OAuth2Exception;
import com.zero.lab.oauth2.common.response.CommonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理，将异常转化为CommonResult进行返回
 *
 * @author geyan
 * @date 2025/8/24
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(OAuth2Exception.class)
    public CommonResult<?> handleOAuth2Exception(OAuth2Exception e) {
        return CommonResult.error(e.getCode(), e.getMsg());
    }
}

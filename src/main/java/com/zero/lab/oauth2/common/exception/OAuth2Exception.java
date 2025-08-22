package com.zero.lab.oauth2.common.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 业务逻辑异常
 *
 * @author geyan
 * @date 2025/8/24
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class OAuth2Exception extends RuntimeException {

    private Integer code;

    private String msg;

    public OAuth2Exception(ErrorCode errorCode) {
        this.code = errorCode.getCode();
        this.msg = errorCode.getMsg();
    }
}

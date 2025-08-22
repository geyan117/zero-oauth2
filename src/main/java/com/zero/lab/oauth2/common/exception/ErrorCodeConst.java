package com.zero.lab.oauth2.common.exception;

/**
 * OAuth2在整个项目中的错误码从 100开始
 * @author geyan
 * @date 2025/8/22
 */
public interface ErrorCodeConst {

    ErrorCode SUCCESS = new ErrorCode(0, "success");

    // === 客户端 100-001-000 ===
    ErrorCode OAUTH2_CLIENT_EXISTS = new ErrorCode(100_001_000, "客户端已经存在");
}

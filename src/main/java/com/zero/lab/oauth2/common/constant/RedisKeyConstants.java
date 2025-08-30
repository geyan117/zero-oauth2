package com.zero.lab.oauth2.common.constant;

/**
 * @author geyan
 * @date 2025/8/30
 */
public interface RedisKeyConstants {

    /**
     * OAuth2 客户端的缓存
     * <p>
     * KEY 格式：oauth_client:{id}
     * VALUE 数据类型：String 客户端信息
     */
    String OAUTH_CLIENT = "zero_oauth_client";
}

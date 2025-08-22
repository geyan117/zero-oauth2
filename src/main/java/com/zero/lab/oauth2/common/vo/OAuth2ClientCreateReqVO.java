package com.zero.lab.oauth2.common.vo;

import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @author geyan
 * @date 2025/8/22
 */
@Data
public class OAuth2ClientCreateReqVO {

    /**
     * 客户端编号
     */
    private String clientId;

    /**
     * 客户端秘钥
     */
    @ToString.Exclude
    private String secret;

    private String logo;


    private String name;

    /**
     * 权限
     */
    private List<String> authorities;

    /**
     * 授权类型
     */
    private List<String> authorizedGrantTypes;

    /**
     * 自动通过的授权范围
     */
    private List<String> autoApproveScopes;

    /**
     * 重定向地址
     */
    private List<String> redirectUris;

    /**
     * 资源
     */
    private List<String> resourceIds;

    /**
     * 授权范围
     */
    private List<String> scopes;

    /**
     * 访问令牌的有效期
     */
    private Integer accessTokenValiditySeconds;

    /**
     * 刷新令牌的有效期
     */
    private Integer refreshTokenValiditySeconds;

    /**
     * 状态
     */
    private Integer status;
}

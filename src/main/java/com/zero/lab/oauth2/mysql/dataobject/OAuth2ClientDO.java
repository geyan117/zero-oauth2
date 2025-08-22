package com.zero.lab.oauth2.mysql.dataobject;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * OAuth2 客户端DO
 *
 * @author geyan
 * @date 2025/8/24
 */
@TableName(value = "zero_oauth2_client", autoResultMap = true)
@Data
@EqualsAndHashCode(callSuper = true)
public class OAuth2ClientDO extends BaseDO {

    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 客户端编号
     */
    private String clientId;

    /**
     * 客户端秘钥
     */
    private String secret;

    /**
     * 应用名
     */
    private String name;

    /**
     * 应用图标
     */
    private String logo;

    /**
     * 应用描述
     */
    private String description;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 访问令牌的有效期
     */
    private Integer accessTokenValiditySeconds;

    /**
     * 刷新令牌的有效期
     */
    private int refreshTokenValiditySeconds;

    /**
     * 可重定向的地址
     */
    @TableField(typeHandler = JacksonTypeHandler.class)
    private List<String> redirectUris;

    /**
     * 授权类型
     */
    @TableField(typeHandler = JacksonTypeHandler.class)
    private List<String> authorizedGrantTypes;

    /**
     * 授权范围
     */
    @TableField(typeHandler = JacksonTypeHandler.class)
    private List<String> scopes;

    /**
     * 自动授权的 scope
     */
    @TableField(typeHandler = JacksonTypeHandler.class)
    private List<String> autoApproveScopes;

    /**
     * 权限
     */
    @TableField(typeHandler = JacksonTypeHandler.class)
    private List<String> authorities;

    /**
     * 资源
     */
    @TableField(typeHandler = JacksonTypeHandler.class)
    private List<String> resourceIds;

    /**
     * 扩展信息，json格式
     */
    private String extendParams;
}

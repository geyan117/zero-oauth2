package com.zero.lab.oauth2.mysql.dataobject;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * @author geyan
 * @date 2025/8/30
 */
@TableName(value = "zero_oauth2_approve", autoResultMap = true)
@Data
@EqualsAndHashCode(callSuper = true)
public class OAuth2ApproveDO extends BaseDO {

    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 用户类型
     */
    private Integer userType;

    /**
     * 客户端编号
     */
    private String clientId;

    /**
     * 授权范围
     */
    private String scope;

    /**
     * 是否批准授权
     */
    private Boolean approved;

    /**
     * 过期时间
     */
    private LocalDateTime expiresTime;

    /**
     * 租户id
     */
    private Long tenantId;
}

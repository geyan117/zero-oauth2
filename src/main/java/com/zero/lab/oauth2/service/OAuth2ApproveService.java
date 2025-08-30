package com.zero.lab.oauth2.service;

import com.zero.lab.oauth2.common.enums.UserTypeEnum;
import com.zero.lab.oauth2.mysql.dataobject.OAuth2ApproveDO;

import java.util.List;

/**
 * @author geyan
 * @date 2025/8/30
 */
public interface OAuth2ApproveService {

    /**
     * 获取用户同意的授权内容，当前用户自己注册的clientId
     * @param clientId 客户端编号
     * @param userId 用户id
     * @param userType 用户类型
     * @return 授权通过的内容
     */
    List<OAuth2ApproveDO> getApproveList(String clientId, long userId, UserTypeEnum userType);
}

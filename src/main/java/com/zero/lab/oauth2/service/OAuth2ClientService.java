package com.zero.lab.oauth2.service;

import com.zero.lab.oauth2.common.vo.OAuth2ClientCreateReqVO;

/**
 * @author geyan
 * @date 2025/8/24
 */
public interface OAuth2ClientService {

    Long createOAuth2Client(OAuth2ClientCreateReqVO createReqVO);
}

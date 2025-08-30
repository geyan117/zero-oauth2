package com.zero.lab.oauth2.service;

import com.zero.lab.oauth2.common.vo.OAuth2ClientReqVO;
import com.zero.lab.oauth2.mysql.dataobject.OAuth2ClientDO;
import jakarta.validation.Valid;

/**
 * @author geyan
 * @date 2025/8/24
 */
public interface OAuth2ClientService {

    Long createOAuth2Client(@Valid OAuth2ClientReqVO createReqVO);

    Boolean updateOAuth2Client(@Valid OAuth2ClientReqVO updateReqVO);

    Boolean deleteOAuth2Client(String clientId);

    OAuth2ClientDO validateOAuth2ClientFromCache(String clientId);
}

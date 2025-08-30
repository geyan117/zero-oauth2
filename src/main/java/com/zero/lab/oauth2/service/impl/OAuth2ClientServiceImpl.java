package com.zero.lab.oauth2.service.impl;

import com.zero.lab.oauth2.common.constant.RedisKeyConstants;
import com.zero.lab.oauth2.common.exception.ErrorCodeConst;
import com.zero.lab.oauth2.common.exception.OAuth2Exception;
import com.zero.lab.oauth2.common.utils.ZeroBeanUtil;
import com.zero.lab.oauth2.common.vo.OAuth2ClientReqVO;
import com.zero.lab.oauth2.mapper.OAuth2ClientMapper;
import com.zero.lab.oauth2.mysql.dataobject.OAuth2ClientDO;
import com.zero.lab.oauth2.service.OAuth2ClientService;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author geyan
 * @date 2025/8/24
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class OAuth2ClientServiceImpl implements OAuth2ClientService {

    private final OAuth2ClientMapper oauth2ClientMapper;

    @Override
    public Long createOAuth2Client(OAuth2ClientReqVO createReqVO) {
        checkClientExist(createReqVO.getClientId());
        // 插入, VO -> DO
        OAuth2ClientDO clientDO = ZeroBeanUtil.toBean(createReqVO, OAuth2ClientDO.class);
        oauth2ClientMapper.insert(clientDO);
        return clientDO.getId();
    }

    @Override
    public Boolean updateOAuth2Client(OAuth2ClientReqVO updateReqVO) {
        checkClientNotExist(updateReqVO.getClientId());
        OAuth2ClientDO clientDO = ZeroBeanUtil.toBean(updateReqVO, OAuth2ClientDO.class);
        return oauth2ClientMapper.updateByClientId(clientDO.getClientId(), clientDO);
    }

    @Override
    public Boolean deleteOAuth2Client(String clientId) {
        checkClientNotExist(clientId);
        return oauth2ClientMapper.deleteByClientId(clientId);
    }

    // TODO@geyan 需要配置 Spring Cache
    @Override
//    @Cacheable(cacheNames = RedisKeyConstants.OAUTH_CLIENT, key = "#clientId", unless = "#result == null")
    public OAuth2ClientDO validateOAuth2ClientFromCache(String clientId) {
        return oauth2ClientMapper.selectByClientId(clientId);
    }

    /**
     * 检查client是否不存在
     *
     * @param clientId 客户端编号
     */
    private void checkClientNotExist(@NotNull String clientId) {
        OAuth2ClientDO client = oauth2ClientMapper.selectByClientId(clientId);
        if (client == null) {
            throw new OAuth2Exception(ErrorCodeConst.OAUTH2_CLIENT_NOT_EXISTS);
        }
    }

    /**
     * 检查是否存在
     *
     * @param clientId 客户端编号
     */
    private void checkClientExist(@NotNull String clientId) {
        OAuth2ClientDO client = oauth2ClientMapper.selectByClientId(clientId);
        if (client != null) {
            throw new OAuth2Exception(ErrorCodeConst.OAUTH2_CLIENT_EXISTS);
        }
    }
}

package com.zero.lab.oauth2.service.impl;

import com.zero.lab.oauth2.common.exception.ErrorCodeConst;
import com.zero.lab.oauth2.common.exception.OAuth2Exception;
import com.zero.lab.oauth2.common.utils.ZeroBeanUtil;
import com.zero.lab.oauth2.common.vo.OAuth2ClientCreateReqVO;
import com.zero.lab.oauth2.mapper.OAuth2ClientMapper;
import com.zero.lab.oauth2.mysql.dataobject.OAuth2ClientDO;
import com.zero.lab.oauth2.service.OAuth2ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author geyan
 * @date 2025/8/24
 */
@Service
@RequiredArgsConstructor
public class OAuth2ClientServiceImpl implements OAuth2ClientService {

    private final OAuth2ClientMapper oAuth2ClientMapper;

    @Override
    public Long createOAuth2Client(OAuth2ClientCreateReqVO createReqVO) {
        checkClientExist(createReqVO.getClientId());
        // 插入, VO -> DO
        OAuth2ClientDO clientDO = ZeroBeanUtil.toBean(createReqVO, OAuth2ClientDO.class);
        oAuth2ClientMapper.insert(clientDO);
        return clientDO.getId();
    }

    /**
     * 检查是否存在
     * @param clientId 客户端编号
     */
    private void checkClientExist(String clientId) {
        OAuth2ClientDO client = oAuth2ClientMapper.selectByClientId(clientId);
        if (client != null) {
            throw new OAuth2Exception(ErrorCodeConst.OAUTH2_CLIENT_EXISTS);
        }
    }
}

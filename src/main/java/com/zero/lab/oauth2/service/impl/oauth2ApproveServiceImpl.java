package com.zero.lab.oauth2.service.impl;

import com.zero.lab.oauth2.common.enums.UserTypeEnum;
import com.zero.lab.oauth2.mapper.OAuth2ApproveMapper;
import com.zero.lab.oauth2.mysql.dataobject.OAuth2ApproveDO;
import com.zero.lab.oauth2.service.OAuth2ApproveService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author geyan
 * @date 2025/8/30
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class oauth2ApproveServiceImpl implements OAuth2ApproveService {

    private final OAuth2ApproveMapper oauth2ApproveMapper;

    @Override
    public List<OAuth2ApproveDO> getApproveList(String clientId, long userId, UserTypeEnum userType) {
        return oauth2ApproveMapper.selectList(clientId, userId, userType.getId());
    }
}

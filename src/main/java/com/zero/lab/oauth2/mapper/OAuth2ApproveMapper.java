package com.zero.lab.oauth2.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zero.lab.oauth2.mysql.dataobject.OAuth2ApproveDO;

import java.util.List;

/**
 * @author geyan
 * @date 2025/8/30
 */
public interface OAuth2ApproveMapper extends BaseMapper<OAuth2ApproveDO> {

    default List<OAuth2ApproveDO> selectList(String clientId, Long userId, int userType) {
        LambdaQueryWrapper<OAuth2ApproveDO> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(OAuth2ApproveDO::getClientId, clientId);
        queryWrapper.eq(OAuth2ApproveDO::getUserId, userId);
        queryWrapper.eq(OAuth2ApproveDO::getUserType, userType);
        return selectList(queryWrapper);
    }
}

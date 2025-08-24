package com.zero.lab.oauth2.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zero.lab.oauth2.mysql.dataobject.OAuth2ClientDO;

/**
 * @author geyan
 * @date 2025/8/24
 */
public interface OAuth2ClientMapper extends BaseMapper<OAuth2ClientDO> {

    default OAuth2ClientDO selectByClientId(String clientId) {
        LambdaQueryWrapper<OAuth2ClientDO> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(OAuth2ClientDO::getClientId, clientId);
        return selectOne(queryWrapper);
    }


    default boolean updateByClientId(String clientId, OAuth2ClientDO clientDO) {
        LambdaUpdateWrapper<OAuth2ClientDO> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(OAuth2ClientDO::getClientId, clientId);
        int affectRow = update(clientDO, updateWrapper);
        return affectRow == 1;
    }
}

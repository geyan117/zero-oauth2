package com.zero.lab.oauth2.common.convert;

import cn.hutool.core.lang.Pair;
import com.zero.lab.oauth2.common.response.OAuth2AuthorizeInfoRespVO;
import com.zero.lab.oauth2.mysql.dataobject.OAuth2ApproveDO;
import com.zero.lab.oauth2.mysql.dataobject.OAuth2ClientDO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author geyan
 * @date 2025/8/30
 */
public class OAuth2Convert {

    /**
     * 从client中的所有授权中，根据approves中的内容进行修改
     * @param client client
     * @param approves approves
     * @return resp
     */
    public static OAuth2AuthorizeInfoRespVO convert(OAuth2ClientDO client, List<OAuth2ApproveDO> approves) {
        List<Pair<String, Boolean>> scopes = new ArrayList<>(client.getScopes().size());
        Map<String, OAuth2ApproveDO> map = approves.stream().collect(Collectors.toMap(OAuth2ApproveDO::getScope, o -> o));
        client.getScopes().forEach(scope -> {
            OAuth2ApproveDO oAuth2ApproveDO = map.get(scope);
            scopes.add(Pair.of(scope, oAuth2ApproveDO != null ? oAuth2ApproveDO.getApproved() : false));
        });
        OAuth2AuthorizeInfoRespVO vo = new OAuth2AuthorizeInfoRespVO();
        vo.setClient(new OAuth2AuthorizeInfoRespVO.Client(client.getName(), client.getLogo()));
        vo.setScopes(scopes);
        return vo;
    }
}

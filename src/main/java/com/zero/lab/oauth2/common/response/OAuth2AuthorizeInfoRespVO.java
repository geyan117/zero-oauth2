package com.zero.lab.oauth2.common.response;

import cn.hutool.core.lang.Pair;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author geyan
 * @date 2025/8/30
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OAuth2AuthorizeInfoRespVO {

    private Client client;

    private List<Pair<String, Boolean>> scopes;

    @Data
    @AllArgsConstructor
    public static class Client {

        private String name;

        private String logo;
    }
}

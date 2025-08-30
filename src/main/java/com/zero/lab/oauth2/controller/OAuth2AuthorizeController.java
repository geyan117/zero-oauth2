package com.zero.lab.oauth2.controller;

import com.zero.lab.oauth2.common.convert.OAuth2Convert;
import com.zero.lab.oauth2.common.enums.UserTypeEnum;
import com.zero.lab.oauth2.common.response.CommonResult;
import com.zero.lab.oauth2.common.response.OAuth2AuthorizeInfoRespVO;
import com.zero.lab.oauth2.mysql.dataobject.OAuth2ApproveDO;
import com.zero.lab.oauth2.mysql.dataobject.OAuth2ClientDO;
import com.zero.lab.oauth2.service.OAuth2ApproveService;
import com.zero.lab.oauth2.service.OAuth2ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author geyan
 * @date 2025/8/30
 */
@RestController
@RequestMapping("/zero/oauth2")
@RequiredArgsConstructor
@Validated
public class OAuth2AuthorizeController {

    private final OAuth2ClientService oauth2ClientService;

    private final OAuth2ApproveService oauth2ApproveService;

    /**
     * 1. 获取该clientId所有的scope
     * 2. 获取用户已经授权的（在前端界面上展示已勾选）
     */
    @GetMapping("/authorize")
    public CommonResult<OAuth2AuthorizeInfoRespVO> authorize(@RequestParam("clientId") String clientId) {
        // 0. 先校验用户是否已经登录，这个由Spring Security实现
        // 1. 获取该clientId所有的scope
        OAuth2ClientDO client = oauth2ClientService.validateOAuth2ClientFromCache(clientId);
        // 2. 获取该用户已经approve的授权内容
        List<OAuth2ApproveDO> approveList = oauth2ApproveService.getApproveList(clientId, mockUserId(), UserTypeEnum.ADMIN);
        return CommonResult.success(OAuth2Convert.convert(client, approveList));
    }


    private long mockUserId() {
        return 0;
    }
}

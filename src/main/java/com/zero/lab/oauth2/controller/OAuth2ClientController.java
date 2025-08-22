package com.zero.lab.oauth2.controller;

import com.zero.lab.oauth2.common.response.CommonResult;
import com.zero.lab.oauth2.common.vo.OAuth2ClientCreateReqVO;
import com.zero.lab.oauth2.service.OAuth2ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author geyan
 * @date 2025/8/22
 */
@RestController
@RequestMapping("/zero/oauth2-client")
@RequiredArgsConstructor
public class OAuth2ClientController {

    private final OAuth2ClientService oAuth2ClientService;

    @PostMapping("/create")
    public CommonResult<Long> createOAuth2Client(@RequestBody OAuth2ClientCreateReqVO createReqVO) {
        return CommonResult.success(oAuth2ClientService.createOAuth2Client(createReqVO));
    }

    @PostMapping("/update")
    public void updateOAuth2Client() {

    }

    @PostMapping("/delete")
    public void deleteOAuth2Client() {

    }
}

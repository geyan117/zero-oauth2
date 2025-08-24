package com.zero.lab.oauth2.controller;

import com.zero.lab.oauth2.common.response.CommonResult;
import com.zero.lab.oauth2.common.vo.OAuth2ClientReqVO;
import com.zero.lab.oauth2.service.OAuth2ClientService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author geyan
 * @date 2025/8/22
 */
@RestController
@RequestMapping("/zero/oauth2-client")
@RequiredArgsConstructor
@Validated
public class OAuth2ClientController {

    private final OAuth2ClientService oAuth2ClientService;

    @PostMapping("/create")
    public CommonResult<Long> createOAuth2Client(@Valid @RequestBody OAuth2ClientReqVO createReqVO) {
        return CommonResult.success(oAuth2ClientService.createOAuth2Client(createReqVO));
    }

    @PutMapping("/update")
    public CommonResult<Boolean> updateOAuth2Client(@Valid @RequestBody OAuth2ClientReqVO updateReqVO) {
        return CommonResult.success(oAuth2ClientService.updateOAuth2Client(updateReqVO));
    }

    @DeleteMapping("/delete")
    public CommonResult<Boolean> deleteOAuth2Client(@NotEmpty @RequestParam String clientId) {
        return CommonResult.success(oAuth2ClientService.deleteOAuth2Client(clientId));
    }
}

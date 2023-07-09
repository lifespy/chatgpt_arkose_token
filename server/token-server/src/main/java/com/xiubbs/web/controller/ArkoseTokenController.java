package com.xiubbs.web.controller;

import com.xiubbs.common.core.domain.R;
import com.xiubbs.common.log.annotation.Log;
import com.xiubbs.common.log.enums.BusinessType;
import com.xiubbs.web.domain.Token;
import com.xiubbs.web.dto.TokenDto;
import com.xiubbs.web.service.ArkoseTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


/**
 * 邮件发送案例
 *
 * @author 西柚
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping
public class ArkoseTokenController {

    private final ArkoseTokenService tokenService;

    /**
     * 接受客户端上报的token
     */
    @Log(title = "接受客户端上报的token", businessType = BusinessType.INSERT)
    @PostMapping("/token")
    public R<Boolean> addToken(@Validated @RequestBody TokenDto param) {
        return tokenService.addToken(param);
    }

    /**
     * 接受客户端上报的token
     */
    @Log(title = "获取token", businessType = BusinessType.QUERY)
    @GetMapping("/token")
    public R<Token> getToken() {
        return tokenService.getToken();
    }

    /**
     * 接受客户端上报的token
     */
    @Log(title = "获取token总数", businessType = BusinessType.QUERY)
    @GetMapping("/token/total")
    public R<Integer> getTotal() {
        return tokenService.getTotal();
    }

}

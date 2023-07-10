package com.xiubbs.web.service;

import cn.hutool.core.util.IdUtil;
import java.time.Duration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.xiubbs.common.core.domain.R;
import com.xiubbs.common.web.config.properties.TokenProperties;
import com.xiubbs.common.web.utils.RequestUtil;
import com.xiubbs.web.conts.HeaderConstant;
import com.xiubbs.web.domain.Token;
import com.xiubbs.web.dto.TokenDto;

/**
 * 注册校验方法
 *
 * @author 西柚
 */
@Service
public class ArkoseTokenService {

    @Autowired
    private TokenProperties tokenProperties;

    @Qualifier("redisCacheService")
    @Autowired
    private ICacheService cacheService;

    /**
     * 新增token
     */
    public R<Boolean> addToken(TokenDto param) {
        if (tokenProperties.getEnable()) {
            String key = RequestUtil.getHttpServletRequest().getHeader(HeaderConstant.SECURITY_KEY);
            String postSecurityKey = tokenProperties.getPostSecurityKey();
            if (!postSecurityKey.equals(key)) {
                return R.fail("key was error!");
            }
        }
        Token token = new Token();
        token.setId(IdUtil.getSnowflakeNextId());
        token.setToken(param.getToken());
        token.setDate(param.getDate());
        cacheService.addToken(token);
        return R.ok();
    }

    /**
     * 获取token
     */
    public R<Token> getToken() {
        Token token = cacheService.getToken();
        while (token != null && token.getDate().getTime() <= System.currentTimeMillis() - Duration.ofMinutes(30).toMillis()) {
            token = cacheService.getToken();
        }
        if (token == null) {
            return R.fail(R.NOTFOUND, "no token");
        }
        return R.ok(token);
    }

    public R<Integer> getTotal() {
        return R.ok(cacheService.getTotal());
    }
}

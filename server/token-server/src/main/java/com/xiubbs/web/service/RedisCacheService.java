package com.xiubbs.web.service;

import com.xiubbs.common.redis.utils.RedisUtils;
import com.xiubbs.web.conts.CacheKeyConstant;
import com.xiubbs.web.domain.Token;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RedisCacheService implements ICacheService {
    @Override
    public Token getToken() {
        return RedisUtils.getObjectFromQueue(CacheKeyConstant.TOKEN_KEY);
    }

    @Override
    public Boolean addToken(Token token) {
        return RedisUtils.putObjectToQueue(CacheKeyConstant.TOKEN_KEY, token);
    }

    @Override
    public int getTotal() {
        return RedisUtils.getQueueSize(CacheKeyConstant.TOKEN_KEY);
    }
}

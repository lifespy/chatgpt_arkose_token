package com.xiubbs.web.service;

import com.xiubbs.web.domain.Token;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MemoryCacheService implements ICacheService {
    @Override
    public Token getToken() {
        //todo
        return null;
    }

    @Override
    public Boolean addToken(Token token) {
        //todo
        return null;
    }

    @Override
    public int getTotal() {
        //todo
        return 0;
    }
}

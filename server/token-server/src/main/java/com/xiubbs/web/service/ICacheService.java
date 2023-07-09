package com.xiubbs.web.service;

import com.xiubbs.web.domain.Token;

public interface ICacheService {
    Token getToken();

    Boolean addToken(Token token);

    int getTotal();
}

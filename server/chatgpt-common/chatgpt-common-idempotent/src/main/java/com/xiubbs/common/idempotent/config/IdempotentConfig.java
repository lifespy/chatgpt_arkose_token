package com.xiubbs.common.idempotent.config;

import com.xiubbs.common.idempotent.aspectj.RepeatSubmitAspect;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConfiguration;

/**
 * 幂等功能配置
 *
 * @author 西柚
 */
@AutoConfiguration(after = RedisConfiguration.class)
public class IdempotentConfig {

    @Bean
    public RepeatSubmitAspect repeatSubmitAspect() {
        return new RepeatSubmitAspect();
    }

}

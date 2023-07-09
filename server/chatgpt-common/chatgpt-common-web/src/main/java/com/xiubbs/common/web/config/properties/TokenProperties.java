package com.xiubbs.common.web.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 验证码 配置属性
 *
 * @author 西柚
 */
@Data
@ConfigurationProperties(prefix = "token")
public class TokenProperties {

    /**
     * 是否启用token验证
     */
    private Boolean enable;

    /**
     * 安全密钥(提交)
     */
    private String postSecurityKey;

    /**
     * 安全密钥(获取)
     */
    private String getSecurityKey;
}

package com.xiubbs.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;

/**
 * 测试单表业务对象 test_demo
 *
 * @author 西柚
 */
@Data
public class TokenDto {

    @NotBlank(message = "token不能为空")
    private String token;

    @NotNull(message = "日期")
    private Date date;


}

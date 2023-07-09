package com.xiubbs.web.domain;

import lombok.Data;

import java.util.Date;

/**
 * 测试单表业务对象 test_demo
 *
 * @author 西柚
 */
@Data
public class Token {

    /**
     * id
     */
    private Long id;

    /**
     * token
     */
    private String token;

    /**
     * 生成日期
     */
    private Date date;

}

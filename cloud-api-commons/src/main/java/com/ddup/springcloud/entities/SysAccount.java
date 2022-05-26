package com.ddup.springcloud.entities;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author: haowanjin
 * @Description TODO
 * @create: 2022/4/22 11:24
 */
@Data
public class SysAccount {
    private Long id;
    private Long userId;
    private Integer sex;
    private BigDecimal amount;
}

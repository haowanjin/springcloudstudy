package com.ddup.springcloud.service;

import java.math.BigDecimal;

/**
 * @author: haowanjin
 * @Description TODO
 * @create: 2022/4/22 13:42
 */
public interface SysAccountService {

    String transferFrom(Long accountId, BigDecimal amount);
}

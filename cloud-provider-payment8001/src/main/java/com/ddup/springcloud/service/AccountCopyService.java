package com.ddup.springcloud.service;

import org.apache.ibatis.annotations.Select;

import java.math.BigDecimal;

/**
 * @author: haowanjin
 * @Description TODO
 * @create: 2022/4/22 13:42
 */
public interface AccountCopyService {

    String transferTo(Long accountId, BigDecimal amount);
}

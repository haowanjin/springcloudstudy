package com.ddup.springcloud.service.impl;

import com.ddup.springcloud.service.AccountService;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author: haowanjin
 * @Description TODO
 * @create: 2022/4/22 15:56
 */
@Service("accountServiceImpl")
@Slf4j
public class AccountServiceImpl {
    @Resource
    private AccountService accountService;

    @GlobalTransactional
    public String transfer(BigDecimal amount) {
        log.info("==============>{}", RootContext.getXID());
        accountService.transferFrom(amount);
        String res = accountService.transferTo(amount);
        return res;
    }
}

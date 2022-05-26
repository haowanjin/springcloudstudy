package com.ddup.springcloud.service.impl;

import com.ddup.springcloud.dao.AccountCopyDao;
import com.ddup.springcloud.entities.SysAccountCopy;
import com.ddup.springcloud.service.AccountCopyService;
import io.seata.core.context.RootContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author: haowanjin
 * @Description
 * @create: 2022/4/22 13:43
 */
@Service
@Slf4j
public class AccountCopyServiceImpl implements AccountCopyService {
    @Resource
    private AccountCopyDao accountCopyDao;

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public String transferTo(Long accountId, BigDecimal amount) {
        log.info("=====transferTo=========>{}", RootContext.getXID());
        SysAccountCopy accountCopy = new SysAccountCopy();
        accountCopy.setId(accountId);
        accountCopy.setAmount(amount);
        int res = accountCopyDao.updateAmount(accountCopy);
        if (amount.longValue() == 3) {
            throw new RuntimeException("入账失败测试");
        }
        return "入账成功更新 " + accountId + " 账户金额";
    }
}

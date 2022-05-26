package com.ddup.springcloud.service.impl;

import com.ddup.springcloud.dao.AccountDao;
import com.ddup.springcloud.entities.SysAccount;
import com.ddup.springcloud.entities.SysAccountCopy;
import com.ddup.springcloud.service.AccountCopyService;
import com.ddup.springcloud.service.SysAccountService;
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
public class SysAccountServiceImpl implements SysAccountService {
    @Resource
    private AccountDao accountDao;

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public String transferFrom(Long accountId, BigDecimal amount) {
        log.info("=======transferFrom=======>{}", RootContext.getXID());
        SysAccount accountCopy = new SysAccount();
        accountCopy.setId(accountId);
        accountCopy.setAmount(amount);
        int res = accountDao.updateAmount(accountCopy);
        if (amount.longValue() == 5) {
            throw new RuntimeException("出账失败测试");
        }
        return "出账成功更新 " + accountId + " 账户金额";
    }
}

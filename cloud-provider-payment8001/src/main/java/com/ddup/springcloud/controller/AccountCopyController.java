package com.ddup.springcloud.controller;

import com.ddup.springcloud.service.AccountCopyService;
import com.ddup.springcloud.service.SysAccountService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author: haowanjin
 * @Description TODO
 * @create: 2022/4/22 13:48
 */
@RestController()
@RequestMapping("/account")
public class AccountCopyController {
    @Resource
    private AccountCopyService accountCopyService;
    @Resource
    private SysAccountService accountService;

    @GetMapping("/transferFrom")
    public String transferFrom(@RequestParam("amount")BigDecimal amount) {
        return accountService.transferFrom(1L, amount);
    }

    @GetMapping("/transferTo")
    public String transferTo(@RequestParam("amount")BigDecimal amount) {
        return accountCopyService.transferTo(1L, amount);
    }
}

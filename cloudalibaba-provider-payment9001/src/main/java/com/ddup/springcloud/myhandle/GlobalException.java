package com.ddup.springcloud.myhandle;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.ddup.springcloud.entities.CommonResult;
import com.sun.xml.internal.ws.handler.HandlerException;

public class GlobalException {
    public static  CommonResult handlerException1(String p1,String p2,BlockException ex) {
        return new CommonResult<>(444, "用户自定义GlobalException handlerException-----1");
    }

    public static  CommonResult handlerException2(BlockException ex) {
        return new CommonResult<>(444, "用户自定义GlobalException handlerException----2");
    }
}

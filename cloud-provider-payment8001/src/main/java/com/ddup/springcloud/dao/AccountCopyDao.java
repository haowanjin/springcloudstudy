package com.ddup.springcloud.dao;

import com.ddup.springcloud.entities.SysAccountCopy;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AccountCopyDao {
    int updateAmount(SysAccountCopy accountCopy);
}

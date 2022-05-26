package com.ddup.springcloud.dao;

import com.ddup.springcloud.entities.SysAccount;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AccountDao {
    int updateAmount(SysAccount accountCopy);
}

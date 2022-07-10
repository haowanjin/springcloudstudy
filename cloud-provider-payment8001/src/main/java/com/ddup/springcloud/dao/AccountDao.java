package com.ddup.springcloud.dao;

import com.ddup.springcloud.entities.SysAccount;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AccountDao {
    int updateAmount(SysAccount accountCopy);

    @Select("select amount from sys_account where id=#{id}")
    int getAmount(long id);
}

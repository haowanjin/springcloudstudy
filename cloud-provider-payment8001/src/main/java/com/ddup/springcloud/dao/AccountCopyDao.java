package com.ddup.springcloud.dao;

import com.ddup.springcloud.entities.SysAccountCopy;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AccountCopyDao {
    int updateAmount(SysAccountCopy accountCopy);

    @Select("select amount from sys_account_copy where id=#{id}")
    int getAmount(long id);
}

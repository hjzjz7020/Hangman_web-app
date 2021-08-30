package com.dao;

import com.domain.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * AccountDao interface
 */
@Mapper
public interface AccountDao {

    // Find all accounts.
    @Select("select * from account")
    public List<Account> findAll();

    // save new account.
    @Insert("insert into account (player_name, password, management_status) values (#{player_name}, #{password}, #{management_status})")
    public void saveAccount(Account account);

}

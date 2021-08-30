package com.service.impl;

import com.dao.AccountDao;
import com.domain.Account;
import com.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    // Find all accounts.
    public List<Account> findAll() {
        System.out.println("Business layer: find all players.");
        return accountDao.findAll();
    }

    // Save account info.
    public void saveAccount(Account player) {
        System.out.println("Business layer: save player info.");
        accountDao.saveAccount(player);
    }
}

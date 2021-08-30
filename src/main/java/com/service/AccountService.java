package com.service;

import com.domain.Account;

import java.util.List;

public interface AccountService {

    // find all accounts.
    public List<Account> findAll();

    // save new account.
    public void saveAccount(Account account);
}

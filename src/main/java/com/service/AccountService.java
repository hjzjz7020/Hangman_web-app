package com.service;

import com.domain.Account;

import java.util.List;

public interface AccountService {

    // find all accounts.
    List<Account> findAll();

    // save new account.
    void insert(Account account);
}

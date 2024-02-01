package com.uningen.aop.dao;

import com.uningen.aop.Account;

import java.util.List;

public interface AccountDAO {
    List<Account> findAccounts();
    void addAccount(Account account);
    public String getName();

    public void setName(String name);

    public String getServiceCode();

    public void setServiceCode(String serviceCode);
}

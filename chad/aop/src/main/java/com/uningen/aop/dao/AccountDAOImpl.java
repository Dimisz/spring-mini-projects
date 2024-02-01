package com.uningen.aop.dao;

import com.uningen.aop.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDAOImpl implements AccountDAO{
    private String name;
    private String serviceCode;

    public String getName() {
        System.out.println("Executing getName() inside AccountDAOImpl");
        return name;
    }

    public void setName(String name) {
        System.out.println("Executing setName() inside AccountDAOImpl");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println("Executing getServiceCode() inside AccountDAOImpl");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println("Executing setServiceCode() inside AccountDAOImpl");
        this.serviceCode = serviceCode;
    }

    @Override
    public List<Account> findAccounts() {
        List<Account> accounts = new ArrayList<>();
        accounts.addAll(List.of(
                new Account("first account", "silver"),
                new Account("second account", "gold"),
                new Account("third account", "platinum")
        ));
        return accounts;
    }

    @Override
    public void addAccount(Account account) {
        System.out.println(getClass() + " ===== Adding account from AccountDAO ====");
    }
}

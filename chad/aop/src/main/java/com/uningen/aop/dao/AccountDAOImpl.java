package com.uningen.aop.dao;

import com.uningen.aop.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO{
    @Override
    public void addAccount(Account account) {
        System.out.println(getClass() + " ===== Adding account from AccountDAO ====");
    }
}

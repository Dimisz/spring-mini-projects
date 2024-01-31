package com.uningen.aop.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements MembershipDAO{
    @Override
    public void addAccount() {
        System.out.println(getClass() + "===== Adding account from MembershipDAO ====");
    }

    @Override
    public boolean addFunds() {
        System.out.println(getClass() + "===== Adding FUNDS from MembershipDAO ====");
        return true;
    }
}

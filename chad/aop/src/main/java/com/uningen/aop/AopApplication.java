package com.uningen.aop;

import com.uningen.aop.dao.AccountDAO;
import com.uningen.aop.dao.MembershipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AopApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO accountDAO, MembershipDAO membershipDAO){
		return runner -> {
//			demoBeforeAdviceOnAccount(accountDAO);
//			demoBeforeAdviceOnMembership(membershipDAO);
			demoAfterReturningAdvice(accountDAO);
		};
	}

	public void demoAfterReturningAdvice(AccountDAO accountDAO){
		List<Account> accounts = accountDAO.findAccounts();
		// display the accounts
		System.out.println("\n\nMain Program: demoAfterReturningAdvice");
		System.out.println("==============");
		System.out.println(accounts);
		System.out.println("\n");
	}

	public void demoBeforeAdviceOnAccount(AccountDAO accountDAO){
		Account account = new Account();
		accountDAO.addAccount(account);
		accountDAO.setName("foobar");
		accountDAO.getName();
		accountDAO.setServiceCode("foobar");
		accountDAO.getServiceCode();

	}

	public void demoBeforeAdviceOnMembership(MembershipDAO membershipDAO){
		membershipDAO.addAccount();
		membershipDAO.addFunds();
	}

}

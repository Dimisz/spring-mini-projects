package com.uningen.aop;

import com.uningen.aop.dao.AccountDAO;
import com.uningen.aop.dao.MembershipDAO;
import com.uningen.aop.service.TrafficFortuneService;
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
	public CommandLineRunner commandLineRunner(AccountDAO accountDAO,
											   MembershipDAO membershipDAO,
											   TrafficFortuneService trafficFortuneService){
		return runner -> {
//			demoBeforeAdviceOnAccount(accountDAO);
//			demoBeforeAdviceOnMembership(membershipDAO);
//			demoAfterReturningAdvice(accountDAO);
//			demoAfterThrowingAdvice(accountDAO);
//			demoAfterAdvice(accountDAO);

//			demoAroundAdvice(trafficFortuneService);
			demoAroundAdviceHandleExeption(trafficFortuneService);
		};
	}

	private void demoAroundAdviceHandleExeption(TrafficFortuneService trafficFortuneService) {
		System.out.println("\n===========================");
		System.out.println("Running demoAroundAdvice from Main App");
		System.out.println("Calling getFortune()....");
		System.out.println("Throwing exeption...");

		String fortune = trafficFortuneService.getFortune(true);
		System.out.println("\nMy fortune is: " + fortune);
		System.out.println("Done with demoAroundAdvice");
	}

	private void demoAroundAdvice(TrafficFortuneService trafficFortuneService) {
		System.out.println("\n===========================");
		System.out.println("Running demoAroundAdvice from Main App");
		System.out.println("Calling getFortune()....");
		String fortune = trafficFortuneService.getFortune();
		System.out.println("\nMy fortune is: " + fortune);
		System.out.println("Done with demoAroundAdvice");
	}

	private void demoAfterAdvice(AccountDAO accountDAO) {
		List<Account> accounts = null;
		try {
			// add a boolean to simulate an exeption
			boolean throwExeption = false;
			accounts = accountDAO.findAccounts(throwExeption);
		}
		catch (Exception ex){
			System.out.println("\n\nMain Program: CAUGHT EXEPTION: " + ex);
		}

		// display the accounts
		System.out.println("\n\nMain Program: demoAfterThrowingAdvice");
		System.out.println("==============");
		System.out.println(accounts);
		System.out.println("\n");
	}

	private void demoAfterThrowingAdvice(AccountDAO accountDAO) {
		List<Account> accounts = null;
		try {
			// add a boolean to simulate an exeption
			boolean throwExeption = true;
			accounts = accountDAO.findAccounts(throwExeption);
		}
		catch (Exception ex){
			System.out.println("\n\nMain Program: CAUGHT EXEPTION: " + ex);
		}

		// display the accounts
		System.out.println("\n\nMain Program: demoAfterThrowingAdvice");
		System.out.println("==============");
		System.out.println(accounts);
		System.out.println("\n");
	}

	public void demoAfterReturningAdvice(AccountDAO accountDAO){
		List<Account> accounts = accountDAO.findAccounts(false);
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

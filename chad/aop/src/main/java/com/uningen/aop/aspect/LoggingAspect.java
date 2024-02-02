package com.uningen.aop.aspect;

import com.uningen.aop.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Order(2)
@Component
public class LoggingAspect {
    @Pointcut("execution(* com.uningen.aop.dao.*.*(..))")
    private void forDaoPackage(){}



//    @Before(("execution(public void com.uningen.aop.dao.MembershipDAO.addAccount())"))
//    @Before("execution(public void add*())")
//    @Before("execution(* add*(com.uningen.aop.Account))")
//    @Before("forDaoPackage()")
//    @Before("forGettersAndSetters()")
//    public void beforeAddAccountAdvice(){
//        System.out.println("\n========>>> Executing @Before advice on addAccount()");
//    }
    @After("execution(* com.uningen.aop.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountAdvice(JoinPoint joinPoint){
        // print out which method we are advicing on
        System.out.println("ADVICING ON METHOD: " + joinPoint.getSignature().toShortString());
        System.out.println("Executing @After (finally) advice");
    }
    @AfterThrowing(
            pointcut = "execution(* com.uningen.aop.dao.AccountDAO.findAccounts(..))",
            throwing = "ex"
    )
    public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable ex){
        // print out which method we are advicing on
        System.out.println("ADVICING ON METHOD: " + joinPoint.getSignature().toShortString());
        System.out.println("Executing after throwing");
        // log out the exeption
        System.out.println("==============================");
        System.out.println("The exeption is: " + ex);
    }
    @AfterReturning(
            pointcut = "execution(* com.uningen.aop.dao.AccountDAO.findAccounts(..))",
            returning = "result"
    )
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result){
        // prit out which methods we advising on
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n============ Executing afterReturning on method: " + method);
        // print out results
        System.out.println("\n============ Result is: " + result);

        // post process the data...

        // uppercase account names
        convertAccountNamesToUpperCase(result);
        System.out.println("\n============ Result is: " + result);
    }

    private void convertAccountNamesToUpperCase(List<Account> result) {
        for(Account account: result){
            String accountName = account.getName();
            account.setName(accountName.toUpperCase());
        }
    }

    @Before("forDaoPackage()")
    public void performApiAnalytics(){
        System.out.println("\n======= PERFORMING ANALYTICS =======\n");
    }
}

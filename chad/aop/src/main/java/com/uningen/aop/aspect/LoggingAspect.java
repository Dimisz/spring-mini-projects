package com.uningen.aop.aspect;

import com.uningen.aop.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
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
    }

    @Before("forDaoPackage()")
    public void performApiAnalytics(){
        System.out.println("\n======= PERFORMING ANALYTICS =======\n");
    }
}

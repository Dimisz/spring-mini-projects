package com.uningen.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    @Pointcut("execution(* com.uningen.aop.dao.*.*(..))")
    private void forDaoPackage(){}

//    @Before(("execution(public void com.uningen.aop.dao.MembershipDAO.addAccount())"))
//    @Before("execution(public void add*())")
//    @Before("execution(* add*(com.uningen.aop.Account))")
    @Before("forDaoPackage()")
    public void beforeAddAccountAdvice(){
        System.out.println("\n========>>> Executing @Before advice on addAccount()");
    }
}

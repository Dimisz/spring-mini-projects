package com.uningen.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(11)
@Component
public class GettersSettersAspect {

    //include getters
    @Pointcut("execution(* com.uningen.aop.dao.*.get*(..))")
    private void forDaoGetters(){}

    //include setters
    @Pointcut("execution(* com.uningen.aop.dao.*.set*(..))")
    private void forDaoSetters(){}

    @Pointcut("forDaoGetters() || forDaoSetters()")
    private void forGettersAndSetters(){}

    @Before("forGettersAndSetters()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint){
        System.out.println("\n======== GETTERS AND SETTERS ADVICE ====== \n");
        // display the method signature
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("Method signature: " + methodSignature);
        // display the method args
        Object[] args = joinPoint.getArgs();
        for(Object arg: args){
            System.out.println(arg);
        }
    }
}

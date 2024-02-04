package com.uningen.aop.aspect;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TrafficFortuneAspect {
    @Around("execution(* com.uningen.aop.service.*.*(..))")
    public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        System.out.println("\n================================");
        System.out.println("INSIDE AROUND ADVICE");
        // print out the method we are advicing on
        System.out.println("Advising on: " + proceedingJoinPoint.getSignature().toShortString());
        // get begin timestamp
        long begin = System.currentTimeMillis();
        // get the result
        Object result = null;
        try {
            result = proceedingJoinPoint.proceed();
        }
        catch(Exception ex){
            System.out.println("@Around advice ENCOUNTERED EXEPTION: " + ex);
            result = "Nothing exiting here. Move along";

            // or rethrow
//            throw ex;
        }

        // get end timestamp
        long end = System.currentTimeMillis();
        // display duration
        long duration = end - begin;

        System.out.println("COMPLETED THE AROUND ADVICE. Took " + duration + "ms.");
        return result;
    }
}

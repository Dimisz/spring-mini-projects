package com.uningen.aspects.aspects;

import com.uningen.aspects.domain.Comment;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.logging.Logger;

@Aspect
@Component
public class LoggingAspect {
    private Logger logger = Logger.getLogger(LoggingAspect.class.getName());

//    @Around("execution(* com.uningen.aspects.service.*.*(..))")
//    public void log(ProceedingJoinPoint joinPoint) throws Throwable {
//        logger.info("Method will execute");
//        joinPoint.proceed();
//        logger.info("Method executed");
//    }
    @Around("execution(* com.uningen.aspects.service.*.*(..))")
//    @Around("@annotation(ToLog)")
    public Object log(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String methodName =
                proceedingJoinPoint.getSignature().getName();
        Object [] arguments =
                proceedingJoinPoint.getArgs();
        logger.info("Method: " + methodName +
                " with parameters " + Arrays.asList(arguments) +
                " will execute");
        Comment comment = new Comment();
        comment.setAuthor("Mike");
        comment.setText("Altered by aspect");
        Object [] newArguments = {comment};

        Object returnedByMethod =
                proceedingJoinPoint.proceed(newArguments);
//        Object returnedByMethod = proceedingJoinPoint.proceed();

        logger.info("Method executed and returned " +
                returnedByMethod);
        return "FAILED";
    }
}

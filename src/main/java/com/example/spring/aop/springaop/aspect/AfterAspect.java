package com.example.spring.aop.springaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class AfterAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    //Advice is run after method returns
    @AfterReturning(
            value = "execution(* com.example.spring.aop.springaop.business.*.*(..))",
            returning = "result" // this puts the result of execution in the "result" variable
    )
    public void afterReturning(JoinPoint joinPoint, Object result) {
        logger.info("{} returned with value {}", joinPoint, result);
    }

    //Advice is run after method throws an error
    @AfterThrowing(
            value = "execution(* com.example.spring.aop.springaop.business.*.*(..))",
            throwing = "exception" // this puts the result of execution in the "result" variable
    )
    public void afterThrowing(JoinPoint joinPoint, Object exception) {
        logger.info("{} returned with value {}", joinPoint, exception);
    }

    //Advice is run after method returns or throws
    @After(value = "execution(* com.example.spring.aop.springaop.business.*.*(..))")
    public void after(JoinPoint joinPoint) {
        logger.info("{} returned with value or threw exception", joinPoint);
    }
}

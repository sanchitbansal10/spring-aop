package com.example.spring.aop.springaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class AroundAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Around(value = "com.example.spring.aop.springaop.aspect.CommonJoinPointConfig.businessLayerExecution()")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        joinPoint. proceed();
        long timeTaken = System.currentTimeMillis() - startTime;
        logger.info("time taken by {} is {}", joinPoint, timeTaken);
    }
}

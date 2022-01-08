package com.example.spring.aop.springaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class BeforeAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    // What kind of method calls I want to intercept
    //execution(ReturnType PACKAGE.CLASS.METHODS(ARGUMENT) )
    @Before("com.example.spring.aop.springaop.aspect.CommonJoinPointConfig.dataLayerExecution()")
    public void before(JoinPoint joinPoint) {
        // What to do
        logger.info("Intercepted Application - {}", joinPoint);
    }
}

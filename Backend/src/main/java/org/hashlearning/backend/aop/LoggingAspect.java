package org.hashlearning.backend.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(* org.hashlearning.backend.service.*.*(..))")
    public void logInfo(JoinPoint point) {
        LOGGER.info("Method called "+ point.getSignature().getName());
    }

    @After("execution(* org.hashlearning.backend.service.*.*(..))")
    public void logInfoAfterMethodExecuted(JoinPoint point) {
        LOGGER.info("Method executed "+ point.getSignature().getName());
    }

    @AfterThrowing("execution(* org.hashlearning.backend.service.*.*(..))")
    public void logInfoAfterMethodWithError(JoinPoint point) {
        LOGGER.error("Method error "+ point.getSignature().getName());
    }
    @AfterReturning("execution(* org.hashlearning.backend.service.*.*(..))")
    public void logInfoAfterMethodSuccess(JoinPoint point) {
        LOGGER.info("Method executed successfully "+ point.getSignature().getName());
    }
}


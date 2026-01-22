package org.hashlearning.backend.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerformanceMonitorAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(PerformanceMonitorAspect.class);

    @Around("execution(* org.hashlearning.backend.service.*.*(..))")
    public Object monitorTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object object= joinPoint.proceed();
        long endTime = System.currentTimeMillis();
        LOGGER.info("Method executed by method "+ joinPoint.getSignature().getName()+" in " +(endTime - startTime));
        return object;
    }
}

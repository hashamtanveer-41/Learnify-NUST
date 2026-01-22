package org.hashlearning.backend.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ValidationAspect {

      private static final Logger LOGGER = LoggerFactory.getLogger(ValidationAspect.class);
    @Around("execution(* org.hashlearning.backend.service.*.*(..)) && args(postId)")
      public Object validateAndUpdate(ProceedingJoinPoint joinPoint, int postId) throws Throwable {
        if (postId<0){
            LOGGER.info("Changing the negative value"+ postId);
            postId = -postId;
            LOGGER.info("The new value is: "+ postId);
        }
        Object o = joinPoint.proceed(new Object[]{postId});
        return o;
      }
}

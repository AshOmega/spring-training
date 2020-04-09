package com.learning.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectImpl {

    Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    /**
     * Executed before any controller method is called in package com.learning.controllers.*
     * @param joinPoint
     */
    @Before("execution(* com.learning.controllers..*.*(..))")
    public void adviceBeforeController(JoinPoint joinPoint) {
        System.out.println("Calling before advice for " + joinPoint.getSignature().toShortString() + " controller");
    }


    /**
     * Executed after any controller method is called in package com.learning.controllers.*
     * @param joinPoint
     */
    @After("execution(* com.learning.controllers..*.*(..))")
    public void adviceAfterController(JoinPoint joinPoint) {
        System.out.println("Calling after advice for " + joinPoint.getSignature().toShortString() + " controller");
    }


    /**
     * Executed before any bean method is called in package com.learning.beans.*
     * @param joinPoint
     */
    @Before("execution(* com.learning.beans..*.*(..))")
    public void adviceBeforeBeans(JoinPoint joinPoint) {
        System.out.println("Calling before advice for " + joinPoint.getSignature().toShortString() + " bean");
    }


    /**
     * Executed after any bean method is called in package com.learning.beans.*
     * @param joinPoint
     */
    @After("execution(* com.learning.beans..*.*(..))")
    public void adviceAfterBeans(JoinPoint joinPoint) {
        System.out.println("Calling after advice for " + joinPoint.getSignature().toShortString() + " bean");
    }


    /**
     * Executed before any method is called in package com.learning.* Useful for purposes like centralized logging
     * @param joinPoint
     */
    @Before("execution(* com.learning..*.*(..))")
    public void adviceBeforeMethod(JoinPoint joinPoint) {
        logger.info("Entering " + joinPoint.getSignature().toShortString() + " method");
    }


    /**
     * Executed after any method is called in package com.learning.* Useful for purposes like centralized logging
     * @param joinPoint
     */
    @After("execution(* com.learning..*.*(..))")
    public void adviceAfterMethod(JoinPoint joinPoint) {
        logger.info("Exiting " + joinPoint.getSignature().toShortString() + " method");
    }
}

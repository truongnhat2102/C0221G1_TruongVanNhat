package com.library.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class BookAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @AfterThrowing(value = "execution(* com.library.controller.LibraryController.*(..))", throwing = "e")
    public void log(JoinPoint joinPoint, Exception e){
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        System.out.println(String.format("have error: %s.%s%s: %s", className, method, args, e.getMessage()));
    }
}

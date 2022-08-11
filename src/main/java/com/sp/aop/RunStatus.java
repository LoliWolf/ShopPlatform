package com.sp.aop;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class RunStatus {

    @Pointcut("execution(* com.sp.service.*Service.*(..))")
    public void status(){}


    @Before("status()")
    public void getStatus(JoinPoint joinPoint){
        log.info(joinPoint.getSignature().getDeclaringType().getName() +  "." +joinPoint.getSignature().getName() +"()");
        String[] keys = ((MethodSignature) joinPoint.getSignature()).getParameterNames();
        Object[] args = joinPoint.getArgs();
        int i=0;
        for (String key:keys){
            if("headers".equals(key)){
                continue;
            }
            log.info(key + " : " + args[i++]);
        }
    }

}

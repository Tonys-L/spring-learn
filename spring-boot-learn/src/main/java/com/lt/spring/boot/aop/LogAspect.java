package com.lt.spring.boot.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author ：Tony.L
 * @version ：2019 Version：1.0
 * @create ：2019/12/13 13:47
 */
@Aspect
@Component
@Slf4j
public class LogAspect {
    @Pointcut("execution(public * com.lt.spring.boot.service.TestService.*(..))")
    public void pointCut() {

    }


    @Before("execution(public * com.lt.spring.boot.service.TestService.*(..))")
    public void log() {
        log.debug("-----------========begin=======----------------");
    }

    @After("pointCut()")
    public void end() {
        log.debug("-----------========end=======----------------");
    }
}

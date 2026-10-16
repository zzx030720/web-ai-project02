package com.zzx.Aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Aspect
public class MyAspect6 {
    //针对list方法、delete方法进行前置通知和后置通知

    //前置通知
//    @Before("@annotation(com.zzx.anno.LogOperation)")
    public void before(){
        log.info("MyAspect6 -> before ...");
    }

    //后置通知
//    @After("@annotation(com.zzx.anno.LogOperation)")
    public void after(){
        log.info("MyAspect6 -> after ...");
    }
}
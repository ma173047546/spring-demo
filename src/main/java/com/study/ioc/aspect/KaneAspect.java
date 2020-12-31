package com.study.ioc.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class KaneAspect {
    //可以理解为，这就是切面

    @Pointcut("execution(* com.study.ioc.service.*.*(..))")
    public void kaneTransfer(){}

    @Before("kaneTransfer()")
    public void test01(){
        System.out.println("before");
    }

}

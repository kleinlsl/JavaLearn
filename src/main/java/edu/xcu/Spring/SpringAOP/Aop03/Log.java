package edu.xcu.Spring.SpringAOP.Aop03;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * @project: JavaLearn
 * @description:
 * @author: dell
 * @date: 2020/9/8 - 15:36
 */
// 添加注解
@Aspect
public class Log {
    @Before("execution(* edu.xcu.Spring.SpringAOP.Aop03.service.impl.*.*(..))")
    public void before(){
        System.out.println("------前------");
    }
    @After("execution(* edu.xcu.Spring.SpringAOP.Aop03.service.impl.*.*(..))")
    public void after(){
        System.out.println("-----后-----");
    }
    @Around("execution(* edu.xcu.Spring.SpringAOP.Aop03.service.impl.*.*(..))")
    public Object aroud(ProceedingJoinPoint jp) throws Throwable {
        System.out.println("环绕前");
        System.out.println("签名："+jp.getSignature());
        // 执行目标方法
        Object o=jp.proceed();

        System.out.println("环绕后");
        return o;
    }
}

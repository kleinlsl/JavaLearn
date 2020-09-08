package edu.xcu.Spring.SpringAOP.Aop01.Log;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @project: JavaLearn
 * @description: 日志切面
 * @author: dell
 * @date: 2020/9/7 - 10:42
 */
public class Log implements MethodBeforeAdvice {

    /**
     * 前置通知
     * @param method 被调用的方法对象  ：  执行的目标方法对象，切入点
     * @param objects 被调用的方法的参数列表
     * @param o 被调用的方法的目标对象  ：  切面
     * @throws Throwable
     */
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println(o.getClass().getName()+"的"+method.getName()+"方法被执行");
    }
}

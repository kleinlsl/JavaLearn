package edu.xcu.Spring.SpringAOP.Aop02;

/**
 * @project: JavaLearn
 * @description:
 * @author: dell
 * @date: 2020/9/8 - 15:36
 */
public class Log {
    public void before(){
        System.out.println("------前------");
    }
    public void after(){
        System.out.println("-----后-----");
    }
}

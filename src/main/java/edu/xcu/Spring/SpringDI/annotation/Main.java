package edu.xcu.Spring.SpringDI.annotation;

import edu.xcu.Spring.SpringDI.annotation.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @project: JavaThread
 * @description:
 * @author: dell
 * @date: 2020/8/7 - 14:59
 * @version: 1.0
 * @website:
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext ac=new ClassPathXmlApplicationContext("classpath:Spring/SpringDI/beanContext.xml");
        AccountService accountService = (AccountService) ac.getBean("accountService");
        AccountService accountService1 = (AccountService) ac.getBean("accountService");
        System.out.println(accountService==accountService1);
        System.out.println(accountService);
        accountService.saveAccount();
    }
}

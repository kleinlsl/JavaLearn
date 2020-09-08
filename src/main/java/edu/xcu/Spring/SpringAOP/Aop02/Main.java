package edu.xcu.Spring.SpringAOP.Aop02;

import edu.xcu.Spring.SpringAOP.Aop02.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @project: JavaLearn
 * @description:
 * @author: dell
 * @date: 2020/9/7 - 16:57
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext ac=new ClassPathXmlApplicationContext("classpath:Spring/SpringAOP/Aop02/bean.xml");
        UserService userService= (UserService) ac.getBean("userService");
        userService.add();
        userService.delete();
    }
}

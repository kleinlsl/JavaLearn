package edu.xcu.Spring.SpringIOC;

import edu.xcu.Spring.SpringIOC.service.MessageService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: dell
 * @date: 2020/8/2 - 10:19
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:Spring/SpringIOC/SpringIOC.xml");

        System.out.println("contxt 启动成功！！");

        MessageService messageService= (MessageService) context.getBean("messageService");
        System.out.println(messageService.getMessage());
    }
}

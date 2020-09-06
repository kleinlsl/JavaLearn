package edu.xcu.Spring.SpringBean;

import edu.xcu.Spring.ObjectBean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: dell
 * @date: 2020/8/6 - 18:56
 */
public class APP {
    public static void main(String[] args) {
        String[] beanName = {"objectBean1","objectBean2","objectBean3","objectBean4","objectBean5","objectBean6"};
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("classpath:Spring/SpringBean/bean.xml");
        System.out.println(ac.getApplicationName());

        for (String name:beanName) {
            ObjectBean objectBean= (ObjectBean) ac.getBean(name);
            System.out.println(objectBean);
        }
        ac.close();
//        ObjectBean objectBean= (ObjectBean) ac.getBean("objectBean1");
//        System.out.println(objectBean);
//        objectBean= (ObjectBean) ac.getBean("objectBean2");
//        System.out.println(objectBean);
//        objectBean= (ObjectBean) ac.getBean("objectBean3");
//        System.out.println(objectBean);
    }
}

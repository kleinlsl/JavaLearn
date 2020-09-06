package edu.xcu.Spring.SpringDI;

import edu.xcu.Spring.ObjectBean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: dell
 * @date: 2020/8/6 - 18:56
 */
public class APP {
    public static void main(String[] args) {
        String[] beanName = {"objectBean1","objectBean2","objectBean3","objectBean4","objectBean5","objectBean6"};
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("classpath:Spring/SpringDI/bean.xml");
        System.out.println(ac.getApplicationName());

        for (String name:beanName) {
            if (ac.containsBean(name)){
                ObjectBean objectBean= (ObjectBean) ac.getBean(name);
                System.out.println(objectBean);
            }
        }
        ac.close();
    }
}

package edu.xcu.Enum;


import org.junit.Test;

/**
 * @project: JavaThread
 * @description:
 * @author: dell
 * @date: 2020/7/12 - 16:08
 * @version: 1.0
 * @website:
 */
public class PizzaStatusTest {
    @Test
    public void test(){
        /**
         * @description: .name()方法获取到枚举字段的字符串值
         * @param: []
         * @date: 2020/7/12 - 16:12
         * @return: void
         */
        System.out.println(PizzaStatus.ORDERED.name());
        System.out.println(PizzaStatus.ORDERED);
        System.out.println(PizzaStatus.ORDERED.name().getClass());
        System.out.println(PizzaStatus.ORDERED.getClass());
    }
}
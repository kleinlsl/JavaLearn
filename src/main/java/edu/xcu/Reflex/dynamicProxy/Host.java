package edu.xcu.Reflex.dynamicProxy;

/**
 * @project: JavaThread
 * @description:
 * @author: dell
 * @date: 2020/9/6 - 10:11
 */
public class Host implements Rent {
    @Override
    public void rent() {
        System.out.println("房屋出租");
    }
}

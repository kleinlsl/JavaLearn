package edu.xcu.designPattern.Structural.Adapter.ObjectAdapter;

/**
 * @project: JavaThread
 * @author: dell
 * @date: 2020/8/1 - 10:39
 */
public class WildCock implements Cock {
    @Override
    public void gobble() {
        System.out.println("咕咕叫");
    }

    @Override
    public void fly() {
        System.out.println("鸡也会飞哦");
    }
}

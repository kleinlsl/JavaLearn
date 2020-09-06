package edu.xcu.designPattern.Structural.Adapter.ObjectAdapter;

/**
 * @project: JavaThread
 * @description:
 * @author: dell
 * @date: 2020/8/1 - 10:46
 * @version: 1.0
 * @website:
 */
public class APP {
    public static void main(String[] args) {
        // 有一只野鸡
        Cock wildCock = new WildCock();
        Duck duck = new CockAdapter(wildCock);
        duck.quack();
        duck.fly();
    }
}

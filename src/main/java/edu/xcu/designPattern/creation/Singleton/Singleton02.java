package edu.xcu.designPattern.creation.Singleton;

/**
 * 饱汉模式 : 调用实例方法才会创建对象
 * @author: dell
 * @date: 2020/7/31 - 10:55
 */
public class Singleton02 {
    // 首先，也是先堵死 new Singleton() 这条路
    private Singleton02() {}
    // 和饿汉模式相比，这边不需要先实例化出来，注意这里的 volatile，它是必须的
    private static volatile Singleton02 instance = null;

    public static Singleton02 getInstance() {
        if (instance == null) {
            // 加锁
            synchronized (Singleton02.class) {
                // 这一次判断也是必须的，不然会有并发问题
                if (instance == null) {
                    instance = new Singleton02();
                }
            }
        }
        return instance;
    }
}

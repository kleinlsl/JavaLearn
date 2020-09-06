package edu.xcu.designPattern.creation.Singleton;

/**
 * @project: JavaThread
 * @description:
 * @author: dell
 * @date: 2020/7/31 - 10:57
 * @version: 1.0
 * @website:
 */
public class Singleton03 {
    private Singleton03(){  }
    // 主要是使用了 嵌套类可以访问外部类的静态属性和静态方法 的特性
    private static class Holder{
        private static Singleton03 instance = new Singleton03();
    }

    public static Singleton03 getInstance(){
        return Holder.instance;
    }
}

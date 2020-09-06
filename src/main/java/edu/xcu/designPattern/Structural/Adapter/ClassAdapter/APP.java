package edu.xcu.designPattern.Structural.Adapter.ClassAdapter;

/**
 * @project: JavaThread
 * @description:
 * @author: dell
 * @date: 2020/8/1 - 10:53
 * @version: 1.0
 * @website:
 */
public class APP {
    public static void main(String[] args) {
        Target t=new ClassAdapter();
        t.method2();
    }
}

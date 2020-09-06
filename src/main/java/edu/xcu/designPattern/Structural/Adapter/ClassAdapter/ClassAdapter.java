package edu.xcu.designPattern.Structural.Adapter.ClassAdapter;

/**
 * @author: dell
 * @date: 2020/8/1 - 10:48
 */
public class ClassAdapter extends SomeThing implements Target{
    @Override
    public void method1() {

    }

    @Override
    public void method2() {
        super.method2();
    }

    @Override
    public void method3() {
        super.method3();
    }

}

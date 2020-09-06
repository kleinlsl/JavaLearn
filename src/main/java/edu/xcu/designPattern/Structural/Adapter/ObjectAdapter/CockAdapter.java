package edu.xcu.designPattern.Structural.Adapter.ObjectAdapter;

/**
 * 鸡的适配器 ： 把几适配成鸭来用
 * @author: dell
 * @date: 2020/8/1 - 10:41
 */
public class CockAdapter implements Duck{
    private Cock cock;

    /**
     * 构造方法中需要一个鸡的实例，此类就是将这只鸡适配成鸭来用
     */
    public CockAdapter(Cock cock){
        this.cock=cock;
    }

    /**
     * 实现鸭的呱呱叫
     */
    @Override
    public void quack() {
        // 内部其实是一只鸡的咕咕叫
        cock.gobble();
    }

    @Override
    public void fly() {
        cock.fly();
    }
}

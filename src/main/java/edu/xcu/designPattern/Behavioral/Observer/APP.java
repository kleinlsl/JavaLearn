package edu.xcu.designPattern.Behavioral.Observer;

/**
 *
 * @author: dell
 * @date: 2020/8/1 - 15:56
 */
public class APP {

    public static void main(String[] args) {
        // 先定义一个主题
        Subject subject1 = new Subject();
        // 定义观察者
        new BinaryObserver(subject1);
        new HexaObserver(subject1);

        // 模拟数据变更，这个时候，观察者们的 update 方法将会被调用
        subject1.setState(11);
    }
}

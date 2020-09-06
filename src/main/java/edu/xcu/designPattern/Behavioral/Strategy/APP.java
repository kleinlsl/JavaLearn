package edu.xcu.designPattern.Behavioral.Strategy;

/**
 * @author: dell
 * @date: 2020/8/1 - 13:12
 */
public class APP {
    public static void main(String[] args) {
        Context context = new Context(new BluePen());
        context.executeDraw(10,0,0);
    }
}

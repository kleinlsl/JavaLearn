package edu.xcu.designPattern.Structural.Decorative;

/**
 * @project: JavaThread
 * @description:
 * @author: dell
 * @date: 2020/8/1 - 11:23
 * @version: 1.0
 * @website:
 */
public class BlackTea extends Beverage {
    /**
     * 返回描述
     */
    @Override
    public String getDescription() {
        return "红茶";
    }

    /**
     * 返回价格
     *
     * @return 价格
     */
    @Override
    public double cost() {
        return 10;
    }
}

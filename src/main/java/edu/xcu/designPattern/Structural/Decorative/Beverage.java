package edu.xcu.designPattern.Structural.Decorative;

/**
 * 饮料的抽象基类
 * @author: dell
 * @date: 2020/8/1 - 11:21
 */
public abstract class Beverage {
    /**
     * 返回描述
     */
    public abstract String getDescription();

    /**
     * 返回价格
     * @return 价格
     */
    public abstract double cost();
}

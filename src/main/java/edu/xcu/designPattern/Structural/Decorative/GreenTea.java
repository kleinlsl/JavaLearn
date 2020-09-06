package edu.xcu.designPattern.Structural.Decorative;

/**
 * @author: dell
 * @date: 2020/8/1 - 11:24
 */
public class GreenTea extends  Beverage{
    /**
     * 返回描述
     */
    @Override
    public String getDescription() {
        return "绿茶";
    }

    /**
     * 返回价格
     *
     * @return 价格
     */
    @Override
    public double cost() {
        return 11;
    }

}

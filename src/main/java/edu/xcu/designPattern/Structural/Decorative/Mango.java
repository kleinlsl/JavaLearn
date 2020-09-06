package edu.xcu.designPattern.Structural.Decorative;

/**
 * @project: JavaThread
 * @description:
 * @author: dell
 * @date: 2020/8/1 - 11:35
 * @version: 1.0
 * @website:
 */
public class Mango extends Condiment {
    private Beverage bevarage;

    public Mango(Beverage bevarage) {
        this.bevarage = bevarage;
    }

    /**
     * 返回描述
     */
    @Override
    public String getDescription() {
        return bevarage.getDescription() + ", 加芒果";
    }

    /**
     * 返回价格
     *
     * @return 价格
     */
    @Override
    public double cost() {
        return bevarage.cost() + 3; // 加芒果需要 3 元
    }
}

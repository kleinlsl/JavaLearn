package edu.xcu.designPattern.Structural.Decorative;

/**
 *
 *
 * @author: dell
 * @date: 2020/8/1 - 11:33
 */
public class Lemon extends Condiment{
    private Beverage bevarage;

    /**
     * 这里很关键，需要传入具体的饮料，如需要传入没有被装饰的红茶或绿茶，
     * 当然也可以传入已经装饰好的芒果绿茶，这样可以做芒果柠檬绿茶
     *
     * @param bevarage
     */

    public Lemon(Beverage bevarage) {
        this.bevarage = bevarage;
    }

    /**
     * 返回描述
     */
    @Override
    public String getDescription() {
        // 装饰
        return bevarage.getDescription() + ", 加柠檬";
    }

    /**
     * 返回价格
     *
     * @return 价格
     */
    @Override
    public double cost() {
        // 装饰
        return bevarage.cost() + 2; // 加柠檬需要 2 元
    }
}

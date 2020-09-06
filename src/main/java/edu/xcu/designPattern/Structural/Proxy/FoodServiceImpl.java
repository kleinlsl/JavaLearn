package edu.xcu.designPattern.Structural.Proxy;

import edu.xcu.designPattern.Structural.Proxy.Bean.Chicken;
import edu.xcu.designPattern.Structural.Proxy.Bean.Food;
import edu.xcu.designPattern.Structural.Proxy.Bean.Noodle;

/**
 * @project: JavaThread
 * @description:
 * @author: dell
 * @date: 2020/7/31 - 12:07
 * @version: 1.0
 * @website:
 */
public class FoodServiceImpl implements FoodService {
    @Override
    public Food makeChicken() {
        Food f = new Chicken();
        f.setSpicy("Chicken");
        return f;
    }

    @Override
    public Food makeNoodle() {
        Food f = new Noodle();
        f.setSpicy("Noodle");
        return f;
    }
}

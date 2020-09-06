package edu.xcu.designPattern.Structural.Proxy;

import edu.xcu.designPattern.Structural.Proxy.Bean.Food;

/**
 * @author: dell
 * @date: 2020/7/31 - 12:02
 */
public interface FoodService {
    Food makeChicken();
    Food makeNoodle();
}

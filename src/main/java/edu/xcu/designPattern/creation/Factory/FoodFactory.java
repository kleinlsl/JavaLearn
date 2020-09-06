package edu.xcu.designPattern.creation.Factory;

import edu.xcu.designPattern.creation.Food;

//@FunctionalInterface
public interface FoodFactory {
    /**
     * 根据名字制作食物
     * @param name
     * @return
     */
    Food makeFood(String name);
}

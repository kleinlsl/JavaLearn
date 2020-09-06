package edu.xcu.designPattern.creation.Factory;

import edu.xcu.designPattern.creation.Food;

/**
 * @project: JavaThread
 * @description:
 * @author: dell
 * @date: 2020/7/31 - 10:07
 */
public class ChineseFoodFactory implements FoodFactory{

    @Override
    public Food makeFood(String name) {
        if (name.equals("A")) {
            return new ChineseFoodA();
        } else if (name.equals("B")) {
            return new ChineseFoodB();
        } else {
            return null;
        }
    }
}

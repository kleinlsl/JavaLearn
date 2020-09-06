package edu.xcu.designPattern.creation.Factory;

import edu.xcu.designPattern.creation.Food;

/**
 * @project: JavaThread
 * @description:
 * @author: dell
 * @date: 2020/7/31 - 10:11
 * @version: 1.0
 * @website:
 */
public class App {
    public static void main(String[] args) {
        FoodFactory factory = new ChineseFoodFactory();
        Food food = factory.makeFood("A");
        System.out.println(food.toString());
    }
}

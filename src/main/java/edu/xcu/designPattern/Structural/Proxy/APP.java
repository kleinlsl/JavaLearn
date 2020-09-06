package edu.xcu.designPattern.Structural.Proxy;

import edu.xcu.designPattern.Structural.Proxy.Bean.Food;

/**
 * @project: JavaThread
 * @description:
 * @author: dell
 * @date: 2020/7/31 - 12:28
 * @version: 1.0
 * @website:
 */
public class APP {
    public static void main(String[] args) {
        FoodService foodService=new FoodServiceProxy();
        Food f=foodService.makeChicken();
        System.out.println(f);
    }
}



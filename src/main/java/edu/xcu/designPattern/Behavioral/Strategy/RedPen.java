package edu.xcu.designPattern.Behavioral.Strategy;

import edu.xcu.designPattern.Structural.Bridge.DrawAPI;

/**
 * @author: dell
 * @date: 2020/8/1 - 10:58
 */
public class RedPen implements Strategy {
    @Override
    public void draw(int radius, int x, int y) {
        System.out.println("用红色笔画图，radius:" + radius + ", x:" + x + ", y:" + y);
    }
}

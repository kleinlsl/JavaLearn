package edu.xcu.designPattern.Behavioral.Strategy;

import edu.xcu.designPattern.Structural.Bridge.DrawAPI;

/**
 * @project: JavaThread
 * @description:
 * @author: dell
 * @date: 2020/8/1 - 10:58
 */
public class BluePen implements Strategy {
    @Override
    public void draw(int radius, int x, int y) {
        System.out.println("用蓝色笔画图，radius:" + radius + ", x:" + x + ", y:" + y);
    }
}

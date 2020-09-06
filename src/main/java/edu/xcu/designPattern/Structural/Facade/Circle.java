package edu.xcu.designPattern.Structural.Facade;

/**
 * @author: dell
 * @date: 2020/8/1 - 11:55
 */
public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Circle::draw()");
    }
}

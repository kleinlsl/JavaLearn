package edu.xcu.designPattern.Structural.Facade;

/**
 * @author: dell
 * @date: 2020/8/1 - 11:56
 */
public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Rectangle::draw()");
    }
}

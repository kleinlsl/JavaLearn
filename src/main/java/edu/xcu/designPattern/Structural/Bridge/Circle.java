package edu.xcu.designPattern.Structural.Bridge;

/**
 * @author: dell
 * @date: 2020/8/1 - 11:04
 */
public class Circle extends Shape{
    private int radius;
    public Circle(int radius,DrawAPI drawAPI){
        super(drawAPI);
        this.radius=radius;
    }
    @Override
    public void draw() {
        drawAPI.draw(radius,0,0);
    }
}

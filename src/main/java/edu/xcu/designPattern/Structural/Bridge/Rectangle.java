package edu.xcu.designPattern.Structural.Bridge;

/**
 * @author: dell
 * @date: 2020/8/1 - 11:06
 */
public class Rectangle extends Shape {
    private int x,y;

    public Rectangle(int x,int y,DrawAPI drawAPI) {
        super(drawAPI);
        this.x=x;
        this.y=y;
    }

    @Override
    public void draw() {
        drawAPI.draw(0,x,y);
    }
}

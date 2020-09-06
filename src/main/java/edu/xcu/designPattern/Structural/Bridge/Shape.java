package edu.xcu.designPattern.Structural.Bridge;

/**
 * @author: dell
 * @date: 2020/8/1 - 11:02
 */
public abstract class Shape {
    protected DrawAPI drawAPI;
    protected Shape(DrawAPI drawAPI){
        this.drawAPI=drawAPI;
    }
    public abstract void draw();
}

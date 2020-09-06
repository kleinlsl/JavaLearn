package edu.xcu.designPattern.Structural.Bridge;

/**
 * @author: dell
 * @date: 2020/8/1 - 11:08
 */
public class APP {
    public static void main(String[] args) {
        Shape greenCircle = new Circle(10,new GreenPen());
        Shape redRectangle = new Rectangle(4,8,new RedPen());
        greenCircle.draw();
        redRectangle.draw();
    }
}

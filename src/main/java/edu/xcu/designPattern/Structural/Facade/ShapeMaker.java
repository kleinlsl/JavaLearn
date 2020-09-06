package edu.xcu.designPattern.Structural.Facade;

/**
 * @project: JavaThread
 * @author: dell
 * @date: 2020/8/1 - 12:00
 */
public class ShapeMaker {
    private Shape circle;
    private Shape rectangle;


    public ShapeMaker() {
        circle = new Circle();
        rectangle = new Rectangle();
    }

    /**
     * 下面定义一堆方法，具体应该调用什么方法，由这个门面来决定
     */

    public void drawCircle(){
        circle.draw();
    }
    public void drawRectangle(){
        rectangle.draw();
    }

}

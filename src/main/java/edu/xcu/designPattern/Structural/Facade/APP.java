package edu.xcu.designPattern.Structural.Facade;

/**
 * @project: JavaThread
 * @description:
 * @author: dell
 * @date: 2020/8/1 - 11:59
 * @version: 1.0
 * @website:
 */
public class APP {
    public static void main(String[] args) {
        /**
         * 正常模式
         */
        // 画一个圆形
        Shape circle = new Circle();
        circle.draw();

        // 画一个长方形
        Shape rectangle = new Rectangle();
        rectangle.draw();

        /**
         * 门面模式
         */
        ShapeMaker shapeMaker = new ShapeMaker();

        // 客户端调用现在更加清晰了
        shapeMaker.drawCircle();
        shapeMaker.drawRectangle();
    }
}

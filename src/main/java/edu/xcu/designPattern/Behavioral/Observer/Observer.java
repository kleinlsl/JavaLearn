package edu.xcu.designPattern.Behavioral.Observer;

/**
 * @project: JavaThread
 * @description:
 * @author: dell
 * @date: 2020/8/1 - 15:49
 * @version: 1.0
 * @website:
 */
public abstract class Observer {
    protected Subject subject;
    public abstract void update();
}

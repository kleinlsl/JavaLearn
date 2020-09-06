package edu.xcu.designPattern.Behavioral.Strategy;

/**
 * @author: dell
 * @date: 2020/8/1 - 13:11
 */
public class Context {
    private Strategy strategy;

    public Context(Strategy strategy){
        this.strategy = strategy;
    }

    public void executeDraw(int radius, int x, int y){
        strategy.draw(radius, x, y);
    }
}

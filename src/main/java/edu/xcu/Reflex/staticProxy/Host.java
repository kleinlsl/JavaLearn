package edu.xcu.Reflex.staticProxy;

/**
 * @project: JavaThread
 * @description: 主机 : 房屋出租接口的实现类
 * @author: dell
 * @date: 2020/9/6 - 10:15
 */
public class Host implements Rent{
    @Override
    public void rent() {
        System.out.println("房屋出租");
    }
}

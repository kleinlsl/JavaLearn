package edu.xcu.Reflex.staticProxy;

/**
 * @project: JavaThread
 * @description: 房屋出租的代理类   中介可通过代理添加额外方法
 * @author: dell
 * @date: 2020/9/6 - 10:21
 */
public class Proxy implements Rent{
    private Host host;
    public Proxy(Host host){
        this.host=host;
    }

    /**
     * 租房
     */
    @Override
    public void rent() {
        seeHouse();
        host.rent();
        fare();
    }
    /**
     * 看房
     */
    private void seeHouse(){
        System.out.println("带租客看房！");
    }
    /**
     * 收取中介费
     */
    private void fare(){
        System.out.println("收取中介费！");
    }
}

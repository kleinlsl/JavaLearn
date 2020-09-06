package edu.xcu.Reflex.staticProxy;

/**
 * @project: JavaThread
 * @description: 客户端
 * @author: dell
 * @date: 2020/9/6 - 10:14
 */
public class Client {
    public static void main(String[] args) {
        // 创建 真实角色
        Host host=new Host();
        // 创建 代理角色
        Proxy proxy=new Proxy(host);
        // 中介 代理售房
        proxy.rent();
    }
}

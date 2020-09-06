package edu.xcu.Reflex.dynamicProxy;

import edu.xcu.Reflex.dynamicProxy.service.UserService;
import edu.xcu.Reflex.dynamicProxy.service.UserServiceImpl;

/**
 * @project: JavaThread
 * @description:
 * @author: dell
 * @date: 2020/9/6 - 10:10
 */
public class Client {
    public static void main(String[] args) {
//        Host host=new Host();
//        ProxyInovationHandler proxyInovationHandler=new ProxyInovationHandler();
//        proxyInovationHandler.setRent(host);
//        Rent proxy = (Rent) proxyInovationHandler.getProxy();
//        proxy.rent();

        UserService userService=new UserServiceImpl();
        ProxyInovationHandlerCopy proxyInovationHandler=new ProxyInovationHandlerCopy();
        proxyInovationHandler.setObject(userService);
        UserService proxy = (UserService) proxyInovationHandler.getProxy();
        proxy.add();
    }
}

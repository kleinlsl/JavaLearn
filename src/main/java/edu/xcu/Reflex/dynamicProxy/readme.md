# 动态代理
- 动态代理和静态代理的角色是一样的
- 动态代理的代理类是动态生成的
- 动态代理分为两类：基于接口动态代理和基于类的动态代理
    - 基于接口的动态代理：JDK动态代理
    - 基于类的动态代理：cglib
- 一个动态代理一般代理一类业务
## JDK动态代理
Proxy 类 和InvocationHandler接口

通过JavaAPI查看类和接口内容
* Proxy 类
    > Proxy 提供用于创建动态代理类和实例的静态方法，它还是由这些方法创建的所有动态代理类的超类。
    ```shell script
    static Object newProxyInstance(ClassLoader loader, Class<?>[] interfaces, InvocationHandler h) 
            // 返回一个指定接口的代理类实例，该接口可以将方法调用指派到指定的调用处理程序。 
            // loader - 定义代理类的类加载器
            // interfaces - 代理类要实现的接口列表
            // h - 指派方法调用的调用处理程序 
    ```
* InvocationHandler接口

    > InvocationHandler 是代理实例的调用处理程序 实现的接口。 

    > 每个代理实例都具有一个关联的调用处理程序。对代理实例调用方法时，将对方法调用进行编码并将其指派到它的调用处理程序的 invoke 方法。
    ```shell script
    Object invoke(Object proxy, Method method, Object[] args);   //    在代理实例上处理方法调用并返回结果。 
    ```
## JDK动态代理实现
+ 创建接口 `Rent.java` 和实现类 `Host.java`
+ 创建 `ProxyInovationHandler.java` 实现InvocationHandler接口
    + 添加 `getProxy()` 方法并重写 `invoke()` 方法
+ 创建 `Client.java` 测试
### 单一类的动态代理
Rent.java
```java
public interface Rent {
    public void rent();
}
```
Host.java
```java
public class Host implements Rent {
    @Override
    public void rent() {
        System.out.println("房屋出租");
    }
}
```
ProxyInovationHandler.java
```java
public class ProxyInovationHandler implements InvocationHandler {
    private Rent rent;
    public void setRent(Rent rent){
        this.rent=rent;
    }
    /**
     * 生成代理类
     */
    public Object getProxy(){
        return Proxy.newProxyInstance(
                this.getClass().getClassLoader(),
                rent.getClass().getInterfaces(),
                this
        );
    }
    /**
     * 
     * @param proxy  
     * @param method 
     * @param args   
     * @return 
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        seeHouse();
        Object result = method.invoke(rent,args);
        fare();
        return result;
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

```
Client.java
```java
public class Client {
    public static void main(String[] args) {
        Host host=new Host();
        ProxyInovationHandler proxyInovationHandler=new ProxyInovationHandler();
        proxyInovationHandler.setRent(host);
        Rent proxy = (Rent) proxyInovationHandler.getProxy();
        proxy.rent();
    }
}
```
### 代理任意类
代理任意类只需要将代理处理器 `ProxyInovationHandler.java` 中的 `Rent` 对象更改为 `Object` 类型
```java
public class ProxyInovationHandlerCopy implements InvocationHandler {
    private Object object;

    public void setObject(Object o) {
        this.object=o;
    }

    /**
     * 生成代理类
     */
    public Object getProxy(){
        return Proxy.newProxyInstance(
                this.getClass().getClassLoader(),
                object.getClass().getInterfaces(),
                this
        );
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log(method.getName());
        Object result = method.invoke(object,args);
        return result;
    }
    /**
     * 日志
     */
    private void log(String methodName){
        System.out.println("执行了"+object.getClass().getSimpleName()+"的"+methodName+"方法");
    }

}

```
Client.java
```java
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

```
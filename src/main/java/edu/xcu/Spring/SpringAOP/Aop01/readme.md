# 使用 `Spring API `实现
查看 `Spring AOP API` 中的集中通知类型的API，本文采用前置通知进行演示。
- [ ] 添加切面类 `Log` ,并实现 `MethodBeforeAdvice` 接口。
- [ ] 添加 `bean.xml` Spring 配置文件，配置 `aop` 的切入点和切面
- [ ] 添加测试方法

## 添加切面 Log
```java
/**
 * @project: JavaLearn
 * @description: 日志切面
 * @author: dell
 * @date: 2020/9/7 - 10:42
 */
public class Log implements MethodBeforeAdvice {

    /**
     * 前置通知
     * @param method 被调用的方法对象  ：  执行的目标方法对象，切入点
     * @param objects 被调用的方法的参数列表
     * @param o 被调用的方法的目标对象  ：  切面
     * @throws Throwable
     */
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println(o.getClass().getName()+"的"+method.getName()+"方法被执行");
    }
}

```
## 配置Aop
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans
       xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:aop="http://www.springframework.org/schema/aop"
       xsi:schemaLocation="
       http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans.xsd
       http://www.springframework.org/schema/aop
       http://www.springframework.org/schema/aop/spring-aop.xsd
">

    <bean id="userService" class="edu.xcu.Spring.SpringAOP.Aop01.service.UserServiceImpl"/>

    <bean id="log" class="edu.xcu.Spring.SpringAOP.Aop01.Log.Log"/>

    <aop:config>
        <aop:pointcut expression="execution(* edu.xcu.Spring.SpringAOP.Aop01.service.UserServiceImpl.*())" id="pointcut"/>
        <aop:advisor advice-ref="log" pointcut-ref="pointcut"/>
    </aop:config>

</beans>
```
## 编写测试
```java
/**
 * @project: JavaLearn
 * @description:
 * @author: dell
 * @date: 2020/9/7 - 16:57
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext ac=new ClassPathXmlApplicationContext("classpath:Spring/SpringAOP/Aop01/bean.xml");
        UserService userService= (UserService) ac.getBean("userService");
        userService.add();
        userService.delete();
    }
}

```
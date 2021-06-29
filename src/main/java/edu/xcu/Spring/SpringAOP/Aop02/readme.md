# 使用 自定义类 实现
查看 `Spring AOP API` 中的集中通知类型的API，本文采用前置通知进行演示。
- [ ] 添加切面类 `Log` ,并添加多个切入点
- [ ] 添加 `bean.xml` Spring 配置文件，配置 `aop` 的切入点和切面
- [ ] 添加测试方法

## 添加切面 Log
```java
/**
 * @project: JavaLearn
 * @description:
 * @author: dell
 * @date: 2020/9/8 - 15:36
 */
public class Log {
    public void before(){
        System.out.println("------前------");
    }
    public void after(){
        System.out.println("-----后-----");
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

    <bean id="userService" class="edu.xcu.Spring.SpringAOP.Aop02.service.impl.UserServiceImpl"/>

    <bean id="log" class="edu.xcu.Spring.SpringAOP.Aop02.Log"/>

    <aop:config>
        <aop:aspect ref="log">
            <aop:pointcut id="pointcut" expression="execution(* edu.xcu.Spring.SpringAOP.Aop02.service.impl.*.*(..))"/>
            <aop:before method="before" pointcut-ref="pointcut"/>
            <aop:after method="after" pointcut-ref="pointcut"/>
        </aop:aspect>
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
        ApplicationContext ac=new ClassPathXmlApplicationContext("classpath:Spring/SpringAOP/Aop02/bean.xml");
        UserService userService= (UserService) ac.getBean("userService");
        userService.add();
        userService.delete();
    }
}

```
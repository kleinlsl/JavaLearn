# 使用 注解 实现
查看 `Spring AOP API` 中的集中通知类型的API，本文采用前置通知进行演示。

- [ ] 添加 `bean.xml` Spring 配置文件，配置 `<aop:aspectj-autoproxy/>(AOP切面自动代理)`
- [ ] 添加切面类 `Log` ，并使用 `@Aspect` 注解标记该类为切面，在类中使用 `After、Before` 等注解标记方法的通知类型
- [ ] 添加测试方法

## 添加 `bean.xml` Spring 配置文件
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:aop="http://www.springframework.org/schema/aop"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd http://www.springframework.org/schema/aop http://www.springframework.org/schema/aop/spring-aop.xsd">

    <bean id="userService" class="edu.xcu.Spring.SpringAOP.Aop03.service.impl.UserServiceImpl"/>

    <bean id="log" class="edu.xcu.Spring.SpringAOP.Aop03.Log"/>

    <aop:aspectj-autoproxy/>

</beans>
```
## 添加切面类 `Log` 
```java
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * @project: JavaLearn
 * @description:
 * @author: dell
 * @date: 2020/9/8 - 15:36
 */
// 添加注解
@Aspect
public class Log {
    @Before("execution(* edu.xcu.Spring.SpringAOP.Aop03.service.impl.*.*(..))")
    public void before(){
        System.out.println("------前------");
    }
    @After("execution(* edu.xcu.Spring.SpringAOP.Aop03.service.impl.*.*(..))")
    public void after(){
        System.out.println("-----后-----");
    }
    @Around("execution(* edu.xcu.Spring.SpringAOP.Aop03.service.impl.*.*(..))")
    public Object aroud(ProceedingJoinPoint jp) throws Throwable {
        System.out.println("环绕前");
        System.out.println("签名："+jp.getSignature());
        // 执行目标方法
        Object o=jp.proceed();

        System.out.println("环绕后");
        return o;
    }
}

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
        ApplicationContext ac=new ClassPathXmlApplicationContext("classpath:Spring/SpringAOP/Aop03/bean.xml");
        UserService userService= (UserService) ac.getBean("userService");
        userService.add();
//        userService.delete();
    }
}


```
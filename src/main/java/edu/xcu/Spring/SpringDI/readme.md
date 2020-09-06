# spring中的依赖注入

## 1、依赖注入:
    
    Dependency Injection
* Ioc的作用:
    
    降低程序间的耦合（依赖关系）
* 依赖关系的管理:

    以后都交给spring来维护
    
    在当前类需要用到其他类的对象，由spring为我们提供，我们只需要在配置文件中说明

* 依赖关系的维护:

    就称之为依赖注入。
## 2、依赖注入:
### 2.1 创建实体类
```java
@Data
public class ObjectBean {
    // 经常变化的数据，不适合注入的方式
    private String name;
    private Integer age;
    private Date birthday;
    private String[] myStr;
    private List<String> myList;
    private Set<String> mySet;
    private Map<String,String> myMap;
    private Properties myProps;

    public ObjectBean(){}

    public ObjectBean(String name) {
        this(name,null,null);
    }
    public ObjectBean(String name,Integer age,Date birthday){
        this.name=name;
        this.age=age;
        this.birthday=birthday;
    }

    public void init(){
        System.out.println(this.getName()+"类已初始化！！！");
    }
    public void destory(){
        System.out.println(this.getName()+"类已销毁！！！");
    }
}

```
### 2.2 创建spring配置文件
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

</beans>
```
### 2.3 能注入的数据:有三类
    * 基本类型和string
    * 其他bean类型（在配置文件中或者注解配置过的bean)
    * 复杂类型/集合类型
    > 用于给List结构集合注入的标签，
          list array set
      用于个Map结构乘合注入的标签:
          map props
      结构相同，标签可以互换
    ```xml
     <bean id="objectBean3" class="edu.xcu.Spring.ObjectBean">
            <property name="name" value="复杂类型注入"/>
            <property name="myStr">
                <array>
                    <value>AAA</value>
                    <value>BBB</value>
                    <value>CCC</value>
                </array>
            </property>
            <property name="myList">
                <list>
                    <value>AAA</value>
                    <value>BBB</value>
                    <value>CCC</value>
                </list>
            </property>
            <property name="mySet">
                <set>
                    <value>AAA</value>
                    <value>BBB</value>
                    <value>CCC</value>
                </set>
            </property>
            <property name="myMap">
                <map>
                    <entry key="A" value="AAA"/>
                    <entry key="B" value="BBB"/>
                    <entry key="C" value="CCC"/>
                </map>
            </property>
            <property name="myProps">
                <props>
                    <prop key="testC">ccc</prop>
                    <prop key="testA">aaa</prop>
                </props>
            </property>
        </bean>
    ```
### 2.4 注入的方式:有三种
* 第—种:使用构造函数提供
> 使用的标签:constructor-arg
          标签出现的位置:bean标签的丙部
          标签中的属性
              type:用于指定要注入的数据的数据类型，该数据类型也是构造函数中某个或某些参数的类型
              index:用于指定要注入的数据给构造函数中指定索引位置的参数赋值。索引的位置是从 0 开始
              name:用于指定给构造函数中指定名称的参数赋值                    常用的
              ======================以上三个用于指定给构造函数中哪个参数赋值===========================
              value:用于提供基本类型和string类型的数据
              ref:用于指定其他的bean类型数据，它指的是在spring的IOC核心容器中出现过的bean对象
          优势:
              在获取bean对象时，注入数据是必须的操作，否则对象无法创建成功。
          弊端:
              改变了bean对象的实例化方式，使我们在创建对象时，如果用不到这些数据，也必须提供。
```xml
    <bean id="objectBean1" class="edu.xcu.Spring.ObjectBean">
        <constructor-arg name="name" value="构造函数注入"/>
        <constructor-arg index="1" value="18"/>
        <constructor-arg type="java.util.Date" ref="date"/>
    </bean>
    <!--  配置一个日期对象  -->
    <bean id="date" class="java.util.Date"/>
```
* 第二种:使用set方法提供

> 涉及的标签:property
          出现的位置:bean标签的内部
          标签的属性
              name:用于指定给构造函数中指定名称的参数赋值
              value:用于提供基本类型和string类型的数据
              ref:用于指定其他的bean类型数据，它指的是在spring的IOC核心容器中出现过的bean对象
          优势:
              创建对象时没有明确的限制，可以直接使用默认构造函数
          弊端:
              如果有某个成员必须有值，则获取对象是有可能set方法没有执行。
```xml
<bean id="objectBean2" class="edu.xcu.Spring.ObjectBean">
        <property name="name" value="set方法注入"/>
        <property name="age" value="18"/>
<!--        <property name="birthday" ref="date"/>-->
</bean>
```                  
* 第三种:使用注解提供
> 见第三部分

## 3、注解注入
 * 曾经XML的配置:
 *      <bean id="accountService" class="。。。"
 *          scope="" init-method="" destroy-method="">
 *          <property name="" value="" | ref=""></property>
 *      </bean>
### 3.1 用于创建对象的:
 *      他们的作用就和在XMIL配置文件中编写一个<bean>标签实现的功能是一样的
 *
 *      @Component：
 *          作用：把当前类对象存入Spring容器中
 *          属性：
 *              value：用于指定bean中的id，当我们不写的时候，它默认的是类名首字母小写
 *       Controller
 *       Service
 *       Repository
 *       以上三个注解的作用和属性与Component是一摸一样的。
 *       他们三个是spring框架为我们提供明确的三层使用的注解，使我们的三层更加清晰。
 *
### 3.2 用子注入数据的:
 *      他们的作用就和在xml配置文件中的bean标签中写一个<property>标签的作用是一样的
 *      Autowired:
 *          作用:自动按照类型注入。只要容器中有唯一的一个bean对象类型和要注入的变量类型匹配，就可以注入成功
 *          出现位置：
 *              可以是变量上，也可以是方法上
 *          细节：
 *              在使用注解注入时，set方法就不是必须的了。
 *      Qualifier:
 *          作用:在按照类中注入的基础之上再按照名称注入。它在给类成员注入时不能单独使用。但是在给方法参数注
 *          属性:
 *              vaLue:用于指定注Abean的id。
 *      Resource
 *          作用:直接按照bean的id注入。它可以独立使用
 *          属性:
 *          name用于指定bear的id。
 *      以上三个注入都只能注入其他bean类型的数据，而基本类型和string类型无法使用上述注解实现。
 *      另外，集合类型的注入只能通过xL来实现。
 *
 *      Value
 *          作用:用于注入基本类型和String类型的数据
 *          属性:
 *          value:用于指定数据的值。它可以使用spring中SpEL(也就是spring的el表达式)
 *                  SpEL的写法:${表达式}
### 3.3 用于改变作用范围的:
 *      他们的作用集合在bear标签中使用scope属性实现的功能是一样的
 *
 *      Scope
 *          作用:用于指定bean的作用范围
 *          属性:
 *              vaLue:指定范围的取值。常用取值:singLeton prototypd
### 3.4 和生命周期相关：
 *      他们的作用就和在bean标签中使用init-method 和 destroy-method的作用一样
 *      PreDestroy
 *          作用:用于指定销毁方法
 *      PostConstruct
 *          作用:用于指定初始化方法

# 前言
> 学习反射应该了解：
> - 反射是什么？
> - 反射能做什么？
> - 如何得到想反射的类？
> - Java创建对象有几种方法？
> - 如何通过反射实例化对象？
> - 如何通过反射调用成员变量和方法？
> - 如何通过反射调用私有的成员变量和方法？

|推荐 | 学习  |
|:--|:--|
| 用最直接的大白话来聊一聊Java中的反射机制 | [url:强烈推荐](https://blog.csdn.net/ju_362204801/article/details/90578678) |
|反射机制|[url:快速入门](https://snailclimb.gitee.io/javaguide/#/docs/java/basic/reflection?id=%e5%8f%8d%e5%b0%84%e7%9a%84%e5%ba%94%e7%94%a8%e5%9c%ba%e6%99%af)|
|Java基础之—反射（非常重要）|[url:补充](https://blog.csdn.net/sinat_38259539/article/details/71799078)|
# 正文
>本文作为引导性，可以让您对反射有一个大致了解；若需要深入学习建议参考以上博客，或官方教程。

- 反射是什么？
 
    - 反射机制是在运行状态，对于任意一个类都可以获得其中的属性和方法。对于任意一个对象，都能够调用它的任意一个方法和属性；这种动态获取的信息以及动态调用对象的方法的功能称为 java 语言的反射机制。

- 反射能做什么？
	- 1、可以动态的实例化对象
 	- 2、可以获取对象中的所有属性和方法
 	- 3、可以访问私有成员（变量和方法）

- 如何得到想反射的类？
 	
 	- 1 通过object.getClass()
 	- 2 通过Object.class()
 	- 3 通过Class.forName(String  className)
 
- 通过下面单元测试理解下这三种方法；可以看到无论是哪种方法最终得到的Class对象都是一样的。

```java
    @Test
    public void getClassz() throws ClassNotFoundException {
        /**
         * 通过object.getClass()
         */
        TargetObject targetObject=new TargetObject();
        Class class1=targetObject.getClass();
        System.out.println(class1);

        /**
         * 通过Object.class()
         */
        Class class2=TargetObject.class;
        System.out.println(class2);

        /**
         * 通过Class.forName(String className)
         * 常使用这种方法
         */
        Class class3=Class.forName("edu.xcu.Reflex.TargetObject");
        System.out.println(class3);

        System.out.println(class1==class2);
        System.out.println(class2==class3);

        /*
        class edu.xcu.Reflex.TargetObject
        class edu.xcu.Reflex.TargetObject
        class edu.xcu.Reflex.TargetObject
        true
        true
         */
    }
```

- Java创建对象有几种方法？
 	- 1 通过new Object()	:	最常用
 	- 2 通过clone，可以克隆一个对象
 	- 3 通过序列化和反序列化	：	使用过前后端分离的同学应该知道
 	- 4 通过本章的反射创建

- 通过代码理解下：

```java
    @Test
    public void getObjects() throws CloneNotSupportedException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        /**
         * 1 通过new Object() : 最常用
         */
        Object object1=new Object();
        /**
         * 2 通过clone，可以克隆一个对象
         *  相关知识还未学习，建议参考以下博客；其中对于浅拷贝和深拷贝的知识也可以学习下
         *  可参考：https://blog.csdn.net/qq_33314107/article/details/80271963
         */
        class Person implements Cloneable {
            private String name;
            private Integer age;
            @Override
            protected Object clone() throws CloneNotSupportedException {
                return super.clone();
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public Integer getAge() {
                return age;
            }

            public void setAge(Integer age) {
                this.age = age;
            }
        }
        Person p1=new Person();
        p1.setAge(31);
        p1.setName("Peter");

        Person p2=(Person) p1.clone();
        Person p3=p1;
        System.out.println(p1==p3);//true
        System.out.println(p1==p2);//false
        p2.setName("Jacky");
        System.out.println("p1="+p1);//p1=Person [name=Peter, age=31]
        System.out.println("p2="+p2);//p2=Person [name=Jacky, age=31]

        /**
         * 3 通过序列化和反序列化 ： 使用过前后端分离的同学应该知道
         */
        /**
         * 4 通过本章的反射创建
         */
        Class classz=Class.forName("edu.xcu.Reflex.TargetObject");
        TargetObject targetObject= (TargetObject) classz.newInstance();
        
    }
```

> - 如何通过反射实例化对象？
> 	- 使用Class.newInstance() 实例化对象

```java
    @Test
    public void getObjects() throws CloneNotSupportedException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        /**
         * 通过本章的反射创建
         */
        Class classz=Class.forName("edu.xcu.Reflex.TargetObject");
        TargetObject targetObject= (TargetObject) classz.newInstance();

    }
```

> - 如何通过反射调用成员变量和方法？
> 	- 参看javaAPI
> 	
> ![在这里插入图片描述](https://img-blog.csdnimg.cn/20200713110524205.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxOTcxNzY4,size_16,color_FFFFFF,t_70)

```java
package edu.xcu.Reflex;

public class TargetObject {
    private String value;

    public TargetObject() {
        value = "JavaGuide";
    }

    public void publicMethod(String s) {
        System.out.println("I love " + s);
    }

    private void privateMethod() {
        System.out.println("value is " + value);
    }
}

```

```java
package edu.xcu.Reflex;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.Assert.*;

public class TargetObjectTest {
    private Class<?> tagetClass;
    private TargetObject targetObject;
    private Method[] methods;
    private Field[] fields;

    @Before
    public void init(){
        try{
            /**
             * 获取TargetObject类的Class对象并且创建TargetObject类实例
             */
            tagetClass = Class.forName("edu.xcu.Reflex.TargetObject");
            targetObject=(TargetObject) tagetClass.newInstance();

            /**
             * 获取所有类中所有定义的方法
             */
            methods = tagetClass.getDeclaredMethods();
            for (Method method : methods) {
                System.out.println(method.getName());
            }

            /**
             * 获取所有类中所有定义的字段
             */
            fields = tagetClass.getDeclaredFields();
            for (Field field : fields) {
                System.out.println(field.getName());
            }

        }
        catch (ClassCastException | ClassNotFoundException e){
            e.getStackTrace();
        } catch (IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void publicMethod() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        /**
         * 获取指定方法并调用
         */
        Method publicMethod = tagetClass.getDeclaredMethod("publicMethod",
                String.class);

        publicMethod.invoke(targetObject, "JavaGuide");
    }
}
```

- 如何通过反射调用私有的成员变量和方法？
- 设置 `privateField.setAccessible(true);`  //为了调用private方法我们取消安全检查

```java
	@Test
    public void privateMethod() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        /**
         * 获取指定方法并调用
         */
        Method privateMethod = tagetClass.getDeclaredMethod("privateMethod");
        //为了调用private方法我们取消安全检查
        privateMethod.setAccessible(true);
        privateMethod.invoke(targetObject);
    }

    @Test
    public void privateField() throws NoSuchFieldException, IllegalAccessException {
        /**
         * 获取指定方法并调用
         */
        Field privateField = tagetClass.getDeclaredField("value");
        //为了调用private方法我们取消安全检查
        privateField.setAccessible(true);
        privateField.set(targetObject,"lsl");
        System.out.println(privateField.get(targetObject));
    }
```

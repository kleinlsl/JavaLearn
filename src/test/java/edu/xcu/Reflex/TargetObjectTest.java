package edu.xcu.Reflex;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: dell
 * @date: 2020/7/12 - 17:55
 */
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

    @Test
    public void setGetMethod() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        /**
         * 测试set 、 get 、toString方法
         */
        User user =new User();
        user.setName("test");
        // set
        Method publicMethod = tagetClass.getDeclaredMethod("setUser",User.class);
        publicMethod.invoke(targetObject,user);
        // get
        publicMethod = tagetClass.getDeclaredMethod("getUser");
        User res = (User) publicMethod.invoke(targetObject);
        System.out.println(res);

        // toString
        publicMethod = tagetClass.getDeclaredMethod("toString");
        System.out.println(publicMethod.invoke(targetObject));

    }
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

}
package edu.xcu.Keyword;

import static java.lang.Math.max;

/**
 * @project: JavaThread
 * @date: 2020/7/12 - 18:55
 * static 关键字可以修饰：
 *  1、成员变量和方法：
 *  2、静态代码块：
 *  3、静态内部类：
 *  4、静态导包：
 * 被static修饰的部分会在类加载的时候执行，且只执行一次
 * 修饰的方法只在调用的时候执行
 */
public class Static {

    // TODO: 2020/7/12 静态代码块，静态代码块对于定义在它之后的静态变量，可以赋值，但是不能访问.
    static {
        i=3;
//        /**
//         * 取消注释可以看见报错
//         */
//        System.out.println(i);
    }
    private static int i;

    // TODO: 2020/7/12 静态成员变量和方法

    String name;
    /**
     * 静态变量
     */
    static int age;

    public Static(String name) {
        this.name = name;
    }
    /**
     * 静态方法
     */
    static void SayHello() {
        System.out.println("Hello i am java");
    }
    @Override
    public String toString() {
        return "Static{"+
                "name=" + name + ",age=" + age +
                "}";
    }

    // TODO: 2020/7/12 静态内部类

    /**
     * 静态内部类与非静态内部类之间存在一个最大的区别，我们知道非静态内部类在编译完成之后会隐含地保存着一个引用，该引用是指向创建它的外围类，但是静态内部类却没有。没有这个引用就意味着：
     *
     *  1、它的创建是不需要依赖外围类的创建。
     *  2、它不能使用任何外围类的非static成员变量和方法。
     */
    // 声明为 private 表明静态内部该类只能在该 Singleton 类中被访问
    private static class SingletonHolder {
        private static final Static INSTANCE = new Static("1");
    }

    public static Static getUniqueInstance() {
        return SingletonHolder.INSTANCE;
    }

    public static void main(String[] args) {
        //创建四个对象
        Static s1=new Static("1");
        Static s2=new Static("2");
        Static s3=new Static("3");
        Static s4=new Static("4");
        //给静态变量赋值
        Static.age=33;
        System.out.println(
                s1+" "+
                s2+" "+
                s3+" "+
                s4+" "
        );
        //输出：Static{name=1,age=33} Static{name=2,age=33} Static{name=3,age=33} Static{name=4,age=33}
        //调用静态方法
        Static.SayHello();


        // TODO: 2020/7/12 静态导包
        //将Math中的所有静态资源导入，这时候可以直接使用里面的静态方法，而不用通过类名进行调用
        //如果只想导入单一某个静态方法，只需要将换成对应的方法名即可
        int max = max(1,2);
        System.out.println(max);
    }
}

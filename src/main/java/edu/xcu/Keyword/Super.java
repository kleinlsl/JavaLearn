package edu.xcu.Keyword;

/**
 * @project: JavaThread
 * @author: dell
 * @date: 2020/7/12 - 18:47
 */
public class Super {
    /**
     * super关键字用于从子类访问父类的变量和方法
     *      使用 this 和 super 要注意的问题：
     *          1、在构造器中使用 super（） 调用父类中的其他构造方法时，该语句必须处于构造器的首行，否则编译器会报错。另外，this 调用本类中的其他构造方法时，也要放在首行。
     *          2、this、super不能用在static方法中。
     */
    protected int number;

    protected void showNumber() {
        System.out.println("number = " + number);
    }

    // TODO: 2020/7/12 创建内部类，继承自Super
    class Sub extends Super {
        void bar() {
            super.number = 10;
            super.showNumber();
        }
    }

    public static void main(String[] args) {
        /**
         * 通过外部类对象创建内部类实例
         */
        Sub sub=new Super().new Sub();
        sub.bar();
    }
}




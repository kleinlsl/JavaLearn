package edu.xcu.Keyword;

/**
 * @project: JavaThread
 * @date: 2020/7/12 - 18:17
 * @website:
 */
public class Final {
    /**
     * final关键字，意思是最终的、不可修改的，最见不得变化 ，用来修饰类、方法和变量，具有以下特点：
     *      1、修饰类：该类不能被继承，类中的成员方法被隐式为 final ；成员变量不受影响。
     *      2、修饰方法：该方法不能被重写
     *      3、修饰变量：变量是基本数据类型变量则不可更改；若变量是引用类型的变量，则不能更改其引用。
     */
    /**
     * final 标识的变量
     */
    final String value;

    // TODO: 2020/7/12 构造方法给value赋值一次，之后不可更改
    public Final(String value) {
        this.value = value;
    }

    // TODO: 2020/7/12 final标识的内部类，用于验证final标识类
    final class Test{
        private String value;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        Test(String value){
            this.value=value;
        }
    }

//    class TestCh extends Test{
//        /**
//         * 取消注释就能发现编译器报错
//         */
//    }

    public static void main(String[] args) {
        Final f=new Final("Final");
//        /**
//         * 取消注释就能发现编译器报错
//         */
//        f.value="001";

        // 通过 .new 创建内部类对象
        Final.Test test=f.new Test("lsl");

        System.out.println(test.getValue());
        /**
         * 验证 final 标识的类，其成员变量未隐式被 final 修饰
         */
        test.setValue("001");
        System.out.println(test.getValue());
    }

}

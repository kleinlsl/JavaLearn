package edu.xcu.Keyword;

/**
 * @project: JavaThread
 * @author: dell
 * @date: 2020/7/12 - 18:40
 */

/**
 * this关键字用于引用类的当前实例,可通过 this 调用当前实例的成员变量和方法。
 */
public class This {
    /**
     * 成员变量
     */
    Object[] objects;

    void report(){
        System.out.println("this is report Method!!");
    }

    void manageObjects(){
        int totalEmp = this.objects.length;
        System.out.println("Total objects: "+totalEmp);
        this.report();
    }

    public static void main(String[] args) {
        This t=new This();
        t.report();
    }
}

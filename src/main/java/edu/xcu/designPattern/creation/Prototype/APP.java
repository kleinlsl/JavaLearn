package edu.xcu.designPattern.creation.Prototype;

/**
 * @project: JavaThread
 * @description:
 * @author: dell
 * @date: 2020/7/31 - 11:30
 * @version: 1.0
 * @website:
 */
public class APP {
    public static void main(String[] args) throws CloneNotSupportedException {
        User c1=new User();
        c1.setName("01");
        User c2 = c1;
        User c3 = (User) c1.clone();
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
    }
}

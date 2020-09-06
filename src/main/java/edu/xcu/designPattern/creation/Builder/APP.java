package edu.xcu.designPattern.creation.Builder;

import edu.xcu.designPattern.creation.Builder.bean.User;

/**
 * @project: JavaThread
 * @description:
 * @author: dell
 * @date: 2020/7/31 - 11:26
 * @version: 1.0
 * @website:
 */
public class APP {
    public static void main(String[] args) {
        User d= User
                .builder()
                .name("foo")
                .password("123456")
                .age(25)
                .build();
        System.out.println(d);
    }
}

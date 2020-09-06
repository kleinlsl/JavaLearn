package edu.xcu.Reflex;

import lombok.Data;

/**
 * @author: dell
 * @date: 2020/7/12 - 17:53
 */
@Data
public class TargetObject {
    private String value;
    private User user;
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

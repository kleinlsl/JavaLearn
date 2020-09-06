package edu.xcu.designPattern.creation.Prototype;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @project: JavaThread
 * @description:
 * @author: dell
 * @date: 2020/7/31 - 11:31
 */
@Setter
@Getter
public class User implements Cloneable {
    private String name;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

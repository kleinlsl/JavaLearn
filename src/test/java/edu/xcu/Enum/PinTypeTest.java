package edu.xcu.Enum;

import org.junit.Before;
import org.junit.Test;

/**
 * @project: JavaThread
 * @description:
 * @author: dell
 * @date: 2020/7/12 - 17:23
 * @version: 1.0
 * @website:
 */
public class PinTypeTest {
    private PinType pinType;

    @Before
    public void init(){
//        pinType=new PinType(100001,"000");
    }

    @Test
    public void test(){
        System.out.println(PinType.FORGET_PASSWORD.getCode());
        System.out.println(PinType.FORGET_PASSWORD.getMessage());
        System.out.println(PinType.FORGET_PASSWORD.toString());
    }

}
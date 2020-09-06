package edu.xcu.Spring.SpringBean;

import edu.xcu.Spring.ObjectBean;

/**
 * @author: dell
 * @date: 2020/8/6 - 19:08
 */
public class StaticFactory {
    public static ObjectBean getObjectBean(String name){
        return new ObjectBean(name);
    }
}

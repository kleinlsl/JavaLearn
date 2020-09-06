package edu.xcu.Spring.SpringBean;

import edu.xcu.Spring.ObjectBean;

/**
 * @author: dell
 * @date: 2020/8/6 - 18:53
 */
public class InstanceFactory {
    public ObjectBean getObjectBean(String name){
        return new ObjectBean(name);
    }
}

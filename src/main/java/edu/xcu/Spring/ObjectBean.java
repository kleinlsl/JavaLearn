package edu.xcu.Spring;

import lombok.Data;

import java.util.*;

/**
 * @author: dell
 * @date: 2020/8/6 - 18:51
 */
@Data
public class ObjectBean {
    // 经常变化的数据，不适合注入的方式
    private String name;
    private Integer age;
    private Date birthday;
    private String[] myStr;
    private List<String> myList;
    private Set<String> mySet;
    private Map<String,String> myMap;
    private Properties myProps;

    public ObjectBean(){}

    public ObjectBean(String name) {
        this(name,null,null);
    }
    public ObjectBean(String name,Integer age,Date birthday){
        this.name=name;
        this.age=age;
        this.birthday=birthday;
    }

    public void init(){
        System.out.println(this.getName()+"类已初始化！！！");
    }
    public void destory(){
        System.out.println(this.getName()+"类已销毁！！！");
    }
}

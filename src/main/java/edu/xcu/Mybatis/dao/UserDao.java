package edu.xcu.Mybatis.dao;

import edu.xcu.Mybatis.bean.User;

import java.util.List;

/**
 * @project: JavaThread
 * @description:
 * @author: dell
 * @date: 2020/8/7 - 18:19
 */
public interface UserDao {
    List<User> findAll();
}

package edu.xcu.Reflex.dynamicProxy.service;

/**
 * @project: JavaLearn
 * @description:
 * @author: dell
 * @date: 2020/9/6 - 14:53
 */
public class UserServiceImpl implements UserService{

    @Override
    public void add() {
        System.out.println("添加用户");
    }

    @Override
    public void delete() {
        System.out.println("删除用户");
    }

    @Override
    public void update() {
        System.out.println("更新用户");
    }

    @Override
    public void search() {
        System.out.println("查找用户");
    }
}

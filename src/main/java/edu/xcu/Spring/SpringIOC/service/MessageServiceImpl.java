package edu.xcu.Spring.SpringIOC.service;

/**
 * @project: JavaThread
 * @description:
 * @author: dell
 * @date: 2020/8/2 - 10:23
 */
public class MessageServiceImpl implements MessageService {
    @Override
    public String getMessage() {
        return "hello world";
    }
}

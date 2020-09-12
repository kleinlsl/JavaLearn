package edu.xcu.Thread;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

/**
 * @project: JavaThread
 * @description:
 * @author: dell
 * @date: 2020/7/18 - 17:08
 */
public class ThreadMessageTest {
    private ThreadMessage threadMessage;
    @Before
    public void init(){
        threadMessage=new ThreadMessage();
    }

    /**
     * 未加锁
     */
    @Test
    public void noneLock() {
        threadMessage.noneLock();
    }

    /**
     * 添加对象锁
     * @throws InterruptedException
     */
    @Test
    public void objectLock() throws InterruptedException {
        threadMessage.ObjectLock();
    }

    /**
     * 等待并唤醒
     * @throws InterruptedException
     */
    @Test
    public void waitAndNotify() throws InterruptedException {
        threadMessage.waitAndNotify();
    }

    /**
     * 信号量通知机制   ---  volatile关键字
     * @throws InterruptedException
     */
    @Test
    public void signal() throws InterruptedException {
        threadMessage.Signal();
    }

    /**
     * 管道测试
     * @throws IOException
     * @throws InterruptedException
     */
    @Test
    public void pipe() throws IOException, InterruptedException {
        threadMessage.pipe();
    }

    /**
     * join方法；join()方法测试  ---  使得当前线程进入等待
     * @throws InterruptedException
     */
    @Test
    public void join() throws InterruptedException {
        threadMessage.join();
    }
}
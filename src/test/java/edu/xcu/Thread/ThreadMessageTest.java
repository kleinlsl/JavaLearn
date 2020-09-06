package edu.xcu.Thread;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

/**
 * @project: JavaThread
 * @description:
 * @author: dell
 * @date: 2020/7/18 - 17:08
 * @version: 1.0
 * @website:
 */
public class ThreadMessageTest {
    private ThreadMessage threadMessage;
    @Before
    public void init(){
        threadMessage=new ThreadMessage();
    }
    @Test
    public void noneLock() {
        threadMessage.noneLock();
    }

    @Test
    public void objectLock() throws InterruptedException {
        threadMessage.ObjectLock();
    }

    @Test
    public void waitAndNotify() throws InterruptedException {
        threadMessage.waitAndNotify();
    }

    @Test
    public void signal() throws InterruptedException {
        threadMessage.Signal();
    }

    @Test
    public void pipe() throws IOException, InterruptedException {
        threadMessage.pipe();
    }

    @Test
    public void join() throws InterruptedException {
        threadMessage.join();
    }
}
package edu.xcu.Thread;

import org.junit.Before;
import org.junit.Test;

/**
 * @project: JavaThread
 * @description: 线程状态测试
 * @author: dell
 * @date: 2020/7/18 - 16:14
 */
public class ThreadStateTest {

    private ThreadState threadState;
    @Before
    public void init(){
        threadState=new ThreadState();
    }
    @Test
    public void blockedTest() throws InterruptedException {
        threadState.blockedTest();
    }
}
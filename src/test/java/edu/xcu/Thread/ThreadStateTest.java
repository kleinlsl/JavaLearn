package edu.xcu.Thread;

import org.junit.Before;
import org.junit.Test;

/**
 * @project: JavaThread
 * @description:
 * @author: dell
 * @date: 2020/7/18 - 16:14
 * @version: 1.0
 * @website:
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
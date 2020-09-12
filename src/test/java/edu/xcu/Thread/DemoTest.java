package edu.xcu.Thread;

import org.junit.Test;

import java.util.concurrent.*;

/**
 * @project: JavaThread
 * @description: 线程 demo 测试
 * @author: dell
 * @date: 2020/7/15 - 13:54
 */
public class DemoTest {
    /**
     * 测试Thread创建线程
     */
    @Test
    public void testMyThread()
    {
        Thread myThread=new Demo.MyThread();
        //调用start（）方法，线程才算启动
        myThread.start();
    }

    /**
     * 测试Runnable创建线程
     */
    @Test
    public void testMyRunnable(){
        /**
         * Thread(Runnable target)
         * Thread(Runnable target, String name)
         */
        new Thread(new Demo.myRunnable()).start();

        new Thread(()->{
            System.out.println("Java 8 匿名内部类");
        }).start();
    }

    /**
     * 测试Task： // 自定义Callable
     * 使用Future接收返回值
     */
    @Test
    public void testTask() throws ExecutionException, InterruptedException {
        // 使用 Executors 创建线程池
        ExecutorService executor = Executors.newCachedThreadPool();

        Demo.Task task = new Demo.Task();
        Future<Integer> result = executor.submit(task);
        // 注意调用get方法会阻塞当前线程，直到得到结果。
        // 所以实际编码中建议使用可以设置超时时间的重载get方法。
        System.out.println(result.get());
    }
    /**
     * 测试Task： // 自定义Callable
     * 使用FutureTask接收返回值
     */
    @Test
    public void testTask2() throws ExecutionException, InterruptedException {
        // 使用 Executors 创建线程池
        ExecutorService executorService=Executors.newCachedThreadPool();

        FutureTask<Integer> futureTask=new FutureTask<>(new Demo.Task());

        executorService.submit(futureTask);
        System.out.println(futureTask.get());
    }

    /**
     * 线程组
     */
    @Test
    public void threadGroup() {
        Demo.threadGroup();
    }

    /**
     * 线程优先级
     */
    @Test
    public void threadPriority() {
        Demo.threadPriority();
    }

    /**
     * 线程组优先级
     */
    @Test
    public void threaGroupPriority() {
        Demo.threaGroupPriority();
    }

    /**
     * 线程组统一异常处理
     */
    @Test
    public void threadGroupException() {
        Demo.threadGroupException();
    }
}
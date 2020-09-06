package edu.xcu.Thread;

import java.util.concurrent.*;
import java.util.stream.IntStream;

/**
 * @project: JavaThread
 * @description:
 * @author: dell
 * @date: 2020/7/15 - 13:15
 * @version: 1.0
 * @website:
 */
public class Demo {

    /**
     * 通过继承Thread创建线程，重写run（）方法
     */
    public static class MyThread extends Thread{
        @Override
        public void run() {
            System.out.println("MyThread run()");
        }
    }

    /**
     * 通过实现Runable接口，并重写run方法
     */
    public static class myRunnable implements Runnable{

        @Override
        public void run() {
            System.out.println("myRunnable run()");
        }
    }

    /**
     *自定义Callable
     */
    public static class Task implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {
            // 模拟计算需要一秒
            Thread.sleep(1000);
            return 2;
        }
        public static void main(String args[]) throws ExecutionException, InterruptedException {
            // 使用 创建线程池
            ExecutorService executor = Executors.newCachedThreadPool();

            Task task = new Task();
            Future<Integer> result = executor.submit(task);
            // 注意调用get方法会阻塞当前线程，直到得到结果。
            // 所以实际编码中建议使用可以设置超时时间的重载get方法。
            System.out.println(result.get());
        }
    }

    /**
     * 线程组：ThreadGroup
     */
    public static void threadGroup(){
        Thread testThread = new Thread(() -> {
            System.out.println("testThread当前线程组名字：" +
                    Thread.currentThread().getThreadGroup().getName());
            System.out.println("testThread线程名字：" +
                    Thread.currentThread().getName());
        });

        testThread.start();
        System.out.println("执行main方法线程名字：" + Thread.currentThread().getName());
    }

    // TODO: 2020/7/15 线程优先级
    public static void threadPriority(){
        Thread a=new Thread();
        System.out.println("我是默认线程优先级："+a.getPriority());

        Thread b=new Thread();
        b.setPriority(10);
        System.out.println("我是设置过的线程优先级："+b.getPriority());
    }

    /**
     * 理解线程优先级和执行顺序的关系：优先级高不一定先执行
     * Java提供一个线程调度器来监视和控制处于RUNNABLE状态的线程。
     * 线程的调度策略采用抢占式，优先级高的线程比优先级低的线程会有更大的几率优先执行。
     * 在优先级相同的情况下，按照“先到先得”的原则。
     * 每个Java程序都有一个默认的主线程，
     * 就是通过JVM启动的第一个线程main线程。
     */
    public static class T1 extends Thread{
        @Override
        public void run() {
            super.run();
            System.out.println(
                    String.format("当前执行的线程是：%s,优先级：%d,所在组:%s",
                            Thread.currentThread().getName(),
                            Thread.currentThread().getPriority(),
                            Thread.currentThread().getThreadGroup().getName()
                    )
            );
        }

        public static void main(String[] args) {
            System.out.println("==========分割线==========  Main begin");
            IntStream.range(1,10).forEach(i->{
                Thread thread = new Thread(new T1());
                thread.setName(String.format("Theard-%d",i));
                thread.setPriority(i);
                thread.start();
            });

            IntStream.range(1,10).forEach(i->{
                Thread thread = new Thread(()->{
                    System.out.println(
                            String.format("当前执行的线程是：%s,优先级：%d,所在组:%s",
                                    Thread.currentThread().getName(),
                                    Thread.currentThread().getPriority(),
                                    Thread.currentThread().getThreadGroup().getName()
                            )
                    );
                });
                thread.setName(String.format("Runnable-%d",i));
                thread.setPriority(i);
                thread.start();
            });
            System.out.println("==========分割线==========  Main end");

            /**
             * 添加守护线程Daemon
             * 还有一种线程称为守护线程（Daemon），守护线程默认的优先级比较低。
             */
            Thread thread=new Thread(()->{
                System.out.println(
                        String.format("当前执行的线程是：%s,优先级：%d,所在组:%s",
                                Thread.currentThread().getName(),
                                Thread.currentThread().getPriority(),
                                Thread.currentThread().getThreadGroup().getName()
                        )
                );
            });
            thread.setName("Daemon");
            //设置该线程为守护线程
            thread.setDaemon(true);
            thread.start();
        }
    }

    // TODO: 2020/7/16 线程组优先级
    public static void threaGroupPriority(){
        ThreadGroup threadGroup=new ThreadGroup("T1");
        threadGroup.setMaxPriority(6);

        Thread thread=new Thread(threadGroup,"thread");
        thread.setPriority(9);
        /**
         * 所以，如果某个线程优先级大于线程所在线程组的最大优先级，
         * 那么该线程的优先级将会失效，取而代之的是线程组的最大优先级。
         */
        System.out.println("我是线程组的优先级"+threadGroup.getMaxPriority());
        System.out.println("我是线程的优先级"+thread.getPriority());
    }

    // TODO: 2020/7/18 线程组统一异常处理 
    public static void threadGroupException(){
        ThreadGroup threadGroup1 = new ThreadGroup("group1") {
            // 继承ThreadGroup并重新定义以下方法
            // 在线程成员抛出unchecked exception
            // 会执行此方法
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println(t.getName() + ": " + e.getMessage());
            }
        };

        // 这个线程是threadGroup1的一员
        Thread thread1 = new Thread(threadGroup1, new Runnable() {
            @Override
            public void run() {
                // 抛出unchecked异常
                throw new RuntimeException("测试异常");
            }
        });

        thread1.start();
    }
}

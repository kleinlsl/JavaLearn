package edu.xcu.Thread;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.util.Scanner;

/**
 * @project: JavaThread
 * @date: 2020/7/18 - 16:50
 */
public class ThreadMessage {
    private Scanner sc=new Scanner(System.in);

    // TODO: 2020/7/18 锁与同步
    public void noneLock(){
        new Thread(()->{
            for (int i = 0; i < 100; i++) {
                System.out.println("Thread A " + i);
            }
        }).start();

        new Thread(()->{
            for (int i = 0; i < 100; i++) {
                System.out.println("Thread B " + i);
            }
        }).start();
    }

    /**
     * 对象锁
     */
    private static Object lock=new Object();
    public void ObjectLock() throws InterruptedException {
        new Thread(()->{
            synchronized (lock){
                for (int i = 0; i < 100; i++) {
                    System.out.println("Thread A " + i);
                }
            }
        }).start();
        Thread.sleep(10);
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    for (int i = 0; i < 100; i++) {
                        System.out.println("Thread B " + i);
                    }
                }
            }
        }).start();

    }

    // TODO: 2020/7/18 等待/通知机制
    public void waitAndNotify() throws InterruptedException {
        new Thread(()->{
            synchronized (lock) {
                for (int i = 0; i < 5; i++) {
                    try {
                        System.out.println("ThreadA: " + i);
                        lock.notify();
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                lock.notify();
            }
        }).start();

        Thread.sleep(1000);

        new Thread(()->{
            synchronized (lock) {
                for (int i = 0; i < 5; i++) {
                    try {
                        System.out.println("ThreadB: " + i);
                        lock.notify();
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                lock.notify();
            }
        }).start();
    }

    // TODO: 2020/7/18 信号量 ： volatile关键字
    private static volatile int signal=0;
    public void Signal() throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (signal < 5) {
                    if (signal % 2 == 0) {
                        System.out.println("threadA: " + signal);
                        signal++;
                    }
                }
            }
        }).start();

        Thread.sleep(1000);
        new Thread(()->{
            while (signal < 5) {
                if (signal % 2 == 1) {
                    System.out.println("threadB: " + signal);
                    signal = signal + 1;
                }
            }
        }).start();
        /**
         * 等待子线程执行完毕
         */
        Thread.sleep(2000);
    }

    // TODO: 2020/7/18 管道
    public static class ReaderThread implements Runnable{
        private PipedReader reader;
        public ReaderThread(PipedReader reader){
            this.reader=reader;
        }
        @Override
        public void run() {
            System.out.println("this is reader");
            int receive = 0;
            try {
                while ((receive = reader.read()) != -1) {
                    System.out.print((char)receive);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static class WriterThread implements Runnable{
        private PipedWriter writer;

        public WriterThread(PipedWriter writer){
            this.writer=writer;
        }
        @Override
        public void run() {
            System.out.println("this is writer");
            int receive = 0;
            try {
                writer.write("test");
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public void pipe() throws IOException, InterruptedException {
        PipedWriter writer=new PipedWriter();
        PipedReader reader=new PipedReader();
        writer.connect(reader);

        new Thread(new ReaderThread(reader)).start();
        Thread.sleep(1000);
        new Thread(new WriterThread(writer)).start();
    }

    // TODO: 2020/7/18 join方法；join()方法是Thread类的一个实例方法。它的作用是让当前线程陷入“等待”状态，等join的这个线程执行完成后，再继续执行当前线程。
    public void join() throws InterruptedException {
        Thread thread=new Thread(()->{
            try {
                System.out.println("我是子线程，我先睡一秒");
                Thread.sleep(1000);
                System.out.println("我是子线程，我睡完了一秒");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();
        thread.join();
        System.out.println("如果不加join方法，我会先被打出来，加了就不一样了");
    }

    // TODO: 2020/7/19 ThreadLocal : 本地线程副本变量工具类
    public static class ThreadLocalDemo {
        public static class ThreadA implements Runnable {
            private ThreadLocal<String> threadLocal;

            public ThreadA(ThreadLocal<String> threadLocal) {
                this.threadLocal = threadLocal;
            }

            @Override
            public void run() {
                threadLocal.set("A");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("ThreadA输出：" + threadLocal.get());
            }

            public static class ThreadB implements Runnable {
                private ThreadLocal<String> threadLocal;

                public ThreadB(ThreadLocal<String> threadLocal) {
                    this.threadLocal = threadLocal;
                }

                @Override
                public void run() {
                    threadLocal.set("B");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("ThreadB输出：" + threadLocal.get());
                }
            }

            public static void main(String[] args) {
                ThreadLocal<String> threadLocal = new ThreadLocal<>();
                new Thread(new ThreadA(threadLocal)).start();
                new Thread(new ThreadB(threadLocal)).start();
            }
        }
    }
}

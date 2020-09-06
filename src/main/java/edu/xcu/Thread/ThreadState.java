package edu.xcu.Thread;

/**
 * @project: JavaThread
 * @date: 2020/7/18 - 16:05
 * 1、操作系统中的线程状态转换
 * 1.1 new
 * 1.2 ready
 * 1.3 running
 * 1.4 waiting
 * 1.5 terminated : 结束
 * 2、Java线程的6个状态
 * // Thread.State 源码
 * public enum State {
 *     NEW,
 *     RUNNABLE,   {包含传统操作系统线程的ready、和running}
 *     BLOCKED,
 *     WAITING,
 *     TIMED_WAITING,
 *     TERMINATED;
 * }
 * 3、状态改变
 * object.wait()  #使当前线程等待，并释放资源
 * object.notify() #随机唤醒一个正在等待的资源
 * object.notifyAll()  #唤醒所有正在等待的资源
 *
 * Thread.sleep()   #使得当前线程进入睡眠，不释放拥有的资源
 * thread.join()    #让当前线程陷入等待，等join这个线程执行完毕后，在执行当前线程。底层还是调用wait()方法
 *
 * 4、创建线程的方法
 * 4.1 继承Thread类，重写run()方法 ; Thread类实现了Runnable接口
 * 4.2 实现Runnable接口，重写run()方法
 * 4.3 使用lambda  ： new Thread(()->{});
 * 4.4 使用匿名内部类 ：new Thread(new Runnable(){});
 */
public class ThreadState {

    // 同步方法争夺锁
    private synchronized void testMethod(){
        try {
            Thread.sleep(2000L);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    public void blockedTest() throws InterruptedException {
        Thread a=new Thread(new Runnable() {
            @Override
            public void run() {
                testMethod();
            }
        },"a");
        Thread b=new Thread(()->{
           testMethod();
        },"b");
        a.start();
//        a.join();
        a.join(1000L);
        Thread.sleep(1000L);
        b.start();
        System.out.println(a.getName() + ":" + a.getState()); // 输出？
        System.out.println(b.getName() + ":" + b.getState()); // 输出？
    }
}

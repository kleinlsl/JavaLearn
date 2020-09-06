package edu.xcu.Thread.ThreadPool;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

/**
 * @project: JavaThread
 * @description:
 * @author: dell
 * @date: 2020/7/20 - 12:49
 * Runnable和Callable<V>
 */
public class ThreadPool {

    // TODO: 2020/7/20 Runnable+ThreadPoolExecutor
    public static class MyRunnable implements Runnable{
        private String command;
        public MyRunnable(String command){
            this.command=command;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " Start. Time = " + new Date());
            processCommand();
            System.out.println(Thread.currentThread().getName() + " End. Time = " + new Date());
        }

        private void processCommand() {
            try {
                Thread.sleep(5000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

        @Override
        public String toString() {
            return "MyRunnable{" +
                    "command='" + command + '\'' +
                    '}';
        }
    }
    public static class ThreadPoolExecutorDemo{
        private static final int CORE_POOL_SIZE=5;   //核心池大小
        private static final int MAX_POOL_SIZE=5;   //线程池最大尺寸
        private static final int QUEUE_CAPACITY=100; //队列大小
        private static final Long KEEP_ALIVE_TIME = 1L;  //当线程数大于核心线程数时，多余的空闲线程存活的最长时间

        public static void main(String[] args) {

            //使用阿里巴巴推荐的创建线程池的方式
            //通过ThreadPoolExecutor构造函数自定义参数创建
            ThreadPoolExecutor executor=new ThreadPoolExecutor(
                    CORE_POOL_SIZE, //核心线程池大小
                    MAX_POOL_SIZE,  //最大线程数
                    KEEP_ALIVE_TIME, //当线程数大于核心线程数时，多余的空闲线程存活的最长时间
                    TimeUnit.SECONDS, //keepAliveTime的时间单位
                    new ArrayBlockingQueue<>(QUEUE_CAPACITY),  //任务队列，用来储存等待执行任务的队列
                    new ThreadPoolExecutor.CallerRunsPolicy()   //饱和策略：四种
                    /**
                     * ThreadPoolExecutor 饱和策略定义:
                     *
                     * 如果当前同时运行的线程数量达到最大线程数量并且队列也已经被放满了任时，ThreadPoolTaskExecutor 定义一些策略:
                     *
                     * ThreadPoolExecutor.AbortPolicy：抛出 RejectedExecutionException来拒绝新任务的处理。
                     * ThreadPoolExecutor.CallerRunsPolicy：调用执行自己的线程运行任务，也就是直接在调用execute方法的线程中运行(run)被拒绝的任务，如果执行程序已关闭，则会丢弃该任务。因此这种策略会降低对于新任务提交速度，影响程序的整体性能。如果您的应用程序可以承受此延迟并且你要求任何一个任务请求都要被执行的话，你可以选择这个策略。
                     * ThreadPoolExecutor.DiscardPolicy： 不处理新任务，直接丢弃掉。
                     * ThreadPoolExecutor.DiscardOldestPolicy： 此策略将丢弃最早的未处理的任务请求。
                     */
            );

            for (int i = 0; i < 10; i++) {
                //创建WorkerThread对象（WorkerThread类实现了Runnable 接口）
                Runnable worker = new MyRunnable("" + i);
                //执行Runnable
                executor.execute(worker);
            }
            executor.shutdown();
            //终止线程池
            while (!executor.isTerminated()){

            }
            System.out.println("Finished all threads");
        }
    }

    // TODO: 2020/7/20 4.4 加餐:Callable+ThreadPoolExecutor示例代码
    public static class MyCallable implements Callable<String> {

        @Override
        public String call() throws Exception {
            Thread.sleep(1000);
            //返回执行当前 Callable 的线程名字
            return Thread.currentThread().getName();
        }
    }

    public static class CallableDemo{
        private static final int CORE_POOL_SIZE = 5;
        private static final int MAX_POOL_SIZE = 10;
        private static final int QUEUE_CAPACITY = 100;
        private static final Long KEEP_ALIVE_TIME = 1L;

        public static void main(String[] args) {

            //使用阿里巴巴推荐的创建线程池的方式
            //通过ThreadPoolExecutor构造函数自定义参数创建
            ThreadPoolExecutor executor=new ThreadPoolExecutor(
                CORE_POOL_SIZE,
                MAX_POOL_SIZE,
                KEEP_ALIVE_TIME,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(QUEUE_CAPACITY),
                new ThreadPoolExecutor.CallerRunsPolicy()
            );

            List<Future<String>> futures=new ArrayList<>();
            Callable<String> callable=new MyCallable();
            for (int i = 0; i < 10; i++) {
                //提交任务到线程池
                Future<String> future = executor.submit(callable);
                //将返回值 future 添加到 list，我们可以通过 future 获得 执行 Callable 得到的返回值
                futures.add(future);
            }

            for (Future<String> fut : futures) {
                try {
                    System.out.println(new Date() + "::" + fut.get());
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            }
            //关闭线程池
            executor.shutdown();
        }
    }
}

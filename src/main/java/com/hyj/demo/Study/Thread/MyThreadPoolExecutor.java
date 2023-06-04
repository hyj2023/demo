package com.hyj.demo.Study.Thread;

import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MyThreadPoolExecutor {

    //核心线程数
    private static int corePoolSize = 1;

    //最大线程数
    private static int maxPoolSize = 2;

    //活跃时间
    private static long keepAliveTime = 1000L;

    //线程工厂
    private static MyThreadFactory myThreadFactory = new MyThreadFactory();

    //堵塞队列
    private static LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue(1);//单项链表
    private static LinkedBlockingDeque linkedBlockingDeque = new LinkedBlockingDeque();//双向链表
    private static ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(1); //数组队列


    //拒接策略
    private static MyRejectHandle myRejectHandle = new MyRejectHandle();

    public static void main(String[] args) {
        threadPoolExecutor();
    }

    public static void threadPoolExecutor() {

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(corePoolSize, maxPoolSize, keepAliveTime, TimeUnit.MILLISECONDS, linkedBlockingQueue, myThreadFactory, myRejectHandle);
        threadPoolExecutor.execute(new MyRunnable());
        threadPoolExecutor.execute(new MyRunnable());
        threadPoolExecutor.execute(new MyRunnable());
        threadPoolExecutor.execute(new MyRunnable());
        threadPoolExecutor.execute(new MyRunnable());




        // ========================
        Condition notFull = new ReentrantLock().newCondition();
        try {
            notFull.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

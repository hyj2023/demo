package com.hyj.demo.Study.Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyExecutor {
    public static void main(String[] args) {

    }
    public static void executorDemo(){
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(new MyRunnable());
        executorService.submit(new MyRunnable());
        executorService.submit(new MyRunnable());
        executorService.submit(new MyRunnable());
        executorService.submit(new MyRunnable());
        executorService.submit(new MyRunnable());
        executorService.submit(new MyRunnable());
        executorService.shutdown();
    }
    public static void executorDemo2(){
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(new MyRunnable());
        executorService.submit(new MyRunnable());
        executorService.submit(new MyRunnable());
        executorService.submit(new MyRunnable());
        executorService.submit(new MyRunnable());
        executorService.submit(new MyRunnable());
        executorService.submit(new MyRunnable());
        executorService.submit(new MyRunnable());
        executorService.submit(new MyRunnable());
        executorService.submit(new MyRunnable());
        executorService.submit(new MyRunnable());
        executorService.shutdown();
    }

}


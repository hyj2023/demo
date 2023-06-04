package com.hyj.demo.Study.Thread;

import java.util.concurrent.FutureTask;

/**
 * 类描述：TODO
 *
 * @author Administrator
 * @date 2022-12-01 17:01
 **/
public class MyThreadDemo {
    static Thread thread1 = null;
    static Thread thread2 = null;
    static Thread thread3 = null;

    public static void main(String[] args) throws Exception {
        interruptDemo();

    }

    public static void yieldTest() throws Exception {
        //yield当前线程让出资源
        thread1 = new Thread(() -> {
            System.out.println("A");
        });
        thread2 = new Thread(() -> {
            Thread.yield();
            System.out.println("B");

        });
        thread3 = new Thread(() -> {
            Thread.yield();
            System.out.println("C");
        });

        thread1.start();
        thread2.start();
        thread3.start();
    }


        public static void joinTest () {
        //join线程加入
            thread1 = new Thread(() -> {
                System.out.println("A");
            });
            thread2 = new Thread(() -> {
                try {
                    thread1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("B");

            });
            thread3 = new Thread(() -> {
                try {
                    thread2.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("C");
            });

            thread1.start();
            thread2.start();
            thread3.start();
        }

        public static void threadDemo () {
            Thread Thread = new MyThread();
            Thread.start();
        }

        public static void runnableDemo () {
            MyRunnable myRunnable = new MyRunnable();
            Thread thread = new Thread(myRunnable);
            thread.start();
        }

        public static void lambdaDemo () {
            Thread thread = new Thread(() -> {
                System.out.println("我是lambda开启的线程");
            });
            thread.start();
        }

    public static void callableDemo () {
        MyCallable myCallable = new MyCallable();
        FutureTask futureTask = new FutureTask<>(myCallable);
        Thread thread = new Thread(futureTask);
        thread.start();
    }

    //中断线程
    public static void interruptDemo() throws InterruptedException {
        MyThread myThread = new MyThread();
        myThread.start();
        Thread.currentThread().sleep(1000);
        myThread.interrupt();

    }
}

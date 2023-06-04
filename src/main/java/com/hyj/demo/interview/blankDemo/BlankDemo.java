package com.hyj.demo.interview.blankDemo;

import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlankDemo {
    /**
     * 窗口类（窗口名称，窗口的等待队列，窗口办理业务方法）
     * 客户类（客户名称，客户需要办理的业务）
     */

    public static void main(String[] args) throws InterruptedException {
        blankDemoOne();//策略1
        blankDemoTwo();//策略2
    }

    //窗口类（窗口名称，窗口的等待队列，窗口办理业务方法）
    static class Wind implements Runnable {

        private String name;
        private LinkedBlockingQueue<User> linkedBlockingQueue;

        public Wind(String name, LinkedBlockingQueue linkedBlockingQueue) {
            this.name = name;
            this.linkedBlockingQueue = linkedBlockingQueue;
        }

        public void methodOne() {
            for (; ; ) {
                try {
                    User take = linkedBlockingQueue.take();
                    System.out.println("【" + name + "】开始为用户{" + take.username + "}办理业务。。。");
                    long l = System.currentTimeMillis();
                    System.out.println("用户{" + take.username + "}等待时间为：" + (l - take.startTime) / 1000);
                    take.behave();
                    System.out.println("用户{" + take.username + "}总处理业务时间为：" + (System.currentTimeMillis() - take.startTime) / 1000);
                    System.out.println("【" + name + "】结束为用户{" + take.username + "}办理业务。。。");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }

        @Override
        public void run() {
            this.methodOne();
        }
    }

    //客户类（客户名称，客户需要办理的业务）
    static class User {
        private String username;
        private long startTime;

        public User(String username, long startTime) {
            this.username = username;
            this.startTime = startTime;
        }

        //用户办理的业务
        public void behave() {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void blankDemoOne() {
        Random random = new Random();
        //三个窗口
        LinkedBlockingQueue<User> queue1 = new LinkedBlockingQueue<>();
        LinkedBlockingQueue<User> queue2 = new LinkedBlockingQueue<>();
        LinkedBlockingQueue<User> queue3 = new LinkedBlockingQueue<>();
        Wind wind1 = new Wind("窗口1号", queue1);
        Wind wind2 = new Wind("窗口2号", queue2);
        Wind wind3 = new Wind("窗口3号", queue3);
        //窗口开启业务
        new Thread(wind1).start();
        new Thread(wind2).start();
        new Thread(wind3).start();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //模拟30个用户办理业务
        new Thread(() -> {
            for (int i = 0; i < 30; i++) {
                int a = random.nextInt(3) + 1;
                //用户随机排队
                switch (a) {
                    case 1:
                        try {
                            queue1.put(new User(i + "", System.currentTimeMillis()));
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        break;
                    case 2:
                        try {
                            queue2.put(new User(i + "", System.currentTimeMillis()));
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        break;
                    case 3:
                        try {
                            queue3.put(new User(i + "", System.currentTimeMillis()));
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        break;
                }

            }
        }).start();
    }

    public static void blankDemoTwo() {
        LinkedBlockingQueue<User> queue = new LinkedBlockingQueue<>();
        Wind wind1 = new Wind("窗口1号", queue);
        Wind wind2 = new Wind("窗口2号", queue);
        Wind wind3 = new Wind("窗口3号", queue);
        new Thread(wind1).start();
        new Thread(wind2).start();
        new Thread(wind3).start();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            for (int i = 0; i < 30; i++) {
                try {
                    queue.put(new User(i + "", System.currentTimeMillis()));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}

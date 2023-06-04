package com.hyj.demo.interview.blankDemo;

import org.omg.CORBA.TIMEOUT;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumerDemo1 {
    /**
     * 生产者（生产者名字，生产方法）
     * 消费者（消费者名字，消费方法）
     */
    public static void main(String[] args) {
        ArrayBlockingQueue<Integer> arrayBlockingQueue = new ArrayBlockingQueue(10000);
        Producer producer = new Producer(arrayBlockingQueue);
        Consumer consumer = new Consumer(arrayBlockingQueue, "1");
        Consumer consumer2 = new Consumer(arrayBlockingQueue, "2");
        Consumer consumer3 = new Consumer(arrayBlockingQueue, "3");

        new Thread(producer).start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(consumer).start();
        new Thread(consumer2).start();
        new Thread(consumer3).start();
    }
    static class Producer implements Runnable{
        private ArrayBlockingQueue<Integer> arrayBlockingQueue;

        public Producer(ArrayBlockingQueue<Integer> arrayBlockingQueue) {
            this.arrayBlockingQueue = arrayBlockingQueue;
        }

        public void produce() {
            for (int i = 1; i <= 100; i++) {
                try {
                    arrayBlockingQueue.put(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        @Override
        public void run() {
            produce();
        }
    }

    static class Consumer implements Runnable{
        private ArrayBlockingQueue<Integer> arrayBlockingQueue;
        private String name;

        public Consumer(ArrayBlockingQueue<Integer> arrayBlockingQueue, String name) {
            this.arrayBlockingQueue = arrayBlockingQueue;
            this.name = name;
        }

        public void consumer() {
            for (; ;) {
                try {
                    Integer take = arrayBlockingQueue.take();
                    System.out.println("消费者【" + name + "】消费了：" + take);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        @Override
        public void run() {
            consumer();
        }
    }
}

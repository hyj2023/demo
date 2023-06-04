package com.hyj.demo.Study.Thread;

/**
 * 类描述：TODO
 *
 * @author Administrator
 * @date 2022-12-01 18:51
 **/
public class MyRunnable implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("我是实现Runnable开启的线程");
    }
}

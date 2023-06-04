package com.hyj.demo.Study.Thread;


/**
 * 类描述：TODO
 *
 * @author Administrator
 * @date 2022-12-01 17:01
 **/
public class MyThread extends Thread {

    @Override
    public void run() {
        for (; ; ) {
            if (interrupted()){
                boolean interrupted = isInterrupted();
                System.out.println("我被中断了！");
                System.out.println(interrupted);
                break;
            }
        }
        System.out.println("我是继承Thread开启的线程");
    }
}

package com.hyj.demo.Study.Lock;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class demo {

    private static int a = 1;

    public static void main(String[] args) throws InterruptedException {
//        new Thread(() -> {
//            while (true) {
//                if (a != 1) {
//                    break;
//                }
//            }
//        }).start();
//
//        TimeUnit.SECONDS.sleep(3);
//        a = 2;
//        P p=new  P();
//        P p1=new  P();
//        P p;
//        X x = new X();
//        System.out.println(P.i);
        System.out.println(P.j);
    }


    public static class P {
        final static int i = 8;
        static int j = 9;


//        {
//            System.out.println("p1");
//        }

        static {
            System.out.println("p");
        }
        static {
            P p = new P();
            System.out.println(p);
        }
    }
        public static class X extends P {
            static{
                System.out.println("x");
            }
    }


}

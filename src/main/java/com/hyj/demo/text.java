package com.hyj.demo;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

public class text {
    public static void main(String[] args) throws Exception {
//        InputStreamReader streamReader = new InputStreamReader(System.in);
//        BufferedReader myBufferedReader = new BufferedReader(streamReader);
//        String str;
//        while ( null !=(str = myBufferedReader.readLine())) {
//            int anInt = Integer.parseInt(str);
//            double x = anInt;
//            double a = x + x + x / 2 + x / 4 + x / 8;
//            System.out.println(a);
//            System.out.println(methodOne(x));
//        }
        SynchronousQueue<String> queue=new SynchronousQueue<>(true);

        new Thread(()->{
            try {
//                queue.offer("1111",1,TimeUnit.MILLISECONDS);
                queue.put("1111");
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("第一个放完数据已返回");
        }).start();

        TimeUnit.SECONDS.sleep(3);

        new Thread(()->{
            String take = "";
            try {
                take = queue.take();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("第二个拿完数据已返回，take="+take);
        }).start();


    }

    public static double methodOne(double height) {
        for (int j1 = 0; j1 < 5; j1++) {
            height = height / 2;
        }
        return height;
    }
}






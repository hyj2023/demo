package com.hyj.demo.nio;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

public class NiOdeno {
    public static void main(String[] args) {
//        File file = new File("C:\\Users\\heyua\\Desktop\\面试 - 副本.txt");
////        try {
////            FileInputStream fileInputStream = new FileInputStream(file);
////            FileChannel channel = fileInputStream.getChannel();
////            ByteBuffer allocate = ByteBuffer.allocate(4096);
////            ByteBuffer allocate2 = ByteBuffer.allocate(4096);
////
////            new Thread(()->{
////                try {
////                    int read = channel.read(allocate, 0);
////                    String s = new String(allocate.array());
////                    System.out.println(s);
////                    System.out.println("==============================");
////                } catch (IOException e) {
////                    e.printStackTrace();
////                }
////
////            }).start();
////            new Thread(()->{
////                try {
////                    int read = channel.read(allocate2, 4096);
////                    String s = new String(allocate2.array());
////                    System.out.println(s);
////                    System.out.println("==============================");
////                } catch (IOException e) {
////                    e.printStackTrace();
////                }
////            }).start();
////
////
////        } catch (Exception e) {
////            e.printStackTrace();
////        }

            try {
                FileThread fileThread = new FileThread( 0,4096L,"第一个");
                fileThread.setThread(fileThread);
                FileThread fileThread1 = new FileThread(4096L,4096L,"第二个");
                FileThread.threadMap.put(0L,fileThread);
                FileThread.threadMap.put(4096L,fileThread1);

                fileThread.start();
                fileThread1.start();

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

}

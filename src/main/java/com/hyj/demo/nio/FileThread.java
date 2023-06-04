package com.hyj.demo.nio;

import org.hibernate.internal.util.BytesHelper;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;

public class FileThread extends Thread {
    private int MAX_FOR = 50;//最大循环等待数
    private long CAPACITY = 1 << 12;//每次读取的大小
    private long allCAPACITY = 1 << 30;//总读取的大小
    private long readCAPACITY = 0;
    private boolean beforeFirst = true; //第一条完整数据之前
    private long lastPosition = 0L;
    private String name;


    //
    public static Map<Long, FileThread> threadMap = new HashMap<>();

    // 与下一个阶段将数据放到此queue中
    private SynchronousQueue<byte[]> preData = new SynchronousQueue<>();

    // 以下一个为准
    // 由下一个阶段的线程来设置，或者自己设置（只有当是读到文件的最后一个阶段可以设置为不用依赖别的线程来改值）
    private volatile boolean isGetNextThreadData = true;

    // 从指定位置开始读取
    private long startPositon;

    // 判断下一个线程是否已经读完第一行了，如果已经读完第一行，则需要依赖此字段去判断是否等待
    private volatile int nextIsStart = 0;// 0-下一个未启动，1-已经读完第一条数据

    // 记录当前循环次数
    private int count = 0;

    // 读到的上一个阶段的数据
    private byte[] preByte;
    //    private byte[] readByte;

    // 存当前线程，用于LockSupport来上锁和解锁
    private Thread thread;

    public FileThread(long startPositon, long lastPosition,String name) {
        this.startPositon = startPositon;
        this.lastPosition = lastPosition;
        this.name = name;
    }

    @Override
    public void run() {
        File file = new File("C:\\Users\\heyua\\Desktop\\111.txt");
        long preThreadKey = 0L;
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            FileChannel channel = fileInputStream.getChannel();
            ByteBuffer allocate = ByteBuffer.allocate(4096);
            int read = channel.read(allocate, startPositon);
//            for (;readCAPACITY <= allCAPACITY;) {
//                if(beforeFirst){
//
//                }
//            }
            if (lastPosition == startPositon) {
                isGetNextThreadData = false;
            }
            if (startPositon != 0L) {
                // 已经读完第一条数据了，发现有上一个线程残留的数据，则需要通知上一个线程
                //
                // todo 读文件第一行是否符合规定格式，如果不是规定格式则需要将数据放到preByte中，然后通知上一个进程需要从我这里拿数据，并将数据放到上一个进程中的queue里
                //
                String contentStart = new String(allocate.array());
                boolean startsWith = contentStart.startsWith("!");

                preThreadKey = startPositon - CAPACITY;
//                this.setPreThreadNextIsStart(preThreadKey);//通知前一个我已经开始并读完第一行

                if (!startsWith) {
                    // 不是以！开头，将!!之前的数据保持到preByte中
                    String[] split = contentStart.split("!");
                    preByte = split[0].getBytes();

                    //是否有上一个线程需要的数据，有则通知
                    this.notice(preThreadKey, preByte);
//                    this.notifyPreThread(preThreadKey);
                } else {
//                    this.isGetNextThreadData = false;
                    this.setPreThreadIsGetNextThreadData(preThreadKey);

                }
            }
            //
            String s = null;
            int preByteLength = preByte == null ? 0 : preByte.length;
            if (0 != preByteLength) {
                int length = allocate.array().length - preByteLength;
                byte[] newByte = new byte[length];
                System.arraycopy(allocate.array(), preByteLength, newByte, 0, length);
                s = new String(newByte);

            } else {
                s = new String(allocate.array());
            }

//            writerToFile(s);
                System.out.println(name+"first=============================="+s);

            // 是否需要下一个线程提供数据
            for (; ; ) {
                if (nextIsStart == 0) {
                    if (lastPosition == startPositon) {
                        break;
                    }
//                    if (MAX_FOR <= count) {
//                        LockSupport.park();
//                    }
                    count++;
                } else {
                    try {
                        if (isGetNextThreadData) {
                            byte[] data = getData();
                            int length1 = allocate.array().length + data.length;
                            byte[] newByte1 = new byte[length1];
                            System.arraycopy(allocate.array(), 0, newByte1, 0, allocate.array().length);
                            System.arraycopy(data, 0, newByte1, allocate.array().length, data.length);
                            //                            writerToFile(new String(newByte1));
                            System.out.println(name+"second=============================="+new String(newByte1));
                            break;
                        } else {
                            break;
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setPreThreadIsGetNextThreadData(Long key) {
        FileThread fileThread = FileThread.threadMap.get(key);
        fileThread.setGetNextThreadData(false);
    }

    public void setPreThreadNextIsStart(Long key) {
        FileThread fileThread = FileThread.threadMap.get(key);
        fileThread.setNextIsStart(1);
    }

    public void notifyPreThread(Long key) {
        FileThread fileThread = FileThread.threadMap.get(key);
        LockSupport.unpark(fileThread);
    }

    public void notice(Long key, byte[] data) {
        FileThread fileThread = FileThread.threadMap.get(key);
        fileThread.setNextIsStart(1);
        try {
            fileThread.getPreData().put(data);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public byte[] getData() throws InterruptedException {
        return this.preData.take();
    }

    public boolean isGetNextThreadData() {
        return isGetNextThreadData;
    }

    public void setGetNextThreadData(boolean getNextThreadData) {
        isGetNextThreadData = getNextThreadData;
    }

    public long getStartPositon() {
        return startPositon;
    }

    public void setStartPositon(int startPositon) {
        this.startPositon = startPositon;
    }

    public SynchronousQueue<byte[]> getPreData() {
        return preData;
    }

    public void setPreData(SynchronousQueue<byte[]> preData) {
        this.preData = preData;
    }

    public void getLockSupportUnpark() {
        LockSupport.unpark(thread);
    }

    public int getNextIsStart() {
        return nextIsStart;
    }

    public void setNextIsStart(int nextIsStart) {
        this.nextIsStart = nextIsStart;
    }

    public Thread getThread() {
        return thread;
    }

    public void setThread(Thread thread) {
        this.thread = thread;
    }

    public void writerToFile(String s) {
        FileUtil.addFile("C:\\Users\\heyua\\Desktop\\111\\1.txt");
        File file1 = new File("C:\\Users\\heyua\\Desktop\\111\\1.txt");
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file1);
            try {
                fileOutputStream.write(s.getBytes());
            } finally {
                fileOutputStream.flush();
                fileOutputStream.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //写入文件
    }
}

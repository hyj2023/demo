package com.hyj.demo.nio;

public class FileEvent {
    private byte[] listen(Long key) throws InterruptedException {
        FileThread fileThread = FileThread.threadMap.get(key);
        return fileThread.getPreData().take();
    }


}

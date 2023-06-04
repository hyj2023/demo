package com.hyj.demo.Study.Thread;

import java.util.concurrent.Callable;

public class MyCallable implements Callable {
    @Override
    public Object call() throws Exception {
        System.out.println("我是实现Callable接口开启的线程");
        return null;
    }
}

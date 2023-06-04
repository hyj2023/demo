package com.hyj.demo.Study;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class aa {
    private static int a = 1;
    private int b = 2;

    public aa() {
        System.out.println("父构造方法");
    }

    static {
        System.out.println(a);
        System.out.println("父静态代码块");
    }
    {
        System.out.println("父普通代码块");
    }
    private static void m(){
        System.out.println("父静态方法");
    }
    private static void m2(){
        System.out.println("父普通方法");
    }

    public static void main(String[] args) {
        new ClassPathXmlApplicationContext();
    }

}

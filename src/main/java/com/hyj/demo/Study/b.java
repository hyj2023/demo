package com.hyj.demo.Study;

public class b extends aa {
    public b() {
        System.out.println("子构造方法");
    }

    static {
        System.out.println("子静态代码块");
    }
    {
        System.out.println("子普通代码块");
    }
    private static void m(){
        System.out.println("子静态方法");
    }
    private static void m2(){
        System.out.println("子普通方法");
    }

    public static void main(String[] args) {
        com.hyj.demo.Study.b b = new b();
    }
}

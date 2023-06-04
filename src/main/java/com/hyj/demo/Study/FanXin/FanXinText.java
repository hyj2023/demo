package com.hyj.demo.Study.FanXin;

import com.sun.org.apache.bcel.internal.generic.NEW;
import jdk.nashorn.internal.ir.CallNode;

import java.lang.reflect.Array;
import java.util.Arrays;

public class FanXinText {
    public static void main(String[] args) {
        Person a = new Person("A",13);
        Person b = new Person("B", 16);
        Person[] people = new Person[]{a,b};
        Arrays.sort(people);
        System.out.println(people.toString());

    }
}

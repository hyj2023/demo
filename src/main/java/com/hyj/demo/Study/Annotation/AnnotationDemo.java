package com.hyj.demo.Study.Annotation;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.lang.reflect.Field;

public class AnnotationDemo {
    public static void main(String[] args) {
        Class<Demo> demoClass = Demo.class;
        boolean annotationPresent = int.class.isAnnotationPresent(demoClass);
        System.out.println(annotationPresent);

    }
}

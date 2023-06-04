package com.hyj.demo.Study.Annotation;

import com.hyj.demo.dto.Student;

import java.lang.annotation.*;

@Inherited
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Demo {
int type() default 0;
String level() default "info";
String value() default "";
}

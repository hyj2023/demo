package com.hyj.demo.Study.Reflefect;

import com.hyj.demo.dto.Student;
import com.hyj.demo.util.UnsafeUtil;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import sun.misc.Unsafe;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class text {
    public static void main(String[] args) throws Exception{
        // jni  java native interface
//        Unsafe unsafe = UnsafeUtil.getUnsafe();
//        Student o = (Student)unsafe.allocateInstance(Student.class);
//        System.out.println(o);
////        Student student = Student.class.newInstance();

//        Student s=new Student();


//        Class<Student> studentClass = Student.class;
//        Student student = studentClass.newInstance();
//
//        //反射字段
//        Field id = studentClass.getDeclaredField("id");
////        System.out.println(id);
//        Field[] declaredFields = studentClass.getDeclaredFields();
//        for (Field field:declaredFields
//             ) {
////            System.out.println(field);
//        }
//        Field declaredField = declaredFields[0];
//        declaredField.setAccessible(true);
//        String name = declaredField.getName();
//        System.out.println(name);
//        int modifiers = declaredField.getModifiers();
//        System.out.println(modifiers);
//        Class<?> type = declaredField.getType();
//        System.out.println(type);
//        declaredField.set(student,10L);
//        System.out.println(student.getId());

        //反射方法
//        Method[] declaredMethods = studentClass.getDeclaredMethods();
//        for (Method method:declaredMethods
//             ) {
//            System.out.println(method);
//        }
//        Method declaredMethod = declaredMethods[0];
//        declaredMethod.setAccessible(true);
//        Object invoke = declaredMethod.invoke(student);
//        System.out.println(invoke);


//        Student xiaoming = new Student("xiaoming");
//        Class<? extends Student> aClass = xiaoming.getClass();
//        Field name = aClass.getDeclaredField("name");
//        name.setAccessible(true);
//        Object o = name.get(xiaoming);
//        System.out.println(o);

        //构造方法
//        Constructor<Student> constructor = Student.class.getConstructor();
//        Student xiaoming = constructor.newInstance();
//        System.out.println(xiaoming.getId());
//        System.out.println(xiaoming.getName());

//        Constructor<Student> declaredConstructor = Student.class.getDeclaredConstructor(Long.class, String.class);
//        declaredConstructor.setAccessible(true);
//        Student xiaoming1 = declaredConstructor.newInstance(10L, "XIAOMING");
//        Long id = xiaoming1.getId();
//        System.out.println(id);

        //获取所以构造方法
//        Constructor<?>[] constructors = Student.class.getDeclaredConstructors();
//        for (Constructor con :
//                constructors) {
//            System.out.println(con);
//        }
    }

}

package com.hyj.demo.Study.iostream;

import java.io.*;

public class outputStreamDemo {
    public static void main(String[] args) throws IOException {
        InputStream fileInputStream = new FileInputStream("C:\\Users\\heyua\\Desktop\\io.txt");
        OutputStream outputStream = new FileOutputStream("C:\\Users\\heyua\\Desktop\\io2.txt");
//        outputStreamMethod(outputStream);
        copyFile(fileInputStream,outputStream);
    }
    public static void outputStreamMethod(OutputStream outputStream) throws IOException {
        try {
            outputStream.write("今天下雨了".getBytes("UTF-8"));
        }finally {
            outputStream.flush();
            outputStream.close();
        }
    }
    public static void copyFile(InputStream fileInputStream,OutputStream outputStream) throws IOException {
        try{
         int a = 0;
         while ((a = fileInputStream.read()) != -1){
             outputStream.write(a);
         }
        }finally {
            outputStream.flush();
            fileInputStream.close();
            outputStream.close();
        }
    }
}

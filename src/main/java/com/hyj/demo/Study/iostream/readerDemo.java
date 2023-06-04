package com.hyj.demo.Study.iostream;



import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * 类描述：TODO
 *
 * @author Administrator
 * @date 2022-12-01 10:17
 **/
public class readerDemo {
    public static void main(String[] args) throws IOException{
//        Reader reader = new FileReader("D:\\Desktop\\io.txt");
        InputStream stream = new FileInputStream("C:\\Users\\heyua\\Desktop\\io.txt");
        Reader reader = new InputStreamReader(stream, StandardCharsets.UTF_8);
//        fileReadeDemo(reader);
//        fileBufferReaderDemo(reader);
    }
    public static void fileReadeDemo(Reader reader) throws IOException {
        int a = 0;
        try{
            while((a = reader.read()) != -1){
                System.out.println((char)a);
            }
        }finally {
            reader.close();
        }
    }
    public static void fileBufferReaderDemo(Reader reader) throws IOException{
        char[] chars = new char[2];
        int a = 0;
        try{
            while ((a=reader.read(chars))!=-1){
                System.out.println(String.valueOf(chars));
            }
        }finally {

        }
    }
}

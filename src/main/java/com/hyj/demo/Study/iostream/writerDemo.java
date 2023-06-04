package com.hyj.demo.Study.iostream;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * 类描述：TODO
 *
 * @author Administrator
 * @date 2022-12-01 13:49
 **/
public class writerDemo {
    public static void main(String[] args) throws IOException {
        OutputStream outputStream = new FileOutputStream("C:\\Users\\heyua\\Desktop\\io2.txt");
        Writer writer = new OutputStreamWriter(outputStream, StandardCharsets.UTF_8);
        fileWriterDemo(writer);
    }

    public static void fileWriterDemo(Writer writer) throws IOException {
        try{
            writer.write("eat");
            writer.write("sleep");
            writer.write("chif".toCharArray());
        }finally {
            writer.close();
        }
    }

    public static void fileBufferWriterDemo(Writer writer) throws IOException {
        CharArrayWriter charArrayWriter = new CharArrayWriter();
        try{
            charArrayWriter.write("eat");
            charArrayWriter.write("sleep");
            charArrayWriter.write("chif".toCharArray());
            writer.write(charArrayWriter.toCharArray());
        }finally {

            writer.close();
        }
    }
}

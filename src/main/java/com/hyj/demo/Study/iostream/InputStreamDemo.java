package com.hyj.demo.Study.iostream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class InputStreamDemo {
    public static void main(String[] args) throws IOException {
        byteArrayInputStreamText();
    }

    public static void inputStreamText() throws IOException {
        InputStream fileInputStream = new FileInputStream("C:\\Users\\heyua\\Desktop\\io.txt");
        int a = 0;
        try {
            byte[] beties = new byte[1024];
            int read = 0;
            StringBuffer stringBuffer = new StringBuffer();
            while ((read = fileInputStream.read(beties)) != -1) {

                String s = new String(beties);
                System.out.print(s);
                System.out.print(read);
            }
        } finally {
            fileInputStream.close();
        }
    }

    public static void byteArrayInputStreamText() throws IOException {
        InputStream fileInputStream = new FileInputStream("C:\\Users\\heyua\\Desktop\\io.txt");
        try {
            StringBuffer stringBuffer = new StringBuffer();
            while (fileInputStream.read() != -1) {
                stringBuffer.append(fileInputStream.read());
            }
            System.out.println(stringBuffer.toString());
        }finally {
            fileInputStream.close();
        }
    }
}
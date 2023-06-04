package com.hyj.demo.nio;

import java.io.File;
import java.io.IOException;

public class FileUtil {

    public static Boolean addFile(String fileName){
//        String fileName ="D:\\file\\demo.html" ;
        File file = new File(fileName);
        if(!file.getParentFile().exists()){//如果文件夹不存在
            file.getParentFile().mkdir();//创建文件夹
        }
        try{//异常处理
            //如果file文件夹下没有demo.html就会创建该文件
            File f = new File(fileName);
            f.createNewFile();
            return true;
                /*这样可以在文件中写内容
                  BufferedWriter bw=new BufferedWriter(new
                  FileWriter("D:\\file\\test.txt"));
                  bw.write("Hello!");//在创建好的文件中写入"Hello"
                  bw.close();//一定要关闭文件
                 */

        }catch(IOException e){
            e.printStackTrace();
        }
        return false;
    }

}

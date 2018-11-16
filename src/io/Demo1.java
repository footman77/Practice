package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author footman77
 * @create 2018-10-22 20:34
 */
public class Demo1 {
    public static void main(String[] args) {

//        FileInputStream inputStream = new FileInputStream("path");
//        byte[] buf = new byte[1024];
//        int len = 0;
//        while ((len = inputStream.read(buf)) != -1){
//            System.out.println(new String(buf,0,len));
//        }
        FileWriter writer = null;

        try {
            writer = new FileWriter("D:\\test\\test.txt");
            writer.write("真好啊");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

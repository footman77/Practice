package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author footman77
 * @create 2018-10-22 21:42
 */
public class CopyDemo {

    public static void main(String[] args) {
        FileInputStream inputStream = null;
        FileOutputStream outputStream = null;
        try {
            inputStream = new FileInputStream("D:\\test\\test.txt");
            outputStream = new FileOutputStream("D:\\test.txt");

            byte[] buf = new byte[1024];
            int len = 0;

            while( (len = inputStream.read(buf)) != -1){
                outputStream.write(buf,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(outputStream != null){
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(inputStream != null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}

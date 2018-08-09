package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Demo3 {
    public static void main(String[] args) throws IOException {
    read();
    }
    public static void read() throws IOException {
        File file = new File("E:\\aaa.txt");
        FileInputStream fileInputStream =  new FileInputStream(file);
        byte[] buf = new byte[1024];
        int length = 0;
        while((length = fileInputStream.read(buf)) != -1){
            System.out.println(new String(buf, 0, length));
        }

        fileInputStream.close();
    }


}

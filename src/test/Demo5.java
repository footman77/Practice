package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo5 {
    public static void main(String[] args) throws IOException {
//        writeTest();
        readTest();
    }


    public static void readTest() throws IOException {
        File file = new File("E:\\aaa.txt");
        FileInputStream fileInputStream = new FileInputStream(file);

        byte[] buf = new byte[3];
        int length = 0;
        while((length = fileInputStream.read(buf)) != -1){
            System.out.print(new String(buf, 0, length));
        }
        fileInputStream.close();
    }

    public static void writeTest() throws IOException {
        File file = new File("E:\\aaa.txt");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        String  datas = "你好啊";
        byte[] buf = datas.getBytes();
       fileOutputStream.write(buf);
       fileOutputStream.close();

    }

}

package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class Demo6 {
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
//        File file = new File("E:\\aaa.txt");
//
//        PrintStream printStream = new PrintStream(file);
//        printStream.println(99999);
//        printStream.close();

//        String str = "你好";
//        byte[] buf = str.getBytes();
//        System.out.println(Arrays.toString(buf));
//
//        String res = new String(buf);
//        System.out.println(res);

        String temp = "中国";
        //编码
        byte[] buf = temp.getBytes("gbk");
        //解码
        temp = new String(buf, "iso8859-1");
        //找到字符对应的数字
        buf = temp.getBytes("iso8859-1");

        temp = new String(buf,"gbk");
        System.out.println(temp);


    }
}

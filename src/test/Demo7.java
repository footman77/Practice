package test;

import java.io.*;

public class Demo7 {
    public static void main(String[] args) throws IOException {
//        readTest1();
        writeTest();
    }

    public static void readTest1() throws IOException {
        //标准的输入流
        InputStream in = System.in;
        //把输入字节流转换成输入字符流
        InputStreamReader inputStreamReader = new InputStreamReader(in);
        //一次输入一行
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String line = null;
        while((line = bufferedReader.readLine()) != null){
            System.out.println(line);
        }

    }

    public static void writeTest() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("E:\\aaa.txt");
        String data = "hello world";
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
        outputStreamWriter.write(data);
        outputStreamWriter.close();
    }

}

package test;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo4 {
    public static void main(String[] args)  {

        copy();
    }
    public static void copy()  {
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            File inFile = new File("E:\\genji.jpg");
            File outFile = new File("D:\\copy.jpg");

             fileInputStream = new FileInputStream(inFile);
             fileOutputStream= new FileOutputStream(outFile);

            byte[] buf = new byte[1024];
            int length = 0;

            while ((length = fileInputStream.read(buf)) != -1) {
                fileOutputStream.write(buf, 0, length);

            }
        }catch(IOException e){
            System.out.println("拷贝错误");
            throw new RuntimeException(e);
        }finally{
            try{
                if(fileOutputStream != null){
                    fileOutputStream.close();
                }

            }catch(IOException e){
                throw new RuntimeException(e);
            }finally {
                try{
                    if(fileInputStream != null){
                        fileInputStream.close();
                    }
                }catch(IOException e){
                    throw new   RuntimeException(e);
                }
            }




        }



    }
}

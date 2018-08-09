package test;

import java.io.File;
import java.util.ArrayList;

public class Demo2 {
    public static void main(String[] args){
        File file = new File("D:\\001");
        File[] filenames = file.listFiles();
        ArrayList wenjian = new ArrayList();
        ArrayList mulu = new ArrayList();
        for(File filename : filenames){
            if(filename.isFile()){
                wenjian.add(filename);
            }else{
                mulu.add(filename);
            }

        }
        System.out.println(wenjian);
        System.out.println(mulu);

    }

}

package test;

import java.io.File;

public class Demo1 {
    public static void main(String[] args){
        File file = new File("D:\\001");
        String reg = "\\w+\\.java";
        String[] filenames = file.list();
        for(String filename : filenames){
            if(filename.matches(reg)){
                System.out.println(filename);
            }
        }
    }

}

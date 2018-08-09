package test;

import java.io.File;

public class Demo9 {
    public static void main(String[] args) {
        removeFiles(new File("E:\\aa"));
    }

    public  static void removeFiles(File dir){
        File[] files = dir.listFiles();
        for(File file : files){
            if(file.isFile()){
                file.delete();
            }else if(file.isDirectory()){
                removeFiles(file);
            }
        }
        dir.delete();
    }
}

package test;

import java.io.File;

public class Demo8 {
    public static void main(String[] args) {
        File file = new File("E:\\aa");
        listFiles(file, "");
    }

    public static void listFiles(File dir, String space){
        //列出所有的文件和文件夹
        File[] files = dir.listFiles();
        for(File file : files){
            if(file.isFile()){
                System.out.println(space + "文件：" + file.getName());
            }else if(file.isDirectory()){
                System.out.println(space + "文件夹：" + file.getName());
                listFiles(file, "     " + space);
            }
        }
    }
}
